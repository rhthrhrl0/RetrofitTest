package com.example.retrofittest

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object MyBindingAdapter {
    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView,items : ArrayList<ResponseResult>){
            if(recyclerView.adapter==null) {
                val adapter=MyAdapter()
                adapter.setHasStableIds(true)
                recyclerView.adapter=adapter
            }

            val myAdapter=recyclerView.adapter as MyAdapter
            myAdapter.postList=items
            myAdapter.notifyDataSetChanged()
            //대입시켜주고 어댑터 한번 갱신시킴
    }
}