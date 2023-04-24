/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerXML;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author placha
 */
public class leerXML {
    public static void main(String[] args) throws SAXException, IOException {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document documento = builder.parse(new File("consecionario.xml"));
            
            //seleccionamos los nodos coche, este elemento devulve un array
            NodeList listaCoches = documento.getElementsByTagName("Coche");
            
            for (int i = 0; i < listaCoches.getLength(); i++) {
                //accedemos a cada posicion del array, es decir a cada elemento coche por separado
                Node nodo = listaCoches.item(i);
                
                //si el nodo contiene un elememento seguimos
                if(nodo.getNodeType() == Node.ELEMENT_NODE){
                    
                    //creamos un element apartir del objeto nodo, casteando
                    Element e = (Element) nodo;
                    //creamos otra nodeList que devolvera una array del los hijos de nodo
                    NodeList hijos = e.getChildNodes();
                    
                    //creamos otro for para acceder a cada hijo se compone de una lista
                    //con [0] matricula, [1]marca, [2] precio
                    
                    for (int j = 0; j <hijos.getLength(); j++) {
                        //en este caso se entrara por cada coche tres veces al array
                        Node hijo = hijos.item(j);
                        //verificamos que nodo tenga contenido
                        if(hijo.getNodeType() == Node.ELEMENT_NODE){
                            //creamos un elemento al que le igualamos el valor de Node hijo
                            Element ehijo = (Element)hijo;
                            //lo leemos, con getNodeName, obtenemos le nombre del nodo
                            //getTextContent obtenemos el texto que contiene
                            //esto lo podemos combinar con condiciones para obtener solo unos datos
                            //ej, solo coches con x precio
                            System.out.println("Propiedad:"+hijo.getNodeName()+" valor: "+hijo.getTextContent());
                        }
                        
                    }
                }
                
            }
            
        }catch(ParserConfigurationException | SAXException e){
            System.out.println("Error:  "+ e.toString());
        }
        
        
    
    }
}
