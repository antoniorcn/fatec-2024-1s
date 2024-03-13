package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.login_activity);

        Button btn = findViewById(R.id.btnLogar);

        btn.setOnClickListener(
                ( e ) -> {
                    Intent it = new Intent(this, LogadoActivity.class);
                    it.putExtra("TESTE", "Olá eu sou um Teste");
                    startActivity(it);
                }
        );
    }
}
