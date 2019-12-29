package com.yhkim.lotto_kt_20191229_finaltest

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_lotto.*
import java.util.*
import kotlin.collections.ArrayList

class LottoActivity : BaseActivity() {

    val winLottoNumArr = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotto)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {
        buyOneLottoBtn.setOnClickListener {
//            6개의 숫자를 랜덤으로 생성 => 텍스트뷰 6개에 반영
            makeWinLottoNum()
        }
    }

    fun makeWinLottoNum() {
//        기존의 당첨 번호 일단 삭제
//        6개의 당첨 번호 생성 => 6번 반복
//        랜덤으로 숫자를 생성 => 제약조건 : 1 ~ 45 사이 , 중복허용안함
//        제약조건을 통과한다면 => 당첨번호 목록으로 추가 : 배열 사용(ArrayList)
//        작은 숫자 부터 정렬
//        여기까지 완료되면 6개 텍스트뷰에 반영 예정

        winLottoNumArr.clear()

        for(i in 0..5) {

            while (true) {
                val randomInt = Random().nextInt(45) + 1 // 0 ~ 44의 랜덤값 + 1 => 1 ~ 45의 랜덤값

                var isDupOk = true // 중복검사여부
                for(num in winLottoNumArr) {
                    if(randomInt == num) {
//                    중복 확인
                        isDupOk = false
                        break
                    }
                }

                if(isDupOk) {
                    winLottoNumArr.add(randomInt)
                    break
                }
            }

        }
        Log.d("최종값",winLottoNumArr.toString())

//      내부값 정렬(오름차순)
        Collections.sort(winLottoNumArr)

//        번호 확인
        for(num in winLottoNumArr) {
            Log.d("로또번호",num.toString())

        }
    }

    override fun setValues() {
    }
}
