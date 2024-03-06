package com.example.layout1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.principal_layout);

        EditText edtNome = findViewById(R.id.edt_nome);
        EditText edtEmail = findViewById(R.id.edt_email);
        EditText edtTelefone = findViewById(R.id.edt_telefone);

        Button btnGravar = findViewById(R.id.btn_gravar);
        btnGravar.setOnClickListener(  e -> {
            Log.i("AGENDA_CONTATO", "Nome: " + edtNome.getText());
            Log.i("AGENDA_CONTATO", "Email: " + edtEmail.getText());
            Log.i("AGENDA_CONTATO", "Telefone: " + edtTelefone.getText());
        });







    }
}
