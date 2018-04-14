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
import android.widget.ListView;
import android.widget.Toast;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static android.support.design.widget.TabLayout.*;


/**
 * Created by Ali on 2018-03-30.
 */

public class Tab1 extends Fragment {
    Button button = null;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab1, container, false);
        listView = rootView.findViewById(R.id.listey);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        Intent intent = getActivity().getIntent();
        Log.e("poop", Arrays.toString(intent.getStringArrayExtra("Values")));
        final String[] info = intent.getStringArrayExtra("Values");
        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable://" + R.drawable.victory, "Wins: " + String.valueOf(info[0])));
        list.add(new Card("drawable://" + R.drawable.image2, "Kills: " + String.valueOf(info[1])));
        list.add(new Card("drawable://" + R.drawable.image3, "Matches: " + String.valueOf(info[2])));
        list.add(new Card("drawable://" + R.drawable.image5, "K/D: " + String.valueOf(info[3])));
        list.add(new Card("drawable://" + R.drawable.image3, "Average Match Time: " + String.valueOf(4)));

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.card_layout, list);
        listView.setAdapter(adapter);




        return rootView;
    }
}
