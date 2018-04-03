package com.example.usuari.smsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class ReceptorSms extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       String origen = "";
       String textoSMS = "";
       Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        for (int i = 0; i <pdus.length; i++) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                SmsMessage sm = SmsMessage.createFromPdu((byte[])pdus[i],"3gpp");
                origen = sm.getOriginatingAddress();
                textoSMS += sm.getMessageBody().toString();
            }
        }
        MainActivity.misSMS.add(origen+":"+textoSMS);
    }
}
