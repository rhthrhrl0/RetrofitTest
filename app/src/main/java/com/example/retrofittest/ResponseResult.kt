package com.example.retrofittest

//이 데이터클래스는 응답을 리스트형태로 한번에 받기 위한 것이다.
class AllPostsResponse : ArrayList<ResponseResult>()

data class ResponseResult(
    //Json은 코틀린 자바와는 다르게 스네이크 표기법 사용
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
    //만약 응답받을 JSON응답 양식에 student_id 같은 변수가 있다고 하면
    //@SerializedName("student_id") 으로 매핑 시킬 수 있다.

    //data클래스는 자동으로 값비교를 하도록 도와주는 hashCode함수가 구현됨
)

