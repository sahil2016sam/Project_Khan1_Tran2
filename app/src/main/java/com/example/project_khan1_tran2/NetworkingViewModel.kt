package com.example.project_khan1_tran2

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.project_khan1_tran2.roomdatabase.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpCookie
import java.net.HttpURLConnection
import java.net.URL


class NetworkingViewModel(app: Application) : AndroidViewModel(app) {

    var username = MutableLiveData<String>()
    var user = MutableLiveData<User>()
    var result = ""

    suspend fun loadData(urlString: String):String{
        var ins : InputStream? = null
         result = ""
        try {
        var url = URL(urlString)
            val conn =url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            val response = conn.responseCode
            Log.d("response code" , "${response}");
            ins = conn.inputStream

            result = ins.bufferedReader().use(BufferedReader::readText)
            var json = JSONObject(result)
            var name = json.optString("name")
            var password = json.optString("password")
            Log.d("result", result)
        }catch (e: Exception){
            Log.d("TAG", e.toString())
        }
        return result
    }
    fun makeRequest(url:String){
        CoroutineScope(Dispatchers.IO).launch {
             result = loadData(url)

            withContext(Dispatchers.Main){
               var json = getJson(result)
                var name = json.optString("name")
                var password = json.optString("password")
                this@NetworkingViewModel.username.value = name
                this@NetworkingViewModel.user.value = User(name, password)
                Toast.makeText(getApplication(), name, Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun getJson(jsonStr : String):JSONObject  {
        var json  = JSONObject(jsonStr)
        Log.d("TAG", jsonStr)
        return json

    }
}