package com.proyekt.narodnieproyekt

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.proyekt.narodnieproyekt.models.Danniy
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.proyekt.narodnieproyekt.databinding.FragmentDiagram2Binding
import com.proyekt.narodnieproyekt.databinding.ItemList2Binding
import com.proyekt.narodnieproyekt.databinding.ItemListBinding


class FragmentDiagram2 : Fragment() {
    private var _binding: FragmentDiagram2Binding?=null
    private val binding get() = _binding!!
    private var position = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDiagram2Binding.inflate(layoutInflater)

        val pieChart: PieChart = binding.pieChart
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry( 641.0f))
        entries.add(PieEntry(656.0f))
        entries.add(PieEntry(653.0f))
        entries.add(PieEntry(665.1f))
        entries.add(PieEntry(583.1f))
        entries.add(PieEntry(650.7f))
        entries.add(PieEntry(670.7f))
        entries.add(PieEntry( 654.5f))
        entries.add(PieEntry( 667.8f))
        entries.add(PieEntry( 642.0f))
        entries.add(PieEntry( 635.5f))
        entries.add(PieEntry(  691.1f))
        entries.add(PieEntry( 725.4f))
        entries.add(PieEntry( 738.0f))
        entries.add(PieEntry( 725.4f))
        entries.add(PieEntry( 692.3f))
        entries.add(PieEntry( 762.3f))
        entries.add(PieEntry( 672.0f))

        val pieDataSet = PieDataSet(entries,"Entries")
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS,200)
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.valueTextSize = 10f
        val pieData = PieData(pieDataSet)
        pieChart.data = pieData
        pieChart.description.isEnabled = false
        pieChart.centerText = "2022 - 672,0"
        pieChart.animate()

        setList()
        setDannie()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setList(): ArrayList<Danniy> {
        val list = ArrayList<Danniy>()
        list.add(Danniy("2005г", "641,0", R.drawable.redish))
        list.add(Danniy("2006г", "656,0", R.drawable.orange))
        list.add(Danniy("2007г", "653,0", R.drawable.yellow))
        list.add(Danniy("2008г", "665,1", R.drawable.green))
        list.add(Danniy("2009г","583,1",R.drawable.brown))
        list.add(Danniy("2010г","650,7",R.drawable.redish))
        list.add(Danniy("2011г","670,7",R.drawable.orange))
        list.add(Danniy("2012г","654,5",R.drawable.yellow))
        list.add(Danniy("2013г","667,8",R.drawable.green))
        list.add(Danniy("2014г","642,0",R.drawable.brown))
        list.add(Danniy("2015г","635,5",R.drawable.redish))
        list.add(Danniy("2016г","640,2",R.drawable.orange))
        list.add(Danniy("2017г","691,1",R.drawable.yellow))
        list.add(Danniy("2018г","725,4",R.drawable.green))
        list.add(Danniy("2019г","738,0",R.drawable.brown))
        list.add(Danniy("2020г","692,3",R.drawable.redish))
        list.add(Danniy("2021г","762,3",R.drawable.orange))
        list.add(Danniy("2022г","672,0",R.drawable.yellow))



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