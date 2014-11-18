package com.example.rui.aementadigital;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.NumberPicker;
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

                //o ideal era fazer isto de outra maneira... ms não estou a ver como -.-
                String key = listDataHeader.get(groupPosition);
                final String dishNamePrice = listDataChild.get(key).get(childPosition);
                final Dialog dialog = new Dialog(getActivity());
                final List<String> dish = new ArrayList<String>();
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishNamePrice.equals(dishes.get(i).getNamePrice())) {
                        dish.add(dishes.get(i).getName());
                        dish.add(String.valueOf(dishes.get(i).getPrice()));
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
                EditText comment = (EditText) dialog.findViewById(R.id.editText);
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
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getActivity().getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

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
        dishes = new ArrayList<DishesHelper>();
        dishes.add(new DishesHelper(1, "Alheira à Mirandela", "Alheira à Mirandela                                                                                      6.99€", 6.99));
        dishes.add(new DishesHelper(1, "Bitoque de Vaca", "Bitoque de Vaca                                                                                            8.99€", 8.99));
        dishes.add(new DishesHelper(1, "Bitoque de Frango", "Bitoque de Frango                                                                                        5.99€", 5.99));
        dishes.add(new DishesHelper(1, "Posta mirandesa", "Posta mirandesa                                                                                          8.99€", 8.99));
        dishes.add(new DishesHelper(1, "Picanha grelhada", "Picanha grelhada                                                                                         7.99€", 7.99));
        dishes.add(new DishesHelper(2, "Bacalhau à Brás", "Bacalhau à Brás                                                                                           6.99€", 6.99));
        dishes.add(new DishesHelper(2, "Bacalhau à Zé do Pipo", "Bacalhau à Zé do Pipo                                                                                6.99€", 6.99));
        dishes.add(new DishesHelper(2, "Bacalhau com Broa", "Bacalhau com Broa                                                                                     9.99€", 9.99));
        dishes.add(new DishesHelper(2, "Robalo Grelhado", "Robalo Grelhado                                                                                        11.99€", 11.99));
        dishes.add(new DishesHelper(2, "Salmão Grelhado com Puré", "Salmão Grelhado com Puré                                                                      8.99€", 8.99));
        dishes.add(new DishesHelper(4, "Esparguete à Bolonhesa", "Esparguete à Bolonhesa                                                                            6.99€", 6.99));
        dishes.add(new DishesHelper(4, "Lasanha Bolonhesa", "Lasanha Bolonhesa                                                                                    7.99€", 7.99));
        dishes.add(new DishesHelper(4, "Ravioli recheado com chouriço", "Ravioli recheado com chouriço                                                               7.99€", 7.99));

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

        for (int i = 0; i < dishes.size(); i++) {
            if (dishes.get(i).getType() == 1) {
                carnes.add(dishes.get(i).getNamePrice());
            }
            if (dishes.get(i).getType() == 2) {
                peixes.add(dishes.get(i).getNamePrice());
            }
            if (dishes.get(i).getType() == 3) {

            }
            if (dishes.get(i).getType() == 4) {
                massas.add(dishes.get(i).getNamePrice());
            }
        }


        listDataChild.put(listDataHeader.get(0), carnes);
        listDataChild.put(listDataHeader.get(1), peixes);
        listDataChild.put(listDataHeader.get(2), massas);
    }


}
