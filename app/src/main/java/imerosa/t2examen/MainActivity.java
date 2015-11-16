package imerosa.t2examen;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void OpenPozos(View view){

        //conexion
//        DatabaseSqLiteHelper helper=new DatabaseSqLiteHelper(getApplicationContext(), "T2proy1", null, 1);
//        //tipo escritura
//        SQLiteDatabase database=helper.getWritableDatabase();
//
//        ContentValues values=new ContentValues();
//
//        values.put("Nombre", "Pozo3");
//        values.put("Operador","operador1");
//        values.put("Favorito","1");
////        values.put("Nombre","Pozo2");
////        values.put("Operador","operador2");
////        values.put("Favorito","no");
//
//        database.insert("Pozos", null, values);
//
//        Toast.makeText(getApplicationContext(), "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();
//
//        //cerramos
//        database.close();

        Intent intent=new Intent(this,ListAllPozosActivity.class);
        startActivity(intent);
    }
    public void OpenFavoritos(View view){
        Intent intent=new Intent(this,ListPozosFavoritosActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
