package comm.example.mohit.warmodroid.cody;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mohit.warmodroid.cody.R;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;
import com.onesignal.OneSignal;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;
import com.parse.signpost.http.HttpRequest;

import org.json.JSONObject;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    CoordinatorLayout rootLayout;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    SharedPreferences sharedPreferences;
    NavigationView navigation;
    private static MainActivity mInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intializiton of toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //declaretion of drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.hello_world, R.string.hello_world);
        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //googletrackers
        AnalyticsTrackers.initialize(this);
        AnalyticsTrackers.getInstance().get(AnalyticsTrackers.Target.APP);
        trackScreenView("Main activity is open");


        //declaretion of buttons
        ImageButton cc_activity = (ImageButton) findViewById(R.id.cc);
        ImageButton cp_activity = (ImageButton) findViewById(R.id.cp);
        ImageButton java_activity = (ImageButton) findViewById(R.id.java);
        ImageButton python_activity = (ImageButton) findViewById(R.id.python);
        ImageButton dpc_activity = (ImageButton) findViewById(R.id.dpc);

        //shared preferences for mute notification option
        sharedPreferences = getSharedPreferences("mute_prefer", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("value", false)) {
            OneSignal.enableVibrate(true);
            OneSignal.enableSound(true);
            //OneSignal.sendTag("mymob","mymob");
            OneSignal.startInit(this)
                    .setNotificationOpenedHandler(new ExampleNotificationOpenedHandler())
                    .init();
        } else {

            OneSignal.enableVibrate(false);
            OneSignal.enableSound(false);
           // OneSignal.sendTag("mymob","mymob");
            OneSignal.startInit(this)
                    .setNotificationOpenedHandler(new ExampleNotificationOpenedHandler())
                    .init();
        }


        dpc_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        dcp_main.class);
                trackEvent("Mainactivity","button_dpc","DPC");
                startActivity(intent);
            }
        });

        cc_activity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        c.class);
                trackEvent("Mainactivity","button_c","C");
                startActivity(intent);
            }
        });
        cp_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        cp.class);
                trackEvent("Mainactivity","button_c++","C++");
                startActivity(intent);
            }
        });
        java_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        java.class);
                trackEvent("Mainactivity","button_java","Java");
                startActivity(intent);
            }
        });
        python_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        python.class);
                trackEvent("Mainactivity","button_python","Python");
                startActivity(intent);
            }
        });
        //decalre menu listiner for drawer
        navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navItem1:
                        Intent intent = new Intent(MainActivity.this,quiz.class);
                        trackEvent("Navigation_drawer","button_quiz","Quiz");
                        startActivity(intent);
                        //Toast.makeText(MainActivity.this,"Getting quiz",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navItem2:
                        Toast.makeText(MainActivity.this,"Comming Soon",Toast.LENGTH_SHORT).show();
                        trackEvent("Navigation_drawer","button_newsfeed","Newsfeed");
                        break;
                    case R.id.navItem3:
                        trackEvent("Navigation_drawer","button_share","Share");
                        Intent shareIntent =
                                new Intent(android.content.Intent.ACTION_SEND);

                        //set the type
                        shareIntent.setType("text/plain");

                        //add a subject
                        shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                                "Now learn a new programming language within hours! Download this app CODY");

                        //build the body of the message to be shared
                        String shareMessage ="\nNow learn a new programming language within hours! Download this app CODY. Get it on https://play.google.com/store/apps/details?id=comm.example.mohit.warmodroid.cody";

                        //add the message
                        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                                shareMessage);

                        //start the chooser for sharing
                        startActivity(Intent.createChooser(shareIntent,
                                "Share with your friend"));
                        //Toast.makeText(MainActivity.this,"Contact to devloper",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navItem4:
                        trackEvent("Navigation_drawer","button_removeads","Removeads");
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Remove all Ads !!!");
                        builder.setMessage("Buy the Cody Premuim from Google app purchase");
                        builder.setNegativeButton("Buy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=comm.pro.mohit.warmodroid.cody");

                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            }
                        });
                        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                        break;
                }
                return false;
            }
        });
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private class ExampleNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
        @Override
        public void notificationOpened(String message, JSONObject additionalData, boolean isActive) {
            try {
                if (additionalData != null) {
                    if (additionalData.has("actionSelected"))
                        Log.d("OneSignalExample", "OneSignal notification button with id " + additionalData.getString("actionSelected") + " pressed");

                    Log.d("OneSignalExample", "Full additionalData:\n" + additionalData.toString());
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            trackEvent("Menu","button_mute","Mute");
            Intent sett = new Intent(MainActivity.this,settings.class);
            startActivity(sett);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //yaha se googlr traker
    public static synchronized MainActivity getInstance() {
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
    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        Intent i = manager.getLaunchIntentForPackage(packageName);
        if (i == null) {
            return false;
            //throw new PackageManager.NameNotFoundException();
        }
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        context.startActivity(i);
        return true;
    }

}
