package com.example.userdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userdetails.model.Users

class UserAdapter (private var userList: List<Users>, private val onItemClick:(Users)->Unit): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    fun setData(user: List<Users>){
        userList=user
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        private val nameTextView:TextView=itemView.findViewById(R.id.txt_view_user_name)
        private val emailTextView:TextView=itemView.findViewById(R.id.txt_view_user_email)


        init {
            itemView.setOnClickListener{
                val position=adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    val user = userList[position]
                    onItemClick.invoke(user)
                }
            }
        }
        fun bind(user:Users){
            nameTextView.text = user.firstName
            emailTextView.text=user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_user_detail,parent,false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.bind(currentUser)
    }

}