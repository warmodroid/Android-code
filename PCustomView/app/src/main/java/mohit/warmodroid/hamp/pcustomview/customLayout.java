package mohit.warmodroid.hamp.pcustomview;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by shiv on 9/9/16.
 */
public class customLayout extends RelativeLayout {

    View rootView;
    TextView valueTextViewOne,valueTextViewTwo;


    public customLayout(Context context) {
        super(context);
        init(context);
    }



    public customLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        //do all set work up here
        rootView = inflate(context,R.layout.custom_layout,this);
        valueTextViewOne= (TextView) rootView.findViewById(R.id.editTextOne);
        valueTextViewTwo = (TextView) rootView.findViewById(R.id.editTextTwo);

    }
}
