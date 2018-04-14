package com.fume.ali.getrequests;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

import static android.support.v4.os.LocaleListCompat.create;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Element steamElement = new Element();
        steamElement.setIconDrawable(R.drawable.code);
        steamElement.setValue("Steamcommunity.com/id/kumail").setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.steamcommunity.com/id/kumail");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        steamElement.setTitle("Add me on Steam");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.building)
                .setDescription("A simple Fortnite stats tracker. No BS, only the stats that you really care about. \n Developed by Ali Naqvi, all images are property of their respective owners. \n Questions and concerns? Contact me. ")
                .addGroup("Hit me up")
                .addEmail("alinaqvi01n@gmail.com")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addGitHub("AliNaqvi01")
                .addItem(steamElement)
                .create();







        setContentView(aboutPage);

    }
}
