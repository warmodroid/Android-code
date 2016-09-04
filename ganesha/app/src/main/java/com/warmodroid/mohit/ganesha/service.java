package com.warmodroid.mohit.ganesha;
import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by root on 3/8/16.
 */
public class service extends Service {

    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver() {
        private boolean usbCharge,acCharge;
        @Override
        public void onReceive(Context ctxt, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
            if (level == 100 && (usbCharge || acCharge)) {
                Vibrator v = (Vibrator) ctxt.getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 500 milliseconds
                v.vibrate(10000);
            }
        }
    };


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        //Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}
