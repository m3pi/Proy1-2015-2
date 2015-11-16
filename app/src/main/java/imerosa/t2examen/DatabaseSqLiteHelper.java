package imerosa.t2examen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mompi3p on 13/11/2015.
 */
public class DatabaseSqLiteHelper extends SQLiteOpenHelper {
    public DatabaseSqLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //crear la tabla
        db.execSQL("CREATE TABLE Pozos(id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Operador TEXT, Favorito TEXT);");
        //db.execSQL("insert into Pozos (Nombre, Operador, Favorito) values('Pozo1','operador1', 'si'; 'Pozo1','operador1', 'no';)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
