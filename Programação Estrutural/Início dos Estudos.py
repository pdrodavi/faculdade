# Pedro davi Dantas da Silva

op = int(input("Informe a questão que deseja testar: "))

# Início Questão 01

if op == 1:

    Lista_Original = []
    Lista_num_pares = []
    Lista_num_impares = []

    while True:
        n = int(input("Digite um número (-1 para sair): "))
        if n == -1:
            break
        Lista_Original.append(n)

        if n % 2 == 0:
            Lista_num_pares.append(n)
        else:
            Lista_num_impares.append(n)

    print("Lista Original =", Lista_Original)
    print("Lista Par = ", Lista_num_pares)
    print("Lista Impar =", Lista_num_impares)

# Fim Questão 01

# Início Questão 02

if op == 2:
    deposito = float(input("Qual o valor do deposito? "))
    juros = float(input("Qual a taxa de juros? "))
    tj = float(deposito * juros / 100)
    tempo_aplicação = int(input("Tempo de aplicação? "))
    tempo = int(tempo_aplicação * 12)
    rendimento1 = (int(tempo) * (float(tj)))
    valorT = (deposito + rendimento1)

    if tempo < 36:
        print("O tempo de investimento precisa ser superior a 3 anos")

    if tempo > 120:
        print("O tempo de investimento precisa ser superior a 10 anos e inferior a 3 anos")

    if rendimento1 > 1000:
        print("Investimento adequado")

    print(deposito)
    print(juros)
    print(rendimento1)
    print(valorT)

# Fim Questão 02

# Início Questão 03

if op == 3:
    Lista_de_medias = []

    # aluno1

    primeiro_nota1 = int(input("Qual a primeira nota do primeiro aluno? "))
    primeiro_nota2 = int(input("Qual a segunda nota do primeiro aluno? "))
    primeiro_nota3 = int(input("Qual a terceira nota do primeiro aluno "))

    primeiro_media = (primeiro_nota1 + primeiro_nota2 + primeiro_nota3) / 3

    Lista_de_medias.append(primeiro_media)

    # aluno2

    segundo_nota1 = int(input("Qual a primeira nota do segundo aluno? "))
    segundo_nota2 = int(input("Qual a segunda nota do segundo aluno? "))
    segundo_nota3 = int(input("Qual a terceira nota do segundo aluno "))

    segundo_media = (segundo_nota1 + segundo_nota2 + segundo_nota3) / 3

    Lista_de_medias.append(segundo_media)

    # aluno3

    terceiro_nota1 = int(input("Qual a primeira nota do terceiro aluno? "))
    terceiro_nota2 = int(input("Qual a segunda nota do terceiro aluno? "))
    terceiro_nota3 = int(input("Qual a terceira nota do terceiro aluno "))

    terceiro_media = (terceiro_nota1 + terceiro_nota2 + terceiro_nota3) / 3

    Lista_de_medias.append(terceiro_media)

    # aluno4

    quarto_nota1 = int(input("Qual a primeira nota do quarto aluno? "))
    quarto_nota2 = int(input("Qual a segunda nota do quarto aluno? "))
    quarto_nota3 = int(input("Qual a terceira nota do quarto aluno "))

    quarto_media = (quarto_nota1 + quarto_nota2 + quarto_nota3) / 3

    Lista_de_medias.append(quarto_media)

    # aluno5

    quinto_nota1 = int(input("Qual a primeira nota do quinto aluno? "))
    quinto_nota2 = int(input("Qual a segunda nota do quinto aluno? "))
    quinto_nota3 = int(input("Qual a terceira nota do quinto aluno "))

    quinto_media = (quinto_nota1 + quinto_nota2 + quinto_nota3) / 3

    Lista_de_medias.append(quinto_media)

    print("As respctivas médias são: ", Lista_de_medias)

    # Situação aluno1

    if Lista_de_medias[0] >= 7:
        print("O aluno 1 está aprovado por média.")

    elif Lista_de_medias[0] < 5:
        print("O aluno 1 está reprovado.")

    elif Lista_de_medias[0] < 7 and Lista_de_medias[0] >= 5:
        print("O aluno 1 está apto para final.")

    # Situação aluno2

    if Lista_de_medias[1] >= 7:
        print("O aluno 2 está aprovado por média.")

    elif Lista_de_medias[1] < 5:
        print("O aluno 2 está reprovado.")

    elif Lista_de_medias[1] < 7 and Lista_de_medias[0] >= 5:
        print("O aluno 2 está apto para final.")

    # Situação aluno3

    if Lista_de_medias[2] >= 7:
        print("O aluno 3 está aprovado por média.")

    elif Lista_de_medias[2] < 5:
        print("O aluno 3 está reprovado.")

    elif Lista_de_medias[2] < 7 and Lista_de_medias[0] >= 5:
        print("O aluno 3 está apto para final.")

    # Situação aluno4

    if Lista_de_medias[3] >= 7:
        print("O aluno 4 está aprovado por média.")

    elif Lista_de_medias[3] < 5:
        print("O aluno 4 está reprovado.")

    elif Lista_de_medias[3] < 7 and Lista_de_medias[0] >= 5:
        print("O aluno 4 está apto para final.")

    # Situação aluno5

    if Lista_de_medias[4] >= 7:
        print("O aluno 5 está aprovado por média.")

    elif Lista_de_medias[4] < 5:
        print("O aluno 5 está reprovado.")

    elif Lista_de_medias[4] < 7 and Lista_de_medias[0] >= 5:
        print("O aluno 5 está apto para final.")

# Fim Questão 03

# Início Questão 04

if op == 4:

    cod = int(input("Informe o código do empregado: "))
    nasc = int(input("Informe o ano de nascimento: "))
    ingresso = int(input("Informe o ano de ingresso na empresa: "))

    idade = 2016 - nasc
    temp_trabalho = (2016 - ingresso)

    print("Código do funcionário: ", cod, "\nIdade do funcionário: ", idade, "anos", "\nTempo de trabalho:",
          temp_trabalho, "anos")

    if idade >= 70:
        print("Requerer aposentadoria do empregado")
    elif temp_trabalho >= 30:
        print("Requerer aposentadoria do empregado")
    elif idade >= 65 and temp_trabalho >= 30:
        print("Requerer aposentadoria do empregado")
    else:
        print("Não requerer aposentadoria do empregado")

# Fim Questão 04

# Início Questão 05

if op == 5:

    quant = int(input("Qual a quantidade de mercadorias no estoque? "))

    v = 0
    v2 = 1
    v3 = 0

    while v < quant:
        valor_mercadoria = float(input("Qual o valor da mercadoria %d: " % v2))
        v += 1
        v2 += 1
        v3 = v3 + valor_mercadoria

    print("Valor total em estoque R$:", v3)
    print("Média de valor das mercadorias: ", valor_mercadoria / quant)

    if quant > 9:
        print("Estoque adequeado a situação atual.")
    else:
        print("Estoque inadequado a situação atual.")

# Fim Questão 05

