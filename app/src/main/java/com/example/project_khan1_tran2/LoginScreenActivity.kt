package com.example.project_khan1_tran2

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.login_screen_activity.*

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

    fun loginClick(view: View) {
        val url =
                "http://mohameom.dev.fast.sheridanc.on.ca/users/verifyUserData.php?name=${userNameEDT.text}&password=${passwordEDT.text}"

    }
}