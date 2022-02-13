package com.example.retrofittest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //힐트 사용하기 위해 필요함. 필트를 쓰는 모든 앱은 해당 어노테이션이 있는 Application 필요
class BaseApplication :Application() {
}