package br.bruno.testemobilewswork.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import br.bruno.testemobilewswork.R
import br.bruno.testemobilewswork.databinding.FragmentDialogBinding


class DialogBoxFragment : DialogFragment(R.layout.fragment_dialog) {


    lateinit var binding: FragmentDialogBinding


    private lateinit var dbCadastro: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogBinding.inflate(layoutInflater)
        return (binding.root)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.dialogBtnSalvar.setOnClickListener {
            dbCadastro.getCadastro()
            println(binding.dialogBtnSalvar)
        }


    }
}
