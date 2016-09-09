package comm.example.mohit.warmodroid.cody;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.mohit.warmodroid.cody.R;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class quiz extends ListActivity implements InterstitialAdListener {
    private ProgressDialog pDialog;

    // URL to get contacts JSON
    private static String url = "http://mastmurgi.com/cody/get_quiz.php";

    // JSON Node names
    private static final String TAG_CONTACTS = "user";
    private static final String TAG_ID = "id";
    private static final String TAG_QUES = "quest";
    private static final String TAG_OPTIONA = "oa";
    private static final String TAG_OPTIONB = "ob";
    private static final String TAG_OPTIONC = "oc";
    private static final String TAG_OPTIOND = "od";
    private static final String TAG_ANSWER = "ans";
    private AdView adView;
    private InterstitialAd interstitialAd;

    // contacts JSONArray
    JSONArray ques = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        loadInterstitialAd();
        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);

        adView = new AdView(this, "1676535802590804_1694386730805711", AdSize.BANNER_320_50);
        adViewContainer.addView(adView);
        adView.loadAd();
        contactList = new ArrayList<HashMap<String, String>>();
        ListView lv = getListView();
        new GetQues().execute();

    }
    private void loadInterstitialAd(){
        interstitialAd = new InterstitialAd(this, "1676535802590804_1694385657472485");
        interstitialAd.setAdListener(quiz.this);
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

    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetQues extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(quiz.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    ques = jsonObj.getJSONArray(TAG_CONTACTS);

                    // looping through All Contacts
                    for (int i = 0; i < ques.length(); i++) {
                        JSONObject c = ques.getJSONObject(i);
                        String id = c.getString(TAG_ID);
                        String quest = c.getString(TAG_QUES);
                        String oa = c.getString(TAG_OPTIONA);
                        String ob = c.getString(TAG_OPTIONB);
                        String oc = c.getString(TAG_OPTIONC);
                        String od = c.getString(TAG_OPTIONB);
                        String answer = c.getString(TAG_ANSWER);
                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_ID, id);
                        contact.put(TAG_QUES, quest);
                        contact.put(TAG_OPTIONA, oa);
                        contact.put(TAG_OPTIONB, ob);
                        contact.put(TAG_OPTIONC, oc);
                        contact.put(TAG_OPTIOND, od);
                        contact.put(TAG_ANSWER,answer);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    quiz.this, contactList,
                    R.layout.quiz_list_item, new String[] { TAG_QUES,TAG_OPTIONA,TAG_OPTIONB,TAG_OPTIONC,TAG_OPTIOND,TAG_ANSWER}, new int[] { R.id.question,
                    R.id.option_one,R.id.option_two,R.id.option_three,R.id.option_four,R.id.answer});

            setListAdapter(adapter);
        }

    }

}
