package com.example.rui.aementadigital;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Created by Rui on 21/10/2014.
 */
public class Pratos extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    List<DishesHelper> dishes;

    private List<DishesHelper> list = new ArrayList<DishesHelper>();
    static ListView listview = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dishes, container, false);

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.listmeat);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {



                final Dialog dialog = new Dialog(getActivity());
                dialog.setTitle("Pedido");
                dialog.setContentView(R.layout.popup);
                dialog.show();
                Button cuisine = (Button) dialog.findViewById(R.id.cuisine);
                Button cancelBtn = (Button) dialog.findViewById(R.id.cancelar);
                Button lista = (Button) dialog.findViewById(R.id.pedidos);
                TextView text = (TextView) dialog.findViewById(R.id.pedido);
                text.setText("tens que fzer um set do pedido, ir a lista procurar");
                cancelBtn.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        dialog.hide();
                    }
                });
                Toast.makeText(
                        getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        dishes = new ArrayList<DishesHelper>();
        dishes.add(new DishesHelper(1, "Alheira à Mirandela", 6.99));
        dishes.add(new DishesHelper(1, "Bitoque de Vaca com arroz e batata", 8.99));
        dishes.add(new DishesHelper(1, "Bitoque de Frango com arroz e batata", 5.99));
        dishes.add(new DishesHelper(2, "Bacalhau com Broa", 9.99));
        dishes.add(new DishesHelper(2, "Robalo Grelhado com Batata Cozida", 11.99));
        dishes.add(new DishesHelper(2, "Salmão Grelhado com Puré", 8.99));
        dishes.add(new DishesHelper(4, "Esparguete à Bolonhesa", 6.99));
        dishes.add(new DishesHelper(4, "Lasanha Bolonhesa", 7.99));

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Carne");
        listDataHeader.add("Peixe");
        listDataHeader.add("Massas");

        // Adding child data
        List<String> carnes = new ArrayList<String>();
        List<String> peixes = new ArrayList<String>();
        List<String> massas = new ArrayList<String>();

        for(int i = 0; i < dishes.size(); i++) {
            if(dishes.get(i).getType() == 1) {
                carnes.add(dishes.get(i).getName());
            }
            if(dishes.get(i).getType() == 2) {
                peixes.add(dishes.get(i).getName());
            }
            if(dishes.get(i).getType() == 3) {

            }
            if(dishes.get(i).getType() == 4) {
                massas.add(dishes.get(i).getName());
            }
        }


        listDataChild.put(listDataHeader.get(0), carnes);
        listDataChild.put(listDataHeader.get(1), peixes);
        listDataChild.put(listDataHeader.get(2), massas);
    }


}
