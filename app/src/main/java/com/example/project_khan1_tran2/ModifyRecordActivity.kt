package com.example.project_khan1_tran2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.example.project_khan1_tran2.roomdatabase.MyViewModelRoomDB
import com.example.project_khan1_tran2.roomdatabase.Student
import kotlinx.android.synthetic.main.modify_record_activity.*

class ModifyRecordActivity : AppCompatActivity() {

    lateinit var viewModel: MyViewModelRoomDB

    var oldId : String = ""
    var studentIdUp: String = ""
    var studentScoreUp: String = ""
    var studentCommentUp: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modify_record_activity)


        oldId = intent.getStringExtra("dataId")!!
        studentIdUp = intent.getStringExtra("studentId")!!
        studentScoreUp = intent.getStringExtra("studentScore")!!
        studentCommentUp = intent.getStringExtra("studentComment")!!

        Log.e("brapultimate", oldId)
        studentIdTvUp.text = studentIdUp
        studentScoreEdtUp.setText(studentScoreUp)
        studentCommentsEdtUp.setText(studentCommentUp)


        viewModel = ViewModelProviders.of(this).get(MyViewModelRoomDB::class.java)

        cancelBtn.setOnClickListener {
            goToAllRecords()
        }

        updateBtn.setOnClickListener {
            updateStudentRecord()
        }

    }

    fun goToAllRecords()
    {
        val intent = Intent(this, AllRecordsActivity::class.java)
        startActivity(intent)
    }

    fun updateStudentRecord()
    {

        val studentIdTv = studentIdTvUp.text.toString()
        val studentScoreTv = studentScoreEdtUp.text.toString()
        val studentCommentEdt = studentCommentsEdtUp.text.toString()
        Log.e("brap", studentIdTv)
        Log.e("brap1", studentScoreTv)
        Log.e("brap2", studentCommentEdt)

        if (updateBtn.text.equals("Update"))
        {
            val student = Student(oldId.toInt(), studentIdTv, studentScoreTv, studentCommentEdt)
            viewModel.updateStudentInfo(student)
        }
        goToAllRecords()
    }
}


