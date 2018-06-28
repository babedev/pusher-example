package com.github.babedev.pushercodelab

import android.app.Activity
import android.util.Log
import io.reactivex.disposables.CompositeDisposable

class SecondaryActivity : Activity() {

    private val disposableBag = CompositeDisposable()

    override fun onResume() {
        super.onResume()

        disposableBag.addAll(MainApplication.message
                .subscribe { Log.d("Secondary", it) })
    }

    override fun onPause() {
        super.onPause()

        disposableBag.clear()
    }
}