package com.example.paymentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.paymentapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnView.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_viewBalanceFragment)}
        binding.btnSend.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_sendmoneyFragment)}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}