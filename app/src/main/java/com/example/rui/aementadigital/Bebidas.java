package com.example.rui.aementadigital;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
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
        drinks.add(new DrinksHelper(3, "Coca-Cola", 1.99));
        drinks.add(new DrinksHelper(3, "Fanta", 1.99));
        drinks.add(new DrinksHelper(3, "Ice-Tea", 1.99));

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
