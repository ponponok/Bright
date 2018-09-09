package com.example.brightonter.newfirebase.weight;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.brightonter.newfirebase.MenuFragment;
import com.example.brightonter.newfirebase.R;
import com.example.brightonter.newfirebase.Weight;
import java.util.ArrayList;

/**
 * Created by Brightonter on 9/8/2018.
 */

public class WeightFragment extends Fragment {

    ArrayList<Weight> weights = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weight_list, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initAdd();
        weights.add(new Weight("01 Jan 2018", 63, "UP"));
        weights.add(new Weight("02 Jan 2018", 64, "DOWN"));
        weights.add(new Weight("03 Jan 2018", 63, "UP"));

//        for (Weight s : weights){
//            Log.d("System", s.getDate()+" "+ s.getStatus()+" "+s.getWeight());
//            Log.d("System", weights.getClass().getName());
//        }
        ListView _weightList = (ListView) getView().findViewById(R.id.weight_list);
        WeightAdapter _weightAdapter = new WeightAdapter(getActivity(), R.layout.fragment_weight_list, weights);

//        for(int i=0 ; i<_weightAdapter.getCount() ; i++){
//            Weight obj = _weightAdapter.getItem(i);
//            Log.d("System", "WeightAdapter - "+obj.getDate());
//        }
        _weightList.setAdapter(_weightAdapter);
    }
    public void initAdd(){
        Button _addBtn = (Button) getView().findViewById(R.id.weight_addBtn);
        _addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new Weight_FormFragment())
                        .addToBackStack(null)
                        .commit();
                Log.d("System", "[WeightFragment] go to Form Weight");
            }
        });
    }


}
