package com.example.calculadora
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    private lateinit var txtResultado: TextView
    private var valorAtual = ""
    private var numero1 = 0.0
    private var operacao = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResultado = findViewById(R.id.txtResultado)
    }

    fun clicarNumero(view: View) {
        val button = view as Button
        valorAtual += button.text
        txtResultado.text = valorAtual

    }
    fun clicarOperacao(view: View) {
        val botao = view as Button
        operacao = botao.text.toString()
        if (valorAtual.isNotEmpty()) {
            numero1 = valorAtual.toDouble()
        }
        operacao = botao.text.toString()
        valorAtual = ""
    }
    fun calcular (view: View) {
        val numero2 = valorAtual.toDouble()
        var resultado = 0.0

        when (operacao) {
            "+" -> resultado = numero1 + numero2
            "-" -> resultado = numero1 - numero2
            "×" -> resultado = numero1 * numero2
            "÷" -> resultado = numero1 / numero2
        }
        txtResultado.text = resultado.toString()
        valorAtual = resultado.toString()
    }
    fun limpar (view: View) {
        if (valorAtual.isNotEmpty()){
            valorAtual = valorAtual.dropLast(1)
            txtResultado.text = if (valorAtual.isEmpty())
    "0"    else valorAtual
        }
    fun limparTudo (view: View) {
        valorAtual = ""
        numero1 = 0.0
        operacao = ""}
    }

}