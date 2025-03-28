package Gimnasio.datos;

import Gimnasio.dominio.Cliente;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAO implements IClienteDAO {

    @Override
    public List<Cliente> listarClientes() {
        return new ArrayList<>();
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return false;  // Aquí estaba el problema
    }
}

