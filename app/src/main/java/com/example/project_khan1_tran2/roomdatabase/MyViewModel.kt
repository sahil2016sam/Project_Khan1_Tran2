package com.example.project_khan1_tran2.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MyViewModel(app : Application) : AndroidViewModel(app)
{
    //initialize variable for list to hold list of Users from database
    lateinit var students: MutableLiveData<List<Student>>

    init {

        //Live data
        students = MutableLiveData<List<Student>>()
    }

    //get method to get all users
    fun getStudents()
    {
        val db = MyDatabase.getDatabase(getApplication())

        //check if database is not null
        if (db != null)
        {
            val list = db.studentDao().getAll()

            students.value = list
        }

    }

    fun update(s : Student)
    {
        val db = MyDatabase.getDatabase(getApplication())

        //check if database is not null
        if (db != null)
        {
            //then update the following user information
            val list = db.studentDao().update(s)
            getStudents()
        }
    }

   /* fun delete(s : Student)
    {
        val db = MyDatabase.getDatabase(getApplication())


    }*/
}