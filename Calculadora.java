import java.util.Scanner;
import java.util.*;

public class Calculadora {
    //Funções de acordo com cada tipo de operação
    //Soma
    //Soma os valores do input até o usuário digitar 0
    public static float sum(Scanner scanner){
        float resultSum = 0;
        for (;;){
            System.out.println("Digite um valor para soma: ");
            System.out.println("Quando quiser parar, digite 0");
            float aux = readFloat(scanner);
            if(aux == 0) return resultSum;
            else {
                resultSum += aux;
            }
        }
    }
    //Subtração
    //O primeiro valor digitado pelo usuário será decrescido dos seguintes
    //Subtrai os valores do input até o usuário digitar 0
    public static float subtraction(Scanner scanner) {
        float resultSubtraction = 0;
        for (; ; ) {
            System.out.println("Digite um valor para subtração:");
            System.out.println("Quando quiser parar, digite 0");
            float aux = readFloat(scanner);
            if (aux == 0) return resultSubtraction;
            else if (resultSubtraction == 0) resultSubtraction = aux;
            else resultSubtraction -= aux;
        }
    }
    //Multiplicação
    //Multiplica os valores do input até o usuário digitar 0
    public static float multiplication(Scanner scanner) {
        float resultMultiplication = 0;
        for (; ; ) {
            System.out.println("Digite um valor para multiplicação:");
            System.out.println("Quando quiser parar, digite 0");
            float input = scanner.nextFloat();
            if (input == 0) return resultMultiplication;
            else if (resultMultiplication == 0) resultMultiplication = input;
            else resultMultiplication *= input;
        }
    }
    //Divisão
    public static float division(Scanner scanner) {
        System.out.println("Digite o valor do numerador: ");
        float numerador = readFloat(scanner);
        System.out.println("Digite o valor do denominador: ");
        float denominador = readFloat(scanner);
        return numerador / denominador;
    }
    //Exponecial
    public static double expo(Scanner scanner) {
        System.out.println("Digite o valor da base do expoente: ");
        double base = readDouble(scanner);
        System.out.println("Digite o valor do expoente: ");
        double exponencial = readDouble(scanner);
        return Math.pow(base, exponencial);
    }
    //Logarítmo
    public static double log(Scanner scanner){
        System.out.println("Digite o valor do logaritmando: ");
        double logarimtmando = readDouble(scanner);
        System.out.println("Digite o valor da base do logaritmo: ");
        double base = readDouble(scanner);
        return Math.log(logarimtmando) / Math.log(base);
    }
    //Função para imprimir a introdução ao programa
    public static void introdutcion() {
        System.out.println("BEM VINDO À CALCULADORA DESENVOLVIDA EM JAVA");
        System.out.println("Aqui você poderá resolver algumas operações matemáticas simples, conforme menu abaixo:");
    }

    //Função para imprimir o menu de operações da calculadora
    public static int menu() {
        List<String> menu = Arrays.asList("0-Sair", "1-Soma", "2-Subtração", "3-Divisão", "4-Multiplicação", "5-Exponencial", "6-Logarítmo");
        System.out.println("Digite o número correspondente a operação que você quer fazer: ");
        menu.forEach(System.out::println);
        System.out.print("Sua resposta: ");
        return menu.toArray().length;
    }

    public static float readFloat(Scanner scanner) {
        for (;;) {
            String linhaDigitada = scanner.next();
            try {
                return Float.parseFloat(linhaDigitada);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Tente novamente.");
            }
        }
    }

    public static double readDouble(Scanner scanner) {
        for (;;) {
            String linhaDigitada = scanner.next();
            try {
                return Double.parseDouble(linhaDigitada);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Tente novamente.");
            }
        }
    }

    public static double operation(Scanner scanner, float lengthMenu){
        for(; ; ){
            float op = readFloat(scanner);
            if (op < 0 || op > lengthMenu) {
                System.out.println("Valor inválido! Digite um número entre 0 e " + (lengthMenu - 1));
            } else {
                if (op == 0) return op;
                else if (op == 1) return sum(scanner);
                else if (op == 2) return subtraction(scanner);
                else if (op == 3) return division(scanner);
                else if (op == 4) return multiplication(scanner);
                else if (op == 5) return expo(scanner);
                else if (op == 6) return log(scanner);
            }
        }
    }

    public static void thanks() {
        System.out.print("Obrigado por usar a calculadora!\nAté a próxima!\nDesenvolvido por DevRubensV");
        System.out.print("Desenvolvido por DevRubensV");
    }

    public static boolean repeat(Scanner scanner){
        for(;;){
            System.out.println("Voce quer fazer outra operação?");
            String x = scanner.next().toLowerCase();
            if(x.contains("sim")) {
                return true;
            } else if (x.contains("nao")){
                return false;
            } else System.out.println("Respota invalida! Responda com sim ou nao");
        }
    }

    //Função para receber valores para operações que permitem multiplas entradas

    public static void main(String[] args){

        //Variavel para verificar se deve continuar operando
        boolean operating = true;

        //Iniciando a variavel scanner para receber dados do prompt
        Scanner scanner = new Scanner(System.in);

        //Função para exibir a introdução do software
        introdutcion();

        //Looping para operar enquanto operating = verdadeiro
        do{

            //Exibe o menu de opções da calculadora
            //A variavel n recebe o cumprimento do array menu
            int n = menu();

            //Recebe e valida a escolha do usuário para que seja numero inteiro
            //Valida a opção do usuário referente ao Menu de operações
            //Deve ser valor entre 0 e o cumprimento do array menu (variavel n)
            double result = operation(scanner, n);

            //Opção de saida a partir do menu
            if (result == 0) break;
            else System.out.println("O resultado da operação é: "+ result);

            //Questiona se o usuario quer fazer outra operação
            //E valida sua resposta como sim ou nao
            boolean aux = repeat(scanner);

            //Se resposta for nao, encerra o programa
            if (!aux) operating = false;
        } while (operating);
        //encerra a função scanner
        scanner.close();
        //Exibe os agradecimentos
        thanks();
    }
}
