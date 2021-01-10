<%@page import="br.com.rokobasi.eakademy.model.Curso"%>
<%@page import="java.util.List"%>
<%@page import="br.com.rokobasi.eakademy.dao.CursoDAO"%>
<%@page import="br.com.rokobasi.eakademy.model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Cadastrar Coordenador</title>

        <!-- Bootstrap Core CSS -->
        <link href="../../res/css/bootstrap.min.css" rel="stylesheet">
        
        <!-- MetisMenu CSS -->
        <link href="../../res/css/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../../res/css/startmin.css" rel="stylesheet">
        
        <!-- Custom Fonts -->
        <link href="../../res/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        
        <!-- My Custom Javascript -->
        <script src="../../res/js/javascript.js"></script>

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp"><img src="../../res/img/logoEakademy.svg" style="width: 150px;"/></a>
                </div>

                
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                

                <ul class="nav navbar-nav navbar-left navbar-top-links">
                    <li><a href="http://www.rokobasi.com.br/"><i class="fa fa-home fa-fw"></i> Website</a></li>
                </ul>

                <ul class="nav navbar-right navbar-top-links">

                    <!-- função de notificações
                    <li class="dropdown navbar-inverse">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell fa-fw"></i> <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-comment fa-fw"></i> New Comment
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small">12 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> Message Sent
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-tasks fa-fw"></i> New Task
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                    -->

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> ${login.nome} <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> Perfil</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configurações</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="javascript://" onclick="logout();"><i class="fa fa-sign-out fa-fw"></i> Encerrar Sessão</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">

                            <!-- botão de pesquisa
                            <li class="sidebar-search">
                                <div class="input-group custom-search-form">
                                    <input type="text" class="form-control" placeholder="Search...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </span>
                                </div>
                            <!-- /input-group -->
                            <!--
                            </li>-->


                            <!-- botão dashboard 
                            <li>
                                <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                            </li>
                            -->
                            <!-- icone de grafico fa fa-bar-chart-o fa-fw -->

                            <li>
                                <a href="#"><i class="fa fa-edit fa-fw"></i> Cadastrar<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="cadastrarCurso.jsp">Curso</a>
                                    </li>
                                    <li>
                                        <a href="cadastrarCoordenador.jsp">Coordenador</a>
                                    </li>
                                    <li>
                                        <a href="cadastrarVestibular.jsp">Vestibular</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>

                            <li>
                                <a href="#"><i class="fa fa-table fa-fw"></i> Visualizar<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="listaDeCoordenadores.jsp">Coordenadores</a>
                                    </li>
                                    <li>
                                        <a href="listaDeProfessores.jsp">Professores</a>
                                    </li>
                                    <li>
                                        <a href="listaDeAlunos.jsp">Alunos</a>
                                    </li>
                                    <li>
                                        <a href="listaDeUsuarios.jsp">Todos</a>
                                    </li>
                                    <li>
                                        <a href="listaDeVestibular.jsp">Vestibulares</a>
                                    </li>
                                    <li>
                                        <a href="listaDeCursos.jsp">Cursos</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>

                            <!--
                            <li>
                                <a href="forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="panels-wells.html">Panels and Wells</a>
                                    </li>
                                    <li>
                                        <a href="buttons.html">Buttons</a>
                                    </li>
                                    <li>
                                        <a href="notifications.html">Notifications</a>
                                    </li>
                                    <li>
                                        <a href="typography.html">Typography</a>
                                    </li>
                                    <li>
                                        <a href="icons.html"> Icons</a>
                                    </li>
                                    <li>
                                        <a href="grid.html">Grid</a>
                                    </li>
                                </ul>
                            <!-- /.nav-second-level -->
                            <!--
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="#">Second Level Item</a>
                                    </li>
                                    <li>
                                        <a href="#">Second Level Item</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level <span class="fa arrow"></span></a>
                                        <ul class="nav nav-third-level">
                                            <li>
                                                <a href="#">Third Level Item</a>
                                            </li>
                                            <li>
                                                <a href="#">Third Level Item</a>
                                            </li>
                                            <li>
                                                <a href="#">Third Level Item</a>
                                            </li>
                                            <li>
                                                <a href="#">Third Level Item</a>
                                            </li>
                                        </ul>
                            <!-- /.nav-third-level -->
                            <!--    
                            </li>
                        </ul>
                            <!-- /.nav-second-level -->
                            <!--
                            </li>
                            <li class="active">
                                <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a class="active" href="blank.html">Blank Page</a>
                                    </li>
                                    <li>
                                        <a href="login.html">Login Page</a>
                                    </li>
                                </ul>
                            <!-- /.nav-second-level -->
                            <!--
                            </li>-->
                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">CADASTRAR COORDENADOR</h1>
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->


                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Informações para cadastro
                                </div>

                                <!-- lado esquerdo painel -->
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            
                                            <form role="form" name="cadCoordenador" action="../../cadCoordenador" method="post">

                                                <div class="form-group">
                                                    <label>Nome</label>
                                                    <input type="text" name="nome" class="form-control" placeholder="Nome do Coordenador">
                                                </div>

                                                <div class="form-group">
                                                    <label>CPF</label>
                                                    <input type="text" name="cpf" class="form-control" placeholder="000.000.000-00" onkeydown="javascript: fMasc(this, mCPF);">
                                                </div>

                                                <div class="form-group">
                                                    <label>Endereço</label>
                                                    <input type="text" name="endereco" class="form-control" placeholder="Rua / Número / Bairro / Cidade / Estado">
                                                </div>

                                                <div class="form-group">
                                                    <label>Email</label>
                                                    <input type="text" name="email" class="form-control" placeholder="email@email.com">
                                                </div>
                                                
                                                <div class="form-group">
                                                    <label>Telefone</label>
                                                    <input type="text" name="telefone" class="form-control" placeholder="(00)90000-0000">
                                                </div>

                                                <div class="form-group">
                                                    <label>Email</label>
                                                    <input type="password" name="senha" class="form-control" placeholder="Digite a senha">
                                                </div>
                                                
                                                <!-- PEGAR ID DO CURSO PARA PASSAR NO POST -->
                                                <% 
                                                    CursoDAO dao = new CursoDAO();
                                                    List<Curso> cursos = dao.getAll();
                                                %>

                                                <div class="form-group">
                                                    <label>Cursos</label>
                                                    <select name="curso" class="form-control">
                                                        <%for(Curso curso : cursos){%>    
                                                        <option value=<%=curso.getId()%>><%=curso.getNome()%></option>
                                                        <%}%>  
                                                    </select>
                                                </div>
                                                    
                                                <!-- PASSANDO PERFIL COORDENADOR ESCONDIDO -->
                                                <input type="hidden" value="coordenador" name="perfil"/>
                                                
                                                <div class="form-group">
                                                    <input type="hidden" value="cadastrarCoordenador" name="param"/>
                                                    <button type="submit" class="btn btn-success">Cadastrar</button>
                                                    <button type="reset" class="btn btn-danger">Cancelar</button>     
                                                </div>
                                                
                                            </form>
                                        </div>

                                        <!-- /.col-lg-6 (nested) LADO DIREITO PAINEL -->
                                        
                                        <div class="col-lg-6">

                                        </div>
                                        <!-- /.col-lg-6 (nested) -->
                                    </div>


                                </div>
                                <!-- /.container-fluid -->
                            </div>
                            <!-- /#page-wrapper -->

                        </div>
                        <!-- /#wrapper -->

                        <!-- jQuery -->
                        <script src="../../res/js/jquery.min.js"></script>

                        <!-- Bootstrap Core JavaScript -->
                        <script src="../../res/js/bootstrap.min.js"></script>

                        <!-- Metis Menu Plugin JavaScript -->
                        <script src="../../res/js/metisMenu.min.js"></script>

                        <!-- Custom Theme JavaScript -->
                        <script src="../../res/js/startmin.js"></script>

                        </body>
                        </html>
