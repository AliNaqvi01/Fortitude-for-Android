package com.fume.ali.getrequests;

import android.content.Intent;
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
        Log.e("poop", Arrays.toString(intent.getStringArrayExtra("Values")));
        final String[] info = intent.getStringArrayExtra("Values");

        final TickerView tickerView = rootView.findViewById(R.id.tickerView20);
        final TickerView tickerView2 = rootView.findViewById(R.id.tickerView21);
        final TickerView tickerView3 = rootView.findViewById(R.id.tickerView22);
        final TickerView tickerView4 = rootView.findViewById(R.id.tickerView23);
        final TickerView tickerView5 = rootView.findViewById(R.id.tickerView24);

        tickerView.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView.setText("H7*^$V#");
        tickerView.setGravity(Gravity.CENTER);
        tickerView.setAnimationDuration(3000);
        tickerView.setText("Wins: " + String.valueOf(info[5]));
        tickerView2.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView2.setText("DG97*&^%J$");
        tickerView2.setGravity(Gravity.CENTER);
        tickerView2.setAnimationDuration(3000);
        tickerView2.setText("Kills: " + String.valueOf(info[6]));
        tickerView3.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView3.setText("G^V)JBA0#%UX");
        tickerView3.setGravity(Gravity.CENTER);
        tickerView3.setAnimationDuration(3000);
        tickerView3.setText("Matches: " + String.valueOf(info[7]));
        tickerView4.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView4.setText("FK*&%#");
        tickerView4.setGravity(Gravity.CENTER);
        tickerView4.setAnimationDuration(3000);
        tickerView4.setText("K/D: " + String.valueOf(info[8]));
        tickerView5.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView5.setText("NI*#^(HV@^(HCOX%@(HXG@^(OHC#");
        tickerView5.setGravity(Gravity.CENTER);
        tickerView5.setAnimationDuration(3000);
        tickerView5.setText("Average Match Time: " + String.valueOf(info[9]));









        return rootView;
    }
}