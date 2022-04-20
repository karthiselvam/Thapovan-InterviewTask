package com.dev23.myapplication.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev23.myapplication.R
import com.dev23.myapplication.data.AccessibleItem
import com.dev23.myapplication.databinding.ListItemBinding
import com.dev23.myapplication.databinding.ValuesViewBinding

class AccessibleAdapter (
    private val context:Context,
    private val accessible:List<AccessibleItem?>
    ) : RecyclerView.Adapter<AccessibleAdapter.MyViewHolder>() {

    private lateinit var binding: ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                                        R.layout.list_item,parent,false)
        return MyViewHolder(binding.root)
    }


    override fun getItemCount(): Int {
        return accessible.size
    }


    @SuppressLint("SetTextI18n")
    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val tvType: TextView = itemView.findViewById(R.id.tvType)
        private val tvMessage: TextView = itemView.findViewById(R.id.tvMessage)
        private val imgValue: ImageView = itemView.findViewById(R.id.imgValue)

        fun bind(item: AccessibleItem) {
            tvType.text = item.type.toString()
            tvMessage.text = item.message.toString()
            val image = if (item.success == true){
                ContextCompat.getDrawable(context,R.drawable.ic_enabled)
            }else{
                ContextCompat.getDrawable(context,R.drawable.ic_disabled)
            }
            imgValue.setImageDrawable(image)
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(accessible[position]!!)
    }


}