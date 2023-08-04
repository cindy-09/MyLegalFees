package my.edu.tarc.mylegalfees.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import my.edu.tarc.mylegalfees.R
import my.edu.tarc.mylegalfees.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        //_binding = FragmentHomeBinding.inflate(inflater, container, false)

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val root: View = binding.root


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageViewCall.setOnClickListener {
            //tell:03-4233 5647
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tell:0342335647"))
            startActivity(intent)
        }
        binding.imageViewWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Bae_Suzy"))
            startActivity(intent)
        }
        binding.buttonCalculate.setOnClickListener{
            val sellingPrice = binding.editTextSellingPrice.text.toString().toFloat()
            val downPayment = binding.editTextDownPayment.text.toString().toFloat()
            val loan = sellingPrice - downPayment
            val firstTime = binding.checkBox.isChecked
            if(firstTime){
                //check if the loan = 90% of the selling price

            }else {
                //check if the loan > 90% of the selling price

            }

        }
        binding.buttonReset.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}