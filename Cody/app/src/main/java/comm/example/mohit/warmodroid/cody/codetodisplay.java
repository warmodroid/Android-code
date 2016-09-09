package comm.example.mohit.warmodroid.cody;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mohit.warmodroid.cody.R;

/**
 * Created by mohit on 10/27/2015.
 */
public class codetodisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codetodisplay);
        Bundle bundle = getIntent().getExtras();
        String code = bundle.getString("code");

        TextView cod = (TextView) findViewById(R.id.code);
        cod.setText(code);

    }
}
