package com.suhail.securityfindings.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.suhail.securityfindings.databinding.FragmentLoginBinding
import com.suhail.securityfindings.viewModels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var navController: NavController
    val viewModel: LoginViewModel by viewModels()
    lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        navController = findNavController()
        viewModel.oneTimeForOnBoarding.observe(viewLifecycleOwner, Observer {
            if (!it) {
                val action = LoginFragmentDirections.actionLoginFragmentToViewPagerFragment()
                navController.navigate(action)
            }
        })
        // Inflate the layout for this fragment
        return binding.root
    }
}