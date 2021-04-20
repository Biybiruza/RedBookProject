package com.biybiruza.redbook.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.biybiruza.redbook.data.model.Animal

@Dao
interface AnimalDao {
    @Query("SELECT * FROM book")
    fun getAllAnimals(): List<Animal>
    
}