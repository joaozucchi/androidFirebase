package com.example.firebaseaulateste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    public void cadastrar(View view) {
        EditText emailText = findViewById(R.id.editText);
        EditText senhaText = findViewById(R.id.editText2);

        String email = emailText.getText().toString();
        String senha = senhaText.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Conta Cadastrado com Sucesso",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Falha ao Cadastrar Conta",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
