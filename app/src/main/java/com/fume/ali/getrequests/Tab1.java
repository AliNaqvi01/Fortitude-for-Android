package com.fume.ali.getrequests;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.lang.reflect.Array;
import java.util.Arrays;

import static android.support.design.widget.TabLayout.*;


/**
 * Created by Ali on 2018-03-30.
 */

public class Tab1 extends Fragment {
    Button button = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab1, container, false);

        Intent intent = getActivity().getIntent();
        Toast.makeText(getContext(), intent.getStringExtra("Values"), Toast.LENGTH_SHORT).show();
        Log.e("poop", Arrays.toString(intent.getStringArrayExtra("Values")));
        final String[] info = intent.getStringArrayExtra("Values");
        Toast.makeText(getContext(), String.valueOf(info[0]), Toast.LENGTH_SHORT).show();

        final TickerView tickerView = rootView.findViewById(R.id.tickerView10);
        final TickerView tickerView2 = rootView.findViewById(R.id.tickerView11);
        final TickerView tickerView3 = rootView.findViewById(R.id.tickerView12);
        final TickerView tickerView4 = rootView.findViewById(R.id.tickerView13);
        final TickerView tickerView5 = rootView.findViewById(R.id.tickerView14);
        tickerView.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView.setText("H7*^$V#");
        tickerView.setGravity(Gravity.CENTER);
        tickerView.setAnimationDuration(3000);
        tickerView.setText("Wins: " + String.valueOf(info[0]));
        tickerView2.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView2.setText("DG97*&^%J$");
        tickerView2.setGravity(Gravity.CENTER);
        tickerView2.setAnimationDuration(3000);
        tickerView2.setText("Kills: " + String.valueOf(info[1]));
        tickerView3.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView3.setText("G^V)JBA0#%UX");
        tickerView3.setGravity(Gravity.CENTER);
        tickerView3.setAnimationDuration(3000);
        tickerView3.setText("Matches: " + String.valueOf(info[2]));
        tickerView4.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView4.setText("FK*&%#");
        tickerView4.setGravity(Gravity.CENTER);
        tickerView4.setAnimationDuration(3000);
        tickerView4.setText("K/D: " + String.valueOf(info[3]));
        tickerView5.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView5.setText("NI*#^(HV@^(HCOX%@(HXG@^(OHC#");
        tickerView5.setGravity(Gravity.CENTER);
        tickerView5.setAnimationDuration(3000);
        tickerView5.setText("Average Match Time: " + String.valueOf(info[3]));











        return rootView;
    }
}
