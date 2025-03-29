package Gimnasio.datos;

import Gimnasio.conexion.Conexion;
import static Gimnasio.conexion.Conexion.getConexion;
import Gimnasio.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public class ClienteDAO implements IClienteDAO {

    //==== LISTAR CLIENTES
    
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;  //va a recibir los resultados de la base de datos
        Connection con = Conexion.getConexion();
        var sql = "SELECT * FROM cliente ORDER BY id";
        try{
            ps = con.prepareStatement(sql);
            
            // Nos permite acceder al valor de cada una de las columnas
            rs = ps.executeQuery();
            while(rs.next()){
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setMenbresia(rs.getInt("menbresia"));
                clientes.add(cliente);
            }
        }catch (SQLException e){
            System.out.println("ERROR al Listar Clientes: " + e.getMessage());
        }
        finally{
            try{
                con.close();
            }catch (SQLException e) {
                System.out.println(" ERROR al cerrar conexion: " + e.getMessage());
            }
        }
        return clientes;
    }

    //======= BUSCAR CLIENTE ========
    
    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs; 
        Connection con = getConexion();
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                cliente.setNombre(rs.getString("nombre: "));
                cliente.setApellido(rs.getString("apellido: "));
                cliente.setTelefono(rs.getInt("telefono: "));
                cliente.setMenbresia(rs.getInt("Menbresia: "));
                return true;
            }
        }catch (Exception e){
            System.out.println("ERROR al recuperar cliente por ID: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("*** ERROR al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    //======= AGREGAR CLIENTE ===========

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO cliente(nombre, apellido, telefono, menbresia) "
                    + "VALUE(?, ?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getTelefono());
            ps.setInt(4, cliente.getMenbresia());
            ps.execute();
            return true;
            
        }catch(Exception e){
            System.out.println("ERROR al agregar cliente: " + e.getMessage()    );
        }
        finally {
            try {
                con.close();
            }catch(Exception e){
                System.out.println("ERROR al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    //========== MODIFICAR CLIENTE =============
    
    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql ="UPDATE cliente SET nombre=?, apellido=?, telefono=?, menbresia=? " +
                "WHERE  id = ?";
            try{
               ps = con.prepareStatement(sql);
               ps.setString(1, cliente.getNombre());
               ps.setString(2, cliente.getApellido());
               ps.setInt(3, cliente.getTelefono());
               ps.setInt(4, cliente.getMenbresia());
               ps.setInt(5, cliente.getId());
               ps.execute();
               return true;
               
            }catch (Exception e){
                System.out.println("ERROR al modificar cliente: " + e.getMessage());  
            }
              finally  {
                try{
                con.close();
                }catch (Exception e){
                    System.out.println("ERROR al cerrar conexion: " + e.getMessage());
                }
            }
        return false;
    }

    //==================== ELIMINAR CLIENTE ======================

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM cliente WHERE id = ?";
        try{
           ps = con.prepareStatement(sql);
           ps.setInt(1, cliente.getId());
           ps.execute();
           return true;
        }catch (Exception e){
            System.out.println("ERROR al eliminar cliente: "+ e.getMessage());
        }
        finally {
            try {
                 con.close();
            }catch (Exception e){
                System.out.println("ERROR al cerrar conexion: " + e.getMessage());
            }             
        }
        
        return false;  
    }
    
    // Prueba
    public static void main(String[] args) {
        IClienteDAO clienteDao = new ClienteDAO ();
        
        //Listar Clientes

        
        // Buscar cliente
       // var cliente1 = new Cliente(2);
       // System.out.println("clente antes de la busqueda: " + cliente1);
       // var encontrado = clienteDao.buscarClientePorId(cliente1);
        //  if(encontrado)
            //    System.out.println("Cliente encontrado: " + cliente1);
           // else
             //   System.out.println("No se a encontro cliente: " + cliente1.getId());

       //AGREGAR CLIENTE

     //  var nuevoCliente = new Cliente("Juan", "Gonzalez", 456741, 800);
    //   var agregado = clienteDao.agregarCliente(nuevoCliente);
    //    if(agregado)
   //         System.out.println("Cliente agregado: " + nuevoCliente);
  //      else
 //           System.out.println("No se agrego el nuevo cliente:" + nuevoCliente);
 
        //modificar clientes
        
 //       var modificarCliente = new Cliente (3, "Rodrigo", "Ortiz", 354987, 150);
  //      var modificado = clienteDao.modificarCliente(modificarCliente);
 //           if(modificado)
 //               System.out.println("Cliente modificado : " + modificarCliente);
 //           else
  //              System.out.println("No se modifico cliente: " + modificarCliente);
  
        // ========= ELIMINAR CLIENTE =============
        var clienteEliminar = new Cliente(3);
        var eliminado = clienteDao.eliminarCliente(clienteEliminar);
            if(eliminado)
                System.out.println("Cliente eliminado: " + clienteEliminar);
            else
                System.out.println("No se elimino cliente: " + clienteEliminar);
        
        //=========== LISTAR CLIENTES =============
            
        System.out.println("*** Listar clientes ***");
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
    }
}

