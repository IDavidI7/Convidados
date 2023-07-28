package com.example.convidados.ui.guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.convidados.adapter.GuestAdapter
import com.example.convidados.databinding.FragmentAllGuestsBinding

class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllGuestsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AllGuestsViewModel
    private val adapter = GuestAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java)
        _binding = FragmentAllGuestsBinding.inflate(inflater, container, false)

        // layout
        binding.recyclerAllGuests.layoutManager = LinearLayoutManager(context)

        //adapter
        binding.recyclerAllGuests.adapter = adapter

        viewModel.getAll()
        observe()

        return binding.root
    }

    private fun observe() {
            viewModel.guests.observe(viewLifecycleOwner) {
            adapter.updatedGuest(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}