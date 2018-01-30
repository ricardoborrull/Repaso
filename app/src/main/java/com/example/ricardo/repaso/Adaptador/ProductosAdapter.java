package com.example.ricardo.repaso.Adaptador;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ricardo.repaso.Modelo.Producto;
import com.example.ricardo.repaso.R;

import java.util.ArrayList;

/**
 * Created by Ricardo on 30/01/2018.
 */

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder>{

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
    CardView cardview;
    TextView nombre;
    TextView precio;

    ProductoViewHolder(View itemView) {
        super(itemView);

        cardview = itemView.findViewById(R.id.cardview);
        nombre = itemView.findViewById(R.id.nombre);
        precio = itemView.findViewById(R.id.precio);
    }
}

    ArrayList<Producto> productos;

    public ProductosAdapter(ArrayList<Producto> productos){
        this.productos = productos;
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ProductoViewHolder pvh = new ProductoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final ProductoViewHolder productViewHolder, final int i) {
        productViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder alertBox = new AlertDialog.Builder(v.getRootView().getContext());
                alertBox.setMessage("¿Estás seguro de que quieres eliminar este producto?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Snackbar.make(v,"Producto: "+productos.get(i).getNombre()+" eliminado",Snackbar.LENGTH_LONG).show();
                                productos.remove(i);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                alertBox.show();
            }
        });
        productViewHolder.nombre.setText(productos.get(i).getNombre());
        productViewHolder.precio.setText(productos.get(i).getPrecio()+"€");
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
