package com.example.paymentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.paymentapp.databinding.FragmentSendmoneyBinding


class SendmoneyFragment : Fragment() {
    private var _binding: FragmentSendmoneyBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSendmoneyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNxt.setOnClickListener {
            val person= binding.editPerson.text.toString()
            if (person.length > 3) {
                val dir = SendmoneyFragmentDirections.actionSendmoneyFragmentToMoneyAmtFragment(person)
                findNavController().navigate(dir)
            } else{
                binding.editPerson.error="Person name is invalid"
                binding.editPerson.requestFocus()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}