import java.util.Scanner;

public class Calculadora {

    public static float sum(float a, float b) {return a + b;}

    public static float subtraction(float a, float b) {return a - b;}

    public static float multiplication(float a, float b) {return a * b;}

    public static float division(float a, float b) {return a / b;}

    public static void introdutcion() {
        System.out.println("BEM VINDO À CALCULADORA DESENVOLVIDA EM JAVA");
        System.out.println("Aqui você poderá resolver algumas operações matemáticas simples, conforme menu abaixo:");
    }

    public static void menu() {
        System.out.println("Digite o número correspondente a operação que você quer fazer: ");
        System.out.println("1-Soma\n2-Subtração\n3-Divisão\n4-Multiplicação\n0-Sair");
        System.out.print("Sua resposta: ");
    }

    public static boolean menuValidation(int x){
        if (x < 0 || x > 4) {
                System.out.println("Valor inválido! Digite um número entre 0 e 4");
                return false;
        } else return true;
    }

    public static int readInteger(Scanner scanner) {
        for (;;) {
            String linhaDigitada = scanner.next();
            try {
                return Integer.parseInt(linhaDigitada);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Tente novamente.");
            }
        }
    }

    public static void thanks() {System.out.print("Obrigado por usar a calculadora!\nAté a próxima!\nDesenvolvido por DevRubensV");}

    public static boolean validString(Scanner scanner){
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

    public static void main(String[] args){

        //Variavel para verificar se deve continuar operando
        boolean operating = true;

        //Iniciando a variavel scanner para receber dados do prompt
        Scanner scanner = new Scanner(System.in);

        //Função para exibir a introdução do software
        introdutcion();

        //Looping para operar enquanto operating = verdadeiro
        while (operating){
            //Variável para sinalizar a operação que o usuário deseja
            int options;

            //Exibe o menu de opeções da calculadora
            //Recebe e valida a escolha do usuário para que seja numero inteiro
            //Valida a opção do usuário referente ao Menu de operações
            //Deve ser valor entre 0 e 4 (limites inclusos)
            do {
                menu();
                options = readInteger(scanner);
            } while (!(menuValidation(options)));

            //Opção de saida a partir do menu
            if (options == 0) break;

            //Solicita o primeiro número para operação
            System.out.print("Digite o primeiro número para a operação: ");
            float num1 = scanner.nextFloat();

            //Solicita o segundo número para operação
            System.out.print("Digite o segundo número para a operação: ");
            float num2 = scanner.nextFloat();

            //Realiza a operação, conforme opção do usuário
            if (options == 1) System.out.println("O resultado da soma é: " + sum(num1, num2));
            else if (options == 2) System.out.println("O resultado da subtração é: " + subtraction(num1, num2));
            else if (options == 3) System.out.println("O resultado da divisão é: " + division(num1, num2));
            else if (options == 4) System.out.println("O resultado da multiplicação é: " + multiplication(num1, num2));

            //Questiona se o usuario quer fazer outra operação
            //E valida sua resposta como sim ou nao
            boolean aux = validString(scanner);

            //Se resposta for nao, encerra o programa
            if (!aux) operating = false;

        }
        //encerra a função scanner
        scanner.close();
        //Exibe os agradecimentos
        thanks();
    }
}
