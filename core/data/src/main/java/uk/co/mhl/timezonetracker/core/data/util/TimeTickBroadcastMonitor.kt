package uk.co.mhl.timezonetracker.core.data.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.shareIn
import java.time.Instant
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class TimeTickBroadcastMonitor @Inject constructor(
    @ApplicationContext private val context: Context,
) : TimeTickMonitor {
    override fun currentTime(): SharedFlow<Instant> = callbackFlow {
        trySend(Instant.now())

        val receiver = object : BroadcastReceiver() {
            override fun onReceive(cotext: Context, intent: Intent) {
                if (intent.action != Intent.ACTION_TIME_TICK) return

                val timeFromIntent = if (VERSION.SDK_INT < VERSION_CODES.R) {
                    null
                } else {
                    intent.getStringExtra(Intent.EXTRA_TIME)?.let { time ->
                        Instant.ofEpochMilli(time.toLong())
                    }
                }

                trySend(timeFromIntent ?: Instant.now())
            }
        }
        context.registerReceiver(receiver, IntentFilter(Intent.ACTION_TIME_TICK))

        awaitClose {
            context.unregisterReceiver(receiver)
        }
    }
        .distinctUntilChanged()
        .conflate()
        .flowOn(Dispatchers.IO)
        .shareIn(CoroutineScope(Dispatchers.Default), SharingStarted.WhileSubscribed(5_000, 1))
}