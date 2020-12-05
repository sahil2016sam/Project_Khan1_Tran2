package com.example.project_khan1_tran2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import org.json.JSONObject


class ViewModel(app: Application) : AndroidViewModel(app) {

    fun makeRequest(url:String){

    }

    fun getJson(jsonStr : String) : JSONObject {
        var json  = JSONObject(jsonStr)
        return json
    }
}