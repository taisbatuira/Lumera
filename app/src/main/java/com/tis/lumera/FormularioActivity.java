package com.tis.lumera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FormularioActivity extends AppCompatActivity {

    private BDLampada banco;
    private Lampada[] resultados = new Lampada[2];
    private int luxEquivalente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        banco = new BDLampada(this);

        populaSpinner(R.id.spinnerLampada1, R.id.spinnerPotenciaLampada1,R.id.textoLumensLampada1, 0);
        populaSpinner(R.id.spinnerLampada2, R.id.spinnerPotenciaLampada2,R.id.textoLumensLampada2, 1);

        Spinner spinnerAmbiente = (Spinner) findViewById(R.id.spinnerLuxAmbiente);
        final Ambientes ambientes = new Ambientes();
        ArrayAdapter<Ambiente> adapterSpinner = new ArrayAdapter<Ambiente>(this, android.R.layout.simple_list_item_1, ambientes.getListaDeAmbientes());
        spinnerAmbiente.setAdapter(adapterSpinner);
        spinnerAmbiente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 luxEquivalente = ambientes.getLuxAmbiente(position);
                //falta mostrar no relatorio como total de lux indicado
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button botao = (Button) findViewById(R.id.botaoCalcular);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horas = extraiConteudoDoCampoInt(R.id.textoHoras);
                int dias = extraiConteudoDoCampoInt(R.id.textoDias);
                double valorKwH = extraiConteudoDoCampoDouble(R.id.textoValorKwH);
                int tamanhoAmbiente = extraiConteudoDoCampoInt(R.id.textoTamanhoAmbiente);
                double precoInstalacao = extraiConteudoDoCampoDouble(R.id.textoPreco);
                int qtdLampada1 = extraiConteudoDoCampoInt(R.id.textoQtdLampada1);

                Lampada potenciaDaLampada1 = resultados[0];
                Lampada potenciaDaLampada2 = resultados[1];
                if(potenciaDaLampada1 != null && potenciaDaLampada2 != null) {
                    double consumo1 = Calculadora.consumo(horas,dias,potenciaDaLampada1.getPotencia());
                    double consumo2 = Calculadora.consumo(horas,dias,potenciaDaLampada2.getPotencia());
                    double valor1 = Calculadora.valorConsumo(consumo1,valorKwH);
                    double valor2 = Calculadora.valorConsumo(consumo2,valorKwH);
                    int reducao = Calculadora.reducao(valor1,valor2);

                    double lumensAmbiente = tamanhoAmbiente * luxEquivalente;
                    int qtdLampada2 = Calculadora.qtdDeLampadas(lumensAmbiente, potenciaDaLampada2.getLumens());
                    double valorInstalacao = precoInstalacao * qtdLampada2;

                    //interface fluente - monta o relatorio usando metodos alinhados
                    Relatorio relatorio = Relatorio.novo()
                            .comLampada1(potenciaDaLampada1.getNomeDaLampada(), potenciaDaLampada1.getPotencia(), potenciaDaLampada1.getLumens(), qtdLampada1)
                            .comLampada2(potenciaDaLampada2.getNomeDaLampada(), potenciaDaLampada2.getPotencia(), potenciaDaLampada2.getLumens(), precoInstalacao)
                            .comDadosGerais(luxEquivalente, tamanhoAmbiente, valorKwH, horas, dias)
                            .comCalculos(reducao, qtdLampada2, valorInstalacao);

                    Intent irParaRelatorio = new Intent(FormularioActivity.this, RelatorioActivity.class);
                    irParaRelatorio.putExtra("DADOS_RELATORIO", relatorio);
                    startActivity(irParaRelatorio);
                }
            }
        });


    }

    private double extraiConteudoDoCampoDouble(int idDoCampo){
        EditText campo = (EditText) findViewById(idDoCampo);
        return Double.parseDouble(campo.getText().toString());
    }

    public int extraiConteudoDoCampoInt(int idDoCampo) {
        EditText campo = (EditText) findViewById(idDoCampo);
        return Integer.parseInt(campo.getText().toString());
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
