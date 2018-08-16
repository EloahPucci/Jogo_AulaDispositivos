package com.example.eloah.joguinho;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnKeyListener {

    private int numeroSorteado;
    private TextView msg;
    private EditText entrada;
    private int cont = 0;
    private TextView msgCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preparacaoInicial();
    }

    private void preparacaoInicial() {
        numeroSorteado = (int)(Math.random() * 101);
        msg = (TextView) findViewById(R.id.mensagem);
        msgCont = (TextView) findViewById(R.id.contTentativas);
        entrada = (EditText) findViewById(R.id.entrada);
        entrada.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
        if(keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_UP ){
            verificar();
            cont++;
            msgCont.setText(cont + " Tentativas");
            entrada.setText("");
            return  true;
        }

        return false;
    }

    private void verificar() {
        int numero = Integer.parseInt(entrada.getText().toString());

        if(numero == numeroSorteado){
            msg.setText(R.string.texto2);
        } else if(numero > numeroSorteado){
            msg.setText(R.string.texto3);
        } else{
            msg.setText(R.string.texto4);
        }
    }
}
