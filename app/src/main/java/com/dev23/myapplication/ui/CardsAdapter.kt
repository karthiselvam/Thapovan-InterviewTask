package com.dev23.myapplication.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev23.myapplication.R
import com.dev23.myapplication.data.HealthItem
import com.dev23.myapplication.databinding.ValuesViewBinding

class CardsAdapter (
    private val context:Context,
    private val healthItems:List<HealthItem?>
    ) : RecyclerView.Adapter<CardsAdapter.MyViewHolder>() {

    private lateinit var binding: ValuesViewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                                        R.layout.values_view,parent,false)
        return MyViewHolder(binding.root)
    }


    override fun getItemCount(): Int {
        return healthItems.size
    }


    @SuppressLint("SetTextI18n")
    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val list: RecyclerView = itemView.findViewById(R.id.list)

        fun bind(item: HealthItem) {
            tvName.text = item.name.toString()
            val mLayoutManager: RecyclerView.LayoutManager =
                LinearLayoutManager(context)
            list.layoutManager = mLayoutManager
            val accessibleAdapter = AccessibleAdapter(context, item.accessible!!)
            list.adapter = accessibleAdapter
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(healthItems[position]!!)
    }


}