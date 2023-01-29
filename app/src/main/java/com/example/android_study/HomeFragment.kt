package com.example.android_study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_study.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding)

    private val mockRepoList =listOf(
        clothes_data(
            R.drawable.clothes_1,
            "TOP",
            "$10000"
        ),
        clothes_data(
            R.drawable.clothes_2,
            "OUTER",
            "$1000000"
        ),
        clothes_data(
            R.drawable.clothes_3,
            "PANTS",
            "$60000"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val adapter = clothes_adapter(requireActivity())
        binding.rvClothes.adapter = adapter // adapter 연결
        adapter.setclothesList(mockRepoList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}