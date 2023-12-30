package com.example.kotlin21.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.kotlin21.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private  var _binding: FragmentDetailBinding? = null
    private val binding:FragmentDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setupListenere()
    }

    private fun getData() {
        try {
            val args by navArgs<DetailFragmentArgs>()
            binding.tvText.text = args.animeModel?.name
            Glide.with(binding.ivDetail).load(args.animeModel?.image).into(binding.ivDetail)
        }catch (exception: Exception) {
            Log.e("TAG", "getData: ")
        }
    }

    private fun setupListenere() {
        binding.btnGoBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}