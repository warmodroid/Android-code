package com.warmodroid.mohit.ganesha;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean isCharging,usbCharge,acCharge;

   private TextView batteryTxt,typeOfCharge;
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context ctxt, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
            batteryTxt.setText(String.valueOf(level) + "%");
            if(usbCharge)
                typeOfCharge.setText("USB charger is plugged in");
            if(acCharge)
                typeOfCharge.setText("AC charger is plugged in");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryTxt = (TextView) this.findViewById(R.id.batteryTxt);
        typeOfCharge= (TextView) this.findViewById(R.id.current);
        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
