package mohit.warmodroid.hamp.customviewtwo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by shiv on 9/10/16.
 */
public class ColorOptionsView extends RelativeLayout {
    private View mValue;
    private ImageView mImage;
    Paint paint;
    String cirlceText;
    int circleColor,circleTextColor;
    float circleTextSize;

    public ColorOptionsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ColorOptionsView, 0, 0);
        try {
            cirlceText = a.getString(R.styleable.ColorOptionsView_circleText);
            circleColor = a.getColor(R.styleable.ColorOptionsView_circleColor, 0);
            circleTextColor = a.getColor(R.styleable.ColorOptionsView_circleTextColor, 0);
            circleTextSize = a.getFloat(R.styleable.ColorOptionsView_circleTextSize,20);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(circleColor);
        int centerX = this.getMeasuredWidth()/2;
        int centerY = this.getMeasuredHeight()/2;
        int raduis = 150;
        canvas.drawCircle(centerX,centerY,raduis,paint);

        paint.setColor(circleTextColor);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(cirlceText,centerX,centerY,paint);
    }
}


