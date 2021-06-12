package com.example.phonepetest.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.phonepetest.R
import com.example.phonepetest.databinding.LayoutGameWindowBinding
import com.example.phonepetest.vm.GameWindowViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameWindowFragment : Fragment(R.layout.layout_game_window) {
    private var _binding: LayoutGameWindowBinding? = null

    private val viewModel: GameWindowViewModel by viewModel()

    val binding: LayoutGameWindowBinding
        get() = _binding ?: throw IllegalArgumentException()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = LayoutGameWindowBinding.bind(view)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        viewModel.requestLogos()

        observeLogoModel()
    }

    private fun observeLogoModel(){
        viewModel.logoListModelEventLd.observe(viewLifecycleOwner) { event->
            event?.getContentIfNotHandled()?.let {
                viewModel.getNextLogo(0)
            }
        }
    }
}