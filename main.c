/*
* Autor: Yasmin Lara Amanajás de Miranda
* Linguagem: C
* Data: 08/12/2024
* Descrição: Simuldor de caixa eletrônico
* Funcionalidades: 
* - Entra com nome e senha 
* - Exibe Extrato/Saldo
* - Realiza depósito e Saque
* Versão: [1.0]
*/

#include <stdio.h>//biblioteca da linguagem C
#include <stdlib.h>//biblioteca para sortear  
#include <time.h>//biblioteca para importar o temporizador

void entrar(char a){//função para receber o nome e a senha do usuário
    char nome[50];//declara que a variavel nome é do tipo char e o tamanho é 50
    int senha;//declara a variavel senha como inteiro
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    printf("Digite seu nome: ");//mostra uma mensagem pedindo para o usuário escrever o nome
    scanf("%s", nome);//armazena o nome do usuário
    printf("Insira sua senha de quatro dígitos: ");//mostra uma mensagem pedindo para o usuário inserir a senha
    scanf("%d", &senha);//armazena a senha do usuário
    printf("\n");//para pular uma linha
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    printf("* Bem-vindo(a) %s! *", nome);//mostra uma mensagem com o nome fornecido pelo usuário
    }

float atualizar_saldo(float *saldo){//função para atualizar o saldo inicial do usuário
    //para sortear um número entre 0 e 199999 
    srand(time(0));
    int sorteio =  rand()% 200000;
    *saldo = sorteio/100.0; //transforma o numero inteiro em um número decimal
}

void opcoes(char a){//função para mostrar ao usuário as opções que ele tem
    printf("\n");//para pular uma linha
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    printf("Escolha uma opção:\n");//apresenta as opções que usuário pode executar
    printf("1 --> Extrato/Saldo\n");//diz que se o usuário escolher a opção 1, ele irá ver o saldo e o extrato dele
    printf("2 --> Deposito\n");//diz ao usuário que se ele escolher a opção 2, ele poderá fazer um depósito
    printf("3 --> Saque\n");// diz ao usuário que se ele escolher a opção 3, ele poderá fazer um saque
    printf("4 --> Sair\n");//diz que se ele escolher a opção 4, o codigo vai parar
}

void mostrar_extrato(char a, float *Extrato, float saldo, int ocorrencia){//função para mostrar o saldo atual e o extrato do usuário
    //coloca uma linha de 20 caracteres
    for (int i = 0; i < 20; i++){
        printf("%c", a);
        }
    printf("\n");//para pular uma linha
    printf("Seu Saldo: %.2f\n", saldo);//mostra ao usuário o saldo atual dele
    //coloca uma linha de 20 caracteres
    for (int i = 0; i < 20; i++){
            printf("%c", a);
        }

    
    printf("\n");//para pular uma linha
    for (int i=0;i<=ocorrencia;i++){//pra imprimir o extrato
        printf("%.2f\n", Extrato[i]);//impeime o elemento do extrato
        //coloca uma linha de 20 caracteres
        for (int i = 0; i < 20; i++){
            printf("%c", a);
        }
        printf("\n");//para pular uma linha
    }
    sleep(5);//temporizador
    printf("\n");//para pular uma linha
}

float deposite(char a, float *Extrato, float *saldo, int *ocorrencia){//função para o usuário fazer um depósito
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    float deposito;//declara que a variável deposito é do tipo float
    printf("Digite o valor que deseja depositar: ");//mostra uma mensagem pedindo para o usuário escrever o valor que deseja depositar
    scanf("%f", &deposito);//armazena o valor do depósito
    *saldo += deposito;//adiciona o valor do depósito ao saldo do usuário
    Extrato[*ocorrencia] = deposito;//adiciona o valor do depósito ao extrato
    (*ocorrencia)++; //aumenta o número de ocorrencias
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    sleep(3);//temporizador
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    printf("Seu Saldo foi atualizado!\n");//avisa ao usuário que o saldo dele foi atualizado
    printf("Seu Saldo: %.2f\n", *saldo);//mostra o saldo atual do usuário
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    sleep(5);//temporizador
}

float sacar(char a, float *Extrato, float *saldo, int *ocorrencia){ // função para o usuário fazer um saque
    float saque;//declara que a variavel saque é do tipo float
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    printf("Digite o valor do saque: ");//pede ao usuário que digite o valor do saque
    scanf("%f", &saque);//armazena o valor do saque
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    sleep(3);//temporizador
    if (saque <= *saldo){//se o saldo for maior que o saque
        *saldo -= saque;// o valor do saque é retirado do saldo
        Extrato[*ocorrencia] = saque*-1;//adiciona o valor do depósito ao extrato
        (*ocorrencia) ++;//aumenta o número de ocorrencias
    //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
        printf("\n");//para pular uma linha
        printf("Seu Saque foi autorizado!\n");//avisa ao usuário que o saque foi autorizado
        printf("Seu Saldo: %.2f\n", *saldo);//mostra ao usuário seu saldo atual
    //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
        printf("\n");//para pular uma linha
        sleep(5);//temporizador
    }
    else{//se o valor do saque for maior que o saldo
        sleep(2);//temporizador
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
        printf("%c", a);
        }
        printf("\n");//para pular uma linha
        printf("Seu Saque foi NEGADO!\n");//avisa ao usuário que o saque foi negado
        printf("O valor excedeu seu saldo!\n");//diz ao usuário que o valor do saque é maior que o saldo
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
        printf("%c", a);
        }
        printf("\n");//para pular uma linha
        sleep(5);//temporizador
    }
}

int main(){
    char a='*';//declara que a variavel a é do tipo char e atribui a ela o caracter "*"
    int n=0, ocorrencia=0;//declara que a variavel n e a variavel ocorrencia são do tipo int e atribui a elas 0
    float saldo=0.0, Extrato[1000] = {0}; // declara que a variavel saldo e o array Extrato[1000] são do tipo float e atribui a ambos o valor 0

    entrar(a);//chama a função entrar
    atualizar_saldo(&saldo);//chama a função para atualizar o saldo inicial
    opcoes(a);//chama a função para mostrar o quadro de opções
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");//para pular uma linha
    printf("--> ");//mostra uma seta pra receber a opção escolhida pelo usuário
    while (n != 4){//o codigo continuara rodando enquanto a escolha do usuário for diferente de 4
        
        scanf("%d", &n);//recebe e garda o valor de n

        if (n == 1){//se o usuário escolher a opção 1
            mostrar_extrato(a, Extrato, saldo, ocorrencia);//chama a função para mostrar o extrato
            opcoes(a); //mostra as opções pro usuário
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            printf("%c", a);
        }
        printf("\n");//para pular uma linha
        printf("--> ");//mostra uma seta pra receber a opção escolhida pelo usuário
        }else if (n == 2){//se o usuário escolher a opção 2
            deposite(a, Extrato, &saldo, &ocorrencia);//chama a função para fazer um deposito
            opcoes(a); //mostra as opções pro usuário
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            printf("%c", a);
        }
        printf("\n");//para pular uma linha
        printf("--> ");//mostra uma seta pra receber a opção escolhida pelo usuário
        }else if (n == 3){//se o usuário escolher a opção 3
            sacar(a, Extrato, &saldo, &ocorrencia);//chama a função para fazer um saque
            opcoes(a); //mostra as opções pro usuário
        //coloca uma linha de 50 caracteres
        for (int i = 0; i < 50; i++){
            printf("%c", a);
        }
        printf("\n");//para pular uma linha
        printf("--> ");//mostra uma seta pra receber a opção escolhida pelo usuário
        }
    }
    //coloca uma linha de 50 caracteres
    for (int i = 0; i < 50; i++){
        printf("%c", a);
    }
    printf("\n");




    return 0;
}