package com.example.project_khan1_tran2

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.project_khan1_tran2.roomdatabase.MyViewModel
import kotlinx.android.synthetic.main.login_screen_activity.*

class LoginScreenActivity : AppCompatActivity() {
    lateinit var vm : ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen_activity)
        vm = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
                .get(ViewModel::class.java)

        //this is a test
        // test run 2
        // test run 3
        // stop with this madness!
        ///ajaj
    }
    fun getData( url : String){

        vm.makeRequest(url)

    }
    fun loginClick(view: View) {
        var name = userNameEDT.text.toString()
        var password = passwordEDT.text.toString()
        val mainIntent = Intent(this, MainScreenActivity::class.java)
        val url:String = "http://mohameom.dev.fast.sheridanc.on.ca/users/verifyUserData.php?name=${userNameEDT.text}&password=${passwordEDT.text}"
        getData(url)
        if (name == "admin" && password == "admin") {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            mainIntent.putExtra("name", name)
            startActivity(mainIntent)
        }
        else if (name == "user" && password == "12345") {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            mainIntent.putExtra("name", name)
            startActivity(mainIntent)
        }
        else {
            Toast.makeText(this, "Login Unsuccessful!", Toast.LENGTH_SHORT).show()
        }

    }
}



