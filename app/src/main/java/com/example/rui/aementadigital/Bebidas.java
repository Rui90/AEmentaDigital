package com.example.rui.aementadigital;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rui on 21/10/2014.
 *
 *
 */
public class Bebidas extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    List<DrinksHelper> drinks;

    private List<DrinksHelper> list = new ArrayList<DrinksHelper>();
    static ListView listview = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.drinks, container, false);

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.listwine);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                //o ideal era fazer isto de outra maneira... ms não estou a ver como -.-
                String key = listDataHeader.get(groupPosition);
                final String dish = listDataChild.get(key).get(childPosition);
                final Dialog dialog = new Dialog(getActivity());

                dialog.setContentView(R.layout.popup);
                dialog.show();

                NumberPicker np = (NumberPicker) dialog.findViewById(R.id.numberPicker);
                np.setMinValue(1);
                np.setMaxValue(10);
                np.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
                Button cuisine = (Button) dialog.findViewById(R.id.cuisine);
                Button cancelBtn = (Button) dialog.findViewById(R.id.cancelar);
                Button lista = (Button) dialog.findViewById(R.id.pedidos);
                TextView text = (TextView) dialog.findViewById(R.id.pedido);
                text.setText(dish);
                ((ContaHelper) getActivity().getApplication()).quantidade = np.getValue();
                np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                        ((ContaHelper) getActivity().getApplication()).quantidade = picker.getValue();
                    }
                });
                // final int quantidade = np.getValue();
                cuisine.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        double price = 0;
                        for (int i = 0; i < drinks.size(); i++) {
                            if (dish.equals(drinks.get(i).getName())) {
                                price = drinks.get(i).getPrice();
                                break;
                            }
                        }
                        ((ContaHelper) getActivity().getApplication()).addPedido(new Pedido(dish, price, ((ContaHelper) getActivity().getApplication()).quantidade), 1);
                        Toast.makeText(getActivity().getApplicationContext(),
                                "O seu pedido foi enviado para a cozinha!",
                                Toast.LENGTH_LONG).show();
                        dialog.hide();
                    }
                });

                lista.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        double price = 0;
                        for (int i = 0; i < drinks.size(); i++) {
                            if (dish.equals(drinks.get(i).getName())) {
                                price = drinks.get(i).getPrice();
                                break;
                            }
                        }
                        ((ContaHelper) getActivity().getApplication()).addPedido(new Pedido(dish, price, ((ContaHelper) getActivity().getApplication()).quantidade), 0);
                        Toast.makeText(getActivity().getApplicationContext(),
                                "O seu pedido foi enviado para a lista!",
                                Toast.LENGTH_LONG).show();
                        dialog.hide();
                    }
                });
                cancelBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.hide();
                    }
                });
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

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
        drinks = new ArrayList<DrinksHelper>();

        drinks.add(new DrinksHelper(1, "Alentejano", 8.99));
        drinks.add(new DrinksHelper(1, "Porto", 6.99));
        drinks.add(new DrinksHelper(1, "Quinta da Bacalhoa", 5.99));
        drinks.add(new DrinksHelper(2, "Sagres", 1.99));
        drinks.add(new DrinksHelper(2, "Super Bock", 1.99));
        drinks.add(new DrinksHelper(2, "Feldschlößchen (importada)", 3.99));
        drinks.add(new DrinksHelper(2, "Radeberger (importada)", 3.99));
        drinks.add(new DrinksHelper(3, "Coca-Cola", 1.99));
        drinks.add(new DrinksHelper(3, "Fanta", 1.99));
        drinks.add(new DrinksHelper(3, "Ice-Tea", 1.99));
        drinks.add(new DrinksHelper(3, "Sumol", 1.99));
        drinks.add(new DrinksHelper(3, "B!", 1.99));

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Vinhos");
        listDataHeader.add("Cervejas");
        listDataHeader.add("Refrigerantes");

        // Adding child data
        List<String> vinhos = new ArrayList<String>();
        List<String> cervejas = new ArrayList<String>();
        List<String> refrigerantes = new ArrayList<String>();

        for(int i = 0; i < drinks.size(); i++) {
            if(drinks.get(i).getType() == 1) {
                vinhos.add(drinks.get(i).getName());
            }
            if(drinks.get(i).getType() == 2) {
                cervejas.add(drinks.get(i).getName());
            }
            if(drinks.get(i).getType() == 3) {
                refrigerantes.add(drinks.get(i).getName());
            }
        }


        listDataChild.put(listDataHeader.get(0), vinhos);
        listDataChild.put(listDataHeader.get(1), cervejas);
        listDataChild.put(listDataHeader.get(2), refrigerantes);
    }
}
