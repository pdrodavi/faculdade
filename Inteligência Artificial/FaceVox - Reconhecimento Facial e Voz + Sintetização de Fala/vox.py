def vox(nome):

    import speech as sr  # módulo de reconhecimento de voz
    import os  # módulo da api do windows
    from datetime import datetime  # módulo para hora e data
    import pyttsx3  # módulo para sintetização de voz

    en = pyttsx3.init() # inicializando sintetizador em variável para ser utilizado
    en.setProperty('rate', 150) # definindo velocidade de fala em 150
    en.setProperty('volume', 1) # definindo voluma da fala que varia de 0.1 a 1.0
    en.setProperty('voice', b'brazil') # definindo idioma da fala

    recon = sr.Recognizer() # inicializando o módulo de reconhecimento de voz em variável

    agora = datetime.now() # data e horário presente
    hora = agora.hour # extraindo hora
    minutos = agora.minute # extraindo minuto

    texto = "Olá " + str(nome) + " seja bem vindo, agora são " + str(hora) + " horas e " + str(minutos) + " minutos, eu sou a jarvis versão feminina, o que deseja fazer?"

    en.say(texto) # sintetizando o texto guardado na variável texto
    en.runAndWait() # método rode e aguarde uma resposta

    recon = sr.Recognizer() # iniciando o método speech recognize na variável recon

    with sr.Microphone() as source: # fazendo a captura do microfone padrão do notebook e atribindo a variável source

        while True:

            print("Dê alguma ordem: ")
            audioOrdem = recon.listen(source) # lê a captura do microfone e transforma o texto falado em escrito, atribuindo a variavel

            try:

                cont = 0

                resposta = recon.recognize_google(audioOrdem, language='pt-BR') # utilizando a API para passar o código e informar que é português brasileiro
                print(recon.recognize_google(audioOrdem, language='pt-BR')) # printando em texto o que foi falado

                # aqui seria o dataset da assistente, podendo ser ifs, arrays ou até mesmo um banco de dados
                if resposta == "Abrir agenda":
                    print("Você disse: ", resposta)
                    en.say("Estou abrindo sua agenda!")
                    os.system(r'C:\agenda.txt')
                    break

                elif resposta == "toque minha música favorita":
                    print("Você disse: ", resposta)
                    en.say("Curta sua música favorita!")
                    os.system(r'C:\Godfather.mp3')
                    break

                elif resposta == "fechar":
                    print("Você disse: ", resposta)
                    en.say("Tchau, tchau, até logo!")
                    break

                elif resposta == "abrir meu Facebook":
                    os.system("start www.facebook.com")
                    break

                elif resposta == "abrir meu email":
                    os.system("start www.gmail.com")
                    break

                elif resposta == "desligar o computador em uma hora":
                    os.system("shutdown -s -t 3600")
                    break

                elif resposta == "desligar o computador":
                    os.system("shutdown -s")
                    break

                else: # caso o que você peça não esteja no dataset ela não realiza e sintetiza essa frase com o método en.say
                    en.say("Infelizmente não tenho acesso ao que me pediu! Me peça outra coisa.")
                    en.runAndWait()

            except sr.UnknownValueError: # exceção caso o microfone não consiga captar uma palavra

                if cont == 0:
                    cont = cont + 1
                    print(cont)
                    en.say("Não consegui entender o que você me disse, por favor, repita!")
                    en.runAndWait()

                if cont > 0:
                    en.say("Novamente eu não conseguir entender o que você me disse, por favor, repita mais uma vez!")
                    en.runAndWait()

            except sr.RequestError as e: # exceção caso o microfone não consiga acessar a api google
                en.say("Não consegui iniciar, talvez a sua internet esteja muito lenta para se comunicar comigo. Estou triste. Tente de novo!")
                en.runAndWait()


# teste separado do reconhecedor de faces
#nome = 'Pedro'
#vox(nome)

