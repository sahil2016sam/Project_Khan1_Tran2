package com.example.project_khan1_tran2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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

        saveRecordBTN.setOnClickListener{
            val intent = Intent(this, AllRecordsActivity::class.java)
            startActivity(intent)
        }

        //creating an instance for ViewModelProvider
        vm = ViewModelProvider(this, ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(this.getApplication()))
            .get(MyViewModel::class.java)

        if (vm != null)
        {
            // will return the users
            vm?.students?.observe(this, {

                //creating a variable to store data in the Array adapter
                var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, it)

                //displaying data in the list view in the second activity from the data stored in the array adapter
               // listView.adapter = adapter

               // recyclerView.adapter = adapter



            })
        }






    }
}