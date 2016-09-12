package mohit.warmodroid.hamp.customviewtwo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by shiv on 9/10/16.
 */
public class ColorOptionsView extends View{
    private View mValue;
    private ImageView mImage;
    private Paint paint;
    String cirlceText;
    int circleColor,circleTextColor;
    float circleTextSize,circleRaduis;


    public ColorOptionsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ColorOptionsView, 0, 0);

        cirlceText = a.getString(R.styleable.ColorOptionsView_circleText);
        circleColor = a.getColor(R.styleable.ColorOptionsView_circleColor, 0);
        circleTextColor = a.getColor(R.styleable.ColorOptionsView_circleTextColor, 0);
        circleTextSize = a.getFloat(R.styleable.ColorOptionsView_circleTextSize,70);
        circleRaduis = a.getFloat(R.styleable.ColorOptionsView_circleRaduis,0);
        a.recycle();
        setWillNotDraw(false);
    }



    public void setCirlceText(String cirlceText) {
        this.cirlceText = cirlceText;
        invalidate();
        requestLayout();
    }

    public void setCircleRaduis(float circleRaduis) {
        this.circleRaduis = circleRaduis;
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
        invalidate();
        requestLayout();
    }



    public void setCircleTextColor(int circleTextColor) {
        this.circleTextColor = circleTextColor;
        invalidate();
        requestLayout();
    }



    public void setCircleTextSize(float circleTextSize) {
        this.circleTextSize = circleTextSize;
        paint.setTextSize(circleTextSize);
        invalidate();
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(circleColor);
        int centerX = this.getMeasuredWidth()/2;
        int centerY = this.getMeasuredHeight()/2;
        canvas.drawCircle(centerX,centerY,circleRaduis,paint);

        paint.setColor(circleTextColor);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(cirlceText,centerX,centerY,paint);
    }
}


