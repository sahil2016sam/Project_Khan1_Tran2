package com.example.project_khan1_tran2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpCookie
import java.net.HttpURLConnection
import java.net.URL


class NetworkingViewModel(app: Application) : AndroidViewModel(app) {

    fun loadData(urlString: String){
        var ins : InputStream? = null
        var result = ""
        try {
        var url = URL(urlString)
            val conn =url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            val response = conn.responseCode
            Log.d("response code" , "${response}");
            ins = conn.inputStream

            result = ins.bufferedReader().use(BufferedReader::readText)
            Log.d("result", result)
        }catch (e: Exception){
            Log.d("TAG", e.toString())
        }
    }
    fun makeRequest(url:String){

    }

    fun getJson(jsonStr : String) : JSONObject {
        var json  = JSONObject(jsonStr)
        return json
    }
}