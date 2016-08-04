package com.warmodroid.mohit.ganesha;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

/**
 * Created by root on 2/8/16.
 */
public class ChargerConnected extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(400);
        Toast.makeText(context, "Charger Connected", Toast.LENGTH_LONG).show();
        context.startService(new Intent(context,service.class));
    }
}
