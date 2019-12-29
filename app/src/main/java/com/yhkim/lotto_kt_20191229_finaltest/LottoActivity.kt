package com.yhkim.lotto_kt_20191229_finaltest

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_lotto.*
import java.util.*
import kotlin.collections.ArrayList

class LottoActivity : BaseActivity() {

    var totalWinMoney = 0L //0을 Long 타입으로 => 그냥 0은 Int로 간주되어 값이 적음
    var usedMoney = 0L //사용금액

    val winLottoNumArr = ArrayList<Int>()
    val winLottoNumTextViewList = ArrayList<TextView>()
    val myLottoNumTextViewList = ArrayList<TextView>()

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

//            몇등인지 판단하기
            checkLottoRank()
        }
    }

    fun checkLottoRank() {

//        등수판단?
//        내가 가진 숫자들과 / 당첨번호를 하나하나 비교해서, 같은 숫자가 몇개인지? 세어야함.
//        이개수에 따라서 등수를 판정.
//        개수가 6개 : 1등 , 5개 : 3등 , 4개 : 4등, 3개 : 5등

//        같은 숫자 카운팅
        var correctCount = 0

//        내가 가진 숫자를
//        몇개의 숫자를 맞췄는지를 correctCount

        for( myNumTxt in myLottoNumTextViewList) {
//            각텍스트뷰에 적힌 숫자가 String => Int로 변환
            val num = myNumTxt.text.toString().toInt()

            Log.d("적혀있는(내가 쓴) 숫자들", num.toString())

            for ( winNum in winLottoNumArr) {
                if(num == winNum) {
//                    당첨번호에 들어있다 ! 맞춘 개수 1 증가
                    correctCount++
                    break
                }
            }
        }

//        맞춘 개수에 따라 등수를 판정
        if(correctCount == 6) {
//            1등 당첨 => 당첨금액 += 50억
            totalWinMoney += 5000000000
        }
        else if( correctCount == 5) {
//            2등 당첨 => 당첨금액 += 150만원
            totalWinMoney += 1500000
        }
        else if( correctCount == 4) {
//            3등 당첨 => 당첨금액 += 5만원
            totalWinMoney += 50000
        }
        else if( correctCount == 3) {
//            4등 당첨 => 당첨금액 += 5천원
            totalWinMoney += 5000
        }
        else {
//            꽝! 당첨금액 변화 없음

        }

        totalWinMoneyTxt.text = String.format("%,d원", totalWinMoney)

//        사용금액 : 한장살때마다 천원씩 증가
        usedMoney += 1000
        useWinMoneyTxt.text = String.format("%,d원", usedMoney)

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
//        for(num in winLottoNumArr) {
//            Log.d("당첨번호",num.toString())
//        }

        for(i in 0..5) {
            val tempTextView = winLottoNumTextViewList.get(i)
            val winNum = winLottoNumArr.get(i)

            tempTextView.text = winNum.toString()
        }
    }

    override fun setValues() {
//        당첨 번호 텍스트뷰들을 배열로 담아둠
        winLottoNumTextViewList.add(lottoNumTxt01)
        winLottoNumTextViewList.add(lottoNumTxt02)
        winLottoNumTextViewList.add(lottoNumTxt03)
        winLottoNumTextViewList.add(lottoNumTxt04)
        winLottoNumTextViewList.add(lottoNumTxt05)
        winLottoNumTextViewList.add(lottoNumTxt06)

//        내가 뽑은 번호 텍스트뷰들을 배열로 담아둠
        myLottoNumTextViewList.add(myNumTxt01)
        myLottoNumTextViewList.add(myNumTxt02)
        myLottoNumTextViewList.add(myNumTxt03)
        myLottoNumTextViewList.add(myNumTxt04)
        myLottoNumTextViewList.add(myNumTxt05)
        myLottoNumTextViewList.add(myNumTxt06)
    }
}
