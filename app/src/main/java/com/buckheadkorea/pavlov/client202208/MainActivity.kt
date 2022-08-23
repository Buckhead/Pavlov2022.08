package com.buckheadkorea.pavlov.client202208

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.buckheadkorea.pavlov.client202208.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        프래그먼트를 생성
        val fragmentList = listOf(FragmentA(),FragmentB(),FragmentC(),FragmentD())

        //어댑터를 생성하고, 생성해둔 프래그먼트 목록을 저장한다.
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList

        //뷰페이저에 어댑터를 연결해준다.
        binding.viewPager.adapter = adapter

        //TabLayout과 뷰 페이저를 연결한다.
        // TabLayoutMediator로 TabLayout과 뷰페이저를 연결한다.
        val tabTitles = listOf<String>("A","B","C","D")
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = tabTitles[position]
        }.attach()

    }
}