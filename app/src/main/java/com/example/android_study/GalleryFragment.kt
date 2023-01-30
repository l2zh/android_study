package com.example.android_study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_study.databinding.FragmentGalleryBinding
import com.example.android_study.databinding.FragmentHomeBinding

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding: FragmentGalleryBinding
        get() = requireNotNull(_binding)

    private val mockRepoList =listOf(
        body_data(
            R.drawable.eye,
            "눈",

        ),
        body_data(
            R.drawable.nose,
            "코",

        ),
        body_data(
            R.drawable.mouth,
            "입",

        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val adapter = body_adapter(requireContext())
        binding.vpBody.adapter = adapter // adapter 연결
        adapter.setbodyList(mockRepoList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}