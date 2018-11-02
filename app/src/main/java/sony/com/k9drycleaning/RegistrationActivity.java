package sony.com.k9drycleaning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.util.Map;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    int valid=0;
    String reg_url = "http://unforced-behavior.000webhostapp.com/drycleaning/registration.php";

    EditText u_name,name,address,email,phone_no,password,con_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button btnRegister=findViewById(R.id.btnRegister);
        TextView backToLogin=findViewById(R.id.backToLogin);

        u_name = findViewById(R.id.userIDTextInputEditText);
        name = findViewById(R.id.nameTextInputEditText);
        address = (EditText) findViewById(R.id.addressTextInputEditText);
        email = (EditText) findViewById(R.id.emailTextInputEditText);
        phone_no = (EditText) findViewById(R.id.phoneNumberTextInputEditText);
        password = (EditText) findViewById(R.id.passwordTextInputEditText);
        con_pass = (EditText) findViewById(R.id.confirmPasswordTextInputEditText);

        backToLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
        );
        btnRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        valid=0;
                        validate();

                        if (valid>0)
                        {
                            Toast.makeText(RegistrationActivity.this, "Please Fill all the fields", Toast.LENGTH_LONG).show();
                        }
                        else {

                            registration();
                        }
                    }
                }
        );
    }

    public void validate(){

        if(name.getText().toString().trim().equals(""))
        {
            name.setError("please enter name");
            valid++;
        }

//        if(email.getText().toString().trim().equals(""))
//        {
//            email.setError("please enter Email");
//            valid++;
//        }

        if (phone_no.getText().toString().length() < 10 || phone_no.getText().toString().length() >= 12) {

            phone_no.setError("Please enter valid phone number");
            // Toast.makeText(SignUpActivity.this,"Please enter valid phone number",Toast.LENGTH_SHORT).show();
            valid++;
        }

        if(u_name.getText().toString().trim().equals(""))
        {
            u_name.setError("please enter user name");
            valid++;
        }

        if(address.getText().toString().trim().equals(""))
        {
            address.setError("please enter address");
            valid++;
        }

//        if (!checkEmail(p_email.getText().toString())) {
//            p_email.setError("Invalid Email");
//
//            // Toast.makeText(SignUpActivity.this, "Paswword lenght should be greater than 6 char", Toast.LENGTH_SHORT).show();
//            valid++;
//
//        }


        if(password.getText().toString().trim().equals(""))
        {
            password.setError("please enter your password");
            valid++;
        }

        if(!isValidPassword(password.getText().toString()))
        {
            password.setError("Paswword lenght should be greater than 3 char or less than 6 char");
            valid++;
        }

//        if (!ValidPassword(password.getText().toString())) {
//            password.setError("Please Enter Valid password (eg. @123)");
//
//            // Toast.makeText(SignUpActivity.this, "Paswword lenght should be greater than 6 char", Toast.LENGTH_SHORT).show();
//            valid++;
//
//        }

        if(!con_pass.getText().toString().equals(password.getText().toString()))
        {

            con_pass.setError("Password did not matched");
            valid++;
        }



    }

//    private boolean checkEmail(String email) {
//        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
//    }
//
//    public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
//            "[a-zA-Z0-9+._%-+]{1,256}" +
//                    "@" +
//                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
//                    "(" +
//                    "." +
//                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
//                    ")+"
//    );

    private boolean isValidPassword(String pass)
    {

        if (pass != null && pass.length() > 2 && pass.length() <= 6) {
            return true;
        }

        return false;

    }

    private boolean ValidPassword(String pa)
    {
        return Password_pattern.matcher(pa).matches();
    }

    final Pattern Password_pattern = Pattern.compile("^([!@#$%^&*?+]+[0-9+]+)$");


    public void registration(){

        StringRequest request = new StringRequest(Request.Method.POST, reg_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //  myPd_ring.dismiss();

                // System.out.println(response.toString());

                Toast.makeText(RegistrationActivity.this, "Registration Succesful", Toast.LENGTH_LONG).show();

                Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(i);
                finish();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // myPd_ring.dismiss();
                if (error instanceof NetworkError) {
                    Toast.makeText(RegistrationActivity.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
                    Toast.makeText(RegistrationActivity.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(RegistrationActivity.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(RegistrationActivity.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();

                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(RegistrationActivity.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(RegistrationActivity.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                }


            }

        })

        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("user_name", u_name.getText().toString());
                parameters.put("name", name.getText().toString());
                parameters.put("address", address.getText().toString());
                parameters.put("email", email.getText().toString());
                parameters.put("ph_number", phone_no.getText().toString());
                parameters.put("password", password.getText().toString());

                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }
}