public class fecha {
    private int dia;
    private int mes;
    private int anio;

    public fecha() {
        dia = 1;
        mes = 1;
        anio = 2022;
    }

    public fecha(int dia, int mes, int anio) {
        if(dia >=1 && dia <= 31){this.dia = dia;}
        if(mes >=1 && mes <= 12){this.mes = mes;}
        if(anio >=1900){this.anio = anio;}

    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", anio=" + anio +
                '}';
    }
}
