package sony.com.k9drycleaning;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;

    private static int currentPage = 0;
    private static final Integer[] XMEN = {};

    private ImageView[] dots;

    LinearLayout linearWash,linearIron,linearWashAndIron,linearDrycleaning;

    RequestQueue rq;
    List<SliderUtils> sliderImg;
    ViewPagerAdapter viewPagerAdapter;

    String request_url = "https://unforced-behavior.000webhostapp.com/drycleaning/slider_image.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocal();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        ====================================MAinContaint==================================================

        linearWash=findViewById(R.id.linearWash);
        linearIron=findViewById(R.id.linearIron);
        linearWashAndIron=findViewById(R.id.linearWashAndIron);
        linearDrycleaning=findViewById(R.id.linearDrycleaning);


        linearWash.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent wash=new Intent(MainActivity.this,OnlyWash.class);
                        startActivity(wash);
                    }
                }
        );

        linearIron.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent iron=new Intent(MainActivity.this,OnlyIron.class);
                        startActivity(iron);
                    }
                }
        );

        linearWashAndIron.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent washAndIron=new Intent(MainActivity.this,WashAndIron.class);
                        startActivity(washAndIron);
                    }
                }
        );

        linearDrycleaning.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent dryCleaning=new Intent(MainActivity.this,Drycleaning.class);
                        startActivity(dryCleaning);
                    }
                }
        );


//*****************************Image Slider**********************************************************************************

        rq = CustomVolleyRequest.getInstance(this).getRequestQueue();

        sliderImg = new ArrayList<>();

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        sendRequest();

//===============================================================================================

//        if (!LoginSharedPreferences.getmInstance(this).isLogedIn()){
//
//            finish();
//            startActivity(new Intent(this,LoginActivity.class));
//            return;
//        }
//==================================================================================================

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//
//                for(int i = 0; i< dotscount; i++){
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
//                }
//
//                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


//  ****************************************************************************************

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            showChangeLanguaqgeDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_priceList) {

            Intent i=new Intent(MainActivity.this,PriceActivity.class);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.nav_Offer) {


        } else if (id == R.id.nav_histry) {

            Intent i=new Intent(MainActivity.this,HistoryActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_aboutUs) {


            Intent i=new Intent(MainActivity.this,AboutUs.class);
            startActivity(i);

        } else if (id == R.id.nav_services) {

            Intent i=new Intent(MainActivity.this,ServicesActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_contactUs) {

            Intent i=new Intent(MainActivity.this,ContactUs.class);
            startActivity(i);

    } else if (id == R.id.nav_Logout) {

            Intent i=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);
            Toast.makeText(this,"Succesfully Logged Out...",Toast.LENGTH_LONG).show();

    } else if (id == R.id.nav_feedback) {


            Intent i=new Intent(MainActivity.this,FeedbackActivity.class);
            startActivity(i);

    } else if (id == R.id.nav_share) {

    } else if (id == R.id.nav_termsandcondition) {

            Intent i=new Intent(MainActivity.this,Terms_And_Condition_Activity.class);
            startActivity(i);
    }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



//    *********************************Image Slider*********************************************************

    public void sendRequest() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {

                    SliderUtils sliderUtils = new SliderUtils();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        sliderUtils.setSliderImageUrl(jsonObject.getString("image_url"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    sliderImg.add(sliderUtils);

                }

                viewPagerAdapter = new ViewPagerAdapter(sliderImg, MainActivity.this);

                viewPager.setAdapter(viewPagerAdapter);


                for (int i = 0; i < XMEN.length; i++)
                    sliderImg.add(sliderImg.get(i));

                viewPager = (ViewPager) findViewById(R.id.viewPager);

                //viewPager.setAdapter(new ViewPagerAdapter(MainActivity.this,sliderImg));
                // CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
                //indicator.setViewPager(mPager);

                // Auto start of viewpager
                final Handler handler = new Handler();
                final Runnable Update = new Runnable() {
                    public void run() {
                        if (currentPage == XMEN.length) {
                            currentPage = 0;
                        }
                        viewPager.setCurrentItem(currentPage++, true);


                    }


                };
                Timer swipeTimer = new Timer();
                swipeTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(Update);
                    }
                }, 6000, 4500);


                dotscount = viewPagerAdapter.getCount();
                dots = new ImageView[dotscount];

                for (int i = 0; i < dotscount; i++) {

                    dots[i] = new ImageView(MainActivity.this);
                    //dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                    params.setMargins(8, 0, 8, 0);

                    sliderDotspanel.addView(dots[i], params);

                }

                //dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });


        CustomVolleyRequest.getInstance(this).addToRequestQueue(jsonArrayRequest);
    }


//    ========================================Languge=====================================================

    private void showChangeLanguaqgeDialog() {

        final String[] listItem = {"मराठी", "English"};

        AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity.this);
        mbuilder.setTitle("Choose Language....");
        mbuilder.setSingleChoiceItems(listItem, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                if (i == 0) {

                    //Marathi
                    setLocal("mr");
                    recreate();
                } else if (i == 1) {

                    //English
                    setLocal("en");
                    recreate();
                }

                dialog.dismiss();

            }
        });

        AlertDialog mDialog = mbuilder.create();
        mDialog.show();

    }

    private void setLocal(String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocal() {

        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocal(language);
    }
}

