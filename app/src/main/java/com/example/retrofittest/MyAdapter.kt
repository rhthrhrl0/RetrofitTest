package com.example.retrofittest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittest.databinding.MainItemBinding

class MyAdapter():RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var postList= mutableListOf<ResponseResult>()

    //뷰홀더 역할을 맡을 뷰홀더 클래스
    class MyViewHolder(val binding:MainItemBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(currentPost:ResponseResult){
            binding.postVm=currentPost
            //건네받은 게시물객체를 화면에 띄우기 위해서 뷰홀더와 연결시키는 것임.
            //뷰홀더를 구성하는 binding의 postVm에 띄울 게시물 객체를 연결시키는 것.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=MainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}