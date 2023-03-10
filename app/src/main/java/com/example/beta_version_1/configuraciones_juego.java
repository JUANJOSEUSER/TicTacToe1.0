package com.example.beta_version_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class configuraciones_juego extends AppCompatActivity {
    int defaul= Color.BLACK;
    int defaul2=Color.BLACK;
    TextView letrax,letrao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuraciones_juego);
        letrao=findViewById(R.id.letrao);
        letrax=findViewById(R.id.letrax);
    }
    public void confirmar(View view) {
        aviso();
        Intent a=new Intent(this,act_juego.class);
        startActivity(a);
        finish();
    }
    public void aviso(){//cada vez que se inicia seccion se crea un xml donde guardaremos datos en memoria
        SharedPreferences librito=getSharedPreferences("cuenta_informacio", Context.MODE_PRIVATE);//se coloca el nombre del xml y el context si quiere ser privado o de acceso restringido
        SharedPreferences.Editor libro=librito.edit();//editor hace la funcion de poder escribir en el xml mandadole la clave y el valor
        libro.putInt("colorX",defaul2);
        libro.putInt("colorO",defaul);
        libro.commit();
    }
    public void elegir_color(View c){
        AmbilWarnaDialog color=new AmbilWarnaDialog(this, defaul, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
            }
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaul=color;
                letrao.setTextColor(color);
            }
        });
        color.show();
    }
    public void cancelar(View view) {
        Intent ventana_cuenta = new Intent(this, act_juego.class);//es el link que lleva a crear cuentas
        startActivity(ventana_cuenta);
    }
    public void elegir_color2(View c){
        AmbilWarnaDialog color=new AmbilWarnaDialog(this, defaul, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
            }
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaul2=color;
                letrax.setTextColor(color);

            }
        });
        color.show();
    }
}