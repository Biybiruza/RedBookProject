package com.biybiruza.redbook.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.biybiruza.redbook.data.model.Animal

@Dao
interface AnimalDao {

    @Query("SELECT * FROM book WHERE type = :type")
    fun getAllAnimals(type:Int): List<Animal>
    
}