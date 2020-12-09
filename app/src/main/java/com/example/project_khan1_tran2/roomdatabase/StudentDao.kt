package com.example.project_khan1_tran2.roomdatabase

import androidx.room.*

@Dao
interface StudentDao {

    @Query("SELECT * FROM studentinfo ORDER BY studentId ASC")
    fun getAllStudentInfo(): List<Student>?

    @Insert
    fun insertStudent(student: Student?)

    @Delete
    fun deleteStudent(student: Student?)

    @Update
    fun updateStudent(student: Student?)
}

