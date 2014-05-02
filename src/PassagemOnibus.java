/* Rodrigo Celebrone RA: 20428584 
*  Vinicius Andrade  RA: 20470284
*/


import java.util.Scanner;

public class PassagemOnibus {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ladoJanela[] = new int[24],
                ladoCorredor[] = new int[24],
                menuPrograma = 0, //escolha do menu
                poltronas,//numero da poltrona
                lotado = 0;//verificação de onibus lotado
        String jancor; //opção janela ou corredor
        System.out.println("Reserve a sua Passagem");

        while (lotado < 48) { //Executa o softaware até a Lotação do Ônibus
            //Menu de Opções
            System.out.println("Escolha a opção");
            System.out.println("1 - Vender Passagem");
            System.out.println("2 - Mostrar mapa de ocupação do ônibus");
            System.out.println("3 - Sair do Programa");
            System.out.print("Digite a opção conforme a numeração: ");
            menuPrograma = input.nextInt();
            while (menuPrograma < 1 || menuPrograma > 3) {
                System.out.print("Digite uma das opções 1,2,3: ");
                menuPrograma = input.nextInt();
            }

            //menuPrograma = 1 - Vende a passagem
            if (menuPrograma == 1) {
                System.out.println("Escolha a opção Janela com (j) ou corredor com (C)");
                jancor = String.valueOf(input.next().charAt(0));
                while (!jancor.equalsIgnoreCase("J") && !jancor.equalsIgnoreCase("C")) {
                    System.out.println("Escolha a opção Janela com (j) ou corredor com (C)");
                    jancor = String.valueOf(input.next().charAt(0));
                }
                System.out.println("Qual o número da poltrona [1 - 24]:");
                poltronas = input.nextInt();
                while (poltronas > 24 || poltronas < 1) {
                    System.out.print("Por Favor digite um numero de 1 a 24: ");
                    poltronas = input.nextInt();
                }

                // Venda de poltrona na janela
                if (jancor.equalsIgnoreCase("J")) {
                    if (ladoJanela[(poltronas - 1)] == 0) {
                        ladoJanela[(poltronas - 1)] = 1;
                        System.out.println("Venda Efetuada.");
                        lotado++;
                    } else {
                        System.out.println("Poltrona Ocupada.");
                    }
                } // Venda de poltrona no Corredor
                else if (jancor.equalsIgnoreCase("C")) {
                    if (ladoCorredor[(poltronas - 1)] == 0) {
                        ladoCorredor[(poltronas - 1)] = 1;
                        System.out.println("Venda Efetuada.");
                        lotado++;
                    } else {
                        System.out.println("Poltrona Ocupada.");
                    }
                }
            }

            //menuPrograma = 2 - Mapeia o Onibus
            if (menuPrograma == 2) {
                System.out.println("Janela           Corredor");
                for (int i = 0; i < 24; i++) {
                    if (ladoJanela[i] == 0 && ladoCorredor[i] == 0) {
                        System.out.println("" + (i + 1 < 10 ? "0":"") + (i + 1) + " - Livre      " + (i + 1 < 10 ? "0":"") + (i + 1) + " - Livre");
                    } else if (ladoJanela[i] == 0 && ladoCorredor[i] == 1) {
                        System.out.println("" + (i + 1 < 10 ? "0":"") + (i + 1) + " - Livre      " + (i + 1 < 10 ? "0":"") + (i + 1) + " - Ocupado");
                    } else if (ladoJanela[i] == 1 && ladoCorredor[i] == 0) {
                        System.out.println("" + (i + 1 < 10 ? "0":"") + (i + 1) + " - Ocupado    " + (i + 1 < 10 ? "0":"") + (i + 1) + " - Livre");
                    } else {
                        System.out.println("" + (i + 1 < 10 ? "0":"") + (i + 1) + " - Ocupado    " + (i + 1 < 10 ? "0":"") + (i + 1) + " - Ocupado");
                    }
                }
            }

            if (lotado >= 48) {
                //Quando Lotado e sai do programa.
                System.out.println("Onibus Lotado!!");
                System.exit(0);
            }

            //menuPrograma = 3 - Sair do Programa
            if (menuPrograma == 3) {
                System.exit(0);
            }
        }
    }
}
