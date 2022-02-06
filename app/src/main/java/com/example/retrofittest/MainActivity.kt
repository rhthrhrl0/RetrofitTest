package com.example.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        //뷰모델 연결
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        binding.vm=viewModel

        //이렇게 하면 해당 binding에 연결시킨 뷰모델은 지정한 생명주기동안 옵저버 역할 함
        binding.lifecycleOwner=this

    }
}