package com.github.babedev.pushercodelab

import android.app.Application
import android.util.Log
import com.pusher.client.Pusher
import com.pusher.client.PusherOptions
import io.reactivex.subjects.PublishSubject

class MainApplication : Application() {

    companion object {
        val message = PublishSubject.create<String>()
    }

    override fun onCreate() {
        super.onCreate()

        val options = PusherOptions().apply {
            setCluster(BuildConfig.PUSHER_CLUSTER)
        }

        val pusher = Pusher(BuildConfig.PUSER_KEY, options)
        val channel = pusher.subscribe("my-channel")

        channel.bind("my-event") { _, _, data ->
            Log.d("App", "Event received")
            message.onNext(data as String)
        }

        pusher.connect()
    }
}