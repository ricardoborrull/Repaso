package com.example.ricardo.repaso.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ricardo.repaso.Modelo.Producto;
import com.example.ricardo.repaso.R;
import static com.example.ricardo.repaso.MainActivity.productos;

public class AnadirProducto extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText etProdName,etProdPrice,etProdDesc;
    Button btnSaveProd,btnCleanFields;
    String getNombre, getPrecio;
    Boolean checkFields;
    Producto producto;

    private OnFragmentInteractionListener mListener;

    public AnadirProducto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnadirProducto.
     */
    // TODO: Rename and change types and number of parameters
    public static AnadirProducto newInstance(String param1, String param2) {
        AnadirProducto fragment = new AnadirProducto();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_anadir_producto, container, false);

        etProdName = v.findViewById(R.id.etProdName);
        etProdPrice = v.findViewById(R.id.etProdPrice);
        etProdDesc = v.findViewById(R.id.etProdDesc);
        btnSaveProd = v.findViewById(R.id.btnSaveProd);
        btnCleanFields = v.findViewById(R.id.btnCleanFields);

        btnSaveProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkProdFields()){
                    producto = new Producto(getNombre,getPrecio);
                    productos.add(producto);
                    Toast.makeText(getContext(),"Producto Guardado",Toast.LENGTH_SHORT).show();
                    etProdName.setText("");
                    etProdPrice.setText("");
                    etProdDesc.setText("");
                }
            }
        });

        btnCleanFields.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etProdName.setText("");
                etProdPrice.setText("");
                etProdDesc.setText("");
            }
        });

        return v;
    }

    public boolean checkProdFields(){
        getNombre = etProdName.getText().toString();
        getPrecio = etProdPrice.getText().toString();
        if (TextUtils.isEmpty(getNombre)){
            etProdName.setError("El producto debe tener un nombre");
            checkFields = false;
        }else if(TextUtils.isEmpty(getPrecio)){
            etProdPrice.setError("El producto debe tener un precio");
            checkFields = false;
        }else {
            checkFields = true;
        }
        return checkFields;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
