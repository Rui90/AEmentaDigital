package com.example.rui.aementadigital;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rui on 04/11/2014.
 */
public class ContaHelper extends Application  {
    List<Pedido> pedidosConcretizados = new ArrayList<Pedido>();
    List<Pedido> pedidosPorEnviar = new ArrayList<Pedido>();

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    int quantidade = 0;

    public ContaHelper() {

    }

    public void addPedido(Pedido p, int type) {
        boolean aux = false;
        if (type == 1) {
            for (int i = 0; i < pedidosConcretizados.size(); i++) {
                if (pedidosConcretizados.get(i).getProdutName().equals(p.getProdutName())) {
                    pedidosConcretizados.get(i).setQuantidade(pedidosConcretizados.get(i).getQuantidade() + p.getQuantidade());
                    aux = true;
                    break;
                }
            }
            if (!aux)
                pedidosConcretizados.add(p);
        } else if (type == 0) {
            for (int i = 0; i < pedidosPorEnviar.size(); i++) {
                if (pedidosPorEnviar.get(i).getProdutName().equals(p.getProdutName())) {
                    pedidosPorEnviar.get(i).setQuantidade(pedidosPorEnviar.get(i).getQuantidade() + p.getQuantidade());
                    aux = true;
                    break;
                }
            }
            if (!aux)
                pedidosPorEnviar.add(p);
        }
    }

    public List<Pedido> getPedidosConcretizados() {
        return pedidosConcretizados;
    }

    public void setPedidosConcretizados(List<Pedido> pedidosConcretizados) {
        this.pedidosConcretizados = pedidosConcretizados;
    }

    public List<Pedido> getPedidosPorEnviar() {
        return pedidosPorEnviar;
    }

    public void setPedidosPorEnviar(List<Pedido> pedidosPorEnviar) {
        this.pedidosPorEnviar = pedidosPorEnviar;
    }



}
