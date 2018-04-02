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
import android.widget.Toast;

import com.github.florent37.awesomebar.AwesomeBar;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button2 = findViewById(R.id.button2);
        final TickerView tickerView = findViewById(R.id.tickerView);
        tickerView.setCharacterList(TickerUtils.getDefaultNumberList());
        final TickerView tickerView2 = findViewById(R.id.tickerView2);
        tickerView2.setCharacterList(TickerUtils.getDefaultNumberList());
        final TickerView tickerView3 = findViewById(R.id.tickerView3);
        tickerView3.setCharacterList(TickerUtils.getDefaultNumberList());
        final TickerView tickerView4 = findViewById(R.id.tickerView4);
        tickerView4.setCharacterList(TickerUtils.getDefaultNumberList());
        final TickerView tickerView5 = findViewById(R.id.tickerView5);
        tickerView5.setCharacterList(TickerUtils.getDefaultNumberList());
        final TickerView tickerView6 = findViewById(R.id.tickerView6);
        tickerView6.setCharacterList(TickerUtils.getDefaultNumberList());

        AwesomeBar bar3 = findViewById(R.id.bar3);
        bar3.setOnMenuClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();



            }
        });





        Intent intent = getIntent();
        Toast.makeText(Main2Activity.this, intent.getStringExtra("Info"), Toast.LENGTH_SHORT).show();
        Log.e("Datra", Arrays.toString(intent.getStringArrayExtra("Info")));

        String[] data = intent.getStringArrayExtra("Info");
           Log.e("Data", (String) data[2]);
        Log.e("Data", (String) data[1]);
        Log.e("Data", (String) data[0]);

        final String[] info = intent.getStringArrayExtra("Indiviudals");
        Toast.makeText(this, (String) info[0], Toast.LENGTH_SHORT).show();




        tickerView.setAnimationDuration(2000);
        tickerView.setAnimationInterpolator(new OvershootInterpolator());
        tickerView.setGravity(Gravity.CENTER);
        tickerView2.setAnimationDuration(2000);
        tickerView2.setAnimationInterpolator(new OvershootInterpolator());
        tickerView2.setGravity(Gravity.CENTER);
        tickerView3.setAnimationDuration(2000);
        tickerView3.setAnimationInterpolator(new OvershootInterpolator());
        tickerView3.setGravity(Gravity.CENTER);
        tickerView4.setAnimationDuration(2000);
        tickerView4.setAnimationInterpolator(new OvershootInterpolator());
        tickerView4.setGravity(Gravity.CENTER);
        tickerView5.setAnimationDuration(2000);
        tickerView5.setAnimationInterpolator(new OvershootInterpolator());
        tickerView5.setGravity(Gravity.CENTER);
        tickerView6.setAnimationInterpolator(new OvershootInterpolator());
        tickerView5.setAnimationDuration(4000);
        tickerView6.setGravity(Gravity.CENTER);

        tickerView.setText("AEC038%#8O");
        tickerView.setText("Device: " + data[0]);
        tickerView2.setText("AEC038%#8OAEC038%#8O");
        tickerView2.setText("Total Score: " + data[1]);
        tickerView3.setText("AEC038%#8OAEC038%#8O");
        tickerView3.setText("Average match time: " + data[2]);
        tickerView4 .setText("AEC038%#8OAEC038%#8O");
        tickerView4.setText("Total play time: " + data[3]);
        tickerView5 .setText("AEC038%#8OAEC038%#8O");
        tickerView5 .setText("nabiuoog*&t&d&s*dG78");
        tickerView5.setText("Matches played: " + data[4]);
        tickerView6 .setText("AEC038%#8OAEC038%#8O");
        tickerView6.setText("Totals kills" + data[5]);



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), Main5Activity.class);
                intent2.putExtra("Values", info);
                startActivity(intent2);
            }
        });





    }
}
