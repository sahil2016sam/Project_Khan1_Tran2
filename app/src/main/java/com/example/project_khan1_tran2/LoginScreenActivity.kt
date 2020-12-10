package com.example.project_khan1_tran2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project_khan1_tran2.roomdatabase.User
import kotlinx.android.synthetic.main.login_screen_activity.*
import org.json.JSONObject
import kotlin.concurrent.thread
import kotlin.math.log

class LoginScreenActivity : AppCompatActivity() {
    lateinit var vm : NetworkingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen_activity)
        vm = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
                .get(NetworkingViewModel::class.java)

        if(vm != null){
            vm.user.observe(this,{
                userNameEDT.setText(it.name)
                passwordEDT.setText(it.password)
            })
        }
    }
    fun getData( url : String){

        vm.makeRequest(url)

    }

    fun loginClick(view: View) {
        var name = userNameEDT.text.toString()
        var password = passwordEDT.text.toString()
        val mainIntent = Intent(this, MainScreenActivity::class.java)
        val url:String = "https://mohameom.dev.fast.sheridanc.on.ca/login/verify.php?name=${name}&password=${password}"
        getData(url)

        var jsonObject = JSONObject()

       var usernameJson = jsonObject.put("name", name)
        var passwordJson = jsonObject.put("password", password)
        jsonObject.put("password", "12345")
        jsonObject.put("password", "admin")

        Log.d("JSON", jsonObject.toString())
        Log.d("name", jsonObject.optString("name"))
        //var checkValid = vm.getJson()
        var loginValid = """{"login": "valid"}"""
        vm.username.observe(this,{
            Log.d("brap3", it)

            if (loginValid == it) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                mainIntent.putExtra("name", name)
                startActivity(mainIntent)
            }
            else {
                Toast.makeText(this, "Login Unsuccessful!", Toast.LENGTH_SHORT).show()
            }
        })


    }
}



