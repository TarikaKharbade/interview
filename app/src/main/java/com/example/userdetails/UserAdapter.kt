package com.example.userdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userdetails.model.Users

class UserAdapter (var userList:List<Users>):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount() : Int{
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.bind(currentUser)
    }

    inner class UserViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(users: Users){
            itemView.findViewById<TextView>(R.id.txt_view_user_id).text= users.id.toString()
            itemView.findViewById<TextView>(R.id.txt_view_user_name).text=users.firstName
            itemView.findViewById<TextView>(R.id.txt_view_user_email).text=users.email
        }
    }

}