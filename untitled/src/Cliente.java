public class Cliente extends Persona {
    private static int contador=0;
    private int id_cliete;
    private fecha fechaUltimaCompra;

    public Cliente() {
    }
    public Cliente(fecha fechaUltimaCompra) {
        this.id_cliete = contador+1;
        this.fechaUltimaCompra = fechaUltimaCompra;
        contador++;
    }

    public Cliente(String nombre, String apellido, int edad, int dni,fecha fechaUltimaCompra) {
        super(nombre, apellido, edad, dni);
        this.id_cliete =contador+1;
        this.fechaUltimaCompra = fechaUltimaCompra;
        contador++;
    }

    public int getId_cliete() {
        return id_cliete;
    }

    public void setId_cliete(int id_cliete) {
        this.id_cliete = id_cliete;
    }

    public fecha getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(fecha fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }


    @Override
    public String toString() {

        return super.toString()+"Cliente{" +
                "id_cliete=" + id_cliete +
                ", fechaUltimaCompra=" + fechaUltimaCompra +
                '}';
    }
}
