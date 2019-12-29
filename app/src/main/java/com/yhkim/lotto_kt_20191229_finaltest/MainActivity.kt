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
    }

}
