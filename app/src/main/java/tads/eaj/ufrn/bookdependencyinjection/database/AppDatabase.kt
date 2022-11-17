package tads.eaj.ufrn.bookdependencyinjection.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tads.eaj.ufrn.bookdependencyinjection.database.dao.LivroDao
import tads.eaj.ufrn.bookdependencyinjection.model.Livro


@Database(entities = [Livro::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun livroDao():LivroDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "database.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}