package com.fume.ali.getrequests;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

/**
 * Created by Ali on 2018-03-30.
 */


public class Tab3 extends Fragment {
    Button button = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab3, container, false);

        Intent intent = getActivity().getIntent();
        Toast.makeText(getContext(), intent.getStringExtra("Values"), Toast.LENGTH_SHORT).show();
        Log.e("poop", Arrays.toString(intent.getStringArrayExtra("Values")));

        final String[] info = intent.getStringArrayExtra("Values");

        button = rootView .findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), String.valueOf(info[2]), Toast.LENGTH_SHORT).show();
            }
        });



        return rootView;
    }
}