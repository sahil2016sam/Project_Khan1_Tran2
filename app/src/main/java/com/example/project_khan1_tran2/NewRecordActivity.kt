package com.example.project_khan1_tran2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.project_khan1_tran2.roomdatabase.MyViewModel
import kotlinx.android.synthetic.main.all_records_activity.*
import kotlinx.android.synthetic.main.new_record_activity.*

class NewRecordActivity : AppCompatActivity() {

    var vm : MyViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_record_activity)
        //implementation for room database

        scoreSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var studentScore = 0
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                studentScore = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

                studentScoreSkTv.text = "$studentScore"

                Toast.makeText(
                        this@NewRecordActivity, "Seek bar progress is :$studentScore",
                        Toast.LENGTH_SHORT
                ).show()
            }
        })



        //creating an instance for ViewModelProvider
        vm = ViewModelProvider(this, ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(this.getApplication()))
            .get(MyViewModel::class.java)



    }

    fun saveRecord(view: View) {
        val saveIntent = Intent(this, AllRecordsActivity::class.java)
        startActivity(saveIntent)
    }

    fun goBack(view: View) {
        val goBackIntent = Intent(this, MainScreenActivity::class.java)
        startActivity(goBackIntent)
    }

    fun addStudent()
    {

    }

    fun updateUser()
    {

    }




}