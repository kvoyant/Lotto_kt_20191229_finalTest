package com.yhkim.lotto_kt_20191229_finaltest.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

//        Notification 타입의 푸시에 사용되는 자료
//        remoteMessage.notification

//        데이터 메세지에 대한 자료
//        remoteMessage?.data
    }

    override fun onNewToken(token: String?) {
        super.onNewToken(token)

        Log.d("발급받은토큰" , token)
//epnAXDAJUkI:APA91bEdFAK1CbmLDeOhosN7dMCI2eNT0uTxRaQZbptmnAxjSZ66d1CFHVqqnk1PwB8zDsv1f5mU4p7Un-Ck95qglDaHxTx63iAXEMsRisHBL74ovaDY4HOTMquMU4bi1w54NmAMzJ3F
    }

}
