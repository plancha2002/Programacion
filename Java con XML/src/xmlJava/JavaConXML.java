/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xmlJava;

import java.io.File;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author placha
 */
public class JavaConXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
            // Creo un DOMImplementation
        DOMImplementation implementation = builder.getDOMImplementation();

            // Creo un documento con un elemento raiz
        Document documento = implementation.createDocument(null, "consecionario", null);
        documento.setXmlVersion("1.0");
        
        //creamos las etiquetas que vamos a usar en el xml
        Element coches = documento.createElement("Coches");
        Element coche = documento.createElement("Coche");
        Element matricula = documento.createElement("Matricula");
        
                //agregar texto
                Text textMatricula = documento.createTextNode("1111AAA");
                //indicamos que el texto sera hijo de matricula
                matricula.appendChild(textMatricula);
                //y matricula es hijo de coche
                coche.appendChild(matricula);
                
        Element marca = documento.createElement("Marca");
        
                //agregar texto
                Text textMarca = documento.createTextNode("AUDI");
                //indicamos que el texto sera hijo de matricula
                marca.appendChild(textMarca);
                //y matricula es hijo de coche
                coche.appendChild(marca);
                
        Element precio = documento.createElement("Precio");
        
                //agregar texto
                Text textPrecio = documento.createTextNode("30000");
                //indicamos que el texto sera hijo de matricula
                precio.appendChild(textPrecio);
                //y matricula es hijo de coche
                coche.appendChild(precio);
        
        //terminamos de componer toda la etiqueta
        coches.appendChild(coche);
        
        //la agregamos al documento
        documento.getDocumentElement().appendChild(coches);
        
         // Asocio el source con el Document
        Source source = new DOMSource(documento);
        // Creo el Result, indicado que fichero se va a crear
        Result result = new StreamResult(new File("consecionario.xml"));
        
          // Creo un transformer, se crea el fichero XML
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        
        }catch(ParserConfigurationException | TransformerException e){
            System.out.println("Error: " + e.toString());
        }
        
       }

  
}
