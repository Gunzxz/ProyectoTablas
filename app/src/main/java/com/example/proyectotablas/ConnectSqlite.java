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


        db.execSQL("CREATE TABLE IF NOT EXISTS datos (fila VARCHAR (10), columna VARCHAR (10), dato VARCHAR (10))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {




    }





}
 