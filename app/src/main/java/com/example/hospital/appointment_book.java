package com.example.hospital;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class appointment_book extends AppCompatActivity {
    private DatePickerDialog picker;
    private TextView resultText;
    private TimePickerDialog timePicker;
    private TextView resultText2;
    private Spinner genderSpinner;
    private EditText name, age, gender, phone, email;
    Button button;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root = db.getReference().child("Users");

    private static final String CHANNEL_ID = "MyNotificationChannel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_book);

        name = findViewById(R.id.editTextTextPersonName);
        age = findViewById(R.id.editTextTextPersonName2);
        phone = findViewById(R.id.editTextPhone);
        email = findViewById(R.id.editTextTextEmailAddress);
        button = findViewById(R.id.button5);
        genderSpinner = findViewById(R.id.gender_spinner);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button dateButton = findViewById(R.id.date_button);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button timeButton = findViewById(R.id.time_button);
        resultText = findViewById(R.id.result_text);
        resultText2 = findViewById(R.id.result_text2);

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);

                timePicker = new TimePickerDialog(appointment_book.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());

                        if (calendar.getTimeInMillis() == cal.getTimeInMillis()) {
                            Toast.makeText(appointment_book.this, "Please choose another time", Toast.LENGTH_SHORT).show();
                        } else {
                            resultText2.setText(timeFormat.format(calendar.getTime()));
                        }
                    }
                }, hour, minute, false);
                timePicker.show();
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                picker = new DatePickerDialog(appointment_book.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(Calendar.YEAR, year);
                        selectedDate.set(Calendar.MONTH, month);
                        selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        Calendar currentDate = Calendar.getInstance();

                        if (selectedDate.getTimeInMillis() == currentDate.getTimeInMillis()) {
                            Toast.makeText(appointment_book.this, "Please choose another date", Toast.LENGTH_SHORT).show();
                        } else {
                            resultText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        }
                    }
                }, year, month, day);
                picker.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rname = name.getText().toString();
                String rage = age.getText().toString();
                String rgender = genderSpinner.getSelectedItem().toString();
                String rphone = phone.getText().toString();
                String remail = email.getText().toString().trim();
                if (!remail.endsWith("@gmail.com")) {
                    remail += "@gmail.com";
                }
                String rdate = resultText.getText().toString();
                String rtime = resultText2.getText().toString();

                if (rname.isEmpty() || rage.isEmpty() || rgender.isEmpty() || rphone.isEmpty() || remail.isEmpty() || rdate.isEmpty() || rtime.isEmpty()) {
                    Toast.makeText(appointment_book.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                    return;
                }

                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("Name", rname);
                userMap.put("Age", rage);
                userMap.put("Gender", rgender);
                userMap.put("Phone", rphone);
                userMap.put("Email", remail);
                userMap.put("Date", rdate);
                userMap.put("Time", rtime);

                root.push().setValue(userMap);

                try {
                    // Create the notification channel if not created already
                    createNotificationChannel();

                    // Build the notification
                    NotificationCompat.Builder ncb = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
                    ncb.setSmallIcon(R.drawable.ic_launcher_foreground);
                    ncb.setContentTitle("Healthcare");
                    ncb.setContentText("You have Booked your Appointment on " + rdate + " and Time is " + rtime);

                    // Show the notification
                    NotificationManagerCompat nmc = NotificationManagerCompat.from(appointment_book.this);
                    nmc.notify(1, ncb.build());
                } catch (SecurityException e) {
                    // Handle the SecurityException (e.g., log it, show an error message)
                    e.printStackTrace();
                    Toast.makeText(appointment_book.this, "Permission required to send notifications", Toast.LENGTH_SHORT).show();
                }

                // Start NotificationActivity
                Intent intent = new Intent(appointment_book.this, MainActivity.class);
                intent.putExtra("text", "You have booked appointment on " + rdate + " and time is " + rtime);
                startActivity(intent);
            }
        });
    }

    // Method to create notification channel
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Define the notification channel ID and name
            CharSequence channelName = "My Notification";

            // Define the notification importance level
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            // Create the notification channel
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, channelName, importance);

            // Get the system service for notification manager
            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            // Create the notification channel
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }
}


