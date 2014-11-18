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
        getActivity().getActionBar().setIcon(R.drawable.wine);

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
                final String dishNamePrice = listDataChild.get(key).get(childPosition);
                final Dialog dialog = new Dialog(getActivity());

                final List<String> dish = new ArrayList<String>();
                for (int i = 0; i < drinks.size(); i++) {
                    if (dishNamePrice.equals(drinks.get(i).getNamePrice())) {
                        dish.add(drinks.get(i).getName());
                        dish.add(String.valueOf(drinks.get(i).getPrice()));
                        break;
                    }
                }

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
                text.setText(dish.get(0));
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
                        ((ContaHelper) getActivity().getApplication()).addPedido(new Pedido(dish.get(0), Double.parseDouble(dish.get(1)), ((ContaHelper) getActivity().getApplication()).quantidade), 1);
                        Toast.makeText(getActivity().getApplicationContext(),
                                "O seu pedido foi enviado para a cozinha!",
                                Toast.LENGTH_LONG).show();
                        dialog.hide();
                    }
                });

                lista.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        ((ContaHelper) getActivity().getApplication()).addPedido(new Pedido(dish.get(0), Double.parseDouble(dish.get(1)), ((ContaHelper) getActivity().getApplication()).quantidade), 0);
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
//                Toast.makeText(getActivity().getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getActivity().getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        drinks = new ArrayList<DrinksHelper>();

        drinks.add(new DrinksHelper(1, "Alentejano", "Alentejano                                                                                                     8.99€", 8.99));
        drinks.add(new DrinksHelper(1, "Porto", "Porto                                                                                                               6.99€", 6.99));
        drinks.add(new DrinksHelper(1, "Quinta da Bacalhoa", "Quinta da Bacalhoa                                                                                    5.99€", 5.99));

        drinks.add(new DrinksHelper(2, "Sagres", "Sagres                                                                                                            1.99€", 1.99));
        drinks.add(new DrinksHelper(2, "Super Bock", "Super Bock                                                                                                    1.99€", 1.99));
        drinks.add(new DrinksHelper(2, "Feldschlößchen (importada)", "Feldschlößchen (importada)                                                                    3.99€", 3.99));
        drinks.add(new DrinksHelper(2, "Radeberger (importada)", "Radeberger (importada)                                                                            3.99€", 3.99));

        drinks.add(new DrinksHelper(3, "Coca-Cola", "Coca-Cola                                                                                                      1.99€", 1.99));
        drinks.add(new DrinksHelper(3, "Fanta", "Fanta                                                                                                              1.99€", 1.99));
        drinks.add(new DrinksHelper(3, "Ice-Tea", "Ice-Tea                                                                                                           1.99€", 1.99));
        drinks.add(new DrinksHelper(3, "Sumol", "Sumol                                                                                                             1.99€", 1.99));
        drinks.add(new DrinksHelper(3, "B!", "B!                                                                                                                     1.00€", 1.99));

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

        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getType() == 1) {
                vinhos.add(drinks.get(i).getNamePrice());
            }
            if (drinks.get(i).getType() == 2) {
                cervejas.add(drinks.get(i).getNamePrice());
            }
            if (drinks.get(i).getType() == 3) {
                refrigerantes.add(drinks.get(i).getNamePrice());
            }
        }


        listDataChild.put(listDataHeader.get(0), vinhos);
        listDataChild.put(listDataHeader.get(1), cervejas);
        listDataChild.put(listDataHeader.get(2), refrigerantes);
    }
}
