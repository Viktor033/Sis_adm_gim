package Gimnasio.dominio;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private int telefono;
    private int menbresia;

    public Cliente() {
    }

    public Cliente(int id){
        this.id = id;
    }

    public Cliente(String nombre, String apellido, int telefono, int menbresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.menbresia = menbresia;
    }

    public Cliente(int id, String nombre, String apellido, int telefono, int menbresia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.menbresia = menbresia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getMenbresia() {
        return menbresia;
    }

    public void setMenbresia(int menbresia) {
        this.menbresia = menbresia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", menbresia=" + menbresia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && telefono == cliente.telefono && menbresia == cliente.menbresia && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, telefono, menbresia);
    }
}
