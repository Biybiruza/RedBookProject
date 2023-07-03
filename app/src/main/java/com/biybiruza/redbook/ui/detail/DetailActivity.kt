package com.biybiruza.redbook.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.biybiruza.redbook.R
import com.biybiruza.redbook.data.RedBookDatabase
import com.biybiruza.redbook.data.dao.AnimalDao
import com.biybiruza.redbook.data.model.Animal
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val ANIMAL_ID = "animal_id"
    }

    private var animalId = 0
    private lateinit var currentAnimal: Animal
    private lateinit var dao: AnimalDao
    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //Back button
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dao =RedBookDatabase.getInstance(this).dao()
        animalId = intent.getIntExtra(ANIMAL_ID, 0)
        currentAnimal = dao.getAnimalById(animalId)
        //actionBar title
        supportActionBar?.title = currentAnimal.nameUzb

        Glide.with(this)
            .load(resources.getIdentifier("picture$animalId","drawable",packageName))
            .into(detailImg)
        detailStatusContent.text = currentAnimal.status
        detailPropagationContent.text = currentAnimal.propagation
        detailHabitatContent.text = currentAnimal.habitat
        detailQuantityContent.text = currentAnimal.quantity
        detailLifestyleContent.text = currentAnimal.lifestyle
        detailLimitingFactorsContent.text = currentAnimal.limitingFactors
        detailBreedingContent.text = currentAnimal.breeding
        detailSecurityContent.text = currentAnimal.security
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        menuItem = menu?.findItem(R.id.bookmark)
        setFavoriteItemIcon()
        return true
    }


    //Back button onClick
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
            R.id.bookmark -> setFavorite()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavorite(){
        if (currentAnimal.isFavourite == null) currentAnimal.isFavourite = 1
        else currentAnimal.isFavourite = 1 - currentAnimal.isFavourite!!
        setFavoriteItemIcon()
        dao.updateAnimal(currentAnimal)
    }

    private fun setFavoriteItemIcon(){
        if (currentAnimal.isFavourite == 1){
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_24)
        } else {
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_border_24)
        }
    }


}