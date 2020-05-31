package com.studying.firstkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.studying.firstkotlin.model.Holder
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_blank.view.*

class BlankFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_blank, container, false)
        val adapter = ArrayAdapter(root.context, android.R.layout.simple_spinner_item, Holder.unitList.keys.toMutableList())
        root.in_number_type.adapter = adapter
        root.out_number_type.adapter = adapter
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        in_number.addTextChangedListener { calc() }
        in_number_type.onItemSelectedListener = spinnerListener
        out_number_type.onItemSelectedListener = spinnerListener
    }

    private fun calc() {
        val inNumber = in_number.text.toString().ifEmpty { "0" }.toDouble()
        val result = inNumber.div(Holder.unitList.getOrDefault(
            in_number_type.selectedItem.toString(), 1.0))

        out_number.text = result.times(Holder.unitList.getOrDefault(
            out_number_type.selectedItem.toString(), 1.0)).toString()
    }

    private val spinnerListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            if (in_number.text.isNotEmpty()) calc()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
}
