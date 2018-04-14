package com.fume.ali.getrequests;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
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
    String loca;

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
        String device = intent.getStringExtra("device");
        Log.e("DEVUCE",device);

        if("pc".equals(device)){
            loca = "drawable://" + R.drawable.pc;
        }else if("ps".equals(device)){
            loca = "drawable://" + R.drawable.ps;
        }else if ("xbl".equals(device)){
            loca = "drawable://" + R.drawable.xbox;
        }

        Log.e("Data", (String) data[2]);
        Log.e("Data", (String) data[1]);
        Log.e("Data", (String) data[0]);
        list.add(new Card(loca, "Device: " + String.valueOf(data[0])));
        list.add(new Card("drawable://victory", "Wins: " + String.valueOf(data[6])));
        list.add(new Card("drawable://mapfiveblurred", "Matches Played: " + data[4]));
        list.add(new Card("drawable://" + R.drawable.mapthreeblurred, "Kills: " + String.valueOf(data[5])));
        list.add(new Card("drawable://" + R.drawable.mapblurred, "Time Played: " + String.valueOf(data[3])));
        list.add(new Card("drawable://" + R.drawable.mapfourblurred, "Average Match Time: " + String.valueOf(data[2])));

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
