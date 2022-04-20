package com.dev23.myapplication.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev23.myapplication.R
import com.dev23.myapplication.data.HealthItem
import com.dev23.myapplication.databinding.CardsViewBinding

class CardsList @JvmOverloads constructor(
    context:Context?,
    attrSet:AttributeSet?=null,
    defStyleAttr:Int=0
) : LinearLayout(context,attrSet,defStyleAttr) {

    private var binding:CardsViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
    R.layout.cards_view,this,true)

    private lateinit var cardsAdapter: CardsAdapter

    init {
        initLayoutManager()
    }

    private fun initLayoutManager(){
        val mLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context)
        binding.cardsList.layoutManager = mLayoutManager
    }

    fun initData(cards: MutableList<HealthItem?>){
        cardsAdapter = CardsAdapter(context,cards)
        binding.cardsList.adapter = cardsAdapter
    }

}