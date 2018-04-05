package com.fume.ali.getrequests;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dd.morphingbutton.MorphingButton;
import com.github.florent37.awesomebar.ActionItem;
import com.github.florent37.awesomebar.AwesomeBar;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.yarolegovich.lovelydialog.LovelyInfoDialog;

import net.igenius.customcheckbox.CustomCheckBox;
import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mehdi.sakout.fancybuttons.FancyButton;
import studio.carbonylgroup.textfieldboxes.ExtendedEditText;
import studio.carbonylgroup.textfieldboxes.TextFieldBoxes;


public class MainActivity extends AppCompatActivity {
    public RequestQueue queue;
    JSONObject jsonObject = null;
    String InputName;
    String ApiInfo;
    String ApiTotalwins;
    String field;
    Editable yolo;
    String device;
    LoadToast lt;
    CustomCheckBox XBOX;
     CustomCheckBox PS;
    public boolean star = true;
    FancyToast toast = null;

    public void dismissKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != activity.getCurrentFocus())
            imm.hideSoftInputFromWindow(activity.getCurrentFocus()
                    .getApplicationWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ExtendedEditText extendedEditText = findViewById(R.id.extended_edit_text);


        List<String> dataset = new LinkedList<>(Arrays.asList("PC", "PS4", "XBOX"));
        lt = new LoadToast(MainActivity.this);
        final LoadToast cant = new LoadToast(MainActivity.this);
        lt.setText("Got it. Fetching data!");
        AwesomeBar bar = findViewById(R.id.bar);
         toast = new FancyToast(MainActivity.this);

        XBOX = findViewById(R.id.customCheckBox2);
        PS = findViewById(R.id.customCheckBox3);
        final CustomCheckBox PC = findViewById(R.id.customCheckBox);

        FancyButton fancyButton = findViewById(R.id.btn_spotify);
        fancyButton.setIconResource(R.drawable.done);
        fancyButton.setText("Search");

        TextFieldBoxes tfv = findViewById(R.id.text_field_boxes);

        tfv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star = true;
            }
        });

        fancyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yolo = extendedEditText.getText();
                lt.show();

                volley();

            }
        });



        PC.setOnCheckedChangeListener(new CustomCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CustomCheckBox checkBox, boolean isChecked) {
                if(isChecked){
                    device = "pc";
                    PS.setChecked(false, true);
                    XBOX.setChecked(false, true);
                    dismissKeyboard(MainActivity.this);

                }

            }
        });



        PS.setOnCheckedChangeListener(new CustomCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CustomCheckBox checkBox, boolean isChecked) {
                if(isChecked){
                    device = "ps";
                    PC.setChecked(false, true);
                    XBOX.setChecked(false, true);
                    dismissKeyboard(MainActivity.this);

                }
            }
        });



        XBOX.setOnCheckedChangeListener(new CustomCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CustomCheckBox checkBox, boolean isChecked) {
                if(isChecked){
                    device = "xbl";
                    PC.setChecked(false, true);
                    PS.setChecked(false, true);


                }
            }
        });

        bar.addAction(R.drawable.awsb_ic_edit_animated,"Info");
        bar.displayHomeAsUpEnabled(true);

        bar.setActionItemClickListener(new AwesomeBar.ActionItemClickListener() {
            @Override
            public void onActionItemClicked(int position, ActionItem actionItem) {
                new LovelyInfoDialog(MainActivity.this)
                        .setTopColorRes(R.color.color_success)
                        .setIcon(R.drawable.ic_info_outline_black_24dp)
                        //This will add Don't show again checkbox to the dialog. You can pass any ID as argument
                        .setMessage("• A beautiful and efficient Fortnite stats tracker \n• Questions and concerns? Hmu at Alinaqvi01n@gmail.com")
                        .show();
            }
        });






        bar.setOnMenuClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toast.makeText(MainActivity.this,"Can't go back now!",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();



            }
        });





        queue = Volley.newRequestQueue(getApplicationContext());





    }
    public void volley(){
        StringRequest sr = new StringRequest(Request.Method.GET, "https://api.fortnitetracker.com/v1/profile/" + device + "/" + yolo.toString(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("HttpClient", "success! response: " + response.toString());
                        ApiInfo = response.toString();
                        Log.e("Loggernig", ApiInfo);
                        String trn;
                        String ApiName = "0";
                        String ApiTotalScore = "0";
                        String ApiRank = "0";
                        String ApiAvgTime = "0";
                        String ApiLifetimematches = "0";
                        String ApiMatchesplayed = "0";
                        String ApiKD = "0";
                        String WinsSolo = "0";
                        String KillsSolo = "0";
                        String MatchesSolo = "0";
                        String KDSolo = "0";
                        String AVGtimeSolo = "0";
                        String WinsDuo = "0";
                        String KillsDuo = "0";
                        String MatchesDuo = "0";
                        String KDDuo = "0";
                        String AVGtimeDuo = "0";
                        String WinsSquad = "0";
                        String KillsSquad = "0";
                        String MatchesSquad = "0";
                        String KDSquad = "0";
                        String AVGtimeSquad = "0";


                        try {

                        ApiName = new JSONObject(response).getString("platformNameLong");

                        try {
                            WinsSolo = new JSONObject(response).getJSONObject("stats").getJSONObject("p2").getJSONObject("top1").getString("value");
                            KillsSolo =  new JSONObject(response).getJSONObject("stats").getJSONObject("p2").getJSONObject("kills").getString("value");
                            KDSolo = new JSONObject(response).getJSONObject("stats").getJSONObject("p2").getJSONObject("kpg").getString("value");
                            AVGtimeSolo = new JSONObject(response).getJSONObject("stats").getJSONObject("p2").getJSONObject("avgTimePlayed").getString("displayValue");
                            MatchesSolo = new JSONObject(response).getJSONObject("stats").getJSONObject("p2").getJSONObject("matches").getString("value");

                        }catch (JSONException e){
                            e.printStackTrace();
                            toast.makeText(MainActivity.this,"You haven't played any solo matches!",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();
                        }

                        try{
                            WinsDuo = new JSONObject(response).getJSONObject("stats").getJSONObject("p9").getJSONObject("top1").getString("value");
                            KillsDuo =  new JSONObject(response).getJSONObject("stats").getJSONObject("p9").getJSONObject("kills").getString("value");
                            KDDuo = new JSONObject(response).getJSONObject("stats").getJSONObject("p9").getJSONObject("kpg").getString("value");
                            AVGtimeDuo = new JSONObject(response).getJSONObject("stats").getJSONObject("p9").getJSONObject("avgTimePlayed").getString("displayValue");
                            MatchesDuo = new JSONObject(response).getJSONObject("stats").getJSONObject("p9").getJSONObject("matches").getString("value");


                        }catch (JSONException e) {
                            e.printStackTrace();
                            toast.makeText(MainActivity.this,"You haven't played any duo matches!",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();
                        }
                        try {
                            WinsSquad = new JSONObject(response).getJSONObject("stats").getJSONObject("p10").getJSONObject("top1").getString("value");
                            KillsSquad = new JSONObject(response).getJSONObject("stats").getJSONObject("p10").getJSONObject("kills").getString("value");
                            KDSquad = new JSONObject(response).getJSONObject("stats").getJSONObject("p10").getJSONObject("kpg").getString("value");
                            AVGtimeSquad = new JSONObject(response).getJSONObject("stats").getJSONObject("p10").getJSONObject("avgTimePlayed").getString("displayValue");
                            MatchesSquad = new JSONObject(response).getJSONObject("stats").getJSONObject("p10").getJSONObject("matches").getString("value");

                        }catch (JSONException e) {
                            e.printStackTrace();
                            toast.makeText(MainActivity.this,"You haven't played any squad matches!",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();
                        }

                     ApiAvgTime = (String) new JSONObject(response).getJSONArray("lifeTimeStats").getJSONObject(14   ).get("value");
                         ApiLifetimematches = (String) new JSONObject(response).getJSONArray("lifeTimeStats").getJSONObject(13   ).get("value");
                        ApiMatchesplayed = (String) new JSONObject(response).getJSONArray("lifeTimeStats").getJSONObject(7).get("value");
                      ApiKD = (String) new JSONObject(response).getJSONArray("lifeTimeStats").getJSONObject(10).get("value");
                        ApiTotalwins = (String) new JSONObject(response).getJSONArray("lifeTimeStats").getJSONObject(8).get("value");



                           Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                           intent.putExtra("Info", new String[] {ApiName, ApiTotalScore, ApiAvgTime, ApiLifetimematches, ApiMatchesplayed, ApiKD, ApiTotalwins});;
                         intent.putExtra("Indiviudals", new String[]{WinsSolo, KillsSolo, MatchesSolo,KDSolo,AVGtimeSolo,WinsDuo,KillsDuo,MatchesDuo,KDDuo,AVGtimeDuo,WinsSquad,KillsSquad,MatchesSquad,KDSquad,AVGtimeSquad});
                            startActivity(intent);





                           Log.e("Data", ApiName);
                           Log.e("Data", ApiTotalScore);
                           Log.e("Data", ApiAvgTime);
                           Log.e("Data", ApiLifetimematches);
                           Log.e("Data", ApiMatchesplayed);
                           Log.e("Data", ApiKD);
                           Log.e("Data", ApiTotalwins);
                           Log.e("Data", WinsSolo);
                           Log.e("Data", KillsSolo);
                           Log.e("Data", MatchesSolo);
                            Log.e("Data", KDSolo);
                            Log.e("Data", AVGtimeSolo);
                            Log.e("Data", WinsDuo);
                            Log.e("Data", KillsDuo);
                            Log.e("Data", MatchesDuo);
                            Log.e("Data", KDDuo);
                            Log.e("Data", AVGtimeDuo);
                            Log.e("Data", WinsSquad);
                            Log.e("Data", KillsSquad);
                            Log.e("Data", MatchesSquad);
                            Log.e("Data", KDSquad);
                            Log.e("Data", AVGtimeSquad);




                            lt.success();
                            toast.makeText(MainActivity.this,"Got it! Here's the stats",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();




                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("AYOOOOOO", "err");
                            toast.makeText(MainActivity.this,"Oops! I can't find that user",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show();



                        }

                        try {
                            jsonObject = new JSONObject(ApiInfo);
                            ApiInfo = jsonObject.getString("accountId");
                            Log.e("Logger", ApiInfo);
                            JSONArray arr = new JSONArray(ApiInfo);
                            for (int i = 0; i < arr.length(); i++) {




                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("HttpClient", "error: " + error.toString());
                    }
                })
        {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("TRN-Api-Key"," 26164136-2834-4ee0-a41a-a19f8deed94e");
                //params.put("pass","YOUR PASSWORD");
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("TRN-Api-Key","26164136-2834-4ee0-a41a-a19f8deed94e");
                return params;
            }
        };
        queue.add(sr);

        sr.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 30000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 30000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });





     /*
*/

    }


}
