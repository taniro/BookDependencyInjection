package tads.eaj.ufrn.bookdependencyinjection.ui.mainfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tads.eaj.ufrn.bookdependencyinjection.model.Livro
import tads.eaj.ufrn.bookdependencyinjection.repository.LivroRepository
import javax.inject.Inject


@HiltViewModel
class MainFragmentViewModel @Inject constructor(val repository: LivroRepository): ViewModel() {


    val livros:LiveData<List<Livro>> = repository.getAll().asLiveData()

    fun create(livro: Livro){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.create(livro)
            }
        }
    }
}