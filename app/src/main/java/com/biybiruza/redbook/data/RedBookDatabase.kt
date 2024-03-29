package com.biybiruza.redbook.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomMasterTable
import com.biybiruza.redbook.data.dao.AnimalDao
import com.biybiruza.redbook.data.model.Animal

@Database(entities = [Animal::class],version = 4)
abstract class RedBookDatabase: RoomDatabase() {
    companion object{
        private lateinit var INSTANCE:RedBookDatabase

        fun getInstance(context: Context): RedBookDatabase = Room.databaseBuilder(
            context,
            RedBookDatabase::class.java,
            "book-database.db"
        )
            .createFromAsset("book-database.db")
            .allowMainThreadQueries()
            .build()
    }

    abstract fun dao():AnimalDao
}