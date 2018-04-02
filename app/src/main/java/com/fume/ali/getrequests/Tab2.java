package com.fume.ali.getrequests;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;

/**
 * Created by Ali on 2018-03-30.
 */

public class Tab2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        Intent intent = getActivity().getIntent();
        Toast.makeText(getContext(), intent.getStringExtra("Values"), Toast.LENGTH_SHORT).show();
        Log.e("poop", Arrays.toString(intent.getStringArrayExtra("Values")));

        return inflater.inflate(R.layout.tab2, container, false);


    }
}