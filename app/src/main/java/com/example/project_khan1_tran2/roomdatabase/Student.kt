package com.example.project_khan1_tran2.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "studentinfo")
data class Student(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id") val id : Int = 0,
        @ColumnInfo(name = "studentId") val studentId : String,
        @ColumnInfo(name = "studentScore") val studentScore : String,
        @ColumnInfo(name = "studentComments") val studentComments : String?

)


