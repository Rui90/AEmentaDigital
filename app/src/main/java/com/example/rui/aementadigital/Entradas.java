package com.example.rui.aementadigital;

import android.support.v4.app.Fragment;import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rui on 23-09-2014.
 */
public class Entradas extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    List<StartersHelper> starters;

    private List<StartersHelper> list = new ArrayList<StartersHelper>();
    static ListView listview = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.starters, container, false);

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.liststarters);

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
        starters = new ArrayList<StartersHelper>();
        starters.add(new StartersHelper(1, "Choutiço Assado", 2.99));
        starters.add(new StartersHelper(1, "Pão de Alho", 3.99));
        starters.add(new StartersHelper(1, "Presunto com Melão", 2.99));
        starters.add(new StartersHelper(2, "Abóbora", 3.99));
        starters.add(new StartersHelper(2, "Caldo Verde", 3.99));
        starters.add(new StartersHelper(2, "Canja", 3.99));

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Entradas");
        listDataHeader.add("Sopas");

        // Adding child data
        List<String> entradas = new ArrayList<String>();
        List<String> sopas = new ArrayList<String>();

        for(int i = 0; i < starters.size(); i++) {
            if(starters.get(i).getType() == 1) {
                entradas.add(starters.get(i).getName());
            }
            if(starters.get(i).getType() == 2) {
                sopas.add(starters.get(i).getName());
            }
        }


        listDataChild.put(listDataHeader.get(0), entradas);
        listDataChild.put(listDataHeader.get(1), sopas);
    }

}