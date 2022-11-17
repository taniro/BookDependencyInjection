package tads.eaj.ufrn.bookdependencyinjection.ui.mainfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import tads.eaj.ufrn.bookdependencyinjection.R
import tads.eaj.ufrn.bookdependencyinjection.databinding.FragmentMainBinding
import tads.eaj.ufrn.bookdependencyinjection.model.Livro


@AndroidEntryPoint
class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var _viewModel: MainFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false )
        _viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

        binding.viewModel = _viewModel
        binding.lifecycleOwner = this

        _viewModel.create(Livro("Harry Potter"))
        _viewModel.create(Livro("Senhor dos Aneis"))
        _viewModel.create(Livro("Dom Casmurro"))

        _viewModel.livros.observe(viewLifecycleOwner){
            it?.forEach {
                Log.i("AULA", it.toString())
            }
        }

        return binding.root
    }
}