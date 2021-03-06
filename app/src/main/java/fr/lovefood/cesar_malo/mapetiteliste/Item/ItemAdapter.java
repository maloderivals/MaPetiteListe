package fr.lovefood.cesar_malo.mapetiteliste.Item;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import fr.lovefood.cesar_malo.mapetiteliste.R;

public class ItemAdapter extends ArrayAdapter<Item> {
    ArrayList<Item> items;
    Context context;
    int ressource;

    public ItemAdapter(Context context, int resource, ArrayList<Item> data) {
        super(context, resource, data);
        this.items = data;
        this.context = context;
        this.ressource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View v = inflater.inflate(ressource, parent, false);

        Item item = items.get(position);
        
        TextView item_tv = (TextView) v.findViewById(R.id.Item_text);
        item_tv.setText(item.getDescription());

        TextView quantity_tv = (TextView) v.findViewById(R.id.Item_quantity);
        quantity_tv.setText(String.valueOf(item.getQuantity()));


        Spinner unit_tv = (Spinner) v.findViewById(R.id.Quantity_unit);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(context,
                R.array.allUnits, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        unit_tv.setAdapter(adapterSpinner);
        unit_tv.setSelection(item.getUnit());


        CheckBox checkedItem = (CheckBox) v.findViewById(R.id.Selected_item);
        checkedItem.setChecked(item.isChecked());

        return v;

    }
}
