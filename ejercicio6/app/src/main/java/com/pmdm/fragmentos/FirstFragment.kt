package com.pmdm.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {
    private lateinit var btn_frag_1_to_2 : Button
    lateinit var navController : NavController          //nuestro navController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navHost = requireActivity()     //referencia del activity
            .supportFragmentManager         //administrador de Fragmentos
            .findFragmentById(R.id.fragment_container_view_dinamic)

        navHost?.let {//Si entramos dentro, no es nulo.
            navController = navHost!!.findNavController()

            btn_frag_1_to_2 = view.findViewById(R.id.btn_frag_1_to_2)

            btn_frag_1_to_2.setOnClickListener {
                //  Toast.makeText(requireContext(), "Botón pulsado", Toast.LENGTH_SHORT).show()
                navController.navigate(R.id.action_fragmentFirst_to_fragmentSecond)  //navegamos
            }
        }
    }
}