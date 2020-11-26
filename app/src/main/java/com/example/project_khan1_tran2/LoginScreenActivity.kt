package com.example.project_khan1_tran2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen_activity)

        //this is a test
        // test run 2
        // test run 3
        // stop with this madness!
        ///ajaj

    }

    fun loginClick(view: View)
    {
        val intent = Intent(this, MainScreenActivity::class.java)
        startActivity(intent)
    }
}