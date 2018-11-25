package com.stein.patternapplication.prototype

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

class PrototypeFragment : Fragment() {

    companion object {
        private val ARG_CAUGHT = "myFragment_caught"

        fun newInstance(caught: String): PrototypeFragment {
            val args: Bundle = Bundle()
            args.putSerializable(ARG_CAUGHT, caught)
            val fragment = PrototypeFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val heavyClass = HeavyClass()

        val clonedHeavyClass = heavyClass.clone()

        //also in Kotlin copy can be used in data classes without imlpementing Cloneable interface

        //also can be used together with abstractFactory , Where can be base parent template with children templates
        //AbstractFactory setup to get any of Base Templates
        //We can send any of children of templates to abstract Factory and it will be clone instances directly that child templates which we send
    }


    data class EMail(var recipient: String, var subject: String?, var message: String?) {
        fun quote(startIndex: Int): String {
            return "> ${message?.substring(startIndex)}"
        }
    }

}