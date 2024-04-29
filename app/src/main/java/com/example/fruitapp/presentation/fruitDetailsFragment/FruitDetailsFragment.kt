package com.example.fruitapp.presentation.fruitDetailsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.fruitapp.R
import com.example.fruitapp.databinding.FragmentFruitDetailsBinding
import com.example.fruitapp.databinding.FragmentFruitListBinding

class FruitDetailsFragment : Fragment() {

    lateinit var binding: FragmentFruitDetailsBinding

    private var name: String? = null
    private var family: String? = null
    private var genus: String? = null
    private var order: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFruitDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            name = it.getString("Name")
            family = it.getString("Family")
            genus = it.getString("Genus")
            order = it.getString("Order")

            val calories = it.getString("Calories")
            val fat = it.getString("Fat")
            val sugar = it.getString("Sugar")
            val carbohydrates = it.getString("Carbohydrates")
            val protein = it.getString("Protein")

            binding.fruitCalories.text = calories
            binding.fruitFat.text = fat
            binding.fruitSugar.text = sugar
            binding.fruitCarbohydrates.text = carbohydrates
            binding.fruitProtein.text = protein

            }
        binding.fruitNameDetails.text = name
        binding.fruitFamily.text = family
        binding.fruitGenus.text = genus
        binding.fruitOrder.text = order

    }

}