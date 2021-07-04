import java.util.Scanner;

public class Calculadora{
    public static void main(String[] args) {
        double views;
        double viewsTotal;
        double clicks;
        double share;
        double valor;

//      O script solicita o valor do investimento em reais e o salva na variável.
        System.out.print("Insira o valor investido em reais: ");
        Scanner input = new Scanner(System.in);
        valor = input.nextDouble();

        views = (valor * 30);
        viewsTotal = views;

//      Como cada post pode ser compartilhado até 4 vezes em sequência, adicionamos os dados em um laço de repetição
//      para incrementar os valores de cliques, compartilhamentos e visualizações até o máximo de quatro compartilhamentos.

        for (int i = 0; i < 4; i++) {
            clicks = (views * 0.12);
            share = (clicks * 0.15);
            views = share * 40;
            viewsTotal += views;
        }

//      Por fim o script retorna a projeção aproximada da quantidade máxima de pessoas que visualizarão o anúncio com o investimento informado.
//      Para uma visualização mais precisa e amigável, o total de visualizações é convertido em um número inteiro.

        System.out.println("Com um investimento de R$" + valor + " este anúncio poderá atingir até " + (int) viewsTotal + " pessoas!");
        System.out.println("** Esta é um projeção aproximada! **");
    }
}
