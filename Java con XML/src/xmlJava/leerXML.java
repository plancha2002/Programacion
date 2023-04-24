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
            
            NodeList listaCoches = documento.getElementsByTagName("Coche");
            
            for (int i = 0; i < listaCoches.getLength(); i++) {
                Node nodo = listaCoches.item(i);
                
                if(nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) nodo;
                    NodeList hijos = e.getChildNodes();
                    for (int j = 0; j <hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);
                        if(hijo.getNodeType() == Node.ELEMENT_NODE){
                            Element ehijo = (Element)hijo;
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
