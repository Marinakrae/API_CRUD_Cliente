package br.ufsm.csi.poow2.cliente_endereco.model;

public class Usuario {

    private String user;
    private String senha;
    private String permissao;

    public Usuario (){

    }

    public Usuario(String user, String senha, String permissao) {
        this.user = user;
        this.senha = senha;
        this.permissao = permissao;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
