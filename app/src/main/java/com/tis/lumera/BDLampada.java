package com.tis.lumera;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tis on 07/11/2016.
 */
public class BDLampada extends SQLiteOpenHelper{

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabela = "create table lampada (TIPO text, POTENCIA real, LUMEN integer)";
        db.execSQL(tabela);
        ContentValues valoresIniciais = new ContentValues();
        insere(valoresIniciais, "Incandescente",20,65); //fazer os demais baseado no excel
        db.insert("lampada",null,valoresIniciais)
    }

    private void insere(ContentValues cv, String tipo, double potencia, int lumen) {
        cv.put("TIPO", tipo);
        cv.put("POTENCIA", potencia);
        cv.put("LUMEN", lumen);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
