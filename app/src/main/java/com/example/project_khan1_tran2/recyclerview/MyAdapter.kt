package com.example.project_khan1_tran2.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_khan1_tran2.R
import com.example.project_khan1_tran2.roomdatabase.Student
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val listener: RowClickListener): RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    var items = ArrayList<Student>()

    fun setListData(data: ArrayList<Student>)
    {
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
                .inflate(R.layout.row, parent, false)
        return MyViewHolder(inflater, listener)

    }


    override fun getItemCount(): Int
    {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.itemView.setOnClickListener{
            listener.onItemClickListener(items[position])
        }
        holder.bind(items[position])
    }



    class MyViewHolder (view: View, val listener: RowClickListener): RecyclerView.ViewHolder(view)
    {
        val studentIDTvRv = view.studentIDTvRv
        val studentScoreTvRv = view.studentScoreTvRv
        val studentCommentsEdtRv = view.studentCommentsTvRv
        val deleteStudent = view.deleteStudentRv

        fun bind(data: Student)
        {
            studentIDTvRv.text = data.studentId

            studentScoreTvRv.text = data.studentScore

            studentCommentsEdtRv.text = data.studentComments

            deleteStudent.setOnClickListener {
                listener.onDeleteStudentClickListener(data)
            }
        }
    }

    interface RowClickListener{

        fun onDeleteStudentClickListener(student: Student)
        fun onItemClickListener(student: Student)

    }
}

