package com.example.brightonter.newfirebase.weight;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;


import com.example.brightonter.newfirebase.R;
import com.example.brightonter.newfirebase.Weight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brightonter on 9/8/2018.
 */

public class WeightAdapter extends ArrayAdapter<Weight>{

    ArrayList<Weight> weights = new ArrayList<Weight>();
    Context context;

    public WeightAdapter(Context context, int resouce, ArrayList<Weight> objects){
        super(context, resouce, objects);
        this.weights = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_weight_list_data, parent, false);

        TextView _date, _weight, _status;
        _date = (TextView) v.findViewById(R.id.data_date);
        _weight = (TextView) v.findViewById(R.id.data_weight);
        _status = (TextView) v.findViewById(R.id.data_status);
        Weight _row = weights.get(position);
        _date.setText(_row.getDate());
        _status.setText(_row.getStatus());
        _weight.setText(String.valueOf(_row.getWeight()));

        Log.d("System", "[WeightAdapter] " +position +" "+ _row.getDate() + " " + _row.getWeight()+ " " + _row.getStatus());
        return v;
    }
}
