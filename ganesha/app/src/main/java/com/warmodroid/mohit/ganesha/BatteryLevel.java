package com.warmodroid.mohit.ganesha;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.Vibrator;
import android.widget.Toast;

/**
 * Created by root on 2/8/16.
 */

public class BatteryLevel extends BroadcastReceiver {
    private boolean isCharging,usbCharge,acCharge;
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);


        float batteryPct = level / (float)scale;
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(400);
        Toast.makeText(context,"Charged = "+batteryPct,Toast.LENGTH_LONG).show();

    }
}
