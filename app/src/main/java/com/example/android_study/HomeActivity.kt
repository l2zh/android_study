package com.example.android_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.android_study.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.galleryFragment -> setFragment(TAG_GALLERY, GalleryFragment())
                R.id.searchFragment -> setFragment(TAG_SEARCH, SearchFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null) {
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME)
        val gallery = manager.findFragmentByTag(TAG_GALLERY)
        val search = manager.findFragmentByTag(TAG_SEARCH)

        if (home != null) {
            fragTransaction.hide(home)
        }

        if (gallery != null) {
            fragTransaction.hide(gallery)
        }

        if (search != null) {
            fragTransaction.hide(search)
        }

        if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        } else if (tag == TAG_GALLERY) {
            if (gallery != null) {
                fragTransaction.show(gallery)
            }
        } else if (tag == TAG_SEARCH) {
            if (search != null) {
                fragTransaction.show(search)
            }
        }

        fragTransaction.commitAllowingStateLoss()

    }

    companion object {
        const val TAG_HOME = "home_fragment"
        const val TAG_GALLERY = "gallery_fragment"
        const val TAG_SEARCH = "search_fragment"
    }
}