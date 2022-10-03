package br.ufsm.csi.poow2.cliente_endereco.controller;

import br.ufsm.csi.poow2.cliente_endereco.model.*;
import br.ufsm.csi.poow2.cliente_endereco.service.*;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RestController()
@RequestMapping("cliente")
public class ClienteController {

    @GetMapping("/listar")
    public static ArrayList<Cliente> getClientes() {
        return new ClienteService().getClientes();
    }

    @GetMapping("/{id}")
    public static Cliente getCliente(@PathVariable("id") int id) {
        return new ClienteService().getCliente(id);
    }

    @PostMapping("/salvar")
    public static void salvar(@RequestBody Cliente cliente) {
        new ClienteService().salvar(cliente);
    }

    @PostMapping("/apagar")
    public static void apagar(@RequestBody Cliente cliente) {
        new ClienteService().apagar(cliente);
    }

    @PutMapping("/editar/{id}")
    public static void editar(@PathVariable("id") int id, @RequestBody Cliente cliente) {
        new ClienteService().editar(id, cliente);
    }

}
