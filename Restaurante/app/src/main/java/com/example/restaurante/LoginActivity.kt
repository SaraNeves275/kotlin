package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
//Criação da variável binding que servirá para manipular a tela.
    //Quando declaramos uma variável com lateinit, estamos indicando
    // que ela será inicializada posteriormente, mas antes de ser acessada.
    private lateinit var binding:ActivityLoginBinding

    //O método onCreate é parte do ciclo de vida de uma atividade Android.
    //Ele é chamado quando a atividade está sendo criada (ou recriada) e é o lugar ideal para
    // realizar tarefas de configuração, como inflar o layout da tela, inicializar variáveis e
    // configurar componentes.
    //O parâmetro savedInstanceState é um objeto Bundle que contém informações sobre o estado
    // anterior da atividade (por exemplo, se ela foi recriada após uma rotação de tela).
    //Você pode usar o savedInstanceState para restaurar o estado da atividade, se necessário.
    override fun onCreate(savedInstanceState: Bundle?) {
        //Inicialize componentes, configure listeners, etc.
        super.onCreate(savedInstanceState)

        //a linha binding = ActivityLoginBinding.inflate(layoutInflater) basicamente infla o
        // layout XML activity_login.xml e cria uma instância de ActivityLoginBinding, que
        // pode ser usada para acessar as visualizações dentro desse layout XML.
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //Basicamente define o layout visual da atividade como sendo o layout XML associado, que foi inflado usando o Data Binding. Isso permite que
        // você acesse as visualizações dentro do layout XML diretamente por meio da instância binding, em vez de usar findViewById().
        setContentView(binding.root)

        //configura um listener de clique para o botão "Entrar" (ou qualquer outro botão com o ID buttonEntrar no layout XML associado).
        binding.buttonEntrar.setOnClickListener {

            //extrai o texto atual do EditText editUsername no layout associado, converte-o para uma string e remove espaços em branco
            // desnecessários, atribuindo o resultado à variável username.
            val username = binding.editUsername.text.toString().trim()

            //extrai o texto atual do EditText editPassword no layout associado, converte-o para uma string e remove espaços em branco
            // desnecessários, atribuindo o resultado à variável Password.
            val password = binding.editPassword.text.toString().trim()

            //verifica se o nome de usuário é "abc" e se a senha é "123". Se ambas as condições forem verdadeiras, o bloco de código dentro do if
            // será executado. Caso contrário, o bloco de código será ignorado e a execução continuará com a próxima instrução após o if. Essa
            // estrutura é comumente usada para realizar a autenticação do usuário, verificando se o nome de usuário e a senha correspondem a
            // valores esperados.
            if (username.equals("abc") && password.equals("123")) {

                // Intent que representa a intenção de iniciar a atividade MainActivity.
                val i = Intent(this, MainActivity::class.java)
                //adiciona o valor contido na variável username como um extra no objeto Intent, identificado pelo nome "username".
                i.putExtra("username", username)
                //é o comando que efetivamente inicia uma nova atividade no Android, com base no Intent fornecido.
                startActivity(i)
                //não encerra o aplicativo por completo, apenas remove a atividade atual da pilha de atividades e retorna à atividade anterior, se
                // houver, ou à tela inicial do dispositivo, se não houver mais atividades na pilha.
                finish()
                //else pode ser usado sozinho após um if, ou pode ser seguido por outro if, criando assim uma cadeia de condições alternativas.
            // Isso permite que você controle o fluxo do programa com base em diferentes situações.
            } else {
                //cria e exibe um Toast com o texto "Errou" e uma duração longa na tela do dispositivo.
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}