package com.example.retrofittest.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittest.ResponseResult
import com.example.retrofittest.databinding.MainItemBinding

class MyViewHolder(val binding: MainItemBinding ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(currentPost: ResponseResult?) {
        binding.post = currentPost
        //건네받은 게시물객체를 화면에 띄우기 위해서 뷰홀더와 연결시키는 것임.
        //뷰홀더를 구성하는 binding의 postVm에 띄울 게시물 객체를 연결시키는 것.
    }
}