import cv2
import os
import numpy as np

lbph = cv2.face.LBPHFaceRecognizer_create()

# função pra retornar todas as imagens e todos os ids e matrizes de pixels das imagens
# varrendo o diretório das imagens capturadas
def getImagemComId():

    caminhos = [os.path.join('fotos', f) for f in os.listdir('fotos')] # percorrendo o diretório de onde as fotos estão armazenadas
    faces = []
    ids = []

    for caminhoImagem in caminhos: # fazendo a leitura de cada uma das imagens do diretório de treinamento

        # convertendo novamente em cinza pro classificador trabalhar melhor
        imagemFace = cv2.cvtColor(cv2.imread(caminhoImagem), cv2.COLOR_BGR2GRAY)

        # pegar os ids e jogar na lista
        # [-1].split('.')[1] > codificação pra quebrar os pontos e pegar apenas os ids
        id = int(os.path.split(caminhoImagem) [-1].split('.')[1])

        #print(id)
        ids.append(id)
        faces.append(imagemFace)

        # mostrar foto
        #cv2.imshow("Face", imagemFace)
        #cv2.waitKey(10000)

    return np.array(ids), faces # numpy retornando os ids e as imagens em si

ids, faces = getImagemComId()

# TREINAMENTO
print("Treinando...")

# algortimo LBPH, fazendo treinamento e escrevendo o classificador yml
lbph.train(faces, ids)
lbph.write('classificadorLBPH.yml')

print("Treino realizado!")
