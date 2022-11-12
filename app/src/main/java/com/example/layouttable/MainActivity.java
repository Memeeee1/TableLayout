package com.example.layouttable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText poids,taille;
    RadioGroup mc;
    RadioButton metre,cm;
    CheckBox mf;
    Button calc,ann;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        poids=findViewById(R.id.poids);
        taille= findViewById(R.id.taille);
        metre =findViewById(R.id.metre);
        cm =findViewById(R.id.cm);
        mc=findViewById(R.id.mc);
        mf=findViewById(R.id.mf);
        calc= findViewById(R.id.calculer);
        ann=findViewById(R.id.annuler);
        res=findViewById(R.id.res);






        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int c = mc.getCheckedRadioButtonId();
                switch (c) {
                    case R.id.metre:

                        float p = Float.parseFloat(poids.getText().toString());
                        float t = Float.parseFloat(taille.getText().toString());
                        if (t==0){
                            Toast.makeText(MainActivity.this,"la taille doit etre supérieur à 0",Toast.LENGTH_LONG).show();
                        }
                        else {
                            res.setText(p / t + "kg/m²");
                            break;
                        }
                    case R.id.cm:

                        float pt = Float.parseFloat(poids.getText().toString());
                        float tl = Float.parseFloat(taille.getText().toString());
                        float resul = pt / (tl * 1000);
                        res.setText(resul + "kg/m²");
                        break;
                }
            }
        });







        ann.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poids.setText("");
                taille.setText("");
                boolean y= cm.isChecked();
                if ( y){
                    metre.setChecked(true);
                }
                if (mf.isChecked()){
                    mf.setChecked(false);
                }
                res.setText(R.string.r_sultat_n_vous_devez_cliquer_sur_le_bouton_calculer_l_imc_pur_obtenir_un_r_sultat);
            }
        });



    }}

