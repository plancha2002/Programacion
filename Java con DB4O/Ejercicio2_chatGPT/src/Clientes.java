public class Clientes {
    private static int contador = 0;
    private int id;
    private String nombre;
    private String direccion;

    private int id_pedido;

    public Clientes() {
    }

    public Clientes( String nombre, String direccion, int id_pedido) {
        this.id = contador+1;
        this.nombre = nombre;
        this.direccion = direccion;
        this.id_pedido = id_pedido;
        contador++;
    }

    public Clientes(String nombre) {
        this.nombre = nombre;
    }

    public Clientes(String nombre,String direccion) {
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", id_pedido=" + id_pedido +
                '}';
    }
}
