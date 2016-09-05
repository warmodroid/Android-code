package mohdev.devashish.mohit.bnm.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Devashish on 16-02-2016.
 */

public class PrefManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "AndroidHive";

    // All Shared Preferences Keys
    private static final String KEY_IS_WAITING_FOR_SMS = "IsWaitingForSms";
    private static final String KEY_MOBILE_NUMBER = "mobile_number";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_USN = "usn";
    private static final String KEY_BRANCH = "branch";
    private static final String KEY_SEM = "sem";
    private static final String KEY_LABEL = "label";





    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIsWaitingForSms(boolean isWaiting) {
        editor.putBoolean(KEY_IS_WAITING_FOR_SMS, isWaiting);
        editor.commit();
    }

    public boolean isWaitingForSms() {
        return pref.getBoolean(KEY_IS_WAITING_FOR_SMS, false);
    }

    public void setMobileNumber(String mobileNumber) {
        editor.putString(KEY_MOBILE_NUMBER, mobileNumber);
        editor.commit();
    }

    public String getMobileNumber() {
        return pref.getString(KEY_MOBILE_NUMBER, null);
    }
    public String getusn() {
        return pref.getString(KEY_USN, null);
    }
    public String getUName() {
        return pref.getString(KEY_NAME, null);
    }
    public String getSem() {return pref.getString(KEY_SEM, null);}
    public String getKeyBranch() {
        return pref.getString(KEY_BRANCH, null);
    }
    public String getKeyLabel() {
        return pref.getString(KEY_LABEL, null);
    }
    public void createLogin(String name, String email, String mobile,String usn,String branch,String sem,String label) {
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_MOBILE, mobile);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.putString(KEY_USN, usn);
        editor.putString(KEY_BRANCH, branch);
        editor.putString(KEY_SEM, sem);
        editor.putString(KEY_LABEL, label);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> profile = new HashMap<>();
        profile.put("name", pref.getString(KEY_NAME, null));
        profile.put("email", pref.getString(KEY_EMAIL, null));
        profile.put("mobile", pref.getString(KEY_MOBILE, null));
        profile.put("usn",pref.getString(KEY_USN,null));
        profile.put("branch",pref.getString(KEY_BRANCH,null));
        profile.put("sem",pref.getString(KEY_SEM,null));
        profile.put("label",pref.getString(KEY_LABEL,null));

        return profile;
    }
}