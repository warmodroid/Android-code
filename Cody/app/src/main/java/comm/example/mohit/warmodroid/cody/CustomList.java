package comm.example.mohit.warmodroid.cody;




/**
 * Created by mohit on 10/26/2015.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mohit.warmodroid.cody.R;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] tiitle;
    private final String[] desp;
    public CustomList(Activity context,
                      String[] tittle, String[] desp) {
        super(context, R.layout.list_single, desp);
        this.context = context;
        this.tiitle = tittle;
        this.desp = desp;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.tittle);

        TextView txtdesp = (TextView) rowView.findViewById(R.id.desp);
        txtTitle.setText(tiitle[position]);
        txtdesp.setText(desp[position]);
        return rowView;
    }
}