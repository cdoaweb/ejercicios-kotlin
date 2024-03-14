package com.pmdm.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController


class SecondFragment : Fragment() {
    private lateinit var btn_frag_2_to_3: Button
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navHost = requireActivity()     //referencia del activity
            .supportFragmentManager         //administrador de Fragmentos
            .findFragmentById(R.id.fragment_container_view_dinamic)

        navHost.let {//Si entramos dentro, no es nulo.
            navController = navHost!!.findNavController()

            btn_frag_2_to_3 = view.findViewById(R.id.btn_frag_2_to_3)

            btn_frag_2_to_3.setOnClickListener {

                navController.navigate(R.id.action_fragmentSecond_to_fragmentThird)
            }
        }
    }
}
