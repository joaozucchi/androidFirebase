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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    EditText emailText = findViewById(R.id.editText);
    EditText senhaText = findViewById(R.id.editText2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

    }

    public void cadastrar(View view) {

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

    public void logar(View view){
        String email = emailText.getText().toString();
        String senha = senhaText.getText().toString();

        mAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Login realizado com sucesso",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, LogadoActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Falha ao realizar login",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}