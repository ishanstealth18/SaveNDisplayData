package stealth.ishan.savendisplaydata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private String logTag = MainActivity.class.getSimpleName();
    public static final String EXTRA_NAME = "stealth.ishan.savendispaydata.extra.nameMessage";
    public static final String address_string = "stealth.ishan.savendispaydata.extra.addressMessage";
    public static final String phone_string = "stealth.ishan.savendispaydata.extra.phoneMessage";
    public static final String email_string = "stealth.ishan.savendispaydata.extra.emailMessage";
    public static final String INPUT_NAME_ERROR = "Name field empty!!";
    public static final String INPUT_ADDRESS_ERROR = "Adress field empty!!";
    public static final String INPUT_PHONE_ERROR = "Phone field empty!!";
    public static final String INPUT_EMAIL_ERROR = "Email field empty!!";
    public static final String INPUT_FIELDS_EMPTY_ERROR = "All fields are empty!!";
    private EditText input_name;
    private EditText input_address;
    private EditText input_phone;
    private EditText input_email;
    private Button submit_button;
    private String inputName = null;
    private String inputAddress = null;
    private String inputPhone = null;
    private String inputEmail = null;
    Snackbar snack;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_name = findViewById(R.id.name_title_view);
        input_address = findViewById(R.id.postal_address_input);
        input_phone = findViewById(R.id.editTextPhone);
        input_email = findViewById(R.id.email_input);
        submit_button = findViewById(R.id.submit_button);
        Log.d(logTag, "Input fields set...");

    }

    public void setData()
    {
        Log.d(logTag, "Inside setData function");
        inputName = input_name.getText().toString();
        Log.d(logTag, "Set Name: " +inputName);
        inputAddress = input_address.getText().toString();
        Log.d(logTag, "Set Address: " +inputAddress);
        inputPhone = input_phone.getText().toString();
        Log.d(logTag, "Set Phone: " +inputPhone);
        inputEmail = input_email.getText().toString();
        Log.d(logTag, "Set Email: " +inputEmail);
    }

    public void sendData(View view) {
        Log.d(logTag, "Submit button clicked..");
        setData();
        if(inputName.equals(""))
        {
            Log.d(logTag, "Name is empty");
            snack = Snackbar.make(findViewById(android.R.id.content), INPUT_NAME_ERROR, Snackbar.LENGTH_SHORT);
            snack.setBackgroundTint(Color.RED);
            snack.show();
            return;
        }
        else if(inputAddress.equals(""))
        {
            Log.d(logTag, "Address is empty");
            snack = Snackbar.make(findViewById(android.R.id.content), INPUT_ADDRESS_ERROR, Snackbar.LENGTH_SHORT);
            snack.setBackgroundTint(Color.RED);
            snack.show();
            return;

        }
        else if(inputPhone.equals(""))
        {
            Log.d(logTag, "Phone is empty");
            snack = Snackbar.make(findViewById(android.R.id.content), INPUT_PHONE_ERROR, Snackbar.LENGTH_SHORT);
            snack.setBackgroundTint(Color.RED);
            snack.show();
            return;
        }
        else if(inputEmail.equals(""))
        {
            Log.d(logTag, "Email is empty");
            snack = Snackbar.make(findViewById(android.R.id.content), INPUT_EMAIL_ERROR, Snackbar.LENGTH_SHORT);
            snack.setBackgroundTint(Color.RED);
            snack.show();
            return;
        }
        else
        {
            Intent sendDataIntent = new Intent(this,DisplayDataActivity.class);
            sendDataIntent.putExtra(EXTRA_NAME,inputName);
            sendDataIntent.putExtra(address_string,inputAddress);
            sendDataIntent.putExtra(phone_string,inputPhone);
            sendDataIntent.putExtra(email_string,inputEmail);
            startActivity(sendDataIntent);
        }

    }
}