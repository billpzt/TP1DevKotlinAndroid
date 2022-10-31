package com.infnet.tp1_deskotlinandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.infnet.tp1_deskotlinandroid.R
import com.infnet.tp1_deskotlinandroid.databinding.FragmentPaisesBinding
import com.infnet.tp1_deskotlinandroid.models.Pais
import com.infnet.tp1_deskotlinandroid.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class PaisesFragment : Fragment() {

    val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentPaisesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaisesBinding.inflate(inflater, container, false)
        val view = binding.root

        setup()
        return view
    }

    private fun setup() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
            btnSave.setOnClickListener {
                onSaveClick()
            }

            btnGetById.setOnClickListener {
                onGetByIdClick()
            }

            btnRemoveById.setOnClickListener {
                onRemoveByIdClick()
            }

            btnUpdate.setOnClickListener {
                onUpdateClick()
            }

            btnListAll.setOnClickListener {
                onListClick()
            }
        }
    }

    private fun onListClick(){
        lifecycleScope.launch {
            val texto = viewModel.getAllPaisesString()
            binding.tvAllPaises.text = texto
        }
    }

    private fun onUpdateClick() {
        val idInput = binding.inputIdPaisUpdate.text.toString().toLong()
        val nomeInput  = binding.inputNomePaisUpdate.text.toString()
        val pais = Pais(id = idInput, nome = nomeInput)
        viewModel.updatePais(pais)
    }

    private fun onRemoveByIdClick() {
        val idInput = binding.inputIdPais.text.toString().toLong()
        viewModel.deletePaisById(idInput)
    }

    private fun onGetByIdClick() {
        val idInput = binding.inputIdPais.text.toString().toLong()
        lifecycleScope.launch {
            val pais = viewModel.getPaisById(idInput)
            binding.tvPais.text = pais.nome
        }
    }

    fun onSaveClick() {
        val nomeInput = binding.inputNomePais.text.toString()
        viewModel.insertPais(Pais(nome = nomeInput))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}