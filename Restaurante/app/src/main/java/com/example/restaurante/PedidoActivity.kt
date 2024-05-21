package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    //Criação da variável binding que servirá para manipular a tela.
    //Quando declaramos uma variável com lateinit, estamos indicando
    // que ela será inicializada posteriormente, mas antes de ser acessada.
    private lateinit var binding: ActivityPedidoBinding
    //O método onCreate é parte do ciclo de vida de uma atividade Android.
    //Ele é chamado quando a atividade está sendo criada (ou recriada) e é o lugar ideal para
    // realizar tarefas de configuração, como inflar o layout da tela, inicializar variáveis e
    // configurar componentes.
    //O parâmetro savedInstanceState é um objeto Bundle que contém informações sobre o estado
    // anterior da atividade (por exemplo, se ela foi recriada após uma rotação de tela).
    //Você pode usar o savedInstanceState para restaurar o estado da atividade, se necessário.
    override fun onCreate(savedInstanceState: Bundle?) {
        //a linha binding = ActivityLoginBinding.inflate(layoutInflater) basicamente infla o layout XML activity_login.xml e cria uma instância de
        // ActivityLoginBinding, que pode ser usada para acessar as visualizações dentro desse layout XML.
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        //Inicialize componentes, configure listeners, etc.
        super.onCreate(savedInstanceState)
        //Basicamente define o layout visual da atividade como sendo o layout XML associado, que foi inflado usando o Data Binding. Isso permite que
        // você acesse as visualizações dentro do layout XML diretamente por meio da instância binding, em vez de usar findViewById().
        setContentView(binding.root)

        //cria uma nova variável chamada i e atribui a ela o objeto Intent que foi usado para iniciar a atividade atual.
        val i = intent
        //obtém um valor inteiro do extra "quantidadePizza" no objeto Intent i.
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        //obtém um valor inteiro do extra "quantidadeSalada" no objeto Intent i.
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        //obtém um valor inteiro do extra "quantidadehamburguer" no objeto Intent i.
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

        //cria uma nova string que começa com "Resumo do Pedido" em uma linha e continua com o conteúdo que você adicionar após o operador +.
        val texto = "Resumo do Pedido\n" +
                //obtém um valor inteiro do extra "quantidadePizza" no objeto Intent i.
                "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                //obtém um valor inteiro do extra "quantidadeSalada" no objeto Intent i.
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
                //obtém um valor inteiro do extra "quantidadeHamburguer" no objeto Intent i.
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"

        //define o texto do TextView textResumo no layout associado como a string texto.
        binding.textResumo.text = texto

    }
}