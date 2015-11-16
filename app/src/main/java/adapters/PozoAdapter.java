package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import imerosa.t2examen.R;
import models.Pozo;

/**
 * Created by mompi3p on 13/11/2015.
 */
public class PozoAdapter extends ArrayAdapter<Pozo> {

    private int resource;

    public PozoAdapter(Context context, int resource, List<Pozo> objects) {
        super(context, resource, objects);
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView==null)
            convertView=inflater.inflate(this.resource, parent, false);

        Pozo item=getItem(position);

        //igualamos alos txt del simple_item_list
        ((TextView)convertView.findViewById(R.id.tv_pozo)).setText(item.Nombre);
        ((TextView)convertView.findViewById(R.id.tv_operador)).setText(item.Operador);

        if (item.Favorito.equals(1)){
            ((ImageView)convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.rojo);
        }
        else{
            ((ImageView)convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.android);
        }


        //retornamos
        return convertView;
    }

}
