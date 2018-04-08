package com.fume.ali.getrequests;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.awesomebar.ActionItem;
import com.github.florent37.awesomebar.AwesomeBar;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mListView = findViewById(R.id.lister);
        mListView.setDivider(null);
        mListView.setDividerHeight(0);
        ArrayList<Card> list = new ArrayList<>();
        Intent intent = getIntent();
        Log.e("Datra", Arrays.toString(intent.getStringArrayExtra("Info")));
        AwesomeBar bar = findViewById(R.id.bar2);
        bar.addAction(R.drawable.awsb_ic_edit_animated,"Details");
        bar.displayHomeAsUpEnabled(true);








        bar.setOnMenuClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


onBackPressed();


            }
        });



        String[] data = intent.getStringArrayExtra("Info");
        Log.e("Data", (String) data[2]);
        Log.e("Data", (String) data[1]);
        Log.e("Data", (String) data[0]);
        list.add(new Card("drawable://" + R.drawable.victoryblurred, "Wins: " + String.valueOf(data[6])));
        list.add(new Card("drawable://" + R.drawable.mapblurred, "Matches Played: " + String.valueOf(data[4])));
        list.add(new Card("drawable://" + R.drawable.maptwoblurred, "K/D: " + data[5]));
        list.add(new Card("drawable://" + R.drawable.map, "Yosemite"));
        list.add(new Card("drawable://" + R.drawable.map, "Yosemite"));
        list.add(new Card("drawable://" + R.drawable.map, "Yosemite"));
        list.add(new Card("drawable://" + R.drawable.map, "Yosemite"));
        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.activity_main2, list);
        mListView.setAdapter(adapter);



        ListView listView = findViewById(R.id.listy);











        final String[] info = intent.getStringArrayExtra("Indiviudals");
        bar.setActionItemClickListener(new AwesomeBar.ActionItemClickListener() {
            @Override
            public void onActionItemClicked(int position, ActionItem actionItem) {

                Intent intent2 = new Intent(getApplicationContext(), Main5Activity.class);
                intent2.putExtra("Values", info);
                startActivity(intent2);




            }
        });















    }
}
