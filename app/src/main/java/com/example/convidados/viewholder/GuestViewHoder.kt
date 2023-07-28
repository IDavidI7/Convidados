package com.example.convidados.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.ui.GuestForm.GuestModel

class GuestViewHoder(private val bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name
    }
}