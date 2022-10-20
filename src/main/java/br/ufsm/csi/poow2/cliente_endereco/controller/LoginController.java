package br.ufsm.csi.poow2.cliente_endereco.controller;

import br.ufsm.csi.poow2.cliente_endereco.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Object> autenticacao(@RequestBody Usuario usuario){
        System.out.println("User: "+usuario.getUser());
        System.out.println("Senha: "+usuario.getSenha());

        try {
            final Authentication autenticado = this.authenticationManager.authenticate
                                        (new UsernamePasswordAuthenticationToken(usuario.getUser(),usuario.getSenha()));
            if(autenticado.isAuthenticated()){
                //colocamos nossa instancia de autenticado no contexto do spring security
                SecurityContextHolder.getContext().setAuthentication(autenticado);
                System.out.println("Está autenticado..........");
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Usuário ou senha incorretos!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Usuário ou senha incorretos!", HttpStatus.BAD_REQUEST);
    }

}
