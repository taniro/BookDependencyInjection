package tads.eaj.ufrn.bookdependencyinjection.repository

import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.bookdependencyinjection.database.dao.LivroDao
import tads.eaj.ufrn.bookdependencyinjection.model.Livro
import javax.inject.Inject

class LivroRepository @Inject constructor(val dao: LivroDao) {

    fun getAll():Flow<List<Livro>>{
        return dao.getAll()
    }

    fun create(livro: Livro){
        dao.create(livro)
    }
}