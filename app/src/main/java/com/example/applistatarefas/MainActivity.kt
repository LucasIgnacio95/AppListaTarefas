package com.example.applistatarefas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applistatarefas.adapter.TarefaAdapter
import com.example.applistatarefas.database.TarefaDAO
import com.example.applistatarefas.databinding.ActivityMainBinding
import com.example.applistatarefas.model.Tarefa

class MainActivity : AppCompatActivity() {

       private val binding by lazy {
           ActivityMainBinding.inflate(layoutInflater)
       }
    private var listaTarefas = emptyList<Tarefa>()
    private var tarefaAdapter: TarefaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.fabAdiconar.setOnClickListener{
            val intent = Intent(this, AdicionarTarefaActivity::class.java)
            startActivity( intent )
        }

        //Recyclerview
        tarefaAdapter = TarefaAdapter(
            { id -> confirmarExclusao(id) },
            { tarefa -> editar(tarefa) }
        )
        tarefaAdapter?.adicionarLista( listaTarefas )
        binding.rvTarefas.adapter = tarefaAdapter

        binding.rvTarefas.layoutManager = LinearLayoutManager(this)


    }

    private fun editar(tarefa: Tarefa) {

        val intent = Intent(this, AdicionarTarefaActivity::class.java)
        intent.putExtra("tarefa", tarefa)
        startActivity( intent )

    }

    private fun confirmarExclusao(id: Int) {

        val alertBuilder = AlertDialog.Builder(this)

        alertBuilder.setTitle("Confirmar exclusao")
        alertBuilder.setMessage("Deseja realmente excluir a tarefa?")

        alertBuilder.setPositiveButton("Sim"){_, _ ->

            val tarefaDAO = TarefaDAO(this)
            if ( tarefaDAO.remover( id ) ) {
                atualizarListaTarefas()
                Toast.makeText(
                    this,
                    "Sucesso ao remover a terefa", Toast.LENGTH_SHORT
                    ).show()
            }else{
                Toast.makeText(
                    this,
                    "Erro ao remover a terefa", Toast.LENGTH_SHORT
                ).show()
            }
        }

        alertBuilder.setNegativeButton("Não"){_, _ -> }

        alertBuilder.create().show()




    }

    private fun atualizarListaTarefas(){

        val tarefaDAO = TarefaDAO(this)
        listaTarefas = tarefaDAO.listar()
        tarefaAdapter?.adicionarLista( listaTarefas )

    }

    override fun onStart() {
        super.onStart()
        atualizarListaTarefas()
    }



}