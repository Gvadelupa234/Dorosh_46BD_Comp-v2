package com.example.fruitapp.presentation.fruitListFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitapp.R
import com.example.fruitapp.data.remote.model.FruitApiModel
import com.example.fruitapp.databinding.ItemFruitBinding

class FruitListAdaptor(
    val context: Context, val onClick: (name: FruitApiModel, position: Int) -> Unit,
) : RecyclerView.Adapter<FruitListAdaptor.FruitListHolder>() {

    private val list = ArrayList<FruitApiModel>()

    inner class FruitListHolder(val binding:ItemFruitBinding):RecyclerView.ViewHolder(binding.root) {


        fun bindView(fruitApiModel: FruitApiModel, position: Int) {
            binding.fruitName.text = fruitApiModel.name
            binding.shortDetails.text = fruitApiModel.family

            binding.buttonDetails.setOnClickListener {
                onClick(fruitApiModel, position)
                val navController = binding.root.findNavController()
                val bundle = Bundle()
                bundle.putString("Name", "Назва: ${fruitApiModel.name}")
                bundle.putString("Family", "Родина: ${fruitApiModel.family}")
                bundle.putString("Genus", "Рід: ${fruitApiModel.genus}")
                bundle.putString("Order", "Порядок: ${fruitApiModel.order}")

                fruitApiModel.nutritions?.let { nutritions ->
                    bundle.putString("Calories", "Калорії: ${nutritions.calories}")
                    bundle.putString("Fat", "Жири: ${nutritions.fat}")
                    bundle.putString("Sugar", "Цукри: ${nutritions.sugar}")
                    bundle.putString("Carbohydrates", "Вуглеводи: ${nutritions.carbohydrates}")
                    bundle.putString("Protein", "Білки: ${nutritions.protein}")
                }

                navController.navigate(R.id.action_fruitListFragment_to_fruitDetailsFragment, bundle)
            }
        }

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitListHolder {
        val view = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FruitListHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FruitListHolder, position: Int) {
        val fruitList = list[position]
        holder.bindView(fruitList, position)
    }

    fun setNewData(newList: List<FruitApiModel>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}