package com.example.fruitapp.presentation.fruitListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.fruitapp.R
import com.example.fruitapp.data.repository.FruitRepository
import com.example.fruitapp.databinding.FragmentFruitListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.converter.gson.GsonConverterFactory

class FruitListFragment : Fragment() {



    lateinit var binding: FragmentFruitListBinding
    lateinit var adapter: FruitListAdaptor
    private lateinit var viewModel: FruitViewModel
    val fruitRepository = FruitRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFruitListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = requireActivity().findViewById<RecyclerView>(R.id.rv)
        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.swipe)

        adapter = FruitListAdaptor(requireContext()) { fruitApiModel, position ->
            Toast.makeText(requireContext(), "${fruitApiModel.name}", Toast.LENGTH_SHORT).show()}
        binding.rv.adapter = adapter



            CoroutineScope(Dispatchers.IO).launch {
                val fruits = fruitRepository.getAllFruits()
                withContext(Dispatchers.Main) {
                    adapter.setNewData(fruits)

                }
            }
        
}

}


