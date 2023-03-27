package com.latihan.latihannavigation.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.latihan.latihannavigation.R
import com.latihan.latihannavigation.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val username = arguments?.getString("username")
            val password = arguments?.getString("password")
            if(binding.input.text.toString() != username) binding.input.error = "Username tidak ditemukan"
            else if(binding.input2.text.toString() != password) binding.input2.error = "Password salah"
            else {
                val bundle = bundleOf(
                    "username" to username,
                    "password" to password
                )
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
            }
        }

        binding.registerLink.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}