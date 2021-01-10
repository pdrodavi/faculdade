/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 */

function validaformLogin() {
    if (document.login.cpf === "") {
        alert("O campo CPF é obrigatório!");
    }
    if (document.login.senha.value === "") {
        alert("O campo SENHA é obrigatório!");
    }
}

function logout(){
    if (window.confirm("Deseja realmente sair da sessão?")) {
        location.href = "../../logout";
    }
}

function logoutInServlet(){
    if (window.confirm("Deseja realmente sair da sessão?")) {
        location.href = "logout?";
    }
}

function disciplinasDoCurso(idCurso){
    location.href = "../../visDisciplinaCurso?&param=disciplinasDoCurso&id_curso="+idCurso;
}

function disciplinasDoCursoInServlet(idCurso){
    location.href = "visDisciplinaCurso?&param=disciplinasDoCurso&id_curso="+idCurso;
}

function professoresDoCurso(idCurso){
    location.href = "../../visProfessoresCurso?&param=professoresDoCurso&id_curso="+idCurso;
}

function professoresDoCursoInServlet(idCurso){
    location.href = "visProfessoresCurso?&param=professoresDoCurso&id_curso="+idCurso;
}

function turmasDoCurso(idCurso){
    location.href = "../../visTurmasCurso?&param=turmasDoCurso&id_curso="+idCurso;
}

function turmasDoCursoInServlet(idCurso){
    location.href = "visTurmasCurso?&param=turmasDoCurso&id_curso="+idCurso;
}

function professoresEsuasTurmasDoCurso(idCurso){
    location.href = "../../visProfessoresTurmas?&param=professoresEsuasTurmas&id_curso="+idCurso;
}

function professoresEsuasTurmasDoCursoInServlet(idCurso){
    location.href = "visProfessoresTurmas?&param=professoresEsuasTurmas&id_curso="+idCurso;
}

function disciplinasDosProfessoresDoCurso(idCurso){
    location.href = "../../visDisciplinasProfessoresCurso?&param=disciplinasDosProfessores&id_curso="+idCurso;
}

function disciplinasDosProfessoresDoCursoInServlet(idCurso){
    location.href = "visDisciplinasProfessoresCurso?&param=disciplinasDosProfessores&id_curso="+idCurso;
}

function turmasDoProfessor(idProfessor){
    location.href = "../../visTurmasProfessor?&param=visualizarTurmasDoProfessor&id_professor="+idProfessor;
}

function turmasDoProfessorInServlet(idProfessor){
    location.href = "visTurmasProfessor?&param=visualizarTurmasDoProfessor&id_professor="+idProfessor;
}

function matricularAluno(idCurso){
    location.href = "../../matAlunoTurma?&param=turmasDoCurso&id_curso="+idCurso;
}

function matricularAlunoInServlet(idCurso){
    location.href = "matAlunoTurma?&param=turmasDoCurso&id_curso="+idCurso;
}

function vincularDisciplinaAluno(idCurso){
    location.href = "../../vincDisciplinaAluno?&param=disciplinasDoCurso&id_curso="+idCurso;
}

function vincularDisciplinaAlunoInServlet(idCurso){
    location.href = "vincDisciplinaAluno?&param=disciplinasDoCurso&id_curso="+idCurso;
}

function turmasDoCursoAluno(idCurso){
    location.href = "../../visTurmasCurso?&param=turmasDoCursoAluno&id_curso="+idCurso;
}

function turmasDoCursoAlunoInServlet(idCurso){
    location.href = "visTurmasCurso?&param=turmasDoCursoAluno&id_curso="+idCurso;
}

function turmasDoCursoAlunoProfessor(idProfessor){
    location.href = "../../visTurmasProfessor?&param=visualizarTurmasDoProfessorForAlunos&id_professor="+idProfessor;
}

function turmasDoCursoAlunoProfessorInServlet(idProfessor){
    location.href = "visTurmasProfessor?&param=visualizarTurmasDoProfessorForAlunos&id_professor="+idProfessor;
}

function verNotasPorDisciplina(idAluno){
    location.href = "../../visDisciplinasAluno?&param=visualizarDisciplinasDoAluno&id_aluno="+idAluno;
}

function verNotasPorDisciplinaInServlet(idAluno){
    location.href = "visDisciplinasAluno?&param=visualizarDisciplinasDoAluno&id_aluno="+idAluno;
}

function cadastrarNotas(idProfessor){
    location.href = "../../cadNotas?&param=visualizarDisciplinasDoProfessorForAlunos&id_professor="+idProfessor;
}

function cadastrarNotasInServlet(idProfessor){
    location.href = "cadNotas?&param=visualizarDisciplinasDoProfessorForAlunos&id_professor="+idProfessor;
}

function excluir(id, nome) {
    if (window.confirm("Deseja realmente excluir o usuário " + nome + " ?")) {
        location.href = "delCoordenador?id=" + id + "&param=excluirCoordenador";
    }
}

function excluirCoordenador(id, nome) {
    if (window.confirm("Deseja realmente excluir o usuário " + nome + " ?")) {
        location.href = "delCoordenador?id=" + id + "&param=excluirCoordenador";
    }
}

function excluirAluno(id, nome) {
    if (window.confirm("Deseja realmente excluir o usuário " + nome + " ?")) {
        location.href = "delAluno?id=" + id + "&param=excluirAluno";
    }
}

function excluirProfessor(id, nome) {
    if (window.confirm("Deseja realmente excluir o usuário " + nome + " ?")) {
        location.href = "delProfessor?id=" + id + "&param=excluirProfessor";
    }
}

function excluirVest(id, nome) {
    if (window.confirm("Deseja realmente excluir o vestibular " + nome + " ?")) {
        location.href = "delVest?id=" + id + "&param=excluirVestibular";
    }
}

function excluirCurso(id, nome) {
    if (window.confirm("Deseja realmente excluir o curso " + nome + " ?")) {
        location.href = "delCurso?id=" + id + "&param=excluirCurso";
    }
}

function mascaraData(campoData)
{
	var data = campoData.value;
	if(data.length === 2)
	{
		data += '/';
		document.forms[0].data.value = data;
		return true;
	}
	if(data.length === 5)
	{
		data += '/';
		document.forms[0].data.value = data;
		return true;
	}
	
}

function fMasc(objeto, mascara) {

    obj = objeto;
    masc = mascara;
    setTimeout("fMascEx()", 1);
}
function fMascEx() {
    obj.value = masc(obj.value);
}
function mTel(tel) {
    tel = tel.replace(/\D/g, "");
    tel = tel.replace(/^(\d)/, "($1");
    tel = tel.replace(/(.{3})(\d)/, "$1)$2");
    if (tel.length === 9) {
        tel = tel.replace(/(.{1})$/, "-$1");
    } else if (tel.length === 10) {
        tel = tel.replace(/(.{2})$/, "-$1");
    } else if (tel.length === 11) {
        tel = tel.replace(/(.{3})$/, "-$1");
    } else if (tel.length === 12) {
        tel = tel.replace(/(.{4})$/, "-$1");
    } else if (tel.length > 12) {
        tel = tel.replace(/(.{4})$/, "-$1");
    }
    return tel;
}
function mCNPJ(cnpj) {
    cnpj = cnpj.replace(/\D/g, "");
    cnpj = cnpj.replace(/^(\d{2})(\d)/, "$1.$2");
    cnpj = cnpj.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3");
    cnpj = cnpj.replace(/\.(\d{3})(\d)/, ".$1/$2");
    cnpj = cnpj.replace(/(\d{4})(\d)/, "$1-$2");
    return cnpj;
}
function mCPF(cpf) {
    cpf = cpf.replace(/\D/g, "");
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
    cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
    return cpf;
}
function mCEP(cep) {
    cep = cep.replace(/\D/g, "");
    cep = cep.replace(/^(\d{2})(\d)/, "$1.$2");
    cep = cep.replace(/\.(\d{3})(\d)/, ".$1-$2");
    return cep;
}
function mNum(num) {
    num = num.replace(/\D/g, "");
    return num;
}

