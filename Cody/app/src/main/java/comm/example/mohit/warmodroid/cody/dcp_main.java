package comm.example.mohit.warmodroid.cody;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohit.warmodroid.cody.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.facebook.ads.*;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class dcp_main extends AppCompatActivity implements InterstitialAdListener {
    private static dcp_main mInstance;
    TextView q,a;
    int ques_no;
    String question;
    //URL to get JSON Array
    private static String url = "http://mastmurgi.com/cody/get_current_ques.php";
    //JSON Node Names
    private static final String TAG_QUES = "quest";
    private static final String TAG_ID = "id";
    JSONArray ques_array_jason = null;
    private AdView adView;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcp_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new JSONParse().execute();
        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);
        adView = new AdView(this, "1676535802590804_1676536609257390", AdSize.BANNER_HEIGHT_50);
        adViewContainer.addView(adView);
        adView.loadAd();
        loadInterstitialAd();
        //googletrackers
        trackScreenView("DPC activity is open");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trackEvent("DPC activity","Share button","DPC");
                Intent shareIntent =
                        new Intent(android.content.Intent.ACTION_SEND);

                //set the type
                shareIntent.setType("text/plain");

                //add a subject
                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        "Hey I shared Daily Practice Code");

                //build the body of the message to be shared
                String shareMessage = question + "\n Get it on https://play.google.com/store/apps/details?id=comm.example.mohit.warmodroid.cody";

                //add the message
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                        shareMessage);

                //start the chooser for sharing
                startActivity(Intent.createChooser(shareIntent,
                        "Share with your friend"));
            }
        });
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
    private void loadInterstitialAd(){
        interstitialAd = new InterstitialAd(this, "1676535802590804_1677965049114546");
        interstitialAd.setAdListener(dcp_main.this);
        interstitialAd.loadAd();
    }

    private class JSONParse extends AsyncTask<String, String, JSONObject> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            q = (TextView)findViewById(R.id.quest_show);
            a = (TextView)findViewById(R.id.ans_show);
            pDialog = new ProgressDialog(dcp_main.this);
            pDialog.setMessage("Getting Daily Practice Code...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected JSONObject doInBackground(String... args) {
            JSONParser jParser = new JSONParser();

            // Getting JSON from URL
            JSONObject json = jParser.getJSONFromUrl(url);
            return json;
        }
        @Override
        protected void onPostExecute(JSONObject json) {
            pDialog.dismiss();
            try {
                // Getting JSON Array
                ques_array_jason = json.getJSONArray("user");
                JSONObject c = ques_array_jason.getJSONObject(0);

                // Storing  JSON item in a Variable
                String id = c.getString(TAG_ID);
                 question = c.getString(TAG_QUES);
                String ans = c.getString("answer");

                //Set JSON Data in TextView
                ques_no = Integer.parseInt(id);
                q.setText(question);
                a.setText(ans);
                Toast.makeText(dcp_main.this,""+ques_no,Toast.LENGTH_LONG).show();

            } catch (JSONException e) {
                Toast toast = Toast.makeText(dcp_main.this, e.getMessage(), Toast.LENGTH_SHORT);
                toast.show();
                e.printStackTrace();
            }

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dpc_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.p_dpc) {

            trackEvent("DPC activity","Previous DPC button","DPC");
            Intent sett = new Intent(dcp_main.this,p_dpc.class);
            startActivity(sett);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //yaha se googlr traker
    public static synchronized dcp_main getInstance() {
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

