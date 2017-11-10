package br.edu.ifma.dai.maurolcsilva.testeui;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    //Definição dos componentes Java
    private TextView lblNome;
    private TextView lblPeso;
    private TextView lblQuantidade;
    private double quantidadedeagua;
    private final byte aguaml = 35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        //Recuperação dos componentes XML para componentes Java
        lblNome = (TextView) findViewById(R.id.lblNomePessoaRecebido);
        lblPeso = (TextView) findViewById(R.id.lblPesoPessoaRecebido);
        lblQuantidade = (TextView) findViewById(R.id.lblQuantidadedeAguaResultado);
        //Recuperação da Intent enviada pela Activity Principal
        Intent it = getIntent();
        //Pegamos o Bundle enviado junto com a Intent
        Bundle parametro = it.getExtras();
        //Recuperamos os parametros
        String nome = parametro.getString("nome");
        byte peso = parametro.getByte("peso");
        //Indicar os dados de nome e peso
        lblNome.setText(nome);
        lblPeso.setText(String.valueOf(peso));
        lblQuantidade.setText(retornaQuantidadeAgua(peso));
    }

    public String retornaQuantidadeAgua(byte peso){
        //Método que calcula a quantidade de água que devemos beber
        quantidadedeagua = (double)(peso * this.aguaml)/1000;

        String resultado = String.valueOf(quantidadedeagua);

        return resultado;
    }
}
