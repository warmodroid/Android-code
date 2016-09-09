package comm.example.mohit.warmodroid.cody;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.facebook.ads.*;

import com.example.mohit.warmodroid.cody.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class java extends AppCompatActivity implements InterstitialAdListener {
    private static java mInstance;
    String[] title = {
            "Alphabetical Sort",
            "Armstrong Number",
            "Binary Search",
            "Bubble Sort",
            "Roots of Quadratic Equation",
            "Compare String",
            "Decimal to Binary Conversion",
            "Even Odd number",
            "Factorial of a Number using Recurion",
            "Fibonacci Number Series",
            "Linear Search",
            "Pallindrome String",
            "Prime Number",
            "Reverse String",
            "Selection Sort",
            "Swap two numbers without using third"
    } ;
    String[] desp = {
            "Alphabetical Sort",
            "Armstrong Number",
            "Binary Search",
            "Bubble Sort",
            "Roots of Quadratic Equation",
            "Compare String",
            "Decimal to Binary Conversion",
            "Even Odd number",
            "Factorial of a Number using Recurion",
            "Fibonacci Number Series",
            "Linear Search",
            "Pallindrome String",
            "Prime Number",
            "Reverse String",
            "Selection Sort",
            "Swap two numbers without using third"
    };
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadInterstitialAd();
        //googletrackers

        trackScreenView("java activity is open");


        ListView list ;
        CustomList adapter = new
                CustomList(java.this, title, desp);
        list=(ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(java.this, codetodisplay.class);
                intent.putExtra("code", new getCode("java/"+title[+position]+".txt",getApplicationContext()).print_on_text());
                startActivity(intent);
                Toast.makeText(java.this, "You Clicked at " + desp[+position], Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void loadInterstitialAd(){
        interstitialAd = new InterstitialAd(this, "1676535802590804_1677979455779772");
        interstitialAd.setAdListener(java.this);
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
    //yaha se googlr traker
    public static synchronized java getInstance() {
        return mInstance;
    }

    //google traker
    public synchronized Tracker getGoogleAnalyticsTracker() {
        AnalyticsTrackers analyticsTrackers = AnalyticsTrackers.getInstance();
        return analyticsTrackers.get(AnalyticsTrackers.Target.APP);
    }

    /***
     * Tracking screen view
     *
     * @param screenName screen name to be displayed on GA dashboard
     */
    public void trackScreenView(String screenName) {
        Tracker t = getGoogleAnalyticsTracker();

        // Set screen name.
        t.setScreenName(screenName);

        // Send a screen view.
        t.send(new HitBuilders.ScreenViewBuilder().build());

        GoogleAnalytics.getInstance(this).dispatchLocalHits();
    }

    /***
     * Tracking event
     *
     * @param category event category
     * @param action   action of the event
     * @param label    label
     */
    public void trackEvent(String category, String action, String label) {
        Tracker t = getGoogleAnalyticsTracker();

        // Build and send an Event.
        t.send(new HitBuilders.EventBuilder().setCategory(category).setAction(action).setLabel(label).build());
    }
}
