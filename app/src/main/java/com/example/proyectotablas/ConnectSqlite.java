package com.example.proyectotablas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectSqlite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DatosTabla.db";
    public static final int DATABASE_VERSION = 1;


    public ConnectSqlite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {




    }


    public Cursor ConsultarUsuPas (String usu, String pass){

        Cursor mCursor  = this.getReadableDatabase().query("usuarios", new String[] {"usuario", "pass"},"usuario LIKE '" + usu +"' AND pass LIKE '" + pass +"'", null,null,null,null);

        return mCursor;
    }

    public Cursor ConsultarPartida (String partida){


        Cursor mCursor = this.getReadableDatabase().query("nombresPartidas", new String[] {"nombre"}, "nombre LIKE '" + partida + "'",null,null,null,null);

        return mCursor;
    }



}
