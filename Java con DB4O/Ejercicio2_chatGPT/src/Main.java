import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;

import java.io.File;
import java.util.ArrayList;

public class Main {
    private static final String rutac = "cliente.db4o";
    private static final String rutap = "pedido.db4o";
    public static void main(String[] args) {

//        Crea una base de datos db4o y almacena varios objetos de una clase
//        llamada Cliente. Los clientes deben tener un id, un nombre,
//        una dirección y una lista de pedidos. Luego, implementa una Query que
//        permita buscar clientes por nombre o por dirección.
        ArrayList<Clientes> clientesLista = new ArrayList<Clientes>();
        ArrayList<Pedidos> pedidosLista = new ArrayList<Pedidos>();

        clientesLista.add(new Clientes("Eduardo", "España",1));
        clientesLista.add(new Clientes("Juan", "España",2));
        clientesLista.add(new Clientes("Maria", "Venezuela",3));
        clientesLista.add(new Clientes("Pedro", "España",4));

        pedidosLista.add(new Pedidos("Lapices", 4, 0.5));
        pedidosLista.add(new Pedidos("Borras", 5, 1));
        pedidosLista.add(new Pedidos("Raton",2,50));
        File f1 = new File(rutac);
        File f2 = new File(rutap);
//        f1.delete();
//        f2.delete();
//
//        escribirDB4Oc(clientesLista);
//        escribirDB4Op(pedidosLista);

        System.out.println(leerDB4On("Juan"));

        leerDB4Od("España");





    }

    public static <T> void escribirDB4Oc( ArrayList<T> lista) throws Db4oIOException {
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), rutac);
            for (T obj : lista) {
                db.store(obj);
                System.out.println(obj.toString());
            }
        } catch (Db4oIOException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            db.close();
        }


    }

    public static <T> void escribirDB4Op( ArrayList<T> lista) throws Db4oIOException {
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), rutap);
            for (T obj : lista) {
                db.store(obj);

            }
        } catch (Db4oIOException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            db.close();
        }


    }

    public static Object leerDB4On(String nombre){
        ArrayList<Clientes> clienteTemp = new ArrayList<>();
        int contador = 0;
        Pedidos pedidoTemp = null;
        ObjectContainer dbCliente = null;
        ObjectContainer dbProducto = null;
        try {
            dbCliente = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), rutac);
            dbProducto = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), rutap);

            Clientes ex = new Clientes(nombre);
            ObjectSet result = dbCliente.queryByExample(ex);


            if (result.isEmpty()) {
                return null;
            }

            while (result.hasNext()) {
                clienteTemp.add((Clientes) result.next());

            }

            for (int i = 0; i < clienteTemp.size(); i++) {
                Pedidos exP = new Pedidos(clienteTemp.get(i).getId_pedido());
                ObjectSet resultadoP = dbProducto.queryByExample(exP);

                if (resultadoP.isEmpty()) {
                    return null;
                }

                while (resultadoP.hasNext()) {
                    pedidoTemp = (Pedidos) resultadoP.next();
                }
                if(pedidoTemp != null){
                    return clienteTemp.get(i) + "Nombre producto: "+pedidoTemp.getNombreProducto()+" Cantidad: "+pedidoTemp.getCantidad()
                            + " Precio unitario: "+pedidoTemp.getPrecioUnidad()+" Precio total: "+pedidoTemp.getPrecioTotal();
                }else{
                    return clienteTemp.get(i);
                }
            }



        }
        catch (Db4oIOException e) {
            System.out.println("Error: " + e.toString());
        }finally {
            dbCliente.close();
            dbProducto.close();
        }

        return null;
    }

    public static void leerDB4Od(String direccion){

        ArrayList<Clientes> clienteTemp = new ArrayList<>();
        int contador = 0;
        Pedidos pedidoTemp = null;
        ObjectContainer dbCliente = null;
        ObjectContainer dbProducto = null;
        try {
            dbCliente = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), rutac);
            dbProducto = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), rutap);

            Clientes ex = new Clientes(null,direccion);
            ObjectSet result = dbCliente.queryByExample(ex);




            while (result.hasNext()) {
                clienteTemp.add((Clientes) result.next());

            }
            System.out.println(clienteTemp.size());
            for (int i = 0; i < clienteTemp.size(); i++) {
                Pedidos exP = new Pedidos(clienteTemp.get(i).getId_pedido());
                ObjectSet resultadoP = dbProducto.queryByExample(exP);



                while (resultadoP.hasNext()) {
                    pedidoTemp = (Pedidos) resultadoP.next();
                }
                if(pedidoTemp != null){
                    System.out.println(clienteTemp.get(i).toString() + "Nombre producto: "+pedidoTemp.getNombreProducto()+" Cantidad: "+pedidoTemp.getCantidad()
                            + " Precio unitario: "+pedidoTemp.getPrecioUnidad()+" Precio total: "+pedidoTemp.getPrecioTotal());
                }else{
                    System.out.println( clienteTemp.get(i));
                }
            }
        }
        catch (Db4oIOException e) {
            System.out.println("Error: " + e.toString());
        }finally {
            dbCliente.close();
            dbProducto.close();
        }


    }
//    public static Object leerDB4O(int id){
//        ObjectContainer db = null;
//        try {
//            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), ruta);
//
//            Producto ex = new Producto(id, null, 0);
//
//            ObjectSet result = db.queryByExample(ex);
//
//            if (result.isEmpty()) {
//                return null;
//            }
//
//            while (result.hasNext()) {
//                return result.next();
//
//            }
//
//        }
//        catch (Db4oIOException e) {
//            System.out.println("Error: " + e.toString());
//        }finally {
//            db.close();
//        }
//
//        return null;
//    }
}