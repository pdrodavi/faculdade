import cv2
import vox

detectorFace = cv2.CascadeClassifier("haarcascade_frontalface_default.xml") # carregando o classificador har xml
reconhecedor = cv2.face.LBPHFaceRecognizer_create() # instanciando o algortimo LBPH
reconhecedor.read("classificadorLBPH.yml") # carregando o classificador criado com o treinamento
largura, altura = 220, 220
font = cv2.FONT_HERSHEY_COMPLEX_SMALL # fonte apresentada no boundingbox
#camera = cv2.VideoCapture(0) # captura da camera
camera = cv2.VideoCapture('http://192.168.43.1:8080/video') # captura da camera

while (True):

    conectado, imagem = camera.read() # abrindo camera
    imagemCinza = cv2.cvtColor(imagem, cv2.COLOR_BGR2GRAY) # transformando imagem em tons de cinza para trabalhar melhor
    # é uma função geral que detecta objetos. Como estamos chamando isso na cascata do rosto, é isso que ele detecta.
    facesDetectadas = detectorFace.detectMultiScale(imagemCinza, scaleFactor=1.5, minSize=(30,30))

    for (x, y, l, a) in facesDetectadas:

        # redimensionamento da imagem pra o padrão pre-definido
        imagemFace = cv2.resize(imagemCinza[y:y + a, x:x + l], (largura, altura))
        # formando o bouding box, passando a imagem, coordenadas x, y, altura e largura pra formar os pontos
        cv2.rectangle(imagem, (x, y), (x + l, y + a), (0,0,255), 2)
        id, confianca = reconhecedor.predict(imagemFace) # passando a imagem capturada para o construtor do algortimo LBPH

        nome = ""

        if id == 1:
            nome = 'Pedro'
            vox.vox(nome) # aqui ele dispara o método da assistente virtual
        elif id == 2:
            nome = 'Davi'
        else:
            nome = 'Desconhecido no sistema' # caso não possua ID compatível mostra rosto desconhecido

        # colocando nome na imagem a partir da posição passada, passando a fonte desejada, tamanho de borda e cor
        cv2.putText(imagem, nome, (x,y +(a+30)), font, 2, (0,0,255))
        # colocando a porcentagem de confiança daquele resulto com os demais parametros sendo os mesmos acima
        cv2.putText(imagem, str(confianca), (x,y + (a+50)), font, 1, (0,0,255))

    cv2.imshow("Face", imagem) # mostrando imagem
    if cv2.waitKey(1) == ord('q'): # quando apertar q sai da janela
        break

camera.release()
cv2.destroyAllWindows() # destroi a janela de exibição