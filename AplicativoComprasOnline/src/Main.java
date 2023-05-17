import Aplicativos.Compras.Online.CartaoCredito.CartaoCredito;
import Aplicativos.Compras.Online.Produto.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o Saldo do Seu Cartão:");
        double limite = leitor.nextDouble();
        leitor.nextLine(); // Consumir a quebra de linha pendente

        CartaoCredito cartaoCredito = new CartaoCredito(limite);
        System.out.println("Seu Limite Atual é: " + limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite o que Deseja Comprar:");
            String descricao = leitor.nextLine();

            System.out.println("Digite o Valor Da sua Compra");
            double valor = leitor.nextDouble();
            leitor.nextLine(); // Consumir a quebra de linha pendente

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartaoCredito.adicionaCompra(compra);

            if (compraRealizada) {
                System.out.println("A Compra Foi Realizada");
                System.out.println("Digite 0 para Sair ou 1 Para continuar Comprando");
                sair = leitor.nextInt();
                leitor.nextLine(); // Consumir a quebra de linha pendente
            } else {
                System.out.println("Saldo Insuficiente para Compra");
                System.out.println("Seu Saldo é " + cartaoCredito.getSaldo());
                sair = 0;
            }
            System.out.println("******************************");
            System.out.println("Compras Realizadas Hoje:\n");

            Collections.sort(cartaoCredito.getCompras());

            for (Compra c : cartaoCredito.getCompras()) {
                System.out.println(c.getDescricao() + " - " + c.getValor());
            }
            System.out.println("\n************************************");

            System.out.println("Seu Saldo R$" + cartaoCredito.getSaldo());
        }
    }
}
