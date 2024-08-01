package dev.gstv.fhouse

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MainApp)
            androidLogger(if (isDebug()) Level.ERROR else Level.NONE)
        }
    }
}


fun Context.isDebug() = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE