package com.infnet.tp1_deskotlinandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.infnet.tp1_deskotlinandroid.R
import com.infnet.tp1_deskotlinandroid.databinding.FragmentEstilosBinding
import com.infnet.tp1_deskotlinandroid.models.Estilo
import com.infnet.tp1_deskotlinandroid.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class EstilosFragment : Fragment() {
    private var _binding: FragmentEstilosBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val viewModel by activityViewModels<MainViewModel>()

//    val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEstilosBinding.inflate(inflater, container, false)
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
            val texto = viewModel.getAllEstilosString()
            binding.tvAllEstilos.text = texto
        }
    }

    private fun onUpdateClick() {
        val idInput = binding.inputIdEstiloUpdate.text.toString().toLong()
        val nomeInput  = binding.inputNomeEstiloUpdate.text.toString()
        val paisIdInput = binding.inputIdPaisUpdate.text.toString().toLong()
        val estilo = Estilo(id = idInput, nome = nomeInput, paisId = paisIdInput)
        viewModel.updateEstilo(estilo)
    }

    private fun onRemoveByIdClick() {
        val idInput = binding.inputIdEstilo.text.toString().toLong()
        viewModel.deleteEstiloById(idInput)
    }

    private fun onGetByIdClick() {
        val idInput = binding.inputIdEstilo.text.toString().toLong()
        lifecycleScope.launch {
            val estilo = viewModel.getEstiloById(idInput)
            binding.tvEstilo.text = estilo.nome
        }
    }

    fun onSaveClick() {
        val nomeInput = binding.inputNomeEstilo.text.toString()
        val paisIdInput = binding.inputIdPais.text.toString().toLong()
        viewModel.insertEstilo(Estilo(nome = nomeInput, paisId = paisIdInput))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}