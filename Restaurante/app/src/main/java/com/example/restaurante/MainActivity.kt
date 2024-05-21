package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//Criação da variável binding que servirá para manipular a tela. Quando declaramos uma variável com lateinit, estamos indicando que ela será
    // inicializada posteriormente, mas antes de ser acessada.
    private lateinit var binding:ActivityMainBinding

    //O método onCreate é parte do ciclo de vida de uma atividade Android. Ele é chamado quando a atividade está sendo criada (ou recriada) e é o
    // lugar ideal para realizar tarefas de configuração, como inflar o layout da tela, inicializar variáveis e configurar componentes.
    //O parâmetro savedInstanceState é um objeto Bundle que contém informações sobre o estado anterior da atividade (por exemplo, se ela foi
    // recriada após uma rotação de tela).
    //Você pode usar o savedInstanceState para restaurar o estado da atividade, se necessário.
    override fun onCreate(savedInstanceState: Bundle?) {
        //a linha binding = ActivityLoginBinding.inflate(layoutInflater) basicamente infla o layout XML activity_login.xml e cria uma instância de
        // ActivityLoginBinding, que pode ser usada para acessar as visualizações dentro desse layout XML.
        binding = ActivityMainBinding.inflate(layoutInflater)

        //Inicialize componentes, configure listeners, etc.
        super.onCreate(savedInstanceState)
        //Basicamente define o layout visual da atividade como sendo o layout XML associado, que foi inflado usando o Data Binding. Isso permite que
        // você acesse as visualizações dentro do layout XML diretamente por meio da instância binding, em vez de usar findViewById().
        setContentView(binding.root)

//extrai o texto atual do EditText editUsername no layout associado, converte-o para uma string e remove espaços em branco desnecessários,
// atribuindo o resultado à variável username.
        val username = intent.extras?.getString("username")

        //verifica se a variável username não é nula e nem vazia.
        if(!username.isNullOrEmpty()){

            //define o texto da TextView textOla no layout associado como "Olá" seguido pelo conteúdo da variável username.
            binding.textOla.setText("Olá $username")
        }
//define um listener de clique para o botão buttonFechar no layout associado.
        binding.buttonFechar.setOnClickListener {
            //todas as atividades anteriores à atividade atual na pilha de atividades serão encerradas, o que significa que o aplicativo será
            // finalizado e retornará à tela inicial ou à última atividade não finalizada.
            finishAffinity()
        }
//define um listener de clique para o botão buttonPedir no layout associado.
        binding.buttonPedir.setOnClickListener {

            //cria um novo objeto Intent que representa a intenção de iniciar a SplashActivity.
            val i = Intent(this, SplashActivity::class.java)
            //adiciona o valor contido no EditText editQuantidadePizza como um extra no objeto Intent i, identificado pelo nome "quantidadePizza".
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            //adiciona o valor contido no EditText editQuantidadeSalada como um extra no objeto Intent i, identificado pelo nome "quantidadeSalada".
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            //adiciona o valor contido no EditText editQuantidadeHamburguer como um extra no objeto Intent i, identificado pelo nome "quantidadehamburguer".
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            //não encerra o aplicativo por completo, apenas remove a atividade atual da pilha de atividades e retorna à atividade anterior, se
            // houver, ou à tela inicial do dispositivo, se não houver mais atividades na pilha.
            startActivity(i)
            //else pode ser usado sozinho após um if, ou pode ser seguido por outro if, criando assim uma cadeia de condições alternativas.
            // Isso permite que você controle o fluxo do programa com base em diferentes situações.
            finish()
        }


        //define um listener de clique para o CheckBox checkPizza no layout associado.
        binding.checkPizza.setOnClickListener {
//verifica se o CheckBox checkPizza está marcado como selecionado. Se o CheckBox estiver selecionado, o bloco de código dentro do if será executado.
            // Caso contrário, se o CheckBox não estiver selecionado, o bloco de código dentro do if será ignorado e a execução continuará com a
            // próxima instrução após o if.
            if(binding.checkPizza.isChecked()){
                // define o texto do EditText editQuantidadePizza no layout associado como "1".
                binding.editQuantidadePizza.setText("1")
                //define a visibilidade da view textPrecoPizza como visível.
                binding.textPrecoPizza.visibility = View.VISIBLE
                //else pode ser usado sozinho após um if, ou pode ser seguido por outro if, criando assim uma cadeia de condições alternativas.
                // Isso permite que você controle o fluxo do programa com base em diferentes situações.
            }else{
                // define o texto do EditText editQuantidadePizza no layout associado como "1".
                binding.editQuantidadePizza.setText("0")
                //define a visibilidade da view textPrecoPizza como visível.
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        //define um listener de clique para o CheckBox checkSalada no layout associado.
        binding.checkSalada.setOnClickListener {
            //verifica se o CheckBox checkSalada está marcado como selecionado. Se o CheckBox estiver selecionado, o bloco de código dentro do if
            // será executado.
            // Caso contrário, se o CheckBox não estiver selecionado, o bloco de código dentro do if será ignorado e a execução continuará com a
            // próxima instrução após o if.
            if(binding.checkSalada.isChecked()){
                // define o texto do EditText editQuantidadeSalada no layout associado como "1".
                binding.editQuantidadeSalada.setText("1")
                //define a visibilidade da view textPrecoSalada como visível.
                binding.textPrecoSalada.visibility = View.VISIBLE
                //else pode ser usado sozinho após um if, ou pode ser seguido por outro if, criando assim uma cadeia de condições alternativas.
                // Isso permite que você controle o fluxo do programa com base em diferentes situações.
            }else{
                // define o texto do EditText editQuantidadeSalada no layout associado como "1".
                binding.editQuantidadeSalada.setText("0")
                //define a visibilidade da view textPrecoSalada como visível.
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        //define um listener de clique para o CheckBox checkHamburguer no layout associado.
        binding.checkHamburger.setOnClickListener {
            //verifica se o CheckBox checkHamburguer está marcado como selecionado. Se o CheckBox estiver selecionado, o bloco de código dentro do if será
            // executado.
// Caso contrário, se o CheckBox não estiver selecionado, o bloco de código dentro do if será ignorado e a execução continuará com a próxima
            // instrução após o if.
            if(binding.checkHamburger.isChecked()){
                // define o texto do EditText editQuantidadeHamburguer no layout associado como "1".
                binding.editQuantidadeHamburguer.setText("1")
                //define a visibilidade da view textPrecohamburguer como visível.
                binding.textPrecoHamburguer.visibility = View.VISIBLE
                //else pode ser usado sozinho após um if, ou pode ser seguido por outro if, criando assim uma cadeia de condições alternativas.
                // Isso permite que você controle o fluxo do programa com base em diferentes situações.
            }else{
                // define o texto do EditText editQuantidadeHamburguer no layout associado como "1".
                binding.editQuantidadeHamburguer.setText("0")
                //define a visibilidade da view textPrecoHamburguer como visível.
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}