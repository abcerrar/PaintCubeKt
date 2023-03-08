package com.example.paintcubekt

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class tablero : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_tablero, container, false)

        Log.d("hola", "hola")

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            tablero().apply {

            }
    }
}