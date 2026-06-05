package com.example.hospital;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 101;
    EditText edEmail, edPassword;
    Button btn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    private Button btnGoogle;
    GoogleSignInClient mGoogleSignInClient;
//    TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        btn = findViewById(R.id.buttonLogin);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        btnGoogle = findViewById(R.id.btnGoogle);
//        tv=findViewById(R.id.textViewNewUser);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
                mGoogleSignInClient.signOut();
            }
        });

//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//            }
//        });


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                performLogin();
//            }

//            private void performLogin() {
//                String email = edEmail.getText().toString();
//                String password = edPassword.getText().toString();
//
//
//                if (!email.matches(emailPattern)) {
//                    edEmail.setError("Enter Context Email");
//                } else if (password.isEmpty() || password.length() < 6) {
//                    edPassword.setError("Enter Proper Password");
//                } else {
//                    progressDialog.setMessage("Please Wait While Login...");
//                    progressDialog.setTitle("Login");
//                    progressDialog.setCanceledOnTouchOutside(false);
//                    progressDialog.show();
//
//                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//
//                                FirebaseUser firebaseUser = mAuth.getCurrentUser();
//                                progressDialog.dismiss();
//                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//
//                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                                finish();
//                            } else {
//                                progressDialog.dismiss();
//                                Toast.makeText(LoginActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                }
//            }


//            public void onBackPressed() {
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                builder.setTitle(R.string.app_name);
//                builder.setIcon(R.mipmap.ic_launcher);
//                builder.setMessage("Do you want to exit?")
//                        .setCancelable(false)
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                Intent a = new Intent(Intent.ACTION_MAIN);
//                                a.addCategory(Intent.CATEGORY_HOME);
//                                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity(a);
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//                AlertDialog alert = builder.create();
//                alert.show();
//
//            }
//        });
//
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account=task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            }catch(ApiException e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(LoginActivity.this, user.getEmail() + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                            updateUI(user);
                            progressDialog.setMessage("Please Wait While Login...");
                            progressDialog.setTitle("Login");
                            progressDialog.setCanceledOnTouchOutside(false);
                            progressDialog.show();
                        } else {
                            Toast.makeText(LoginActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void onBackPressed() {

        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent a = new Intent(Intent.ACTION_MAIN);
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(a);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}