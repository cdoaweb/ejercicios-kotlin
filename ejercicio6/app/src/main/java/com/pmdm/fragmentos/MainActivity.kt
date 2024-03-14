package com.pmdm.fragmentos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager : FragmentManager //gestor de Fragmentos.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initComponent()
    }

    private fun initComponent() {
       fragmentManager = supportFragmentManager  //gestor de transacciones
    }


}