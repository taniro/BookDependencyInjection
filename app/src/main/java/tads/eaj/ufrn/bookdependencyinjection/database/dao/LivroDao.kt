package tads.eaj.ufrn.bookdependencyinjection.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.bookdependencyinjection.model.Livro

@Dao
interface LivroDao {

    @Query("select * from Livro")
    fun getAll(): Flow<List<Livro>>

    @Insert
    fun create(livro: Livro)
}