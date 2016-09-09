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
        final TextView textViewOne = (TextView) findViewById(R.id.textView1);
        final TextView textViewTwo = (TextView) findViewById(R.id.textView2);
        final TextView textViewThree = (TextView) findViewById(R.id.textView3);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout);
        final Animation a = AnimationUtils.loadAnimation(this,R.anim.textviewone);
        final Animation b = AnimationUtils.loadAnimation(this,R.anim.textviewtwo);
        final Animation c = AnimationUtils.loadAnimation(this,R.anim.textviewthree);
        a.reset();
        b.reset();
        c.reset();
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewOne.startAnimation(a);
                textViewTwo.startAnimation(b);
                textViewThree.startAnimation(c);
                a.setDuration(10000);
                b.setDuration(10000);
                c.setDuration(10000);
            }
        });
    }
}
