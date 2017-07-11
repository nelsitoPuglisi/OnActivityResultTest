package com.iamat.onactivityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_a.*

class AActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { startB() }

        txtView.setOnClickListener { startBAndFinish() }
        txtView2.setOnClickListener { startBWithFlag() }
    }

    private fun startBWithFlag() {
        val intent = Intent(this, BActivity::class.java)
        intent.putExtra("METODO", "startActivity with Flag")
        intent.flags = Intent.FLAG_ACTIVITY_FORWARD_RESULT
        startActivity(intent)
        finish()
    }

    private fun startBAndFinish() {
        val intent = Intent(this, BActivity::class.java)
        intent.putExtra("METODO", "startActivityForResult and finish")
        startActivityForResult(intent, 1)
        finish()
    }

    private fun startB() {
        val intent = Intent(this, BActivity::class.java)
        intent.putExtra("METODO", "startActivityForResult and onActivityResult")
        startActivityForResult(intent, 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2) {
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}
