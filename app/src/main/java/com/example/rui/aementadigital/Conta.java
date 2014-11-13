package com.example.rui.aementadigital;

import android.app.Dialog;
import android.content.SyncStatusObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by Rui on 21/10/2014.
 */
public class Conta extends Fragment {

    double total_aux = 0.0;
    ImageButton[] buttonsEdit;
    ImageButton[] buttonsRemove;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.account, container, false);
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);

        if(((ContaHelper) getActivity().getApplication()).pedidosPorEnviar.size() > 0){
            toSendRequests(view);
            Button send2Account = (Button) view.findViewById(R.id.sendToKitchen);
            TextView text = (TextView) view.findViewById(R.id.pedidosporEnviar);
            text.setVisibility(View.VISIBLE);
            send2Account.setVisibility(View.VISIBLE);

            for(int i = 0; i < buttonsEdit.length; i++) {
                if(buttonsEdit[i] != null) {
                buttonsEdit[i].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Eu cliquei!", Toast.LENGTH_LONG).show();
                    }
                });
                }
            }


            send2Account.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    List<Pedido> completedRequests = ((ContaHelper) getActivity().getApplication()).pedidosConcretizados;
                    List<Pedido> waitingOrders = ((ContaHelper) getActivity().getApplication()).pedidosPorEnviar;

                    for(int i = 0; i < waitingOrders.size(); i++)
                        completedRequests.add(waitingOrders.get(i));
                    waitingOrders.clear();


                    getActivity().getActionBar().setTitle("Conta");
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    Fragment fragment = new Conta();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();
                }
            });
        }

        if(((ContaHelper) getActivity().getApplication()).pedidosConcretizados.size() > 0) {
            sentResquests(view);
            Button sendAccount = (Button) view.findViewById(R.id.sendAccount);
            TextView text = (TextView) view.findViewById(R.id.pedidosenviados);
            text.setVisibility(View.VISIBLE);
            sendAccount.setVisibility(View.VISIBLE);
            final double total = total_aux;
            sendAccount.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(getActivity());

                    dialog.setContentView(R.layout.dados_cont);
                    dialog.show();
                    dialog.setTitle("Valor a pagar: " + total + " €");
                    Button confirm = (Button) dialog.findViewById(R.id.confirmB);
                    Button cancelBtn = (Button) dialog.findViewById(R.id.cancelB);
                    cancelBtn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            dialog.hide();
                        }
                    });
                    EditText text = (EditText) dialog.findViewById(R.id.editText2);
                    confirm.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            List<Pedido> completedRequests = ((ContaHelper) getActivity().getApplication()).pedidosConcretizados;

                            Toast.makeText(getActivity().getApplicationContext(),
                                    "Obrigado por ter vindo. Esperamos que tenha ficado satisfeito com o serviço. \n Por favor aguarde pragamento",
                                    Toast.LENGTH_LONG).show();
                            dialog.hide();
                            getActivity().getActionBar().setTitle("Home");
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            Fragment fragment = new Home.HomeView();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.container, fragment)
                                    .commit();

                            //eliminar os pedidos feitos
                            completedRequests.clear();
                        }
                    });
                }
            });
        }
        return view;
    }

    public void sentResquests(View v) {
        TableLayout stk = (TableLayout) v.findViewById(R.id.table_main);
        List<Pedido> completedRequests = ((ContaHelper) getActivity().getApplication()).pedidosConcretizados;

        TableRow tbrow0 = new TableRow(getActivity());
        TextView tv0 = new TextView(getActivity());
        tv0.setText("Produto");
        tv0.setTextColor(Color.WHITE);
        tv0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(getActivity());
        tv1.setText(" Preço/Unidade ");
        tv1.setTextColor(Color.WHITE);
        tv1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(getActivity());
        tv2.setText("Quantidade ");
        tv2.setTextColor(Color.WHITE);
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(getActivity());
        tv3.setText("Total");
        tv3.setTextColor(Color.WHITE);
        tv3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        tbrow0.addView(tv3);
        stk.addView(tbrow0);
        for (int i = 0; i < completedRequests.size(); i++) {
            TableRow tbrow = new TableRow(getActivity());
            TextView t0v = new TextView(getActivity());
            t0v.setText(completedRequests.get(i).getProdutName());
            t0v.setTextColor(Color.WHITE);

//            t0v.setGravity(Gravity.CENTER);
//            t0v.setGravity(Gravity.LEFT);



            tbrow.addView(t0v);
            TextView t1v = new TextView(getActivity());
            t1v.setText(" " + String.valueOf(completedRequests.get(i).getPrice()) + " ");
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(getActivity());
            t2v.setText(String.valueOf(completedRequests.get(i).getQuantidade()) + " ");
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(getActivity());
            double calc = completedRequests.get(i).getQuantidade()*completedRequests.get(i).getPrice();
            total_aux += calc;
            t3v.setText(String.valueOf(calc));
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            stk.addView(tbrow);
        }
        TableRow tbrow = new TableRow(getActivity());
        TextView t0v = new TextView(getActivity());
        tbrow.addView(t0v);
        TextView t1v = new TextView(getActivity());
        tbrow.addView(t1v);
        TextView t2v = new TextView(getActivity());
        tbrow.addView(t2v);
        TextView t3v = new TextView(getActivity());
        t3v.setText(String.valueOf(total_aux));
        t3v.setTextColor(Color.WHITE);
        t3v.setGravity(Gravity.CENTER);
        tbrow.addView(t3v);
        stk.addView(tbrow);
    }

    public void toSendRequests(View v) {
        buttonsEdit = new ImageButton[((ContaHelper) getActivity().getApplication()).pedidosPorEnviar.size()];
        buttonsRemove = new ImageButton[((ContaHelper) getActivity().getApplication()).pedidosPorEnviar.size()];
        TableLayout stk = (TableLayout) v.findViewById(R.id.second_table);
        List<Pedido> waitingOrders = ((ContaHelper) getActivity().getApplication()).pedidosPorEnviar;

        TableRow tbrow0 = new TableRow(getActivity());
        TextView tv0 = new TextView(getActivity());
        tv0.setText("Produto");
        tv0.setTextColor(Color.WHITE);
        tv0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(getActivity());
        tv1.setText(" Preço/Unidade ");
        tv1.setTextColor(Color.WHITE);
        tv1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(getActivity());
        tv2.setText("Quantidade ");
        tv2.setTextColor(Color.WHITE);
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(getActivity());
        tv3.setText("Total");
        tv3.setTextColor(Color.WHITE);
        tv3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        tbrow0.addView(tv3);
        stk.addView(tbrow0);
        for (int i = 0; i < waitingOrders.size(); i++) {
            TableRow tbrow = new TableRow(getActivity());
            TextView t0v = new TextView(getActivity());
            t0v.setText(waitingOrders.get(i).getProdutName());
            t0v.setTextColor(Color.WHITE);
            //t0v.setGravity(Gravity.CENTER);
            tbrow.addView(t0v);
            TextView t1v = new TextView(getActivity());
            t1v.setText(" " + String.valueOf(waitingOrders.get(i).getPrice()) + " ");
            t1v.setTextColor(Color.WHITE);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(getActivity());
            t2v.setText(String.valueOf(waitingOrders.get(i).getQuantidade()) + " ");
            t2v.setTextColor(Color.WHITE);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(getActivity());
            double calc = waitingOrders.get(i).getQuantidade()*waitingOrders.get(i).getPrice();
            total_aux += calc;
            t3v.setText(String.valueOf(calc));
            t3v.setTextColor(Color.WHITE);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            ImageButton t4v = new ImageButton(getActivity());
            t4v.setImageResource(R.drawable.ic_action_edit);
            t4v.setBackgroundColor(Color.TRANSPARENT);
            tbrow.addView(t4v);
            buttonsEdit[i] = t4v;
            ImageButton t5v = new ImageButton(getActivity());
            t5v.setImageResource(R.drawable.ic_action_remove);
            t5v.setBackgroundColor(Color.TRANSPARENT);
            buttonsRemove[i] = t5v;
            tbrow.addView(t5v);
            stk.addView(tbrow);
        }
        TableRow tbrow = new TableRow(getActivity());
        TextView t0v = new TextView(getActivity());
        tbrow.addView(t0v);
        TextView t1v = new TextView(getActivity());
        tbrow.addView(t1v);
        TextView t2v = new TextView(getActivity());
        tbrow.addView(t2v);
        TextView t3v = new TextView(getActivity());
        t3v.setText(String.valueOf(total_aux));
        t3v.setTextColor(Color.WHITE);
        t3v.setGravity(Gravity.CENTER);
        tbrow.addView(t3v);
        stk.addView(tbrow);
    }

}
