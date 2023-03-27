package com.latihan.latihannavigation.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.latihan.latihannavigation.R
import com.latihan.latihannavigation.databinding.FragmentHomeBinding
import com.latihan.latihannavigation.databinding.FragmentRegisterBinding

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = arguments?.getString("username")
        binding.helloUser.text = "Hello, $username"

        binding.userIcon.setOnClickListener{
            val bundle = bundleOf("username" to username)
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment, bundle)
        }
    }
}