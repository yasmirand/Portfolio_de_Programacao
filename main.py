'''
* Autor: Yasmin Lara Amanajás de Miranda
* Linguagem: Python
* Data: 04/12/2024
* Descrição: Simuldor de caixa eletrônico
* Funcionalidades: 
* - Entra com nome e senha 
* - Exibe Extrato/Saldo
* - Realizar depósito e Saque
* Versão: 1.0
'''
import random #importa a biblioteca para sortear um número aleatório para ser o saldo inicial do usuário
import time #importa a biblioteca para utilizar o temporizador

def inicio():#uma função para iniciar o código
    nome = entrar() #armazena o nome do usuário
    print(f"{"*"} Bem-vindo(a) {nome}! {"*"}") #uma mensagem de bem vindo para o usuário
    saldo, Extrato = atualizar_saldo() #atualiza o saldo e o extrato do usuário
    n = 0 #anula o valor da variável n
    while n != 4: #o código vai continuar sendo executado enquanto o usuário não digitar 4
        opcoes()# mostra o quadro de opções
        print(f"{"*"*50}") #coloca uma linha de 50 caracteres
        n = int(input("--> ")) #recebe a opção que o usuário escolheu
        if n == 1: #se o usuário escolher a opção 1
            mostrar_extrato(Extrato, saldo) #o saldo atual e o extrato será mostrado ao usuário
        elif n == 2: #se o usuário escolher a opção 2
            Extrato, saldo = deposite(Extrato, saldo) #o usuário irá depositar algum valor em sua conta
        elif n == 3: #se o usuário escolher a opção 3
            Extrato, saldo = sacar(Extrato, saldo) #o usuário poderá sacar algum valor de sua conta
    print(f"{"*"*50}") #coloca uma linha de 50 caracteres

def entrar():#função para receber o nome e a senha do usuário
    print(f"{"*"*50}")#coloca uma linha de 50 caracteres
    nome = input("Digite seu nome: ") #para receber o nome do usuário
    senha = int(input("Insira sua senha de quatro dígitos: "))#para receber a senha do usuário
    print(f"{"*"*50}")#coloca uma linha de 50 caracteres
    return nome #retorna o nome do usuário

def atualizar_saldo():#função criada para determinar o saldo inicial do usuário
    saldo = random.uniform(0.50, 2000)#sorteia um número para ser o saldo inicial do usário
    Extrato=[] #para limpar o extrato
    return saldo, Extrato#retorna o extrato e o saldo do usuário

def opcoes(): #função para mostrar ao usuário as opções que ele tem
    print(f"{"*"*50}")#coloca uma linha de 50 caracteres
    print("Escolha uma opção:") #apresenta as opções que usuário pode executar
    print("1 --> Extrato/Saldo")# diz que se o usuário escolher a opção 1, ele irá ver o saldo e o extrato dele
    print("2 --> Deposito") # diz ao usuário que se ele escolher a opção 2, ele poderá fazer um depósito
    print("3 --> Saque") # diz ao usuário que se ele escolher a opção 3, ele poderá fazer um saque
    print("4 --> Sair") #diz que se ele escolher a opção 4, o codigo vai parar

def mostrar_extrato(Extrato, saldo): #função para mostrar o saldo atual e o extrato do usuário
    print(f"{"*"*20}")#coloca uma linha de 20 caracteres
    print(f"Seu Saldo: {saldo:.2f}")# mostra ao usuário o saldo atual dele
    print(f"{"*"*20}")#coloca uma linha de 20 caracteres
    for elemento in Extrato: #a ação irá se repitir para cada elemento na lista Extrato, vai mostrar o extrato
        print(f"{elemento}") # impeime o elemento do extrato
        print(f"{"*"*20}")#coloca uma linha de 20 caracteres
    time.sleep(7)#um temporizador de 7 segundos
    print("\n") #para pular uma linha

def deposite(Extrato, saldo):# função para o usuário fazer um depósito
    print(f"{"*"*50}")#coloca uma linha de 50 caracteres
    deposito = float(input("Digite o valor que deseja depositar: "))#pede ao usuário que ele informe qual o valor do depósito
    print(f"{"*"*50}")#coloca uma linha de 50 caracteres
    time.sleep(3) #intervalo de 3 segundos
    saldo += deposito #o saldo recebe o saldo mais o valor do depósito
    Extrato.append(deposito) #adiciona a informação de que aconteceu um depósito ao extrato
    print(f"{"*"*50}")#coloca uma linha de 50 caracteres
    print("Seu Saldo foi atualizado!")#informa ao usuário que o saldo foi atualizado
    print(f"Seu Saldo: {saldo:.2f}")#mostra o novo saldo do usuário
    print(f"{"*"*50}")#coloca uma linha de 50 caracteres
    print("\n") #para pular uma linha
    time.sleep(5) #pausa de 5 segundos
    return Extrato, saldo #retorna o saldo e o extrato do usuário
    
def sacar(Extrato,saldo): # função para o usuário fazer um saque
    print(f"{"*"*50}")#coloca uma linha de 50 caracteres
    saque = float(input("Digite o valor do saque: ")) #pede ao usuário que ele informe o valor do saque
    print(f"{"*"*50}")#coloca uma linha de 50 caracteres
    time.sleep(3) #intervalo de 3 segundos
    if saque <= saldo: # se o valor do saque for menor ou igual ao saldo
        saldo -= saque # o saldo recebe o saldo menos o saque
        Extrato.append(saque*-1) #informa ao extrato que aconteceu um saque
        print(f"{"*"*50}")#coloca uma linha de 50 caracteres
        print("Seu Saque foi autorizado!") # diz ao usuário que o saque foi autorizado
        print(f"Seu Saldo: {saldo:.2f}") #mostar o novo saldo do usuário
        print(f"{"*"*50}")#coloca uma linha de 50 caracteres
        print("\n") #para pular uma linha
        time.sleep(5) #temporizador de 5 segundos
        return Extrato, saldo #retorna o extarto e o saldo do usuário
    else: #se o valor for maior que o saldo
        time.sleep(2) #intervalo de 2 segundos
        print(f"{"*"*50}")#coloca uma linha de 50 caracteres
        print("Seu Saque foi NEGADO!") #informa ao usuário que o saque foi negado
        print(f"O valor excedeu seu saldo!") #diz que o valor do saque é mair que o saldo
        print(f"{"*"*50}")#coloca uma linha de 50 caracteres
        print("\n") #para pular uma linha
        time.sleep(5) #intervalo de 5 segundos
        return Extrato, saldo #retorna o extarto e o saldo do usuário
   
inicio()#chama a função inicio para iniciar o código