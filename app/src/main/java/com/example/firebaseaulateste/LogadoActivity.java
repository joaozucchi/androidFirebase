package com.example.firebaseaulateste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogadoActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    TextView emailCurrent;
    FirebaseUser currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logado);

        mAuth = FirebaseAuth.getInstance();

        emailCurrent= findViewById(R.id.emailCurrent);
        currentUser = mAuth.getCurrentUser();
        emailCurrent.setText(currentUser.getEmail());
    }

    public void deslogar(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(LogadoActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
