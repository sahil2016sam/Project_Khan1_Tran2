package com.example.project_khan1_tran2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.project_khan1_tran2.roomdatabase.MyViewModel

class AllRecordsActivity : AppCompatActivity() {

    var vm : MyViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_records_activity)

        //creating an instance for ViewModelProvider
        //reason for creating it like this
        vm = ViewModelProvider(this, ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(this.getApplication()))
            .get(MyViewModel::class.java)


    }
}