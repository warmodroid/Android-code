package comm.example.mohit.warmodroid.cody;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.audiofx.BassBoost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mohit.warmodroid.cody.R;

public class settings extends AppCompatActivity {

    CheckBox mute_check ;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPreferences = getSharedPreferences("mute_prefer", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        mute_check = (CheckBox) findViewById(R.id.checkbox);

        mute_check.setChecked(sharedPreferences.getBoolean("value",false));
        mute_check.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(mute_check.isChecked())
                {
                    Toast.makeText(settings.this,"Now you  won't receive any notification",Toast.LENGTH_LONG).show();
                    editor.putBoolean("value",true);
                    editor.commit();
                }
                else
                {
                    Toast.makeText(settings.this,"You activated Push Notification Service",Toast.LENGTH_LONG).show();
                    editor.putBoolean("value",false);
                    editor.commit();
                }

            }
        });

    }
}
