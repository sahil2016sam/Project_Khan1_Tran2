package com.example.project_khan1_tran2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.main_screen_activity.*


class MainScreenActivity : AppCompatActivity() {
    var newIntent:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen_activity)
        newIntent = intent.getStringExtra("name")!!
        greetUserTv.text = "Hi, $newIntent"


    }


    fun submitCLK(view: View) {
        if (new_recordRBTN.isChecked){
            val newRecordIntent = Intent(this, NewRecordActivity::class.java)
            startActivity(newRecordIntent)
        }
        else if (prev_recordRBTN.isChecked){
            val allRecordsIntent = Intent(this, AllRecordsActivity::class.java)
            startActivity(allRecordsIntent)
        }
        else if (logoutRBTN.isChecked){
            finish()
        }
    }


}