package br.bruno.testemobilewswork.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.bruno.testemobilewswork.Room.Comprador
import br.bruno.testemobilewswork.databinding.CompradorModelBinding

class CadastroAdapter(val cadastros : List<Comprador>): RecyclerView.Adapter<CadastroAdapter.ViewHolder>( ){

    class ViewHolder(val binding: CompradorModelBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CompradorModelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(cadastros[position]){
                binding.nomeCadastra.text = nome
                binding.carroCadastro.text = nome_modelo

            }
        }
    }

    override fun getItemCount(): Int =  cadastros.size

}