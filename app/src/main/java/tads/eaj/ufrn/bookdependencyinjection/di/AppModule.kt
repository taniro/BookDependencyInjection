package tads.eaj.ufrn.bookdependencyinjection.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tads.eaj.ufrn.bookdependencyinjection.database.AppDatabase
import tads.eaj.ufrn.bookdependencyinjection.database.dao.LivroDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getDatabase(app:Application):AppDatabase{
        return AppDatabase.invoke(app)
    }

    @Singleton
    @Provides
    fun getDao(database: AppDatabase):LivroDao{
        return database.livroDao()
    }
}