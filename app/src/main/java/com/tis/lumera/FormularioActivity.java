package com.tis.lumera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FormularioActivity extends AppCompatActivity {

    private BDLampada banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        banco = new BDLampada(this);

        populaSpinner(R.id.spinnerLampada1, R.id.spinnerPotenciaLampada1,R.id.textoLumensLampada1);
        populaSpinner(R.id.spinnerLampada2, R.id.spinnerPotenciaLampada2,R.id.textoLumensLampada2);


    }

    private void populaSpinner(int idSpinnerLampada, final int idSpinnerPotenciaLampada, final int idTextLumenLampada) {
        final String[] lampadas = {"- Tipo de Lâmpada -", "Incandescente", "LED", "Fluorescente", "Tubo Fluorescente", "Iodeto Metálico"};
        Spinner spinnerLampada = (Spinner) findViewById(idSpinnerLampada);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lampadas);
        spinnerLampada.setAdapter(adapterSpinner);
        spinnerLampada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    String tipoDaLampadaSelecionada = (String) parent.getItemAtPosition(position);
                    List<Lampada> listaLampadas = banco.listaLampada(tipoDaLampadaSelecionada);
                    Spinner spinnerPotenciaLampada = (Spinner) findViewById(idSpinnerPotenciaLampada);
                    ArrayAdapter<Lampada> adapterSpinnerPotencia = new ArrayAdapter<Lampada>(FormularioActivity.this, android.R.layout.simple_list_item_1, listaLampadas);
                    spinnerPotenciaLampada.setAdapter(adapterSpinnerPotencia);
                    spinnerPotenciaLampada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Lampada potenciaDaLampada = (Lampada) parent.getItemAtPosition(position);
                            TextView lumensLampada = (TextView) findViewById(idTextLumenLampada);
                            lumensLampada.setText(String.valueOf(potenciaDaLampada.getLumens()));
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
