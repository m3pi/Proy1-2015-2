package imerosa.t2examen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.PozoAdapter;
import models.Pozo;

public class ListPozosFavoritosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pozos_favoritos);
        setListContent();
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void setListContent(){
        //llamamos al metodo que trae la lista de solicitudes
        PozoAdapter adapter=new PozoAdapter(this, R.layout.simple_list_item_pozos,
                GetFavoritosFromDB());
        //adignamos a que listview vamoa a inflar los simple items
        ListView list=(ListView)findViewById(R.id.lv_Pozos);
        list.setAdapter(adapter);
    }

    private List<Pozo> GetFavoritosFromDB(){
        //una variable para almacenar todas la solicitudes que trae la consulta
        List<Pozo> pozos =new ArrayList<>();

        //conexion
        DatabaseSqLiteHelper helper=new DatabaseSqLiteHelper(this, "T2proy1", null, 1);
        SQLiteDatabase db=helper.getWritableDatabase();

        //declaramos un cursor para declarar  la consulta sql
        Cursor consulta=db.rawQuery("SELECT * FROM Pozos WHERE Favorito='si';", null);

        while (consulta.moveToNext()){
            Pozo poso =new Pozo();

            poso.Nombre=consulta.getString(1);
            poso.Operador=consulta.getString(2);
            poso.Favorito=consulta.getString(3);

            pozos.add(poso);
        }

        return pozos;
    }


}
