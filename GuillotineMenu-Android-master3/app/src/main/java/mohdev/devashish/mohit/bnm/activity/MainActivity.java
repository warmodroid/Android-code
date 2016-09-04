package mohdev.devashish.mohit.bnm.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.sauronsoftware.ftp4j.FTPClient;
import mohdev.devashish.mohit.animation.GuillotineAnimation;
import mohdev.devashish.mohit.bnm.R;
import mohdev.devashish.mohit.bnm.helper.PrefManager;

/**
 * Created by Dmytro Denysenko on 5/4/15.
 */
public class MainActivity extends AppCompatActivity {


    /*********  work only for Dedicated IP ***********/
    static final String FTP_HOST= "ftp.mastmurgi.com";

    /*********  FTP USERNAME ***********/
    static final String FTP_USER = "book@mastmurgi.com";

    /*********  FTP PASSWORD ***********/
    static final String FTP_PASS  ="*****";



    private static final long RIPPLE_DURATION = 250;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;




    // URL to get contacts JSON
    private static String url = "http://mastmurgi.com/book_php/notes_json.php";
    private static String url_notes_databsae = "http://mastmurgi.com/book_php/insert_db.php";
    private static final String TAG_CONTACTS = "user";
    private static final String TAG_ID = "id";
    private static final String TAG_USN = "usn";
    private static final String TAG_NAME = "name";
    private static final String TAG_SUBJECT = "subject";
    private static final String TAG_BRANCH = "branch";
    private static final String TAG_SEM = "sem";
    private static final String TAG_FILE_ADD = "file_add";
    private static final String TAG_LABEL = "label";
    private  String  subject_notes;
    private  String path;

    ProgressDialog dialog;
    ArrayList results = new ArrayList<DataObject>();

    // contacts JSONArray
    JSONArray ques = null;



    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.root)
    FrameLayout root;
    @InjectView(R.id.content_hamburger)
    View contentHamburger;

    private static final String FILES_TO_UPLOAD = "upload";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity);
        ButterKnife.inject(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();

             FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                View promptsView = li.inflate(R.layout.prompts, null);


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        MainActivity.this);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        subject_notes = userInput.getText().toString();
                                        if(subject_notes.length()!=0)
                                        {
                                            Intent intent = new Intent(getBaseContext(),FileSelectionActivity.class);
                                            startActivityForResult(intent, 0);
                                        }
                                        else
                                        {
                                            Snackbar.make(findViewById(R.id.root)," Enter subject name.",Snackbar.LENGTH_LONG).show();
                                        }

                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

        new GetQues().execute();


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        String InputPath = Environment.getExternalStorageDirectory().getPath();
        if(requestCode == 0 && resultCode == RESULT_OK){
            ArrayList<File> Files = (ArrayList<File>) data.getSerializableExtra(FILES_TO_UPLOAD); //file array list
            ArrayList<String> files_paths = new ArrayList<>(); //string array
            int i = 0;


            for(File file : Files){
                //String fileName = file.getName();
                String uri = file.getAbsolutePath();
                files_paths.add( uri.toString());//storing the selected file's paths to string array files_path

                i++;
            }


            SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
            String format = s.format(new Date());

            String InputData = InputPath+"/z"+format+".zip";
            path = "http://mastmurgi.com/book/lol"+"/z"+format+".zip";
            Toast.makeText(MainActivity.this,path,Toast.LENGTH_LONG).show();
            zipIt zip  = new zipIt(files_paths,InputData);
            zip.zip();
            File f = new File(InputData);
            // Upload sdcard file
            ntwk n = new ntwk();
            n.execute(f);
            //uploadFile(f);

        }else{
        }

    }

    private class GetQues extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog= new ProgressDialog(MainActivity.this);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();
            PrefManager pref = new PrefManager(MainActivity.this);
            List<NameValuePair> pair =new ArrayList<NameValuePair>();
            pair.add(new BasicNameValuePair("branch",pref.getKeyBranch()));
            pair.add(new BasicNameValuePair("sem",pref.getSem()));
            ServiceHandler s = new ServiceHandler();
            String jsonStr = s.makeServiceCall(url,ServiceHandler.POST,pair);
            //Toast.makeText(MainActivity.this,jsonStr,Toast.LENGTH_SHORT).show();

            // Making a request to url and getting response
            //String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

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
                        String usn = c.getString(TAG_USN);
                        String name = c.getString(TAG_NAME);
                        String subject = c.getString(TAG_SUBJECT);
                        String branch = c.getString(TAG_BRANCH);
                        String sem = c.getString(TAG_SEM);
                        String file_add = c.getString(TAG_FILE_ADD);
                        String label = c.getString(TAG_LABEL);

                        DataObject obj = new DataObject(id,usn,name,subject,branch,sem,file_add,label);
                        results.add(i, obj);
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
            if (dialog.isShowing())
                dialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */

            mAdapter = new MyRecyclerViewAdapter(results);
            mRecyclerView.setAdapter(mAdapter);
        }

    }



    public class ntwk extends AsyncTask<File,Void,Void>
    {
        ProgressDialog pg = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pg.show();
            pg.setCancelable(false);
        }

        @Override
        protected Void doInBackground(File... params) {
            uploadFile(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pg.dismiss();
            new update_database().execute(subject_notes,path);
        }
    }
    public void uploadFile(File fileName){


        FTPClient client = new FTPClient();

        try {

            client.connect(FTP_HOST,21);
            client.login(FTP_USER, FTP_PASS);
            client.setType(FTPClient.TYPE_BINARY);
            client.changeDirectory("/lol/");

            client.upload(fileName, null);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                client.disconnect(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

//Asyn to update notes database
    private class update_database extends AsyncTask<String,Void,Void>
{

    @Override
    protected Void doInBackground(String... params) {
        PrefManager pref = new PrefManager(MainActivity.this);
        String subject =params[0];
        String file_add = params[1];

        List<NameValuePair> pair =new ArrayList<NameValuePair>();
        pair.add(new BasicNameValuePair("usn",pref.getusn()));
        pair.add(new BasicNameValuePair("name",pref.getUName()));
        pair.add(new BasicNameValuePair("subject",subject));
        pair.add(new BasicNameValuePair("branch",pref.getKeyBranch()));
        pair.add(new BasicNameValuePair("sem",pref.getSem()));
        pair.add(new BasicNameValuePair("file_add",file_add));
        pair.add(new BasicNameValuePair("label",pref.getKeyLabel()));
        ServiceHandler s = new ServiceHandler();
        String json = s.makeServiceCall(url_notes_databsae,ServiceHandler.POST,pair);

        if (json != null) {
            try {
                JSONObject jsonObj = new JSONObject(json);
                boolean error = jsonObj.getBoolean("error");
                // checking for error node in json
                if (!error) {
                    // new category created successfully
                    //Log.e("Prediction added successfully ", "> " + jsonObj.getString("message"));
                    Toast.makeText(MainActivity.this,jsonObj.getString("message"),Toast.LENGTH_LONG).show();
                } else {
                    //Log.e("Add Prediction Error: ", "> " + jsonObj.getString("message"));
                    Toast.makeText(MainActivity.this,jsonObj.getString("message"),Toast.LENGTH_LONG).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            Log.e("JSON Data", "JSON data error!");
        }
        return null;
    }

}
}
