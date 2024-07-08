package br.edu.iserj.jogodavelha1203

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.iserj.jogodavelha1203.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val tabuleiro = arrayOf(
        arrayOf("A", "B", "C"),
        arrayOf("D", "E", "F"),
        arrayOf("G", "H", "I")
    )

    //Qual jogador está jogando
    var jogadorAtual = "X"

    // Método onCreate que é chamado quando a Activity é criada
    // Entrada: savedInstanceState - o estado salvo da Activity
    // Saída: Nenhuma
    override fun onCreate(savedInstanceState: Bundle?) {
        // Infla o layout usando o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root) // Define o layout da Activity como a raiz do binding
    }

    // Função que será chamada quando um botão for clicado
    // Entrada: view - a view que foi clicada
    // Saída: Nenhuma
    fun buttonClick(view: View) {
        // Converte a view recebida para um botão
        val buttonSelecionado = view as Button
        // Define o texto do botão clicado como "X"
        buttonSelecionado.text = jogadorAtual


        // Atualiza o tabuleiro com "X" na posição correspondente ao botão clicado
        when (buttonSelecionado.id) {
            binding.buttonUm.id -> tabuleiro[0][0] = jogadorAtual
            binding.buttonDois.id -> tabuleiro[0][1] = jogadorAtual
            binding.buttonTres.id -> tabuleiro[0][2] = jogadorAtual
            binding.buttonQuatro.id -> tabuleiro[1][0] = jogadorAtual
            binding.buttonCinco.id -> tabuleiro[1][1] = jogadorAtual
            binding.buttonSeis.id -> tabuleiro[1][2] = jogadorAtual
            binding.buttonSete.id -> tabuleiro[2][0] = jogadorAtual
            binding.buttonOito.id -> tabuleiro[2][1] = jogadorAtual
            binding.buttonNove.id -> tabuleiro[2][2] = jogadorAtual
        }

        //Recebe o jogador vencedor através da função verificaTabuleiro. @param tabuleito
        var vencedor = verificaVencedor(tabuleiro)
        if (!vencedor.isNullOrBlank()) {
            Toast.makeText(this, "vencedor: " + vencedor, Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonSelecionado.setBackgroundResource(R.drawable.twiligthsparkle)

        var rx = Random.nextInt(0, 3)
        var ry = Random.nextInt(0, 3)
var i = 0
        while (i < 9) {
            rx = Random.nextInt(0, 3)
            ry = Random.nextInt(0, 3)
            if  (tabuleiro[rx][ry] != "X" && tabuleiro[rx][ry] != "O") {
                break
            }
            i++
        }
        tabuleiro[rx][ry] = "O"

        val posicao = rx*3 + ry

        when(posicao){
            1 -> {
                binding.buttonUm.setBackgroundResource(R.drawable.pinkiepie)
                binding.buttonUm.isEnabled = false
            }
            2 -> {
                binding.buttonDois.setBackgroundResource(R.drawable.pinkiepie)
                binding.buttonDois.isEnabled = false
            }
            3 -> {
                binding.buttonTres.setBackgroundResource(R.drawable.pinkiepie)
                binding.buttonTres.isEnabled = false
            }
            4 -> {
                binding.buttonQuatro.setBackgroundResource(R.drawable.pinkiepie)
                binding.buttonQuatro.isEnabled = false
            }
            5 -> {
                binding.buttonCinco.setBackgroundResource(R.drawable.pinkiepie)
                binding.buttonCinco.isEnabled = false
            }
            6 -> {
                binding.buttonSeis.setBackgroundResource(R.drawable.pinkiepie)
                binding.buttonSeis.isEnabled = false
            }
            7 -> {
                binding.buttonSete.setBackgroundResource(R.drawable.pinkiepie)
                binding.buttonSete.isEnabled = false
            }
            8 -> {
                binding.buttonOito.setBackgroundResource(R.drawable.pinkiepie)
                binding.buttonOito.isEnabled = false
            }
            9 -> {
                binding.buttonNove.setBackgroundResource(R.drawable.pinkiepie)
                binding.buttonNove.isEnabled = false
            }
        }

    }

}
    fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {
        // Verifica linhas e colunas
        for (i in 0 until 3) {
            //Verifica se há três itens iguais na linha
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return tabuleiro[i][0]
            }
            //Verifica se há três itens iguais na coluna
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return tabuleiro[0][i]
            }
        }
        // Verifica diagonais
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return tabuleiro[0][0]
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return tabuleiro[0][2]
        }

        //Verifica a quantidade de jogadores
        var empate = 0
        for (linha in tabuleiro) {
            for (valor in linha) {
                if (valor.equals("X") || valor.equals("0")) {

                }
            }
        }
        //Se existem 9 jogadas e não há três letras iguais, houve um empate
        if (empate == 9) {
            return "empate"
        }
        // Nenhum vencedor
        return null
    }