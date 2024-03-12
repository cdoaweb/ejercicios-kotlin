package com.pmdm.fragmentos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private val firstFragment = FirstFragment()
    private val secondFragment= SecondFragment()
    private lateinit var fragmentManager : FragmentManager //gestor de Fragmentos.
    private lateinit var btnFirstFragment: Button
    private lateinit var btnSecondFragment: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        initEvent()
    }

    private fun initComponent() {
       fragmentManager = supportFragmentManager  //gestor de transacciones
       btnFirstFragment = findViewById(R.id.btn_frag1)
       btnSecondFragment = findViewById(R.id.btn_frag2)
    }

    private fun initEvent() {
        btnFirstFragment.setOnClickListener{
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, firstFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btnSecondFragment.setOnClickListener{
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }


}