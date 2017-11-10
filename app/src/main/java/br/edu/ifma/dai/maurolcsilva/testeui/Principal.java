package br.edu.ifma.dai.maurolcsilva.testeui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    //Definição dos componentes Java
    private Button btnCalcular;
    private EditText txtNome;
    private EditText txtPeso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Recuperação dos componentes XML para componentes Java
        btnCalcular = (Button) findViewById(R.id.btnCalcularAgua);
        //Registro do Botão para escutar a ação de Click
        btnCalcular.setOnClickListener(this);
        txtNome = (EditText) findViewById(R.id.txtNomePessoa);
        txtPeso = (EditText) findViewById(R.id.txtPesoPessoa);
    }

    @Override
    public void onClick(View view) {
        String nome;
        byte peso;

        //Recuperação dos valores colocados dentro das caixas de texto
        nome = txtNome.getText().toString();
        peso = Byte.parseByte(txtPeso.getText().toString());

        //Criação do Bundle
        Bundle parametro = new Bundle();
        parametro.putString("nome",nome);
        parametro.putByte("peso",peso);

        //Criação da Intent
        Intent itchamartela = new Intent(this,Resultado.class);
        //Associação do Bundle a Intent
        itchamartela.putExtras(parametro);
        //Dispara a Intent e faz a chamada para a outra Activity
        startActivity(itchamartela);
    }
}
