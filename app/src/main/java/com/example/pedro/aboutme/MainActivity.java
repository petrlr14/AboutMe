package com.example.pedro.aboutme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        fab=findViewById(R.id.fab);//se obtiene elemento floatin Action button
        addingListener();//se agrega el listener al boton
    }

    private void addingListener(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendInfo();//al hacer click en el boton se lanza el intent
            }
        });
    }

    private void sendInfo(){
        intent=new Intent(Intent.ACTION_SEND);//se inicializa el intent
        intent.setType("text/plain");//se define el tipo del intent
        intent.putExtra(Intent.EXTRA_TEXT, getText());//se agrega el texto a mandar
        Intent chooser=Intent.createChooser(intent, "Selecciona una aplicacion");//se crea un chooser con un mensaje personalizado
        startActivity(chooser);
    }

    private String getText(){//se crea la cadena a mandar
        return "Nombre:\t"+getString(R.string.my_name)+"\n"+
                "Titulo:\t"+getString(R.string.carrera)+"\n"+
                "Github:\t"+getString(R.string.github_username)+"\n"+
                "Twitter:\t"+getString(R.string.twitter)+"\n"+
                "Number:\t"+getString(R.string.phone_number)+"\n"+
                "Mail:\t"+getString(R.string.mail);
    }



}
