package tads.eaj.ufrn.bookdependencyinjection.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Livro (val nome:String){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}