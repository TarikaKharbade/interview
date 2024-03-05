package com.example.userdetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.userdetails.API.UserService
import com.example.userdetails.Repository.UserRepository
import com.example.userdetails.ViewModel.UserListViewModel
import com.example.userdetails.ViewModel.UserListViewModelFactory
import com.example.userdetails.model.Users
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserListFragment : Fragment() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var userListViewModel: UserListViewModel
    private lateinit var userRepository : UserRepository
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        userListViewModel = ViewModelProvider(this).get(UserListViewModel::class.java)

        recyclerView = view.findViewById(R.id.recycler_view_users)

        userAdapter = UserAdapter(emptyList())
        recyclerView.adapter = userAdapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(UserService::class.java)
        userRepository = UserRepository(apiService)


        userListViewModel = ViewModelProvider(this, UserListViewModelFactory(userRepository))[UserListViewModel::class.java]
//        userListViewModel = ViewModelProvider(this)[UserListViewModel::class.java]
        userListViewModel.fetchUsers()
        userListViewModel.users.observe(viewLifecycleOwner, Observer { users ->
           Log.d("zzzksd",users.toString())
            userAdapter.userList = users
            userAdapter.notifyDataSetChanged()
        })

    }

}