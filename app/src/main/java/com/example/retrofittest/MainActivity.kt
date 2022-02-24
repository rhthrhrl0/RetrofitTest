package com.example.retrofittest


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.retrofittest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels //이거 하려면  implementation 'androidx.activity:activity-ktx:1.2.0' 필요


//힐트 진입점. 만약 프래그먼트를 지니는 액티비티가 진입점이 필요없어도 액티비티에 선언해줘야함.
//그래야 해당 프래그먼트들에 진입가능함. 거기에도 물론 해당 어노테이션있어야함.
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.myAdapter = MyAdapter.Builder().build(viewModel::removeItem)

        binding.vm = viewModel

        //이렇게 하면 해당 binding에 연결시킨 뷰모델은 지정한 생명주기동안 옵저버 역할 함
        binding.lifecycleOwner = this

    }
}