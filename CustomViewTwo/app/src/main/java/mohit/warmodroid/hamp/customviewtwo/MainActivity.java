package mohit.warmodroid.hamp.customviewtwo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ColorOptionsView myView = (ColorOptionsView) findViewById(R.id.circle);
        myView.setCirlceText("Click on me to see magic");
        myView.setCircleTextSize(20);
        myView.setCircleRaduis(150);
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_button);
        animation.reset();
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You clicked this circle",Toast.LENGTH_LONG).show();
                myView.setCircleColor(Color.GREEN);
                myView.startAnimation(animation);
                animation.setDuration(10000);
            }
        });
    }

}
