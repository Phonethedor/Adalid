package com.adalid.individual2.Modelo.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Consumo::class], version = 1)//no es necesario definir si exporto esquema
abstract class ConsumoDatabase: RoomDatabase() {

    abstract fun getConsumoDao(): ConsumoDao


    companion object {
        @Volatile
        private var INSTANCE: ConsumoDatabase? = null


        fun getDatabase(context: Context): ConsumoDatabase {
            val tempInntance = INSTANCE
            if (tempInntance != null) {

                return tempInntance
            }


            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ConsumoDatabase::class.java,
                    "ConsumoDB"
                )
                    .build()
                INSTANCE = instance
                return instance

            }
        }
    }

}

