package com.example.project_khan1_tran2.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//need to add this annotation, so that it knows its a database
@Database(entities = arrayOf(Student::class) , version = 1)

abstract class MyDatabase : RoomDatabase()
{
    //Note: If you give method a static "keyword", then it will be at class level

    //step 1: we will create a function
    //make it an abstract function
    //creating an object
    abstract fun studentDao() : StudentDao

    companion object {

        // have to call method to access it
        private var instance: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase?
        {
            // if null then will create the RoomDatabase
            if (instance == null)
            {
                synchronized(MyDatabase::class)
                {
                    instance = Room.databaseBuilder(

                        context.applicationContext,

                        //represents class for database
                        MyDatabase::class.java,

                        //string represents name of database
                        "MyDB"

                        //building the database
                        // don't want to worry about threads so therefore "
                        // .allowMainThreadQueries" will be added to the ".build"
                    ).allowMainThreadQueries().build()

                }
            }
            return instance

        }

    }
}