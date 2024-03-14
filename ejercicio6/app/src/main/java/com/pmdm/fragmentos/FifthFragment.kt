package com.pmdm.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class FifthFragment : Fragment() {
    lateinit var navController : NavController
    lateinit var btn_frag_5_to_4 : Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fifth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navHost = requireActivity()     //referencia del activity
            .supportFragmentManager         //administrador de Fragmentos
            .findFragmentById(R.id.fragment_container_view_dinamic)

        navHost.let {//Si entramos dentro, no es nulo.
            navController = navHost!!.findNavController()

            btn_frag_5_to_4 = view.findViewById(R.id.btn_frag_5_to_4)

            btn_frag_5_to_4.setOnClickListener {

                navController.navigate(R.id.action_fragmentFifth_to_fragmentFourth)
            }
        }
    }
}