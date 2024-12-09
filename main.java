/**
* Autor: Yasmin Lara Amanajás de Miranda
* Linguagem: Java
* Data: 08/12/2024
* Descrição: Simuldor de caixa eletrônico
* Funcionalidades: 
* - Entra com nome e senha 
* - Exibe Extrato/Saldo
* - Realizar depósito e Saque
* Versão: 1.0
*/

//bibliotecas da linguagem java
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;//biblioteca para sortear  

public class main {

    public static void entrar(Scanner yas, char a){//função para receber o nome e a senha do usuário
        //coloca uma linha de 50 caracteres
            for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        System.out.printf("Digite seu nome: ");//mostra uma mensagem pedindo para o usuário escrever o nome
        String nome = yas.next(); //para receber o nome do usuário
        System.out.printf("Insira sua senha de quatro dígitos: ");//mostra uma mensagem pedindo para o usuário inserir a senha
        int senha = yas.nextInt();//para receber a senha do usuário
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        System.out.printf("* Bem-vindo(a) %s! *", nome);//mostra uma mensagem com o nome fornecido pelo usuário
        System.out.printf("\n");//para pular uma linha
    }

    public static float atualizar_saldo(){//função criada para determinar o saldo inicial do usuário
        int sorteio = ThreadLocalRandom.current().nextInt(200000);//para sortear um número entre 0 e 199999 
        float saldo = sorteio/100.0f; //transforma o numero inteiro em um número decimal
        return saldo;//retorna o saldo do usuário
    }

    public static void opcoes(char a){ //função para mostrar ao usuário as opções que ele tem
         //coloca uma linha de 50 caracteres
         for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        System.out.println("Escolha uma opção:"); //apresenta as opções que usuário pode executar
        System.out.println("1 --> Extrato/Saldo");// diz que se o usuário escolher a opção 1, ele irá ver o saldo e o extrato dele
        System.out.println("2 --> Deposito"); // diz ao usuário que se ele escolher a opção 2, ele poderá fazer um depósito
        System.out.println("3 --> Saque"); // diz ao usuário que se ele escolher a opção 3, ele poderá fazer um saque
        System.out.println("4 --> Sair"); //diz que se ele escolher a opção 4, o codigo vai parar
    }

    public static void mostrar_extrato(char a, float[] Extrato, float saldo, int ocorrencia){ //função para mostrar o saldo atual e o extrato do usuário
        //coloca uma linha de 20 caracteres
        for (int i = 0; i < 20; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        System.out.printf("Seu Saldo: %.2f\n", saldo);// mostra ao usuário o saldo atual dele
        //coloca uma linha de 20 caracteres
        for (int i = 0; i < 20; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        for (int i=0;i<=ocorrencia;i++){//pra imprimir o extrato
            System.out.printf("%.2f\n", Extrato[i]);//impeime o elemento do extrato
            //coloca uma linha de 20 caracteres
            for (int k = 0; k < 20; k++){
                System.out.printf("%c", a);
            }
            System.out.printf("\n");//para pular uma linha
            
        }
        System.out.printf("\n");//para pular uma linha
        //temporizador de 5 segundos
        try { Thread.sleep(5000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }
    }

    public static float deposite(Scanner yas, char a, float[] Extrato, float saldo, int ocorrencia){// função para o usuário fazer um depósito
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        System.out.printf("Digite o valor que deseja depositar: ");//pede ao usuário que ele informe qual o valor do depósito
        float deposito = yas.nextFloat();
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        //temporizador de 3 segundos
        try { Thread.sleep(3000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }
        saldo += deposito; //o saldo recebe o saldo mais o valor do depósito
        Extrato[ocorrencia] = deposito; //adiciona a informação de que aconteceu um depósito ao extrato
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        System.out.printf("Seu Saldo foi atualizado!");//informa ao usuário que o saldo foi atualizado
        System.out.printf("\n");//para pular uma linha
        System.out.printf("Seu Saldo: %.2f",saldo);//mostra o novo saldo do usuário
        System.out.printf("\n");//para pular uma linha
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        //temporizador de 5 segundos
        try { Thread.sleep(5000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }
        return saldo; //retorna o saldo do usuário
    }

    public static float sacar(Scanner yas, char a, float[] Extrato, float saldo, int ocorrencia){ // função para o usuário fazer um saque
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        System.out.printf("Digite o valor do saque: ");//pede ao usuário q insira o valor do saque
        float saque = yas.nextFloat(); //pede ao usuário que ele informe o valor do saque
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        //temporizador de 3 segundos
        try { Thread.sleep(3000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }
        if (saque <= saldo){ // se o valor do saque for menor ou igual ao saldo
            saldo -= saque; // o saldo recebe o saldo menos o saque
            Extrato[ocorrencia] = saque*-1;//informa ao extrato que aconteceu um saque
            //coloca uma linha de 50 caracteres
            for (int i = 0; i < 50; i++){
                System.out.printf("%c", a);
            }
            System.out.printf("\n");//para pular uma linha
            System.out.printf("Seu Saque foi autorizado!\n"); // diz ao usuário que o saque foi autorizado
            System.out.printf("Seu Saldo: %.2f", saldo); //mostar o novo saldo do usuário
            System.out.printf("\n");//para pular uma linha
            //coloca uma linha de 50 caracteres
            for (int i = 0; i < 50; i++){
                System.out.printf("%c", a);
            }
            System.out.printf("\n");//para pular uma linha
            //temporizador de 3 segundos
        try { Thread.sleep(3000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }
            return saldo; //retorna o extarto e o saldo do usuário
        }else{ //se o valor for maior que o saldo
            //temporizador de 2 segundos
        try { Thread.sleep(2000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }
            //coloca uma linha de 50 caracteres
            for (int i = 0; i < 50; i++){
                System.out.printf("%c", a);
            }
            System.out.printf("\n");//para pular uma linha
            System.out.printf("Seu Saque foi NEGADO!"); //informa ao usuário que o saque foi negado
            System.out.printf("\n");//para pular uma linha
            System.out.printf("O valor excedeu seu saldo!"); //diz que o valor do saque é mair que o saldo
            System.out.printf("\n");//para pular uma linha
            //coloca uma linha de 50 caracteres
            for (int i = 0; i < 50; i++){
                System.out.printf("%c", a);
            }
            System.out.printf("\n");//para pular uma linha
            //temporizador de 5 segundos
        try { Thread.sleep(5000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }
            return saldo; //retorna o extarto e o saldo do usuário
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner yas = new Scanner(System.in);//diz que yas é usado para ler a entrada do usuário
        char a='*';//declara que a variavel a é do tipo char e atribui a ela o caracter "*"
        int n=0, ocorrencia=0;//declara que a variavel n e a variavel ocorrencia são do tipo int e atribui a elas 0
        float saldo, saldoo; // declara que saldo e saldoo são do tipo float
        float[] Extrato = new float[1000]; // declara que a variavel saldo e o array Extrato[1000] são do tipo float e atribui a ambos o valor 0

        entrar(yas, a);//chama a função entrar
        saldo = atualizar_saldo();//chama a função para atualizar o saldo inicial
        opcoes(a);//chama a função para mostrar o quadro de opções
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha
        System.out.printf("--> ");//mostra uma seta pra receber a opção escolhida pelo usuário
        while (n != 4){//o codigo continuara rodando enquanto a escolha do usuário for diferente de 4
            
            n = yas.nextInt();//recebe e garda o valor de n

            if (n == 1){//se o usuário escolher a opção 1
                mostrar_extrato(a, Extrato, saldo, ocorrencia);//chama a função para mostrar o extrato
                opcoes(a); //mostra as opções pro usuário
            //coloca uma linha de 50 caracteres
            for (int i = 0; i < 50; i++){
                System.out.printf("%c", a);
            }
            System.out.printf("\n");//para pular uma linha
            System.out.printf("--> ");//mostra uma seta pra receber a opção escolhida pelo usuário
            }else if (n == 2){//se o usuário escolher a opção 2
                saldoo = saldo;// saldoo recebe o valor de saldo
                saldo = deposite(yas, a, Extrato, saldo, ocorrencia);//chama a função para fazer um deposito
                if (saldoo<saldo){//se saldoo for menor que saldo quer dizer que aconteceu um depósito
                    ocorrencia ++;//aumenta o número de ocorrencias
                }
                opcoes(a); //mostra as opções pro usuário
            //coloca uma linha de 50 caracteres
            for (int i = 0; i < 50; i++){
                System.out.printf("%c", a);
            }
            System.out.printf("\n");//para pular uma linha
            System.out.printf("--> ");//mostra uma seta pra receber a opção escolhida pelo usuário
            }else if (n == 3){//se o usuário escolher a opção 3
                saldoo = saldo; //saldoo recebe o valor de saldo
                saldo = sacar(yas, a, Extrato, saldo, ocorrencia);//chama a função para fazer um saque
                if (saldoo<saldo){//se saldoo for maior que saldo quer dizer que aconteceu um saque
                    ocorrencia ++;//aumenta o número de ocorrencias
                }
                opcoes(a); //mostra as opções pro usuário
            //coloca uma linha de 50 caracteres
            for (int i = 0; i < 50; i++){
                System.out.printf("%c", a);
            }
            System.out.printf("\n");//para pular uma linha
            System.out.printf("--> ");//mostra uma seta pra receber a opção escolhida pelo usuário
            }
        }
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            System.out.printf("%c", a);
        }
        System.out.printf("\n");//para pular uma linha



        
        yas.close();
    }
}
