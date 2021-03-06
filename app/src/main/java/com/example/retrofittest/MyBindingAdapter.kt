package com.example.retrofittest


import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object MyBindingAdapter {
    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: ArrayList<ResponseResult>?) {
        val myAdapter = recyclerView.adapter as MyAdapter
        if (items != null) {
            //submitList로 넘겨주면 ListAdapter가 내부적으로 알아서 현재와의 차이를 계산해줌.
            //이때 백그라운드 스레드를 사용하고 리스트 차이만 비교하여 효율적으로 갱신
            myAdapter.submitList(items)
        }
    }
}