package com.biybiruza.redbook.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.biybiruza.redbook.data.model.Animal

@Dao
interface AnimalDao {

    @Query("SELECT * FROM book WHERE type = :type")
    fun getAllAnimals(type:Int): List<Animal>

    @Query("SELECT * FROM book WHERE id = :id")
    fun getAnimalById(id: Int): Animal

    @Query("SELECT * FROM book WHERE type = :type and nameEng like :word")
    fun searchAnimalBYName(type: Int, word: String) : List<Animal>

    @Update
    fun updateAnimal(animal: Animal)
}