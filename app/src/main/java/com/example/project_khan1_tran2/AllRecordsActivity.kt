package com.example.project_khan1_tran2

import android.content.Intent
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_khan1_tran2.recyclerview.MyAdapter
import com.example.project_khan1_tran2.roomdatabase.MyViewModelRoomDB
import com.example.project_khan1_tran2.roomdatabase.Student
import kotlinx.android.synthetic.main.all_records_activity.*
import kotlinx.android.synthetic.main.new_record_activity.*

class AllRecordsActivity : AppCompatActivity(), MyAdapter.RowClickListener {

    lateinit var recyclerViewAdapter: MyAdapter
    lateinit var viewModel: MyViewModelRoomDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_records_activity)

        recyclerView.apply{

            layoutManager = LinearLayoutManager(this@AllRecordsActivity)

            recyclerViewAdapter = MyAdapter(this@AllRecordsActivity)

            adapter = recyclerViewAdapter

            val divider = DividerItemDecoration(application, HORIZONTAL)
            addItemDecoration(divider)
        }

        viewModel = ViewModelProviders.of(this).get(MyViewModelRoomDB::class.java)
        viewModel.getAllStudentsObservers().observe(this, Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()

        })

        mainPageBtn.setOnClickListener {

            goToMainScreen()

        }

    }

    override fun onDeleteStudentClickListener(student: Student) {
        viewModel.deleteStudentInfo(student)
    }

    override fun onItemClickListener(student: Student) {


        val intent = Intent(this, ModifyRecordActivity::class.java)
        intent.putExtra("dataId", student.id.toString())
        intent.putExtra("studentId", student.studentId)
        intent.putExtra("studentScore", student.studentScore)
        intent.putExtra("studentComment", student.studentComments)
        startActivity(intent)


    }

    fun goToMainScreen()
    {
        finish()
    }


}