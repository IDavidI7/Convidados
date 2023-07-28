package com.example.convidados.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.ui.GuestForm.GuestModel
import com.example.convidados.viewholder.GuestViewHoder

class GuestAdapter : RecyclerView.Adapter<GuestViewHoder>() {

    private var guestList: List<GuestModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHoder {
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHoder(item)
    }

    override fun getItemCount(): Int {
        return guestList.count()
    }

    override fun onBindViewHolder(holder: GuestViewHoder, position: Int) {
        holder.bind(guestList[position])
    }

    fun updatedGuest(list: List<GuestModel>) {
        guestList = list
        notifyDataSetChanged()
    }

}