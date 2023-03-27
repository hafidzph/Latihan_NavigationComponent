package com.latihan.latihannavigation.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.latihan.latihannavigation.R
import com.latihan.latihannavigation.databinding.FragmentLoginBinding
import com.latihan.latihannavigation.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    lateinit var binding : FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val name = binding.input.text.toString()
            val username = binding.input2.text.toString()
            val password = binding.input3.text.toString()
            val confPass = binding.input4.text.toString()
            val bundle = Bundle()

            bundle.apply {
                putString("username", username)
                putString("password", password)
            }
            if(name.isEmpty()) binding.input.error = "Nama Harus Diisi"
            else if(username.isEmpty()) binding.input2.error = "Username Harus Diisi"
            else if(password.isEmpty()) binding.input3.error = "Password Harus Diisi"
            else if(confPass != password) binding.input4.error = "Password Tidak Sama"
            else findNavController().navigate(R.id.action_registerFragment_to_loginFragment, bundle)
        }

        binding.loginLink.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}