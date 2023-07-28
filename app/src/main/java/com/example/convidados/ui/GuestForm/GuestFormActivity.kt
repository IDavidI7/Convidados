package com.example.convidados.ui.GuestForm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[GuestFormaViewModel::class.java]

        binding.buttonPresent.isChecked = true

        binding.buttonSave.setOnClickListener {
            val name = binding.editName.text.toString()
            val presence = binding.buttonPresent.isChecked

            val model = GuestModel(0, name, presence)
            viewModel.insert(model)
        }
    }
}