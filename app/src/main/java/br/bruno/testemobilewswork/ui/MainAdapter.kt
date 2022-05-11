package br.bruno.mvvm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import br.bruno.testemobilewswork.data.Carros
import br.bruno.testemobilewswork.data.cadastro
import br.bruno.testemobilewswork.databinding.ResItemCarroBinding
import br.bruno.testemobilewswork.ui.DialogBoxFragment

class MainAdapter(private val fm: FragmentManager) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var carros = mutableListOf<Carros>()

    fun setCarrosList(carros: List<Carros>) {

        this.carros = carros.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResItemCarroBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val carros = carros[position]
        holder.bind(carros)
    }

    override fun getItemCount(): Int {
        return carros.size
    }

    inner class MainViewHolder(val binding: ResItemCarroBinding) : RecyclerView.ViewHolder(binding.root) {



        fun bind(carros: Carros) {
            binding.id.text = carros.id.toString()
            binding.marcaId.text = carros.marca_id.toString()
            binding.marcaNome.text = carros.marca_nome
            binding.nomeModelo.text = carros.nome_modelo
            binding.ano.text = carros.ano.toString()
            binding.combustivel.text = carros.combustivel.toString()
            binding.numPortas.text = carros.num_portas.toString()
            binding.valorFipe.text = carros.valor_fipe
            binding.cor.text = carros.cor
            binding.timestampCadastro.text = carros.timestamp_cadastro.toString()

            binding.btnEuQuero.setOnClickListener {
                val dialog = DialogBoxFragment()

                cadastro.carroId = carros.id
                cadastro.carroModelo = carros.nome_modelo


                dialog.show(fm, "customDialog")

                println(cadastro.toString())
            }
        }
    }
}



