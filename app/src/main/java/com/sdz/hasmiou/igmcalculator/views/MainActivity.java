package com.sdz.hasmiou.igmcalculator.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sdz.hasmiou.igmcalculator.R;
import com.sdz.hasmiou.igmcalculator.controllers.ProfilController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }

    private Button btnCalculate;
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView txtResult;
    private ImageView picture;
    private ProfilController controller;

    /**
     *
     */
    private void init(){
        this.btnCalculate = (Button) findViewById(R.id.btnCalculate);
        this.txtResult = (TextView) findViewById(R.id.txtResult);
        this.rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        this.txtAge = (EditText) findViewById(R.id.txtAge);
        this.txtPoids = (EditText) findViewById(R.id.txtPoids);
        this.txtTaille = (EditText) findViewById(R.id.txtTaille);
        this.picture = (ImageView) findViewById(R.id.imgBody);

        this.controller = ProfilController.getInstance();
        this.handleClick();
        Toast.makeText(MainActivity.this, "Merci de saisir voss informations puis cliquer sur calculer", Toast.LENGTH_SHORT).show();
    }

    /**
     *
     */
    private void handleClick(){
        this.btnCalculate.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                calculateImg();
            }
        });
    }

    /**
     *
     */
    private void calculateImg(){
        Integer p = 0;
        Integer t = 0;
        Integer a = 0;
        Integer s = 0;
        try{
            p = Integer.parseInt(txtPoids.getText().toString());
            t = Integer.parseInt(txtTaille.getText().toString());
            a = Integer.parseInt(txtAge.getText().toString());
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Error: Une erreur s'est produite :(", Toast.LENGTH_SHORT).show();
        }

        if(rdHomme.isChecked()){
            s = 1;
        }
        if(t==0||a==0||p==0){
            Toast.makeText(MainActivity.this, "Saisie incorrecte, Veillez entrer les bonnes données", Toast.LENGTH_SHORT).show();
        }else{
            displayResult(p, t, a, s);
        }
    }

    /**
     *
     * @param poids
     * @param taille
     * @param age
     * @param sex
     */
    private void displayResult(Integer poids, Integer taille, Integer age, Integer sex){
        this.controller.createProfil(poids, taille,age, sex);
        float img = this.controller.getImg();
        String message = this.controller.getMessage();
        if(message=="Normal"){
            if ((sex == 1)) {
                this.picture.setImageResource(R.drawable.mh);
            } else {
                this.picture.setImageResource(R.drawable.mgirl);
            }
            txtResult.setTextColor(Color.GREEN);
        }else{
            if(message=="Trop faible"){
                if ((sex == 1)) {
                    this.picture.setImageResource(R.drawable.xsh);
                } else {
                    this.picture.setImageResource(R.drawable.xsgirl);
                }
            }else{
                if ((sex == 1)) {
                    this.picture.setImageResource(R.drawable.xlh);
                } else {
                    this.picture.setImageResource(R.drawable.xlgirl);
                }
            }
            txtResult.setTextColor(Color.RED);
        }
        txtResult.setText(String.format("%.01f",img)+ ": IMG "+message);
    }
}
