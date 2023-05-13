public class Empleado extends Persona{
    private static int contador = 0;
    private int id_empleado;
    private fecha fechaUltimaInasistencia;

    public Empleado() {
    }

    public Empleado( fecha fechaUltimaInasistencia) {
        this.id_empleado =  contador+1;
        this.fechaUltimaInasistencia = fechaUltimaInasistencia;
        contador++;
    }

    public Empleado(String nombre, String apellido, int edad, int dni,  fecha fechaUltimaInasistencia) {
        super(nombre, apellido, edad, dni);
        this.id_empleado = contador+1;
        this.fechaUltimaInasistencia = fechaUltimaInasistencia;
        contador++;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public fecha getFechaUltimaInasistencia() {
        return fechaUltimaInasistencia;
    }

    public void setFechaUltimaInasistencia(fecha fechaUltimaInasistencia) {
        this.fechaUltimaInasistencia = fechaUltimaInasistencia;
    }

    @Override
    public String toString() {
        return super.toString()+"Empleado{" +
                "id_empleado=" + id_empleado +
                ", fechaUltimaInasistencia=" + fechaUltimaInasistencia +
                '}';
    }
}
