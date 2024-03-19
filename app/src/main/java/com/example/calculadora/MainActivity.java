package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private TextView tvOperacao;
    private StringBuilder numeroAtual;
    private char operadorAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);
        tvOperacao = findViewById(R.id.tvOperacao);
        numeroAtual = new StringBuilder();
        operadorAtual = ' ';
    }

    public void onCliqueNumero(View view) {
        String textoBotao = view.getTag().toString();
        numeroAtual.append(textoBotao);
        tvResultado.setText(numeroAtual.toString());
    }

    public void onCliqueOperador(View view) {
        operadorAtual = view.getTag().toString().charAt(0);
        String textoOperacao = getString(R.string.formato_operacao, numeroAtual.toString(), operadorAtual);
        tvOperacao.setText(textoOperacao);
        numeroAtual.setLength(0);
    }

    public void onCliqueIgual(View view) {
        double resultado = calcularResultado();
        String textoResultado = formatarResultado(resultado);
        tvResultado.setText(textoResultado);

        String textoOperacao = tvOperacao.getText().toString();
        if (!textoOperacao.isEmpty() && !textoResultado.isEmpty()) {
            String textoOperacaoCompleta = getString(R.string.formato_operacao_completa, textoOperacao, numeroAtual.toString(), textoResultado);
            tvOperacao.setText(textoOperacaoCompleta);
        }

        numeroAtual.setLength(0);
        operadorAtual = ' ';
    }

    public void onCliqueLimpar(View view) {
        numeroAtual.setLength(0);
        operadorAtual = ' ';
        tvResultado.setText("");
        tvOperacao.setText("");
    }

    private double calcularResultado() {
        double num1 = Double.parseDouble(tvOperacao.getText().toString().split(" ")[0]);
        double num2 = Double.parseDouble(numeroAtual.toString());
        switch (operadorAtual) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    private String formatarResultado(double resultado) {
        if (resultado == (int) resultado) {
            return String.valueOf((int) resultado);
        } else {
            return String.valueOf(resultado);
        }
    }
}
