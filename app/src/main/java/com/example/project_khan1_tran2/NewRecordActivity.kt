package com.example.project_khan1_tran2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.all_records_activity.*
import kotlinx.android.synthetic.main.new_record_activity.*

class NewRecordActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_record_activity)

        //implementation for the score seekbar
        scoreSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var studentScore = 0
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                studentScore = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

                studentScoreTvNewRec.text = "$studentScore"

                Toast.makeText(
                        this@NewRecordActivity, "Seek bar progress is :$studentScore",
                        Toast.LENGTH_SHORT
                ).show()
            }
        })

        saveRecordBTN.setOnClickListener{


        }

    }



    fun goToAllRecordsActivity()
    {
       /* val intent = Intent(this, AllRecordsActivity::class.java)
        intent.putExtra("Student Id", studentIdEDTNewRec)
        intent.putExtra("Student Score", studentScoreTvNewRec)
        intent.putExtra()
        startActivity(intent)*/
    }
}