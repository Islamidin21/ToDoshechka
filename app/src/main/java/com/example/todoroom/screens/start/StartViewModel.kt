package com.example.todoroom.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.todoroom.REPOSITORY
import com.example.todoroom.db.NoteDataBase
import com.example.todoroom.db.repository.NoteRealization
import com.example.todoroom.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {
    val context = application

    fun initDataBase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes():LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}