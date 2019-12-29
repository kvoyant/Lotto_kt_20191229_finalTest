package com.yhkim.lotto_kt_20191229_finaltest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {
        lottoBtn.setOnClickListener {
            val intent = Intent(mContext, LottoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun setValues() {

        Log.d("토큰값 확인", FirebaseInstanceId.getInstance().token)

        //앱을 꺼놓고 해야 보인다 , FirebaseServce에서는 최초한번만 보이므로 여기서 계속 확인 가능
//에뮬레이터
//epnAXDAJUkI:APA91bEdFAK1CbmLDeOhosN7dMCI2eNT0uTxRaQZbptmnAxjSZ66d1CFHVqqnk1PwB8zDsv1f5mU4p7Un-Ck95qglDaHxTx63iAXEMsRisHBL74ovaDY4HOTMquMU4bi1w54NmAMzJ3F
// 내폰
//dzKeeyqJnhg:APA91bGm6Lsv4SlxOqfetSorng5u7Rsm5R3qGmBC_Al2xhJ7TsEb4b6lj_o1vj0-XLvp8pNJR6wnfXekc54g20UIFrB9sbN32eGsovEVU22p_2tOgPRAU0e2qJsuygzl7Vq28STJURpy
    }

}
