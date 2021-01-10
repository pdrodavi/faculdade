import cv2
import numpy as np

classificador = cv2.CascadeClassifier("haarcascade_frontalface_default.xml") # carregando a classificador haar
classificadorOlho = cv2.CascadeClassifier("haarcascade_eye.xml") # carregando classificador haar de olho

# camera > IP Web Cam - config através do endereço
#camera = cv2.VideoCapture('http://192.168.43.1:8080/video') # capturar imagem na webcan > parametro 0 camera padrão do notebook
camera = cv2.VideoCapture(0) # captura da camera

#captura das imagens para treinamento
amostra = 1 # quantas fotos vão ser tiradas quando pressionar a tecla determinada
numeroAmostras = 25 # 25 fotos do rosto de cada pessoa
id = input("Digite o identificador: ") # id para identificar a pessoa no classificador, podendo conter o nome, etc
largura, altura = 220, 220 # tamanho da foto a ser tirada. 220x220 px.

while (True):

    conectado, imagem = camera.read() # carregando a captura da camera nas variáveis

    imagemCinza = cv2.cvtColor(imagem, cv2.COLOR_BGR2GRAY) # convertendo a imagem capturada em escala de cinza

    # chamando classificador, passando a imagem, a escala da imagem e o tamanho minimo de caputra de rosto
    # dependendo do scaleFactor o algortimo pode ser mais ou menos eficiente de acordo com o ambiente
    facesDetectadas = classificador.detectMultiScale(imagemCinza, scaleFactor=1.5, minSize=(30, 30))

    for(x, y, l, a) in facesDetectadas:

        # desenhando o boudingbox com as coordenadas, cor do retangulo e largura de borda
        cv2.rectangle(imagem, (x,y), (x + l, y + a), (0,0,255), 2)

        # região dos olhos
        regiao = imagem[y:y + a, x:x + l] # eixo y + altura e eixo x + largura
        regiaoCinzaOlho = cv2.cvtColor(regiao, cv2.COLOR_BGR2GRAY) # conversão em escala de cinza
        olhosDetectados = classificadorOlho.detectMultiScale(regiaoCinzaOlho) # aplicando classificador na região do olho em escala de cinza

        #desenhando o boudingbox dos olhos
        for(ox, oy, ol, oa) in olhosDetectados:

            # ox e oy = ponto incial e ponto final onde se vai formar a boundingbox
            cv2.rectangle(regiao, (ox, oy), (ox + ol, oy + oa), (0, 255, 0), 1)

            # guardando os rostos capturados
            if cv2.waitKey(1) & 0xFF == ord('q'): # quando apertar a tecla q ele executa a instrução dentro do if (tirar a foto)

                # controlando a média de brilho, pra gravar apenas em ambientes luminosos para foto não sair ruim
                if np.average(imagemCinza) > 110:

                    # redimensionando a imagem para alturar e largura pre definida
                    imagemFace = cv2.resize(imagemCinza[y:y + a, x:x + l], (largura, altura))

                    #gravando a imagem em disco
                    cv2.imwrite("fotos/pessoa." + str(id) + "." + str(amostra) + ".jpg", imagemFace)
                    print("[foto " + str(amostra) + " capturada com sucesso]")
                    amostra += 1 # incremento para salvar a outra foto com outro numero

    cv2.imshow("Face", imagem) # mostrando em caixa a imagem
    #cv2.waitKey(1)

    # parar captura de tela se a quantidade de fotos for igual ou maior ao numero pre-definido
    if(amostra >= numeroAmostras + 1):
        break

print("Faces capturadas com sucesso!")
camera.release()
cv2.destroyAllWindows() # destroi janela do window