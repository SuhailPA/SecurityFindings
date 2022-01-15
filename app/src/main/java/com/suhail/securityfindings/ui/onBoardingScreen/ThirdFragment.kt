package com.suhail.securityfindings.ui.onBoardingScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.suhail.securityfindings.dataStore.DataStoreFile
import com.suhail.securityfindings.databinding.FragmentThirdBinding
import com.suhail.securityfindings.ui.ViewPagerFragmentDirections
import com.suhail.securityfindings.viewModels.ViewPagerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : Fragment() {

    lateinit var binding: FragmentThirdBinding
    lateinit var navController: NavController
    val viewModel: ViewPagerViewModel by viewModels()
    lateinit var dataStore: DataStoreFile
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(layoutInflater)
        navController = findNavController()
        dataStore = DataStoreFile(this.requireContext())
        binding.finish.setOnClickListener {
            viewModel.updateDataInDataStore()
        }
        viewModel.goToNextPage.observe(viewLifecycleOwner, Observer {
            if (it) {
                val action =
                    ViewPagerFragmentDirections.actionViewPagerFragmentToLoginFragment()
                navController.navigate(action)
            }
        })

        return binding.root
    }

}