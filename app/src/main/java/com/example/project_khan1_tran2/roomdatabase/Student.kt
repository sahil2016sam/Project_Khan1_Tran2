package com.example.project_khan1_tran2.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(

    @PrimaryKey var id : Int,
    @ColumnInfo(name = "student_score")
    var score: String,
    var comments : String
    )
{
    //created a return to return the user data information with just the main values
    override fun toString(): String
    {
        return "$id , $score , $comments"
    }

}

