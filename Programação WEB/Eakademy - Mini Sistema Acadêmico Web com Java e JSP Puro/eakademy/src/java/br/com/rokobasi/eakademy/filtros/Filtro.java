package br.com.rokobasi.eakademy.filtros;

import br.com.rokobasi.eakademy.model.Login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = {"/diretor/*", "/coordenador/*", "/professor/*", "/aluno/*"})
public class Filtro implements Filter {
    
    //private FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FILTRO INICIADO");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI(); // identificação do recurso que o usuário ta acessando, saber o que o usuário quer acessar
        String context = req.getContextPath(); // contexto da app pra nao da 404
        
        Login login = (Login)req.getSession().getAttribute("login");
        
        if (login == null) {
            chain.doFilter(request, response);
        } else if (login.getPerfil().equalsIgnoreCase("diretor") && !uri.contains("/diretor/")) {
            resp.sendRedirect(context + "/pages/diretor/index.jsp");
        } else if (login.getPerfil().equalsIgnoreCase("coordenador") && !uri.contains("/coordenador/")) {
            resp.sendRedirect(context + "/pages/coordenador/index.jsp");
        } else if (login.getPerfil().equalsIgnoreCase("professor") && !uri.contains("/professor/")) {
            resp.sendRedirect(context + "/pages/professor/index.jsp");
        } else if (login.getPerfil().equalsIgnoreCase("aluno") && !uri.contains("/aluno/")) {
            resp.sendRedirect(context + "/pages/aluno/index.jsp");
        } else {
            try {
                chain.doFilter(request, response);
            } catch (Exception ex) {
                System.out.println("Erro:" +ex.getMessage());
            }
        }
        
    }

    @Override
    public void destroy() {
        System.out.println("Filtro destruído!");
    }
    
}
