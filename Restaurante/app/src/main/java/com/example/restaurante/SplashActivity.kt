package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
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
        //Basicamente define o layout visual da atividade como sendo o layout XML associado, que foi inflado usando o Data Binding. Isso permite que
        // você acesse as visualizações dentro do layout XML diretamente por meio da instância binding, em vez de usar findViewById().
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            //cria uma nova variável chamada i e atribui a ela o objeto Intent que foi usado para iniciar a atividade atual.
            val i = intent
            //cria um novo objeto Intent que representa a intenção de iniciar a PedidoActivity.
            val j = Intent(this,PedidoActivity::class.java)
//você poderá acessar os extras usando intent.getStringExtra("chave1") e intent.getStringExtra("chave2") dentro da PedidoActivity.
            j.putExtras(i)
            // configurado para iniciar a atividade PedidoActivity, você pode iniciar essa atividade chamando startActivity(j).
            startActivity(j)
        },2000)

    }
}