public class Pedidos {
    private static int contador = 0;
    private int id;
    private String nombreProducto;
    private int cantidad;

    private double precioUnidad;
    private double precioTotal;

    public Pedidos() {
    }

    public Pedidos( String nombreProducto, int cantidad, double precioUnidad) {
        this.id = contador+1;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.precioTotal = precioUnidad * cantidad;
        contador++;

    }

    public Pedidos( int id,String nombreProducto, int cantidad, double precioUnidad) {
        this.id = contador+1;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.precioTotal = precioUnidad * cantidad;
        contador++;

    }

    public Pedidos(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnidad=" + precioUnidad +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
