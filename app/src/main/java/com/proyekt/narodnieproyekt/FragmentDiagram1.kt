package com.proyekt.narodnieproyekt

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.proyekt.narodnieproyekt.models.Danniy
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.proyekt.narodnieproyekt.databinding.FragmentDiagram1Binding
import com.proyekt.narodnieproyekt.databinding.ItemListBinding


class FragmentDiagram1 : Fragment() {


    private var _binding: FragmentDiagram1Binding? = null
    private val binding get() = _binding!!

    private var position = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDiagram1Binding.inflate(layoutInflater)
        setDannie()

        val barChart: BarChart = binding.barChart
        val entries: ArrayList<BarEntry> = ArrayList()

        entries.add(BarEntry(1991f, 643f))
        entries.add(BarEntry(1992f, 641f))
        entries.add(BarEntry(1993f, 618f))
        entries.add(BarEntry(1994f, 607f))
        entries.add(BarEntry(1995f, 595f))
        entries.add(BarEntry(1996f, 601f))
        entries.add(BarEntry(1997f, 571f))
        entries.add(BarEntry(1998f, 591f))
        entries.add(BarEntry(1999f, 592f))
        entries.add(BarEntry(2000f, 584f))
        entries.add(BarEntry(2001f, 581f))
        entries.add(BarEntry(2002f, 595f))
        entries.add(BarEntry(2003f, 620f))
        entries.add(BarEntry(2004f, 633f))



        val barDataSet = BarDataSet(entries, "Entries")
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS, 200)
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 16f

        val barData = BarData(barDataSet)
        barChart.setFitBars(true)
        barChart.data = barData
        barChart.description.text = "Custom Bar Chart Example"

        barChart.animate()






        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun setList(): ArrayList<Danniy> {
        val list = ArrayList<Danniy>()
        list.add(Danniy("1991г", "643,0", R.drawable.redish))
        list.add(Danniy("1992г", "641,0", R.drawable.orange))
        list.add(Danniy("1993г", "618,0", R.drawable.yellow))
        list.add(Danniy("1994г", "607,0", R.drawable.green))
        list.add(Danniy("1995г", "595,0", R.drawable.brown))
        list.add(Danniy("1996г", "601,0", R.drawable.redish))
        list.add(Danniy("1997г", "571,0", R.drawable.orange))
        list.add(Danniy("1998г", "591,0", R.drawable.yellow))
        list.add(Danniy("1999г", "592,0", R.drawable.green))
        list.add(Danniy("2000г", "584,0", R.drawable.brown))
        list.add(Danniy("2001г", "581,0", R.drawable.redish))
        list.add(Danniy("2002г", "595,0", R.drawable.orange))
        list.add(Danniy("2003г", "620,0", R.drawable.yellow))
        list.add(Danniy("2004г", "633,0", R.drawable.green))
        return list
    }

    fun setDannie() {
        val list = setList()
        list.forEach {
            val view = ItemListBinding.inflate(layoutInflater)
            view.data.text = list[position].data
            view.summa.text = list[position].summa1
            view.input.setImageResource(list[position].color!!)
            binding.listContainer.addView(view.root)
            position += 1
        }
    }

}