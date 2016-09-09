package comm.example.mohit.warmodroid.cody;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mohit.warmodroid.cody.R;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

public class p_dpc_single_ques_show extends AppCompatActivity implements InterstitialAdListener {

    private AdView adView;
    TextView an;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_dpc_single_ques_show);
        loadInterstitialAd();
        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);

        adView = new AdView(this, "1676535802590804_1695054214072296", AdSize.BANNER_320_50);
        adViewContainer.addView(adView);
        adView.loadAd();
        an = (TextView) findViewById(R.id.a);
        Bundle bundle = getIntent().getExtras();
        String answer = bundle.getString("answer");
        an.setText(answer);
    }
    private void loadInterstitialAd(){
        interstitialAd = new InterstitialAd(this, "1676535802590804_1692537470990637");
        interstitialAd.setAdListener(p_dpc_single_ques_show.this);
        interstitialAd.loadAd();
    }
    @Override
    public void onInterstitialDisplayed(Ad ad) {

    }

    @Override
    public void onInterstitialDismissed(Ad ad) {

    }

    @Override
    public void onError(Ad ad, AdError adError) {

    }

    @Override
    public void onAdLoaded(Ad ad) {
        interstitialAd.show();
    }

    @Override
    public void onAdClicked(Ad ad) {

    }
}
