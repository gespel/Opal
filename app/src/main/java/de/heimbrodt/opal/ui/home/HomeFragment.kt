package de.heimbrodt.opal.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import de.heimbrodt.opal.MainActivity
import de.heimbrodt.opal.R
import de.heimbrodt.opal.SportType
import de.heimbrodt.opal.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        binding.btnJogging.setOnClickListener{
            MainActivity.user.addCaloriesBurnt(binding.editTime.text.toString().toInt(), SportType.Jogging)
        }
        binding.btnBike.setOnClickListener {
            MainActivity.user.addCaloriesBurnt(binding.editTime.text.toString().toInt(), SportType.Biking)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}