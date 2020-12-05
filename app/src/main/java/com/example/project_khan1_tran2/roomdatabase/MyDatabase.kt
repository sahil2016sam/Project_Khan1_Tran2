package com.example.project_khan1_tran2.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//need to add this annotation, so that it knows its a database
@Database(entities = [Student::class], version = 1)

abstract class MyDatabase : RoomDatabase()
{
    abstract fun studentDao(): StudentDao?

    companion object
    {



    }
}