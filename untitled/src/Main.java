import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.collections.DelegatingSet;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String ruta = "Persona.db4o";

    public static void main(String[] args) {
        //empiezo con consultas SODA
//        Buscar objetos con un valor específico: Crea una base de datos con varios objetos y,
//        a continuación, realiza una consulta para buscar todos los objetos que tengan un valor
//        específico en un campo determinado. Por ejemplo, podrías buscar todos los objetos con un campo
//        "nombre" que contenga la cadena "Juan".
//
//      Buscar objetos que cumplan ciertas condiciones: Crea una base de datos con varios objetos y,
//      a continuación, realiza una consulta para buscar todos los objetos que cumplan ciertas condiciones.
//      Por ejemplo, podrías buscar todos los objetos con un campo "edad" mayor que 30 y menor que 40.
//
//        Ordenar objetos según un campo específico: Crea una base de datos con varios objetos y, a continuación,
//         realiza una consulta para ordenar los objetos según un campo específico. Por ejemplo, podrías ordenar
//        los objetos según su campo "fecha" de forma ascendente o descendente.
        //persona>clientes
        //clientes tendra fecha

        // condesare los tres ejercicio en uno

        /*
        * bloque de codigo en des uso solo usado para insertar datos
        * */
//        File f = new File(ruta);
//        f.delete();
//        ArrayList<Persona> personas = new ArrayList<Persona>();
       fecha f1 =new fecha(10,10,2012);
       fecha f2 =new fecha(28,2,2022);

//        personas.add(new Cliente("Eduardo","Planchart",30,1234,f1));
//        personas.add(new Cliente("Juan","Planchart",18,3425,f1));
//        personas.add(new Cliente("Juan","Carrillo",20,0122,f2));
//        personas.add(new Cliente("Maria","Carrillo",30,4123,f2));
//
//        personas.add(new Empleado("Humberto", "AM", 23,9900,f2));
//        personas.add(new Empleado("Maricio", "Renault", 48,1212,f1));
//        personas.add(new Empleado("Andres", "Carr", 12,2323,f2));
//        personas.add(new Empleado("Flavio", "Briatore", 60,3333,f1));
//
//        escribirDB4O(personas);
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean bucle = true;

        while (bucle){
            menu();
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    EmpleadosQuery();
                    break;
                case 2:
                    clientesQuery();
                    break;
                case 3:
                    personaQuery();
                    break;
                case 4:
                    System.out.println("Que nombre busca?");
                    String nombre = scanner.next();
                    personaQueryNombre(nombre);

                    break;
                case 5:
                    personaQueryEdad(scanner.nextInt());
                    break;
                case 6:
                    System.out.println("Entre que edades desea buscar");
                    System.out.print("Mayor que:");
                    int mayor=scanner.nextInt();
                    System.out.println("");
                    System.out.print("Menor que:");
                    int menor=scanner.nextInt();
                    System.out.println("");
                    personaQueryEdadEntre(mayor,menor);
                    break;
                case 7:
                    System.out.print("Persona mayor que: ");
                    int edad=scanner.nextInt();
                    System.out.println("");
                    personaQueryEdadMayorQue(edad);
                    break;
                case 8:
                    System.out.print("Persona menor que: ");
                    int edadMenor=scanner.nextInt();
                    System.out.println("");
                    personaQueryEdadMenorQue(edadMenor);
                    break;
                case 9:
                    personaQueryOrdenadaNombre();
                    break;
                case 10:
                    personaQueryOrdenadaEdad();
                    break;
                case 11:
                    bucle = false;
                    break;
                case 12:
                        System.out.println("de que año");
                        int anio=scanner.nextInt();
                        personaQueryAnioInasis(anio);
                        break;
                case 14:
                    System.out.println("Borrar a todas las persona menores que:");
                    int edadMenorQue = scanner.nextInt();
                    borrarElementoPorEdadMenorQue(edadMenorQue);
                    break;
                case 13:
                    System.out.println("Nombre a cambiar:");
                    String busq = scanner.next();
                    System.out.println("Nombre nuevo");
                    String nuevo = scanner.next();
                    personaActualizarNombre(busq,nuevo);
                    break;
                default:
            }
        }






    }
    public static void menu(){
        System.out.println("1. Buscar empleados");
        System.out.println("2. Buscar clientes");
        System.out.println("3. Buscar personas");
        System.out.println("4. Buscar nombre de persona");
        System.out.println("5. Buscar persona por edad");
        System.out.println("6. Buscar persona mayor que y menor que");
        System.out.println("7. Buscar persona mayor que");
        System.out.println("8. Buscar persona menor que");
        System.out.println("9. personas ordenadas por nombre");
        System.out.println("10. personas ordenadas por edad");
        System.out.println("12. anio inasis");
        System.out.println("13. actualizar un nombre");
        System.out.println("14. borrar un elemenot buscado por edad");
        System.out.println("11.salir");
    }
    public static <T> void escribirDB4O(ArrayList<T> lista){
        ObjectContainer bd = null;

        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);

            for(T iteracionForE : lista){
                bd.store(iteracionForE);
                System.out.println(iteracionForE);
                System.out.println("Ingresado correctamente");
            }

        }catch (Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }


    }

    public static void EmpleadosQuery(){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Empleado.class);
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }

        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }
    public static void clientesQuery(){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Cliente.class);
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }

        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }

    public static void personaQuery(){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }

        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }

    public static void personaQueryNombre(String nombre){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            Constraint busquedaNombre = query.descend("nombre").constrain(nombre);
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }


        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }
    public static void personaQueryEdad(int edad){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            Constraint busquedaEdad = query.descend("edad").constrain(edad).equal();
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }

        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }
    public static void personaQueryEdadMayorQue(int edad){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            Constraint busquedaEdad = query.descend("edad").constrain(edad).greater();
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }

        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }

    public static void personaQueryEdadMenorQue(int edad){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            Constraint busquedaEdad = query.descend("edad").constrain(edad).smaller();
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }

        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }

    public static void personaQueryEdadEntre(int edad1 , int edad2){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            Constraint busquedaEdad = query.descend("edad").constrain(edad2).smaller();
            query.descend("edad").constrain(edad1).greater().and(busquedaEdad);

            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }

        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }

    public static void personaQueryOrdenadaNombre(){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            query.descend("nombre").orderDescending();
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }

        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }

    public static void personaQueryOrdenadaEdad(){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            query.descend("edad").orderDescending();
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }

        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }

    public static void personaQueryAnioInasis(int anio){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            Constraint busquedaNombre = query.descend("fechaUltimaInasistencia").descend("anio").constrain(anio);
            ObjectSet res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
            }


        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }

    public static void borrarElementoPorEdadMenorQue(int edadMenor){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            Constraint busquedaNombre = query.descend("edad").constrain(edadMenor).smaller();
            ObjectSet<Persona> res = query.execute();

            while(res.hasNext()){
                System.out.println(res.next());
                System.out.println("borrado");
                bd.delete(res.next());
            }


        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }

    public static void personaActualizarNombre(String nombreBuscar, String nuevoNombre){
        ObjectContainer bd = null;
        try{
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),ruta);
            Query query = bd.query();
            query.constrain(Persona.class);
            Constraint busquedaNombre = query.descend("nombre").constrain(nombreBuscar).equal();
            ObjectSet<Persona> res = query.execute();

            while(res.hasNext()){
                Persona persona = res.next();
                persona.setNombre(nuevoNombre);
                bd.store(persona);


            }


        }catch(Db4oIOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            bd.close();
        }
    }





}