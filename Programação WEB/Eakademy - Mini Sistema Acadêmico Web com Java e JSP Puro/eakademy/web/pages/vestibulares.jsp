<%-- 
    Document   : index
    Created on : 27/02/2019, 21:13:44
    Author     : Pedro Davi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Vestibulares</title>   

        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>     
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    </head>

    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">

                <!-- logotipo que fica no canto da navbar, h1 titulo, 
                mb-0 (margin-bottom) tira a margem abaixo-->
                <a class="navbar-brand h1 mb-0" href="#">RokoAcademy</a>

                <!-- botão para navbar recolher ou não, classe navbar-toggler-->
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
                    <!-- sinal de recolhimento do botão - menu hamburguer -->
                    <span class="navbar-toggler-icon"></span>
                </button>

                <!-- referenciando ao navbar bootstrap e evento de recolhimento -->
                <div class="collapse navbar-collapse" id="navbarSite">
                    <!-- conteúdo do menu - lista, mr-auto alinhada a esquerda -->
                    <ul class="navbar-nav mr-2 mr-auto">
                        <!-- indicando que é item da navbar -->

                        <li class="nav-item">
                            <!-- indicando que é um link da navbar -->
                            <a class="nav-link" href="../login.jsp">Sair</a></li>
                    </ul>
                </div>	
            </div>
        </nav>
        
        <!-- carrosel -->
        <div id="carouselSite" class="carousel slide" data-ride="carousel">

            <!-- indicadores dos slides -->
            <ol class="carousel-indicators">
                <!-- itens da lista com o id do carrosel -->
                <li data-target="#carouselSite" data-slide-to="0" class="active"></li>
                <li data-target="#carouselSite" data-slide-to="1"></li>
                <li data-target="#carouselSite" data-slide-to="2"></li>
            </ol>

            <div class="carousel-inner">

                <!-- item do carrosel - imagens, classe active pra definir qual
                imagem aparecerá primeiro -->
                <div class="carousel-item active">
                    <!-- img-fruild pra imagem ocupadar todo espaço,
                    classe dblock ocupa todo espaço em várias dimensões de tela-->
                    <img src="../res/img/slides/slide-01.jpg" class="img-fluid d-block" alt="First slide">
                    <!-- legenda pro slide -->
                    <!-- d-none pra esconder texto quando tela for menor que md-block -->
                    <div class="carousel-caption d-none d-md-block text-dark">
                        <h5></h5>
                        <p></p>
                    </div>
                </div>

                <div class="carousel-item">
                    <!-- img-fruild pra imagem ocupadar todo espaço,
                    classe dblock ocupa todo espaço em várias dimensões de tela-->
                    <img src="../res/img/slides/slide-02.jpg" class="img-fluid d-block" alt="Second slide">
                    <!-- legenda pro slide -->
                    <!-- d-none pra esconder texto quando tela for menor que md-block -->
                    <div class="carousel-caption d-none d-md-block text-dark">
                        <h5></h5>
                        <p></p>
                    </div>
                </div>

                <div class="carousel-item">
                    <!-- img-fruild pra imagem ocupadar todo espaço,
                    classe dblock ocupa todo espaço em várias dimensões de tela-->
                    <img src="../res/img/slides/slide-03.jpg" class="img-fluid d-block" alt="Third slide">
                    <!-- legenda pro slide -->
                    <!-- d-none pra esconder texto quando tela for menor que md-block -->
                    <div class="carousel-caption d-none d-md-block text-dark">
                        <h5></h5>
                        <p></p>
                    </div>
                </div>

            </div>

            <!-- controle carrosel anterior -->
            <a class="carousel-control-prev" href="#carouselSite" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Anterior</span>
            </a>
            <!-- controle carrosel próximo -->
            <a class="carousel-control-next" href="#carouselSite" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Próximo</span>
            </a>

        </div>
    

    </body>
</html>