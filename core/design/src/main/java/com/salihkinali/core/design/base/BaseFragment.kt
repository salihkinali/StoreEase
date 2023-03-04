package com.salihkinali.core.design.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflate: (layoutInflater: LayoutInflater) -> VB
) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflate.invoke(inflater)

        if (_binding == null) {
            throw IllegalArgumentException("Binding null")
        }
        return binding.root
    }
}