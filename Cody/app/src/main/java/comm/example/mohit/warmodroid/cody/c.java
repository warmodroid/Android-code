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

import com.example.mohit.warmodroid.cody.R;
import com.facebook.ads.*;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class c extends AppCompatActivity implements InterstitialAdListener{
    private static c mInstance;
    Toolbar toolbar;
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
            "Letter Count of a String",
            "Linear Search",
            "Pallindrome String",
            "Pascal Number Triangle patter",
            "Prime Number",
            "Reverse String",
            "Selection Sort",
            "String Cocatenation",
            "Swap two numbers without using third"
    } ;
    String[] desp = {
            "Alphabetical Sort",
            "A positive integer is called an Armstrong number if the sum of cubes of individual digit is equal to that number itself.",
            "The code below assumes that the input numbers are in ascending order.",
            "You can easily modify it to print numbers in descending order.",
            "Roots of Quadratic Equation",
            "This c program compares two strings.",
            "C program to convert decimal to binary.",
            "C program to check odd or even using modulus operator.",
            "Factorial of a Number using Recurion",
            "Fibonacci Number Series",
            "Letter Count of a String",
            "Linear Search",
            "Pallindrome String",
            "Pascal Number Triangle patter",
            "Prime Number",
            "Reverse String",
            "Selection Sort",
            "String Cocatenation",
            "Swap two numbers without using third"
    };
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loadInterstitialAd();
        //googletrackers
        trackScreenView("c activity is open");


        ListView list ;
        CustomList adapter = new
                CustomList(c.this, title, desp);
        list=(ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(c.this, codetodisplay.class);
                intent.putExtra("code", new getCode("c/"+title[+position]+".txt",getApplicationContext()).print_on_text());
                trackEvent("c activity",title[+position],"DPC");
                startActivity(intent);
                Toast.makeText(c.this, "You Clicked at " + title[+position], Toast.LENGTH_SHORT).show();


            }
        });



    }
    private void loadInterstitialAd(){
        interstitialAd = new InterstitialAd(this, "1676535802590804_1677970162447368");
        interstitialAd.setAdListener(c.this);
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
    public static synchronized c getInstance() {
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
