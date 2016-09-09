package mohit.warmodroid.hamp.panimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.textView);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout);
        final Animation a = AnimationUtils.loadAnimation(this,R.anim.anim);
        a.reset();
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.startAnimation(a);
                a.setDuration(10000);
            }
        });
    }
}
