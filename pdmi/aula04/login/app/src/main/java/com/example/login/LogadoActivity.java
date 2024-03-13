package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class LogadoActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        Intent intent = getIntent();
        String valor = intent.getStringExtra("TESTE");
        Log.i("LOGIN", valor);

        setContentView(R.layout.logado_activity);
    }
}
