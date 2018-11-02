package sony.com.k9drycleaning;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextName, editTextContact, editTextFeedback;
    ProgressBar progressBar;

    int valid=0;

    Button btnSubmit;

    AlertDialog.Builder builder;
    String reg_url = "https://unforced-behavior.000webhostapp.com/drycleaning/feedback.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editTextName = findViewById(R.id.editTextName);
        editTextContact = findViewById(R.id.editTextContact);
        editTextFeedback = findViewById(R.id.editTextFeedback);

        btnSubmit = findViewById(R.id.btnSubmit);

        builder = new AlertDialog.Builder(FeedbackActivity.this);


        btnSubmit.setOnClickListener(this);
    }


    private void feedback(){

        StringRequest request = new StringRequest(Request.Method.POST, reg_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //  myPd_ring.dismiss();

                // System.out.println(response.toString());

                Toast.makeText(FeedbackActivity.this, "Thank you...", Toast.LENGTH_LONG).show();

                Intent i = new Intent(FeedbackActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // myPd_ring.dismiss();
                if (error instanceof NetworkError) {
                    Toast.makeText(FeedbackActivity.this, "Cannot connect to Internet...Please check your connection!", Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
                    Toast.makeText(FeedbackActivity.this, "The server could not be found. Please try again after some time!!", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(FeedbackActivity.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(FeedbackActivity.this, "Parsing error! Please try again after some time !!", Toast.LENGTH_LONG).show();
                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(FeedbackActivity.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(FeedbackActivity.this, "Cannot connect to Internet...Please check your connection !", Toast.LENGTH_LONG).show();
                }


            }

        })

        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("feedback_name", editTextName.getText().toString());
                parameters.put("feedback_contact", editTextContact.getText().toString());
                parameters.put("feedback_feedback", editTextFeedback.getText().toString());


                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }

    public void validate(){

        if (editTextContact.getText().toString().length() < 10 || editTextContact.getText().toString().length() >= 12) {

            editTextContact.setError("Please enter valid phone number");
            // Toast.makeText(SignUpActivity.this,"Please enter valid phone number",Toast.LENGTH_SHORT).show();
            valid++;
        }

        if(editTextName.getText().toString().trim().equals(""))
        {
            editTextName.setError("please enter name");
            valid++;
        }

        if(editTextFeedback.getText().toString().trim().equals(""))
        {
            editTextFeedback.setError("Give feedback...");
            valid++;
        }
    }


    public void onClick(View view) {
        if (view == btnSubmit) {

            valid=0;
            validate();

            if (valid>0)
            {
                Toast.makeText(FeedbackActivity.this, "Please Fill all the fields", Toast.LENGTH_LONG).show();
            }
            else {

                feedback();
            }

        }
    }
}

