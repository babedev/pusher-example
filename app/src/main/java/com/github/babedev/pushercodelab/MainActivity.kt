package com.github.babedev.pushercodelab

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val disposableBag = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNext.setOnClickListener {
            startActivity(Intent(this, SecondaryActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        disposableBag.addAll(MainApplication.message
                .subscribe { Log.d("Main", it) })
    }

    override fun onPause() {
        super.onPause()

        disposableBag.clear()
    }
}