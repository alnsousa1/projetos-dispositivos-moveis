package com.example.aula02_10_08_23;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button botaoCalcular;
    EditText edtEtanol, edtGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //aqui diz para o JAVA qual tela (XML) ela vai controlar
        setContentView(R.layout.activity_main);

        //vinculando os campos do XML com os objetos do JAVA
        edtEtanol = findViewById(R.id.edtEtanol);
        edtGasolina = findViewById(R.id.edtGasolina);
        botaoCalcular = findViewById(R.id.btnCalcular);

        //criando um listener para "ouvir" o clique do botao
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }

    private void calcular() {
        double valorEtanol = Double.parseDouble(edtEtanol.getText().toString());
        double valorGasolina = Double.parseDouble(edtGasolina.getText().toString());

        double resultado = valorEtanol / valorGasolina;

        if (resultado <= 0.7){
            mostrarMensagem("Melhor abastecer com Etanol!");
        }else {
            mostrarMensagem("Melhor abastecer com Gasolina!");
        }
    }

    private void mostrarMensagem(String texto){
        // Criando uma mensagem do tipo TOAST (Uma mensagem que aparece e some sozinha)
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();

        //Criando uma mensagem do tipo modal
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        //adicionando um título no alerta/dialog, tipo o do alert do JavaScript
        alerta.setTitle("Resultado");
        //adicionando uma mensagem no alerta/dialog
        alerta.setMessage(texto);

        //adicionando um botão de confirmação para fechar a mensagem
        alerta.setNeutralButton("Ok", null);

        //exibindo o alerta/dialog na tela
        alerta.show();
    }
}