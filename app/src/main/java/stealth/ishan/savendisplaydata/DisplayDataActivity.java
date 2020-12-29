package stealth.ishan.savendisplaydata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayDataActivity extends AppCompatActivity {
    private String logTag = DisplayDataActivity.class.getSimpleName();
    private TextView display_name;
    private TextView display_address;
    private TextView display_phone;
    private TextView display_email;
    private String displayInputName;
    private String displayInputAddress;
    private String displayInputPhone;
    private String displayInputEmail;
    Intent getDataIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        display_name = findViewById(R.id.display_input_name);
        display_address = findViewById(R.id.display_input_address_title);
        display_phone = findViewById(R.id.editTextPhone2);
        display_email = findViewById(R.id.display_input_email);
        Log.d(logTag, "Inside second activity");
        getDataIntent = getIntent();
        getPersonalDetails();
        setPersonalDetails();
    }

    public void getPersonalDetails()
    {
        //Intent getDataIntent = getIntent();
        Log.d(logTag, "Getting personal details");
        displayInputName = getDataIntent.getStringExtra(MainActivity.EXTRA_NAME);
        Log.d(logTag, "Name: " +displayInputName);
        displayInputAddress = getDataIntent.getStringExtra(MainActivity.address_string);
        Log.d(logTag, "Address: " +displayInputAddress);
        displayInputPhone = getDataIntent.getStringExtra(MainActivity.phone_string);
        Log.d(logTag, "Phone: " +displayInputPhone);
        displayInputEmail = getDataIntent.getStringExtra(MainActivity.email_string);
        Log.d(logTag, "Email: " +displayInputEmail);
    }

    public void setPersonalDetails()
    {
        Log.d(logTag, "Setting personal details");
        display_name.setText(displayInputName);
        display_address.setText(displayInputAddress);
        display_phone.setText(displayInputPhone);
        display_email.setText(displayInputEmail);
    }
}