package br.ufsm.csi.poow2.cliente_endereco.dao;

import br.ufsm.csi.poow2.cliente_endereco.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioDAO {

    public Usuario getUsuario(String user){
        if(user.equals("marina@teste")){
            //criptografar a senha
            return new Usuario(user, new BCryptPasswordEncoder().encode("123"), "ADMIN");
            //aqui seria a consulta para trazer o usuário
        }else if(user.equals("claudia@teste")){
            return new Usuario(user, new BCryptPasswordEncoder().encode("1234"), "USER");
        } else {
            return null;
        }
    }


}
