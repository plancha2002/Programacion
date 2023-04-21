import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.*;
import com.db4o.ext.Db4oIOException;
import com.db4o.query.Query;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    private static final String ruta = "Productos.db4o";
    public static void main(String[] args) {
//        Crea una base de datos db4o y almacena varios objetos de una clase
//        llamada Producto. Los productos deben tener un id, un nombre y un precio.
//        Luego, implementa una Query que permita buscar productos por id o por nombre.

        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto(1, "Notebook", 100));
        productos.add(new Producto(2, "Tablet", 200));
        productos.add(new Producto(3, "Mouse", 300));
        productos.add(new Producto(4, "Keyboard", 400));

            File file = new File(ruta);
            file.delete();
            escribirDB4O(productos);

        System.out.println(leerDB4O("Notebook").toString());
        System.out.println(leerDB4O(4).toString());

    }

    public static <T> void escribirDB4O( ArrayList<T> lista) throws Db4oIOException {
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), ruta);
            for (T obj : lista) {
                db.store(obj);
            }
        } catch (Db4oIOException e) {
            System.out.println("Error: " + e.toString());
        } finally {
            db.close();
        }


    }

    public static Object leerDB4O(String nombre){
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), ruta);

            Producto ex = new Producto(0, nombre, 0);

            ObjectSet result = db.queryByExample(ex);

            if (result.isEmpty()) {
                return null;
            }

            while (result.hasNext()) {
                return result.next();

            }

        }
        catch (Db4oIOException e) {
            System.out.println("Error: " + e.toString());
        }finally {
            db.close();
        }

        return null;
        }
    public static Object leerDB4O(int id){
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), ruta);

            Producto ex = new Producto(id, null, 0);

            ObjectSet result = db.queryByExample(ex);

            if (result.isEmpty()) {
                return null;
            }

            while (result.hasNext()) {
                return result.next();

            }

        }
        catch (Db4oIOException e) {
            System.out.println("Error: " + e.toString());
        }finally {
            db.close();
        }

        return null;
    }

    }



