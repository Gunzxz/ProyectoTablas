package com.example.proyectotablas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public String nombreUsuario;
    Spinner spinner1,spinner2;
    Button button1;
    TextView text;

       public MainActivity(String nombreUsuario, String nombreProyecto, String nombrePais) {
        this.nombreUsuario = nombreUsuario;
        this.nombreProyecto = nombreProyecto;
        this.nombrePais = nombrePais;
    }

    public MainActivity() {
        this.nombreUsuario = "";
        this.nombreProyecto = "";
        this.nombrePais = "";
    }




    public String nombreProyecto;
    public String nombrePais;
    ArrayList<MainActivity> listaUsuario;
    ArrayList<MainActivity> listaProyecto;
    ArrayList<MainActivity> listaPais;

    ArrayList<String> listaUsuario2;
    ArrayList<String> listaProyecto2;
    ArrayList<String> listaPais2;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public String getNombrePais() {
        return nombrePais;
    }



    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConnectSqlite admin = new ConnectSqlite(this, ConnectSqlite.DATABASE_NAME, null, ConnectSqlite.DATABASE_VERSION);
        final SQLiteDatabase bbdd = admin.getWritableDatabase();


        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        button1 = findViewById(R.id.button1);
        text = findViewById(R.id.text1);


       /* ContentValues registro = new ContentValues();

        registro.put("usuario","Pepe");
        registro.put("usuario","Juan");
        registro.put("usuario","Antonio");
        registro.put("usuario","Alberto");
        registro.put("usuario","María");

        bbdd.insert("usuarios",null,registro);


        ContentValues registro2 = new ContentValues();

        registro.put("proyecto","ProyectoPepe");
        registro.put("proyecto","ProyectoJuan");
        registro.put("proyecto","ProyectoAntonio");
        registro.put("proyecto","ProyectoAlberto");
        registro.put("proyecto","ProyectoMaría");
        registro.put("proyecto","ProyectoPepe2");
        registro.put("proyecto","ProyectoJuan2");
        registro.put("proyecto","ProyectoAntonio2");
        registro.put("proyecto","ProyectoAlberto2");
        registro.put("proyecto","ProyectoMaría2");
        registro.put("proyecto","ProyectoPepe3");
        registro.put("proyecto","ProyectoJuan3");
        registro.put("proyecto","ProyectoAntonio3");
        registro.put("proyecto","ProyectoAlberto3");
        registro.put("proyecto","ProyectoMaría3");
        registro.put("proyecto","ProyectoPepe5");
        registro.put("proyecto","ProyectoJuan5");
        registro.put("proyecto","ProyectoAntonio5");
        registro.put("proyecto","ProyectoAlberto5");
        registro.put("proyecto","ProyectoMaría5");
        registro.put("proyecto","ProyectoPepe4");
        registro.put("proyecto","ProyectoJuan4");
        registro.put("proyecto","ProyectoAntonio4");
        registro.put("proyecto","ProyectoAlberto4");
        registro.put("proyecto","ProyectoMaría4");
        bbdd.insert("proyecto",null,registro2);


        ContentValues registro3 = new ContentValues();

        registro.put("pais","España");
        registro.put("pais","Alemania");
        registro.put("pais","EEUU");
        registro.put("pais","Francia");
        registro.put("pais","Cuba");
        bbdd.insert("pais",null,registro3);*/

        //consultarListaUsuarios();
        obtenerListaUsuario();
        ArrayAdapter<String> adaptador2 = new ArrayAdapter(this, R.layout.negrita_spinner,listaUsuario2 );
        spinner1.setAdapter(adaptador2);

        //consultarListaPais();
        obtenerListaPais();
        ArrayAdapter<String> adaptador3 = new ArrayAdapter(this, R.layout.negrita_spinner,listaPais2 );
        spinner2.setAdapter(adaptador3);

        final ConnectSqlite admin2 = new ConnectSqlite(this, ConnectSqlite.DATABASE_NAME, null, ConnectSqlite.DATABASE_VERSION);
        final SQLiteDatabase bbdd2 = admin.getReadableDatabase();

    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Cursor c = bbdd2.rawQuery("SELECT dato FROM datos WHERE columna = '" + spinner1.getSelectedItem().toString() + "' AND fila = '"+ spinner2.getSelectedItem().toString()+"'", null);

            if(c.moveToFirst()) {


                do {

                    String resultado = c.getString(0);

                    text.setText(resultado);

                }

                while (c.moveToNext());

            }




        }
    });


    }


   /* public void consultarListaUsuarios() {

        final ConnectSqlite admin = new ConnectSqlite(this, ConnectSqlite.DATABASE_NAME, null, ConnectSqlite.DATABASE_VERSION);
        final SQLiteDatabase bbdd2 = admin.getReadableDatabase();

        MainActivity persona = null;
        listaUsuario = new ArrayList<MainActivity>();

        //Select


        Cursor cursor = bbdd2.rawQuery("SELECT * FROM columna ",null);


        if(cursor.moveToFirst() && cursor != null) {


            do {

                persona = new MainActivity();
                persona.setNombreUsuario(cursor.getString(0));


                Log.i("partida", "" + persona.getNombreUsuario());


                listaUsuario.add(persona);

            }

            while (cursor.moveToNext());

            cursor.close();
            bbdd2.close();

        }

        obtenerListaUsuario();

        bbdd2.close();

    }*/





   /* public void consultarListaPais() {

        final ConnectSqlite admin = new ConnectSqlite(this, ConnectSqlite.DATABASE_NAME, null, ConnectSqlite.DATABASE_VERSION);
        final SQLiteDatabase bbdd2 = admin.getReadableDatabase();

        MainActivity persona2 = null;
        listaPais = new ArrayList<MainActivity>();

        //Select


        Cursor cursor = bbdd2.rawQuery("SELECT * FROM fila ",null);


        if(cursor.moveToFirst() && cursor != null) {


            do {

                persona2 = new MainActivity();
                persona2.setNombrePais(cursor.getString(0));


                Log.i("partida", "" + persona2.getNombrePais());


                listaPais.add(persona2);

            }

            while (cursor.moveToNext());

            cursor.close();
            bbdd2.close();

        }

        obtenerListaPais();

        bbdd2.close();

    }*/






    public void obtenerListaUsuario(){

        final ConnectSqlite admin = new ConnectSqlite(this, ConnectSqlite.DATABASE_NAME, null, ConnectSqlite.DATABASE_VERSION);
        final SQLiteDatabase bbdd2 = admin.getReadableDatabase();
        //final Cursor consulta = bbdd2.rawQuery("SELECT * FROM nombresPartidas ", null);

        listaUsuario2 = new ArrayList<String>();
        listaUsuario2.add("1");
        listaUsuario2.add("1");
        listaUsuario2.add("2");
        listaUsuario2.add("3");
        listaUsuario2.add("4");
        listaUsuario2.add("5");
        listaUsuario2.add("6");
        listaUsuario2.add("7");
        listaUsuario2.add("8");
        listaUsuario2.add("9");
        listaUsuario2.add("10");
        listaUsuario2.add("15");
        listaUsuario2.add("20");





    }


    public void obtenerListaPais(){

        final ConnectSqlite admin = new ConnectSqlite(this, ConnectSqlite.DATABASE_NAME, null, ConnectSqlite.DATABASE_VERSION);
        final SQLiteDatabase bbdd2 = admin.getReadableDatabase();
        //final Cursor consulta = bbdd2.rawQuery("SELECT * FROM nombresPartidas ", null);

        listaPais2 = new ArrayList<String>();
        listaPais2.add("1/1000");
        listaPais2.add("1/500");
        listaPais2.add("1/250");
        listaPais2.add("1/125");
        listaPais2.add("1/60");
        listaPais2.add("1/30");
        listaPais2.add("1/15");
        listaPais2.add("1/8");
        listaPais2.add("1/4");
        listaPais2.add("1/2");
        listaPais2.add("1''");





        }



    }



