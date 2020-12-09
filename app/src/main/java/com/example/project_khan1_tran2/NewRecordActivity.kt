package com.example.project_khan1_tran2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.project_khan1_tran2.recyclerview.MyAdapter
import com.example.project_khan1_tran2.roomdatabase.MyViewModelRoomDB
import com.example.project_khan1_tran2.roomdatabase.Student
import kotlinx.android.synthetic.main.all_records_activity.*
import kotlinx.android.synthetic.main.new_record_activity.*

class NewRecordActivity : AppCompatActivity() {

    lateinit var viewModel: MyViewModelRoomDB
   // lateinit var recyclerViewAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_record_activity)

        viewModel = ViewModelProviders.of(this).get(MyViewModelRoomDB::class.java)


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

        backBTN.setOnClickListener {
            goToMainScreen()
        }

        saveRecordBTN.setOnClickListener{

            val studentIdTv = studentIdEDTNewRec.text.toString()
            val studentScoreTv = studentScoreTvNewRec.text.toString()
            val studentCommentEdt = commentsEDTNewRec.text.toString()

            if (saveRecordBTN.text.equals("Save Record"))
            {
                val student = Student(0, studentIdTv, studentScoreTv, studentCommentEdt)
                viewModel.insertStudentInfo(student)
            }

           else
            {
                val student = Student(studentIdEDTNewRec.getTag(studentIdEDTNewRec.id).toString().toInt(), studentIdTv, studentScoreTv, studentCommentEdt)
                viewModel.updateStudentInfo(student)
            }



            goToAllRecordsActivity()

            studentIdEDTNewRec.setText("")
            studentScoreTvNewRec.setText("")
            commentsEDTNewRec.setText("")
        }

    }



    fun goToAllRecordsActivity()
    {
        val intent = Intent(this, AllRecordsActivity::class.java)
        startActivity(intent)
    }

    fun goToMainScreen()
    {
        finish()
    }
}


