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
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohit.warmodroid.cody.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class p_dpc extends ListActivity {

    private ProgressDialog pDialog;
    TextView a;

    // URL to get contacts JSON
    private static String url = "http://mastmurgi.com/cody/get_p_dpc.php";

    // JSON Node names
    private static final String TAG_CONTACTS = "user";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "quest";
    private static final String TAG_ANSWER = "answer";

    // contacts JSONArray
    JSONArray ques = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_dpc);
        a = (TextView) findViewById(R.id.answer);
        contactList = new ArrayList<HashMap<String, String>>();
        ListView lv = getListView();
        new GetQues().execute();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String answer = ((TextView) view.findViewById(R.id.answer))
                        .getText().toString();
                Intent intent = new Intent(p_dpc.this, p_dpc_single_ques_show.class);
                intent.putExtra("answer", answer);
                startActivity(intent);
                //Toast.makeText(p_dpc.this,answer,Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetQues extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(p_dpc.this);
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
                        String name = c.getString(TAG_NAME);
                        String answer = c.getString(TAG_ANSWER);
                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_ID, id);
                        contact.put(TAG_NAME, name);
                        contact.put(TAG_ANSWER, answer);

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
                    p_dpc.this, contactList,
                    R.layout.p_dpc_list, new String[] { TAG_ID, TAG_NAME,TAG_ANSWER}, new int[] { R.id.qno,
                    R.id.ques,R.id.answer});

            setListAdapter(adapter);
        }

    }


}

