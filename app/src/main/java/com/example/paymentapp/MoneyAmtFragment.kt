package com.example.paymentapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.paymentapp.databinding.FragmentMoneyAmtBinding


class MoneyAmtFragment : Fragment() {
    private var _binding: FragmentMoneyAmtBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoneyAmtBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // read the bundle
        val args = MoneyAmtFragmentArgs.fromBundle(requireArguments())
        binding.textView15.text = args.name

        binding.btnCnf.setOnClickListener {
            // this will crash if amount is blank
            val amount = binding.editTextAmt.text.toString().toFloat()
            Log.d(tag, "dunno why its crashing, fix this shit!")
            val dir = MoneyAmtFragmentDirections.actionMoneyAmtFragmentToSuccessFragment(args.name, amount)
            findNavController().navigate(dir)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}