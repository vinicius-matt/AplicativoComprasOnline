package Aplicativos.Compras.Online.CartaoCredito;
import Aplicativos.Compras.Online.Produto.Compra;

import java.util.ArrayList;
import java.util.List;

public class CartaoCredito {
    private double Limite;
    private double Saldo;
    private List<Compra> Compras;

    public CartaoCredito(double limite) {
        this.Limite = limite;
        this.Saldo = Limite;
        this.Compras = new ArrayList<>();
    }

    public boolean adicionaCompra(Compra compra) {
        if (this.Saldo > compra.getValor()) {
            System.out.println("Compra Realizada");
            this.Saldo -= compra.getValor();
            this.Compras.add(compra);
            System.out.println("Saldo Atual Após a Compra " + Saldo);
            return true;
        }
        return false;
    }

    public double getLimite() {
        return Limite;
    }

    public double getSaldo() {
        return Saldo;
    }

    public List<Compra> getCompras() {
        return Compras;
    }
}

