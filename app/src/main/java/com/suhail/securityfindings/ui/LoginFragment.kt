package com.suhail.securityfindings.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.suhail.securityfindings.R
import com.suhail.securityfindings.dataStore.DataStoreFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginFragment : Fragment() {
    lateinit var dataStore: DataStoreFile
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStore = DataStoreFile(this.requireContext())
        lifecycleScope.launch {
            dataStore.getDataStore().collect {
                if (!it) {
                    withContext(Dispatchers.Main) {
                        navController = findNavController()
                        val action =
                            LoginFragmentDirections.actionLoginFragmentToViewPagerFragment()
                        navController.navigate(action)
                    }
                }
            }
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}