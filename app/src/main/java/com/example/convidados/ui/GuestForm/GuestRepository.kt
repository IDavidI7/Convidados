package com.example.convidados.ui.GuestForm

class GuestRepository private constructor(){

    private val repository = GuestRepository()

    //Singleton
    companion object {
        private lateinit var repository : GuestRepository

        fun getInstance(): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository()
            }
            return repository
        }
    }

}