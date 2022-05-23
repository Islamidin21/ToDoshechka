package com.example.todoroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoroom.db.dao.NoteDao
import com.example.todoroom.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase:RoomDatabase() {
    abstract fun getNoteDao():NoteDao

    companion object{
        private var dateBase: NoteDataBase ?= null

        @Synchronized
        fun getInstance(context:Context):NoteDataBase{
            return if(dateBase ==null){
                dateBase = Room.databaseBuilder(context, NoteDataBase::class.java,"db").build()
                dateBase as NoteDataBase
            }else{
                dateBase as NoteDataBase
            }
        }
    }
}