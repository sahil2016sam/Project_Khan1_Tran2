package com.example.project_khan1_tran2.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_khan1_tran2.R
import com.example.project_khan1_tran2.roomdatabase.Student

class MyAdapter(val data: ArrayList<Student>, var context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{

}