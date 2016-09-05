package mohdev.devashish.mohit.bnm.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import mohdev.devashish.mohit.bnm.R;

import java.util.ArrayList;

/**
 * Created by Devashish on 16-02-2016.
 */

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder>  {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<DataObject> mDataset;

    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView usn;
        TextView name;
        TextView subject;
        TextView branch;
        TextView sem;
        TextView file_add;
        TextView label;
        ImageButton download_image;
        ImageButton hard_copy_button;

        public DataObjectHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id._id);
            usn = (TextView) itemView.findViewById(R.id._usn);
            name = (TextView) itemView.findViewById(R.id._name);
            subject = (TextView) itemView.findViewById(R.id._subject);
            branch = (TextView) itemView.findViewById(R.id._branch);
            sem = (TextView) itemView.findViewById(R.id._sem);
            file_add = (TextView) itemView.findViewById(R.id._file_add);
            label = (TextView) itemView.findViewById(R.id._label);
            download_image = (ImageButton) itemView.findViewById(R.id._download_image);
            hard_copy_button = (ImageButton) itemView.findViewById(R.id._hard_copy_button);
            download_image.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            Toast.makeText(v.getContext(),file_add.getText(),Toast.LENGTH_SHORT).show();

                 Intent i = new Intent(Intent.ACTION_VIEW);
                 i.setData(Uri.parse(file_add.getText().toString()));
                 v.getContext().startActivity(i);
             }
             });
        }

    }

    public MyRecyclerViewAdapter(ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        //holder.label.setText(mDataset.get(position).getmText1());
        holder.id.setText(mDataset.get(position).id);
        holder.usn.setText(mDataset.get(position).usn);
        holder.name.setText(mDataset.get(position).name);
        holder.subject.setText(mDataset.get(position).subject);
        holder.branch.setText(mDataset.get(position).branch);
        holder.sem.setText(mDataset.get(position).sem);
        holder.file_add.setText(mDataset.get(position).file_add);
        holder.label.setText(mDataset.get(position).label);
    }

    public void addItem(DataObject dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}

