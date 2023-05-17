package Aplicativos.Compras.Online.Produto;

public class Compra implements Comparable<Compra>{
    private String Descricao;
    private Double valor;

    public String getDescricao() {
        return Descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Compra(String descricao, double valor){
        this.Descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "compra:" + "Descricao = '" + Descricao + valor +
                ", valor = " + valor;
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(outraCompra.valor));
    }
}
