package com.example.project_khan1_tran2.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import org.w3c.dom.Entity

class MyViewModelRoomDB(app: Application): AndroidViewModel(app)
{
    lateinit var allStudents: MutableLiveData<List<Student>>

    init {
        allStudents = MutableLiveData()
        getAllStudents()
    }

    fun getAllStudentsObservers(): MutableLiveData<List<Student>>
    {
        return allStudents
    }

    fun getAllStudents()
    {
        val studentDao = MyDatabase.getAppDatabase((getApplication()))?.studentDao()
        val list = studentDao?.getAllStudentInfo()

        allStudents.postValue(list)
    }

    fun insertStudentInfo(entity: Student)
    {
        val studentDao = MyDatabase.getAppDatabase(getApplication())?.studentDao()
        studentDao?.insertStudent(entity)
        getAllStudents()
    }

    fun updateStudentInfo(entity: Student){
        val studentDao = MyDatabase.getAppDatabase(getApplication())?.studentDao()
        studentDao?.updateStudent(entity)
        getAllStudents()
    }

    fun deleteStudentInfo(entity: Student){
        val studentDao = MyDatabase.getAppDatabase(getApplication())?.studentDao()
        studentDao?.deleteStudent(entity)
        getAllStudents()
    }
}