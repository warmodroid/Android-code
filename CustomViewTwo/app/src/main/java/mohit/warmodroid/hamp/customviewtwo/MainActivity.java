package mohit.warmodroid.hamp.customviewtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorOptionsView myView = (ColorOptionsView) findViewById(R.id.circle);
        myView.setCirlceText("Hey its working now...!!!");
        myView.setCircleTextSize(20);
        myView.setCircleRaduis(150);
    }

}