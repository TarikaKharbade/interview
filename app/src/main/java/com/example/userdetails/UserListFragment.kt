package com.example.userdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.userdetails.Repository.UserRepository
import com.example.userdetails.ViewModel.UserListViewModel
import kotlinx.coroutines.launch

class UserListFragment : Fragment() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var userListViewModel: UserListViewModel
    private lateinit var userRepository : UserRepository

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

        userListViewModel = ViewModelProvider(this).get(UserListViewModel::class.java)

        val recyclerView:RecyclerView = view.findViewById(R.id.recycler_view_users)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = userAdapter

       lifecycleScope.launch {
           val users = userRepository.getUserFromApi()
           userAdapter.setData(users)
       }

        observeUserList()
    }

    private fun observeUserList() {

        userListViewModel.users.observe(viewLifecycleOwner, Observer { users ->

        })

    }



}