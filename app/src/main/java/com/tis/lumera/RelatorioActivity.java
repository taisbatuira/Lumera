package com.tis.lumera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RelatorioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        Relatorio relatorio = (Relatorio) getIntent().getSerializableExtra("DADOS_RELATORIO");

        populaString(R.id.relatorioTextoLampada1, relatorio.nomeLampada1);
        populaInt(R.id.relatorioTextoPotenciaLampada1, relatorio.potenciaLampada1);
        populaInt(R.id.relatorioTextoLumensLampada1, relatorio.lumensLampada1);
        populaInt(R.id.relatorioTextoQtdLampada1, relatorio.qtdLampadas1);

        populaString(R.id.relatorioTextoLampada2, relatorio.nomeLampada2);
        populaInt(R.id.relatorioTextoPotenciaLampada2, relatorio.potenciaLampada2);
        populaInt(R.id.relatorioTextoLumensLampada2, relatorio.lumensLampada2);
        populaDouble(R.id.relatorioTextoPrecoLampada2, relatorio.precoLampada2);

        populaInt(R.id.relatorioTextoLuxAmbiente, relatorio.luxAmbiente);
        populaInt(R.id.relatorioTextoTamanhoAmbiente, relatorio.tamanhoAmbiente);
        populaDouble(R.id.relatorioTextoValorKwH, relatorio.valorKwH);
        populaInt(R.id.relatorioTextoHoras, relatorio.horasLigada);
        populaInt(R.id.relatorioTextoDias, relatorio.diasLigada);

        populaString(R.id.relatorioTextoReducao, relatorio.reducao + "%");
        String textoDoCampo = "Quantidade de Lampadas "+relatorio.nomeLampada2+": "+relatorio.qtdLampadas2;
        populaString(R.id.relatorioTextoQtdLampada2, textoDoCampo);
        populaDouble(R.id.relatorioTextoCustoInstalacao, relatorio.valorInstalacaoLampadas2);
    }

    private void populaString(int idDoCampo, String texto) {
        TextView campo = (TextView) findViewById(idDoCampo);
        campo.setText(texto);
    }

    private void populaInt(int idDoCampo, int valorInt) {
        TextView campo = (TextView) findViewById(idDoCampo);
        campo.setText(String.valueOf(valorInt));
    }

    private void populaDouble(int idDoCampo, double valorDouble) {
        TextView campo = (TextView) findViewById(idDoCampo);
        campo.setText(String.valueOf(valorDouble));
    }
}
