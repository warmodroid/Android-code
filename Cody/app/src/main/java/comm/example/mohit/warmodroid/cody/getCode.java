package comm.example.mohit.warmodroid.cody;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mohit on 10/27/2015.
 */
public class getCode {
String code;
    Context context;
    public getCode(String code,Context context)
    {
        this.code = code;
        this.context = context;
    }

    public String print_on_text()
    {
        AssetManager assetManager = context.getAssets();
        try
        {
            InputStream is = assetManager.open(code);
            StringBuilder sb = new StringBuilder();
            String line = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while((line = reader.readLine())!=null)
            {
                sb.append(line+"\n");
            }
            return sb.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}

