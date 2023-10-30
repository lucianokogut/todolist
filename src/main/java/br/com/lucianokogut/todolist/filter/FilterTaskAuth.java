package br.com.lucianokogut.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.lucianokogut.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var servletPath = request.getServletPath();
        if (servletPath.equals("/tasks/")) {

            // Executar alguma ação antes de "bater no Controller"
            System.out.println("Iniciando o Filter para autorização! \n");

            // Pegar a autenticação do Usuário e Senha
            var authorization = request.getHeader("Authorization");
            System.out.println("Request com a autorização " + authorization);

            var authEncoded = authorization.substring("Basic".length()).trim();
            byte[] authDecode = Base64.getDecoder().decode(authEncoded);
            System.out.println("Auth da request alterada para authEncoded " + authEncoded);

            var authString = new String(authDecode);
            System.out.println("AuthEncoded da request alterada para authString " + authString);

            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            System.out.println("Chegou no doFilter com os seguintes dados: \nauth => "
                    + authorization + " \nauthEncoded => " + authEncoded + " \nauthDecode => "
                    + authDecode + " \nauthString => " + authString + " \ncredentials[0] => "
                    + credentials[0] + " \nusername => " + username + " \ncredentials[1] => "
                    + credentials[1] + " \npassword => " + password);

            System.out.println("Pode ou não seguir o caminho feliz...");

            // Validar usuário
            var user = this.userRepository.findByUsername(username);
            if (user == null) {
                // Usuário não existe e retorna statusCode 401
                response.sendError(401, "Usuário não existe...");
            } else {
                // Validar senha
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (passwordVerify.verified) {
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401, "Password inválido!");
                }
            }

        } else {
            filterChain.doFilter(request, response);
        }

    }

}
