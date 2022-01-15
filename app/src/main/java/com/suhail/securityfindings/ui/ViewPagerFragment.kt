package com.suhail.securityfindings.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.suhail.securityfindings.adapters.ViewPagerAdapter
import com.suhail.securityfindings.databinding.FragmentViewPagerBinding
import com.suhail.securityfindings.ui.onBoardingScreen.FirstScreenFragment
import com.suhail.securityfindings.ui.onBoardingScreen.SecondScreenFragment
import com.suhail.securityfindings.ui.onBoardingScreen.ThirdFragment

class ViewPagerFragment : Fragment() {

    lateinit var binding: FragmentViewPagerBinding
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewPagerBinding.inflate(layoutInflater)
        val fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdFragment()
        )

        val viewPagerAdapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.onBoardingScreens.adapter = viewPagerAdapter

        return binding.root
    }


}