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
public class Sobremesas extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    List<DessertsHelper> desserts;

    private List<DessertsHelper> list = new ArrayList<DessertsHelper>();
    static ListView listview = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.desserts, container, false);
        getActivity().getActionBar().setIcon(R.drawable.icecream);

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.listdesserts);

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
                for (int i = 0; i < desserts.size(); i++) {
                    if (dishNamePrice.equals(desserts.get(i).getNamePrice())) {
                        dish.add(desserts.get(i).getName());
                        dish.add(String.valueOf(desserts.get(i).getPrice()));
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
        desserts = new ArrayList<DessertsHelper>();
        desserts.add(new DessertsHelper(1, "Bolo de Cenoura", "Bolo de Cenoura                                                                                           1.50€", 1.50));
        desserts.add(new DessertsHelper(1, "Bolo da Avó", "Bolo da Avó                                                                                                    1.50€", 1.50));
        desserts.add(new DessertsHelper(1, "Bolo de Chocolate", "Bolo de Chocolate                                                                                        1.50€", 1.50));
        desserts.add(new DessertsHelper(1, "Bolo de Iogurte", "Bolo de Iogurte                                                                                             1.50€", 1.50));

        desserts.add(new DessertsHelper(2, "Café normal", "Café normal                                                                                                   0.50€", 0.50));
        desserts.add(new DessertsHelper(2, "Café descafeinado", "Café descafeinado                                                                                       0.50€", 0.50));
        desserts.add(new DessertsHelper(2, "Capuccino", "Capuccino                                                                                                      1.00€", 1.00));

        desserts.add(new DessertsHelper(3, "Baba de Camelo", "Baba de Camelo                                                                                           1.99€", 1.99));
        desserts.add(new DessertsHelper(3, "Mousse de chocolate", "Mousse de chocolate                                                                                  1.99€", 1.99));
        desserts.add(new DessertsHelper(3, "Pudim Flan", "Pudim Flan                                                                                                     1.99€", 1.99));

        desserts.add(new DessertsHelper(4, "Banana", "Banana                                                                                                            1.00€", 1.00));
        desserts.add(new DessertsHelper(4, "Melão", "Melão                                                                                                               1.00€", 1.00));
        desserts.add(new DessertsHelper(4, "Meloa", "Meloa                                                                                                               1.00€", 1.00));
        desserts.add(new DessertsHelper(4, "Melancia", "Melancia                                                                                                          1.00€", 1.00));
        desserts.add(new DessertsHelper(4, "Laranja", "Laranja                                                                                                             1.00€", 1.00));

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Bolos");
        listDataHeader.add("Café");
        listDataHeader.add("Doces");
        listDataHeader.add("Fruta da Época");

        // Adding child data
        List<String> bolos = new ArrayList<String>();
        List<String> cafes = new ArrayList<String>();
        List<String> doces = new ArrayList<String>();
        List<String> frutas = new ArrayList<String>();

        for (int i = 0; i < desserts.size(); i++) {
            if (desserts.get(i).getType() == 1) {
                bolos.add(desserts.get(i).getNamePrice());
            }
            if (desserts.get(i).getType() == 2) {
                cafes.add(desserts.get(i).getNamePrice());
            }
            if (desserts.get(i).getType() == 3) {
                doces.add(desserts.get(i).getNamePrice());
            }
            if (desserts.get(i).getType() == 4) {
                frutas.add(desserts.get(i).getNamePrice());
            }
        }


        listDataChild.put(listDataHeader.get(0), bolos);
        listDataChild.put(listDataHeader.get(1), cafes);
        listDataChild.put(listDataHeader.get(2), doces);
        listDataChild.put(listDataHeader.get(3), frutas);
    }
}
