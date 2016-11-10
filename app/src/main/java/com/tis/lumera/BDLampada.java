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
        insere(valoresIniciais, "Incandescente",20,65);
        insere(valoresIniciais, "Incandescente",35,225);
        insere(valoresIniciais, "Incandescente",40,330);
        insere(valoresIniciais, "Incandescente",50,470);
        insere(valoresIniciais, "Incandescente",60,575);
        insere(valoresIniciais, "Incandescente",70,715);
        insere(valoresIniciais, "Incandescente",80,880);
        insere(valoresIniciais, "Incandescente",100,1000);
        insere(valoresIniciais, "Incandescente",110,1078);
        insere(valoresIniciais, "Incandescente",120,1200);
        insere(valoresIniciais, "Incandescente",140,1400);
        insere(valoresIniciais, "Incandescente",150,1550);
        insere(valoresIniciais, "Incandescente",200,1825);
        insere(valoresIniciais, "Incandescente",250,1900);
        insere(valoresIniciais, "Incandescente",300,2075);
        insere(valoresIniciais, "Incandescente",350,3470);
        insere(valoresIniciais, "Incandescente",400,5550);
        insere(valoresIniciais, "Incandescente",500,7300);
        insere(valoresIniciais, "Incandescente",550,8500);
        insere(valoresIniciais, "Incandescente",700,10750);
        insere(valoresIniciais, "LED",2,65);
        insere(valoresIniciais, "LED",3,225);
        insere(valoresIniciais, "LED",5,330);
        insere(valoresIniciais, "LED",6,470);
        insere(valoresIniciais, "LED",7,575);
        insere(valoresIniciais, "LED",9,715);
        insere(valoresIniciais, "LED",10,880);
        insere(valoresIniciais, "LED",12,1000);
        insere(valoresIniciais, "LED",13,1078);
        insere(valoresIniciais, "LED",15,1200);
        insere(valoresIniciais, "LED",18,1400);
        insere(valoresIniciais, "LED",20,1550);
        insere(valoresIniciais, "LED",25,1825);
        insere(valoresIniciais, "LED",30,1900);
        insere(valoresIniciais, "LED",35,2075);
        insere(valoresIniciais, "LED",50,3470);
        insere(valoresIniciais, "LED",80,5550);
        insere(valoresIniciais, "LED",100,7300);
        insere(valoresIniciais, "LED",120,8500);
        insere(valoresIniciais, "LED",150,10750);
        insere(valoresIniciais, "Fluorescente",6,65);
        insere(valoresIniciais, "Fluorescente",8,225);
        insere(valoresIniciais, "Fluorescente",11,330);
        insere(valoresIniciais, "Fluorescente",13,470);
        insere(valoresIniciais, "Fluorescente",15,575);
        insere(valoresIniciais, "Fluorescente",18,715);
        insere(valoresIniciais, "Fluorescente",20,880);
        insere(valoresIniciais, "Fluorescente",25,1000);
        insere(valoresIniciais, "Fluorescente",30,1078);
        insere(valoresIniciais, "Fluorescente",40,1200);
        insere(valoresIniciais, "Fluorescente",50,1400);
        insere(valoresIniciais, "Fluorescente",60,1550);
        insere(valoresIniciais, "Fluorescente",70,1825);
        insere(valoresIniciais, "Fluorescente",80,1900);
        insere(valoresIniciais, "Fluorescente",90,2075);
        insere(valoresIniciais, "Fluorescente",100,3470);
        insere(valoresIniciais, "Fluorescente",150,5550);
        insere(valoresIniciais, "Fluorescente",200,7300);
        insere(valoresIniciais, "Fluorescente",250,8500);
        insere(valoresIniciais, "Fluorescente",300,10750);
        insere(valoresIniciais, "Tubo Fluorescente",12,470);
        insere(valoresIniciais, "Tubo Fluorescente",14,575);
        insere(valoresIniciais, "Tubo Fluorescente",18,715);
        insere(valoresIniciais, "Tubo Fluorescente",20,880);
        insere(valoresIniciais, "Tubo Fluorescente",25,1000);
        insere(valoresIniciais, "Tubo Fluorescente",28,1078);
        insere(valoresIniciais, "Tubo Fluorescente",32,1200);
        insere(valoresIniciais, "Tubo Fluorescente",36,1400);
        insere(valoresIniciais, "Tubo Fluorescente",44,1550);
        insere(valoresIniciais, "Tubo Fluorescente",58,1825);
        insere(valoresIniciais, "Tubo Fluorescente",70,1900);
        insere(valoresIniciais, "Fluorescente",50,880); // halogenuro
        insere(valoresIniciais, "Fluorescente",60,1000);
        insere(valoresIniciais, "Fluorescente",70,1078);
        insere(valoresIniciais, "Fluorescente",75,1200);
        insere(valoresIniciais, "Fluorescente",90,1400);
        insere(valoresIniciais, "Fluorescente",120,1550);
        insere(valoresIniciais, "Fluorescente",150,1825);
        insere(valoresIniciais, "Fluorescente",170,1900);
        insere(valoresIniciais, "Fluorescente",180,2075);
        insere(valoresIniciais, "Fluorescente",200,3470);
        insere(valoresIniciais, "Fluorescente",250,5550);
        insere(valoresIniciais, "Fluorescente",300,7300);
        insere(valoresIniciais, "Fluorescente",350,8500);
        insere(valoresIniciais, "Fluorescente",500,10750);

        db.insert("lampada",null,valoresIniciais);

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
