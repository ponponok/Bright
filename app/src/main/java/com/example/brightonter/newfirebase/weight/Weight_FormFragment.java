package com.example.brightonter.newfirebase.weight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brightonter.newfirebase.MenuFragment;
import com.example.brightonter.newfirebase.R;
import com.example.brightonter.newfirebase.Weight;

import java.util.ArrayList;

/**
 * Created by Brightonter on 9/8/2018.
 */

public class Weight_FormFragment extends Fragment {
    ArrayList<Weight> _weightList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weight_item, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBack();
        initSave();

    }
    public void initBack(){
        Button _addBtn = (Button) getView().findViewById(R.id.weight_form_backBtn);
        _addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new WeightFragment())
                        .addToBackStack(null)
                        .commit();
                Log.d("System", "[Weight_FormFragment] Back to menu");
            }
        });
    }
    public void initSave(){
        Button _saveBtn = (Button) getView().findViewById(R.id.weight_form_saveBtn);
        _saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText _date = (EditText) getView().findViewById(R.id.weight_form_date);
                EditText _weight = (EditText) getView().findViewById(R.id.weight_form_weight);
                String _dateStr = _date.getText().toString();
                String _weightStr = _weight.getText().toString();

                if (!_dateStr.isEmpty() && !_weightStr.isEmpty()){
                    int _weightInt = Integer.parseInt(_weightStr);
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new WeightFragment())
                            .addToBackStack(null)
                            .commit();
                    Log.d("System", "[Weight_FormFragment] Add to Adapter");
                    for (Weight s : _weightList){
                        Log.d("System", s.getDate()+ " "+s.getWeight());
                    }
                }else{
                    Toast.makeText(getActivity(), "Please fill your date and weight", Toast.LENGTH_SHORT).show();
                    Log.d("System", "[Weight_FormFragment] Date or Weight isEmpty");
                }
            }
        });
    }
}
