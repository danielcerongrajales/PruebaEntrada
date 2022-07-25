package com.example.pruebaentrada.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pruebaentrada.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    val homeViewModel:HomeViewModel by activityViewModels()
    private lateinit var movieAdapter2:MovieAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        homeViewModel
        movieAdapter2=MovieAdapter()
        binding.rv.apply {
            layoutManager =  GridLayoutManager(this.context,2)
            setHasFixedSize(true)


        }
       homeViewModel.productsList.observe(viewLifecycleOwner){

           movieAdapter2.submitList(it)

       }


//                   }
        binding.rv.adapter = movieAdapter2
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}