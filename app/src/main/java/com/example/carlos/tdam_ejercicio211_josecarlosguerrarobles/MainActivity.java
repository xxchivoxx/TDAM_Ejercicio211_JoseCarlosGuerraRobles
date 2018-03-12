package com.example.carlos.tdam_ejercicio211_josecarlosguerrarobles;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail;
    RadioButton rbtnMale, rbtnFemale;
    CheckBox chkCo, chkWr, chkJo;
    Spinner spnZodiac;
    Button btnSave, btnGetMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbtnMale = findViewById(R.id.rbtnMale);
        rbtnFemale = findViewById(R.id.rbtnFemale);

        chkCo = findViewById(R.id.checkBox);
        chkWr = findViewById(R.id.checkBox2);
        chkJo = findViewById(R.id.checkBox3);

        spnZodiac = findViewById(R.id.spinner);

        edtEmail = findViewById(R.id.editText2);

        btnSave = findViewById(R.id.btnSave);
        btnGetMe = findViewById(R.id.btnGetMe);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveChanges();
            }
        });

        btnGetMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChanges();
            }
        });
    }

    private void saveChanges(){
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("CORREO",edtEmail.getText().toString());
        editor.putBoolean("GENEROM",rbtnMale.isChecked());
        editor.putBoolean("GENEROF",rbtnFemale.isChecked());
        editor.putBoolean("CHKCo",chkCo.isChecked());
        editor.putBoolean("CHKWr",chkWr.isChecked());
        editor.putBoolean("CHKJo",chkJo.isChecked());
        editor.putInt("SIGNO",spnZodiac.getSelectedItemPosition());
        editor.commit();
        Toast.makeText(this, "Preferences saved it", Toast.LENGTH_SHORT).show();
    }

    private void getChanges(){
        String texto="";
        Boolean generoM,generoF,chkCo,chkWr,chkJo;
        int signo;
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        texto = sharedPreferences.getString("CORREO",null);
        generoM = sharedPreferences.getBoolean("GENEROM",false);
        generoF = sharedPreferences.getBoolean("GENEROF",false);
        chkCo = sharedPreferences.getBoolean("CHKCo",false);
        chkWr = sharedPreferences.getBoolean("CHKWr",false);
        chkJo = sharedPreferences.getBoolean("CHKJo",false);
        signo = sharedPreferences.getInt("SIGNO",0);
        edtEmail.setText(texto);
        rbtnMale.setChecked(generoM);
        rbtnFemale.setChecked(generoF);
        this.chkCo.setChecked(chkCo);
        this.chkWr.setChecked(chkWr);
        this.chkJo.setChecked(chkJo);
        spnZodiac.setSelection(signo);
        Toast.makeText(this, "Preferences got it", Toast.LENGTH_SHORT).show();
    }
}
