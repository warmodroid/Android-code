package com.warmodroid.mohit.ganesha;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

/**
 * Created by root on 2/8/16.
 */
public class ChargerDisconected extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(400);
        //Toast.makeText(context,"Charger Disconnected",Toast.LENGTH_LONG).show();
        context.stopService(new Intent(context,service.class));
    }
}
