package com.tis.lumera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FormularioActivity extends AppCompatActivity {

    private BDLampada banco;
    private Lampada[] resultados = new Lampada[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        banco = new BDLampada(this);

        populaSpinner(R.id.spinnerLampada1, R.id.spinnerPotenciaLampada1,R.id.textoLumensLampada1, 0);
        populaSpinner(R.id.spinnerLampada2, R.id.spinnerPotenciaLampada2,R.id.textoLumensLampada2, 1);

        Button botao = (Button) findViewById(R.id.botaoCalcular);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double horas = extraiConteudoDoCampo((EditText)findViewById(R.id.textoHoras));
                double dias = extraiConteudoDoCampo((EditText)findViewById(R.id.textoDias));
                double valorKwH = extraiConteudoDoCampo((EditText)findViewById(R.id.textoValorKwH));
                Lampada potenciaDaLampada1 = resultados[0];
                Lampada potenciaDaLampada2 = resultados[1];
                if(potenciaDaLampada1 != null && potenciaDaLampada2 != null) {
                    double consumo1 = Calculadora.consumo(horas,dias,potenciaDaLampada1.getPotencia());
                    double consumo2 = Calculadora.consumo(horas,dias,potenciaDaLampada2.getPotencia());
                    double valor1 = Calculadora.valorConsumo(consumo1,valorKwH);
                    double valor2 = Calculadora.valorConsumo(consumo2,valorKwH);
                    double reducao = Calculadora.reducao(valor1,valor2);
                    Log.i("blah",reducao+"");

                }


            }
        });


    }

    private double extraiConteudoDoCampo (EditText campo){
        return Double.parseDouble(campo.getText().toString());
    }

    private void populaSpinner(int idSpinnerLampada, final int idSpinnerPotenciaLampada, final int idTextLumenLampada, final int i) {
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
                            resultados[i] = potenciaDaLampada;
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
