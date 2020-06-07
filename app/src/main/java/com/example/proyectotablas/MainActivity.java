package com.example.proyectotablas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ConnectException;
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


        Cursor c2 = bbdd2.rawQuery("SELECT * FROM datos", null);

        if (c2.getCount() == 0) {

            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/500', '1', '1/1000');");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/250', '1', '1/500');");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/125', '1', '1/250');");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/60', '1', '1/125');");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/30', '1', '1/60');");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/15', '1', '1/30');");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/8', '1', '1/15');");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/4', '1', '1/8');");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/2', '1', '1/4');");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '1', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '1', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/250', '2', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/125', '2', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/60', '2', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/30', '2', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/25', '2', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/15', '2', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/8', '2', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/4', '2', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/2', '2', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '2', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '2', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/125', '3', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/60', '3', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/30', '3', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/15', '3', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/8', '3', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/4', '3', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/2', '3', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '3', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '3', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('4\"', '3', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('8\"', '3', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/60', '4', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/30', '4', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/15', '4', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/8', '4', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/4', '4', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/2', '4', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '4', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '4', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('4\"', '4', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('8\"', '4', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('16\"', '4', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/30', '5', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/15', '5', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/8', '5', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/4', '5', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '5', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '5', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('4\"', '5', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('8\"', '5', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('16\"', '5', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('32\"', '5', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/15', '6', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/8', '6', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/4', '6', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/2', '6', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '6', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '6', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('4\"', '6', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('8\"', '6', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('16\"', '6', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('32\"', '6', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('64\"', '6', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/', '7', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/4', '7', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/2', '7', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '7', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '7', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('4\"', '7', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('8\"', '7', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('16\"', '7', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('32\"', '7', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('64\"', '7', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('12\"', '7', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/4', '8', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/2', '8', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '8', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '8', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('4\"', '8', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('8\"', '8', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('16\"', '8', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('32\"', '8', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('64\"', '8', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('12\"', '8', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('256\"', '8', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1/2', '9', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '9', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '9', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('4\"', '9', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('8\"', '9', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('16\"', '9', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('32\"', '9', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('64\"', '9', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('12\"', '9', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('256\"', '9', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('512\"', '9', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1\"', '10', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2\"', '10', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('4\"', '10', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('8\"', '10', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('16\"', '10', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('32\"', '10', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('64\"', '10', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('12\"', '10', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('256\"', '10', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('512\"', '10', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('17''4\"', '10', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('32\"', '11', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('64\"', '11', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('12\"', '15', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('256\"', '15', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('512\"', '15', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('17''4\"', '15', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('34''\"', '15', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('6''16\"', '15', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('136''32\"', '15', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('273''4\"', '15', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('546''\"', '15', '1''');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('16''40\"', '20', '1/1000');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('33''20\"', '20', '1/500');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('66''40\"', '20', '1/250');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('133''20\"', '20', '1/125');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('266''40\"', '20', '1/60');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('533''20\"', '20', '1/30');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('1066''40\"', '20', '1/15');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('2133''20\"', '20', '1/8');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('4266''40\"', '20', '1/4');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('533''20\"', '20', '1/2');\n");
            bbdd.execSQL("INSERT INTO \"main\".\"datos\" (\"dato\", \"columna\", \"fila\") VALUES ('17066'' 40\"', '20', '1''');");


        }






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



    public void obtenerListaUsuario(){

        final ConnectSqlite admin = new ConnectSqlite(this, ConnectSqlite.DATABASE_NAME, null, ConnectSqlite.DATABASE_VERSION);
        final SQLiteDatabase bbdd2 = admin.getReadableDatabase();
        //final Cursor consulta = bbdd2.rawQuery("SELECT * FROM nombresPartidas ", null);

        listaUsuario2 = new ArrayList<String>();
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



