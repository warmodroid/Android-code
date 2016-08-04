package jaaga.arpit.crystalball;

import jaaga.arpit.crystalball.ShakeDetector.OnShakeListener;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private CrystalBall mcrystalball = new CrystalBall();
	private TextView mAnswerLabel;
	private ImageView CrystalBallImage;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private ShakeDetector mShakeDetector;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mAnswerLabel = (TextView) findViewById(R.id.textView1);
    	CrystalBallImage = (ImageView) findViewById(R.id.imageView1);
       
    	mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    	mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    	mShakeDetector = new ShakeDetector(new OnShakeListener() {
			
			@Override
			public void onShake() {
				handleNewAnswer();
			}
		});
    	
     }
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
        
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	mSensorManager.unregisterListener(mShakeDetector);
    }

    private void animateCrystalBall(){
    	
    	//Set the ball_animation.xml file to CrystalBallImage
    	CrystalBallImage.setImageResource(R.drawable.ball_animation);
    	
    	AnimationDrawable ballAnimation = (AnimationDrawable) CrystalBallImage.getDrawable();
    	if(ballAnimation.isRunning())
    	{
    		ballAnimation.stop();
    	}
    	ballAnimation.start();
    }
    
    private void animateAnswer(){
    	AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
    	fadeInAnimation.setDuration(1500);
    	fadeInAnimation.setFillAfter(true);
    	
    	mAnswerLabel.setAnimation(fadeInAnimation);
    }
    
    private void playsound(){
    	MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.crystal_ball);
    	player.start();
    	player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	private void handleNewAnswer() {
		String answer = mcrystalball.getAnswer();
		mAnswerLabel.setText(answer);
		animateCrystalBall();
		playsound();
	}
    
}
