package sony.com.k9drycleaning;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;



public class LoginActivity extends AppCompatActivity {

    int valid=0;
EditText userIDTextInputEditText,passwordTextInputEditText;
    RequestQueue requestQueue;
    String Login_url = "http://unforced-behavior.000webhostapp.com/drycleaning/login.php";

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String uName = "uName";
    public static final String passwordKey = "passwordKey";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userIDTextInputEditText=findViewById(R.id.userIDTextInputEditText);
        passwordTextInputEditText=findViewById(R.id.passwordTextInputEditText);


        Button btnLogin=findViewById(R.id.btnLogin);
        TextView registerHere=findViewById(R.id.registerHere);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

//        ==================================================================================================

//        if (LoginSharedPreferences.getmInstance(this).isLogedIn()){
//
//            finish();
//            startActivity(new Intent(this,MainActivity.class));
//            return;
//        }

//        ===========================================================================================

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final ProgressDialog myPd_ring = ProgressDialog.show(LoginActivity.this, "", "Please Wait.....", true);
                myPd_ring.setCancelable(true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        try {
                            //Thread.sleep(10000);
                        } catch (Exception e) {

                        }
//                        myPd_ring.dismiss();
                    }
                }).start();
//        =========================================================================================================================

                StringRequest stringRequest = new StringRequest(Request.Method.POST, Login_url, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        myPd_ring.dismiss();
                        if (response.trim().equals("Login Successful")) {
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();

                            String n  = userIDTextInputEditText.getText().toString();
                            String ph  = passwordTextInputEditText.getText().toString();

                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            editor.putString(uName, n);
                            editor.putString(passwordKey, ph);
                            editor.commit();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            Bundle bundle=new Bundle();
//                            bundle.putString("uName",userIDTextInputEditText.getText().toString());
//                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                        } else {
                            myPd_ring.cancel();
                            Toast.makeText(LoginActivity.this, response, Toast.LENGTH_LONG).show();

                        }
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                myPd_ring.dismiss();
                                myPd_ring.cancel();

                                if (error instanceof NetworkError) {
                                    Toast.makeText(LoginActivity.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                                } else if (error instanceof ServerError) {
                                    Toast.makeText(LoginActivity.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                                } else if (error instanceof AuthFailureError) {
                                    Toast.makeText(LoginActivity.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                                } else if (error instanceof ParseError) {
                                    Toast.makeText(LoginActivity.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();
                                } else if (error instanceof NoConnectionError) {
                                    Toast.makeText(LoginActivity.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                                } else if (error instanceof TimeoutError) {
                                    Toast.makeText(LoginActivity.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                                }

                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("user_name", userIDTextInputEditText.getText().toString());
                        parameters.put("password", passwordTextInputEditText.getText().toString());


                        return parameters;
                    }
                };

                requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        });

//    ===========================================================================================================================

        registerHere.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    }
                }
        );

    }


//************************************************************************************************************************************

    public void onBackPressed() {

        //super.onBackPressed();
        Log.d("back button", "back button pressed");
        AlertDialog.Builder ad1=new AlertDialog.Builder(this);
        ad1.setMessage("Are you sure you want to exit ?");
        ad1.setCancelable(false);


        ad1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {


            }
        });

        ad1.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
                startActivity(intent);
                finish();
                System.exit(0);


            }
        });
        AlertDialog alert=ad1.create();
        alert.show();

    }
    //============================================================================================================================

    private void showChangeLanguaqgeDialog() {

        final String[] listItem = {"मराठी", "English"};

        AlertDialog.Builder mbuilder = new AlertDialog.Builder(LoginActivity.this);
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

        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocal(language);
    }

}

