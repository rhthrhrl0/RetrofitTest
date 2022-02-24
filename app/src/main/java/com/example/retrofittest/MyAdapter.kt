package com.example.retrofittest


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.retrofittest.databinding.MainItemBinding
import com.example.retrofittest.viewholder.MyViewHolder


class MyAdapter private constructor(
    diffCallback: DiffUtil.ItemCallback<ResponseResult>,
    var deleteClick: (ResponseResult) -> Unit
) :
    ListAdapter<ResponseResult, MyViewHolder>(diffCallback) {

    class Builder {

        //DiffUtil은 두 데이터셋을 받아서 차이를 비교해주는 클래스임.
        private val differCallBack = object : DiffUtil.ItemCallback<ResponseResult>() {
            override fun areItemsTheSame( //비교대상인 두 객체가 동일한지 비교
                oldItem: ResponseResult,
                newItem: ResponseResult
            ): Boolean {
                //각 게시물별로 고유번호인 id를 비교
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame( //두 아이템이 동일한 데이터를 가지는지 비교
                oldItem: ResponseResult,
                newItem: ResponseResult
            ): Boolean {
                return oldItem == newItem   //ResponseResult는 데이터클래스이므로 값을 비교함.
            }
        }

        fun build(deleteClick: (ResponseResult) -> Unit): MyAdapter {
            return MyAdapter(differCallBack, deleteClick)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: ResponseResult = getItem(position)
        holder.bind(item)
        //리스트어댑터는 따로 items리스트를 선언하지 않음. 내부적으로 존재함.
        //글서 오버라이드 메서드중 하나인 getItemCount는 더이상 만들지 않음.

        holder.binding.deleteBt.setOnClickListener {
            deleteClick(item)
        }
    }

}