package com.example.project_khan1_tran2.roomdatabase

import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    fun insertAll(vararg student: Student)

    @Query("SELECT * FROM student")
    fun getAll() : List<Student>?

    @Update
    fun update(student: Student?)

    /*@Delete
    fun delete(student: Student)*/

}