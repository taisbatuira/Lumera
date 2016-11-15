package com.tis.lumera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        final BDLampada banco = new BDLampada(this);

        final String[] lampadas = {"- Tipo de Lâmpada -","Incandescente","LED","Fluorescente","Tubo Fluorescente","Iodeto Metálico"};
        Spinner spinnerLampada1 = (Spinner) findViewById(R.id.spinnerLampada1);
        ArrayAdapter<String> adapterSpinner1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lampadas);
        spinnerLampada1.setAdapter(adapterSpinner1);
        spinnerLampada1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0){
                    String tipoDaLampadaSelecionada = (String) parent.getItemAtPosition(position);
                    List<Lampada> listaLampadas = banco.listaLampada(tipoDaLampadaSelecionada);
                    Spinner spinnerPotenciaLampada1 = (Spinner) findViewById(R.id.spinnerPotenciaLampada1);
                    ArrayAdapter<Lampada> adapterSpinnerPotencia1 = new ArrayAdapter<Lampada>(FormularioActivity.this,android.R.layout.simple_list_item_1,listaLampadas);
                    spinnerPotenciaLampada1.setAdapter(adapterSpinnerPotencia1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
