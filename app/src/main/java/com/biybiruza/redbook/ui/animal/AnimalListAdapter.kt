package com.biybiruza.redbook.ui.animal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biybiruza.redbook.R
import com.biybiruza.redbook.data.model.Animal
import kotlinx.android.synthetic.main.item_animal.view.*

class AnimalListAdapter : RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder>() {
    inner class AnimalViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun populateModel(animal: Animal){
            itemView.tvUzName.text = animal.nameUzb
            itemView.tvEngName.text = animal.nameEng
            itemView.tvRusName.text = animal.nameRus
        }
    }

    var models = listOf<Animal>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_animal,parent,false)
        return AnimalViewHolder(itemView)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.populateModel(models[position])
    }
}