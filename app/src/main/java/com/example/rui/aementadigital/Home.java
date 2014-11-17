package com.example.rui.aementadigital;

import android.app.Activity;

import android.app.ActionBar;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class Home extends FragmentActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        Fragment fragment = new HomeView();
        //int position = mNavigationDrawerFragment.getListView().getSelectedItemPosition();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case 0: {
//                Toast.makeText(getApplicationContext(),"position: " + position, Toast.LENGTH_LONG).show();
                Fragment fragment = new HomeView();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
                break;
            }
            case 1: {
                Fragment fragment = new Entradas();
//                Toast.makeText(getApplicationContext(),"position: " + position, Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
                break;
            }
            case 2: {
                Fragment fragment = new Pratos();
//                Toast.makeText(getApplicationContext(),"position: " + position, Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
                break;
            }
            case 3: {
                Fragment fragment = new Sobremesas();
//                Toast.makeText(getApplicationContext(),"position: " + position, Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
                break;
            }
            case 4: {
                Fragment fragment = new Bebidas();
//                Toast.makeText(getApplicationContext(),"position: " + position, Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
                break;
            }
            case 5: {
                Fragment fragment = new Conta();
//                Toast.makeText(getApplicationContext(),"position: " + position, Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
                break;
            }
//            case 6: {
//                Fragment fragment = new AskPassword();
////                Toast.makeText(getApplicationContext(),"position: " + position, Toast.LENGTH_LONG).show();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, fragment)
//                        .commit();
//                break;
//            }

        }
    }


    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.home);
                break;
            case 2:
                mTitle = getString(R.string.entries);
                break;
            case 3:
                mTitle = getString(R.string.dishes);
                break;
            case 4:
                mTitle = getString(R.string.desserts);
                break;
            case 5:
                mTitle = getString(R.string.beverages);
                break;
//            case 6:
//                mTitle = getString(R.string.code);
//                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.home, menu);
            restoreActionBar();
            MenuItem item = menu.findItem(R.id.action_settings);
            item.setVisible(false);

//            item = menu.findItem(R.id.action_example);
//            List<Pedido> completedRequests = ((ContaHelper) this.getApplication()).pedidosConcretizados;
//            if (completedRequests.size() != 0) {
//                double check = 0.00;
//                for (Pedido p : completedRequests) {
//                    check += p.getPrice();
//                }
//
//                item.setTitle("Conta: " + Math.round(check * 100.0) / 100.0);
//            }

            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
//            item.setVisible(false);
            return true;
        }

        if (item.getItemId() == R.id.action_example) {

//            List<Pedido> completedRequests = ((ContaHelper) this.getApplication()).pedidosConcretizados;
//            if (completedRequests.size() != 0) {
//                double check = 0.00;
//                for (Pedido p : completedRequests) {
//                    check += p.getPrice();
//                }
//
//                item.setTitle("Conta: " + Math.round(check * 100.0) / 100.0 + " €");
//                System.out.println(check);
//            }

            final FragmentManager fragmentManager = this.getSupportFragmentManager();
            Fragment fragment = new Conta();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class HomeView extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            final FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_home, container, false);
            //mNavigationDrawerFragment.getListView().setItemChecked(0,true);
            Button entradas = (Button) view.findViewById((R.id.button1));
            Button pratos = (Button) view.findViewById((R.id.cancelB));
            Button sobremesas = (Button) view.findViewById((R.id.button3));
            Button bebidas = (Button) view.findViewById((R.id.button4));
            Button conta = (Button) view.findViewById((R.id.button5));

            getActivity().getActionBar().setTitle("Home");


            entradas.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    getActivity().getActionBar().setTitle("Entradas e Cafés");
                    Fragment fragment = new Entradas();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
                }
            });

            pratos.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    getActivity().getActionBar().setTitle("Pratos");
                    Fragment fragment = new Pratos();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
                }
            });

            sobremesas.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    getActivity().getActionBar().setTitle("Sobremesas e Cafés");
                    Fragment fragment = new Sobremesas();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
                }
            });

            bebidas.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    getActivity().getActionBar().setTitle("Bebidas");
                    Fragment fragment = new Bebidas();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
                }
            });

            conta.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    getActivity().getActionBar().setTitle("Conta");
                    Fragment fragment = new Conta();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
                }
            });

            return view;
        }
    }

    public void onBackPressed() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        List l = fragmentManager.getFragments();

        if (l == null) {
            Fragment fragment = new AskPassword();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        } else {
            String[] parts = l.get(l.size() - 1).toString().split("\\{");
            if (parts[0].equals("HomeView")) {
                Fragment fragment = new AskPassword();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
            } else if (parts[0].equals("AskPassword")) {
                //do nothing
            } else {
                Fragment fragment = new HomeView();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
            }
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((Home) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}