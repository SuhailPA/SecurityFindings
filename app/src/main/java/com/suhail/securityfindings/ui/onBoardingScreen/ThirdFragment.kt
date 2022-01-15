package com.suhail.securityfindings.ui.onBoardingScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.suhail.securityfindings.dataStore.DataStoreFile
import com.suhail.securityfindings.databinding.FragmentThirdBinding
import com.suhail.securityfindings.ui.ViewPagerFragmentDirections
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ThirdFragment : Fragment() {

    lateinit var binding: FragmentThirdBinding
    lateinit var navController: NavController
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
            lifecycleScope.launch {
                dataStore.saveToDataStore(true)
                withContext(Dispatchers.Main) {
                    val action =
                        ViewPagerFragmentDirections.actionViewPagerFragmentToLoginFragment()
                    navController.navigate(action)
                }
            }

        }
        return binding.root
    }

}