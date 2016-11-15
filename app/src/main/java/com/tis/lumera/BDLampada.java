package com.tis.lumera;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tis on 07/11/2016.
 */
public class BDLampada extends SQLiteOpenHelper{

    public BDLampada(Context context) {
        super(context, "Lumera", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabela = "create table lampada (TIPO text, POTENCIA integer, LUMEN integer)";
        db.execSQL(tabela);

        insere(db, "Incandescente",20,65);
        insere(db, "Incandescente",35,225);
        insere(db, "Incandescente",40,330);
        insere(db, "Incandescente",50,470);
        insere(db, "Incandescente",60,575);
        insere(db, "Incandescente",70,715);
        insere(db, "Incandescente",80,880);
        insere(db, "Incandescente",100,1000);
        insere(db, "Incandescente",110,1078);
        insere(db, "Incandescente",120,1200);
        insere(db, "Incandescente",140,1400);
        insere(db, "Incandescente",150,1550);
        insere(db, "Incandescente",200,1825);
        insere(db, "Incandescente",250,1900);
        insere(db, "Incandescente",300,2075);
        insere(db, "Incandescente",350,3470);
        insere(db, "Incandescente",400,5550);
        insere(db, "Incandescente",500,7300);
        insere(db, "Incandescente",550,8500);
        insere(db, "Incandescente",700,10750);
        insere(db, "LED",2,65);
        insere(db, "LED",3,225);
        insere(db, "LED",5,330);
        insere(db, "LED",6,470);
        insere(db, "LED",7,575);
        insere(db, "LED",9,715);
        insere(db, "LED",10,880);
        insere(db, "LED",12,1000);
        insere(db, "LED",13,1078);
        insere(db, "LED",15,1200);
        insere(db, "LED",18,1400);
        insere(db, "LED",20,1550);
        insere(db, "LED",25,1825);
        insere(db, "LED",30,1900);
        insere(db, "LED",35,2075);
        insere(db, "LED",50,3470);
        insere(db, "LED",80,5550);
        insere(db, "LED",100,7300);
        insere(db, "LED",120,8500);
        insere(db, "LED",150,10750);
        insere(db, "Fluorescente",6,65);
        insere(db, "Fluorescente",8,225);
        insere(db, "Fluorescente",11,330);
        insere(db, "Fluorescente",13,470);
        insere(db, "Fluorescente",15,575);
        insere(db, "Fluorescente",18,715);
        insere(db, "Fluorescente",20,880);
        insere(db, "Fluorescente",25,1000);
        insere(db, "Fluorescente",30,1078);
        insere(db, "Fluorescente",40,1200);
        insere(db, "Fluorescente",50,1400);
        insere(db, "Fluorescente",60,1550);
        insere(db, "Fluorescente",70,1825);
        insere(db, "Fluorescente",80,1900);
        insere(db, "Fluorescente",90,2075);
        insere(db, "Fluorescente",100,3470);
        insere(db, "Fluorescente",150,5550);
        insere(db, "Fluorescente",200,7300);
        insere(db, "Fluorescente",250,8500);
        insere(db, "Fluorescente",300,10750);
        insere(db, "Tubo Fluorescente",12,470);
        insere(db, "Tubo Fluorescente",14,575);
        insere(db, "Tubo Fluorescente",18,715);
        insere(db, "Tubo Fluorescente",20,880);
        insere(db, "Tubo Fluorescente",25,1000);
        insere(db, "Tubo Fluorescente",28,1078);
        insere(db, "Tubo Fluorescente",32,1200);
        insere(db, "Tubo Fluorescente",36,1400);
        insere(db, "Tubo Fluorescente",44,1550);
        insere(db, "Tubo Fluorescente",58,1825);
        insere(db, "Tubo Fluorescente",70,1900);
        insere(db, "Iodeto Metálico",50,880); // halogenuro
        insere(db, "Iodeto Metálico",60,1000);
        insere(db, "Iodeto Metálico",70,1078);
        insere(db, "Iodeto Metálico",75,1200);
        insere(db, "Iodeto Metálico",90,1400);
        insere(db, "Iodeto Metálico",120,1550);
        insere(db, "Iodeto Metálico",150,1825);
        insere(db, "Iodeto Metálico",170,1900);
        insere(db, "Iodeto Metálico",180,2075);
        insere(db, "Iodeto Metálico",200,3470);
        insere(db, "Iodeto Metálico",250,5550);
        insere(db, "Iodeto Metálico",300,7300);
        insere(db, "Iodeto Metálico",350,8500);
        insere(db, "Iodeto Metálico",500,10750);
    }

    private void insere(SQLiteDatabase db, String tipo, int potencia, int lumen) {
        ContentValues cv = new ContentValues();
        cv.put("TIPO", tipo);
        cv.put("POTENCIA", potencia);
        cv.put("LUMEN", lumen);
        db.insert("lampada",null,cv);
    }

    public List<Lampada> listaLampada(String nomeDaLampada){
        List<Lampada> lampadas = new ArrayList<Lampada>();
        String buscaListaLampada = "select POTENCIA, LUMEN from lampada where TIPO=?";
        Cursor cursor = getReadableDatabase().rawQuery(buscaListaLampada,new String[]{nomeDaLampada});
        while (cursor.moveToNext()){
            int potencia = cursor.getInt(cursor.getColumnIndex("POTENCIA"));
            int lumen = cursor.getInt(cursor.getColumnIndex("LUMEN"));
            Lampada lampada = new Lampada(nomeDaLampada,potencia,lumen);
            lampadas.add(lampada);
        }
        cursor.close();
        return lampadas;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
