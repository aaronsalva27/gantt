package clases;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static clases.Subtarea.listaSubTareas;
import static clases.Tarea.listaTareas;
import static clases.Usuario.listaUsuarios;

/**
 * Created by Aarón on 12/03/2017.
 */
public class EscrituraXML {

    public void crearXML(String arxivo){
        String fichero = arxivo+".xml";

        int a = 0;
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder =
                    dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            // root element
            Element rootElement = doc.createElement("Tareas");
            doc.appendChild(rootElement);

            for (a=0;a<listaTareas.size();a++) {
                //  supercars element
                Element supercar = doc.createElement("Tarea");
                rootElement.appendChild(supercar);

                // carname element
                Element carname = doc.createElement("Nombre");
                carname.appendChild(
                        doc.createTextNode(listaTareas.get(a).getNombre()));
                supercar.appendChild(carname);

                Element carname1 = doc.createElement("Tiempo");
                carname1.appendChild(
                        doc.createTextNode(String.valueOf(listaTareas.get(a).getTiempo())));
                supercar.appendChild(carname1);

                Element carname2 = doc.createElement("Subtareas");
                carname2.appendChild(
                        doc.createTextNode(String.valueOf(listaTareas.get(a).getTareas())));
                supercar.appendChild(carname2);

                Element carname3 = doc.createElement("Inicio");
                carname3.appendChild(
                        doc.createTextNode(String.valueOf(listaTareas.get(a).getInicio())));
                supercar.appendChild(carname3);

                Element carname4 = doc.createElement("Finaliza");
                carname4.appendChild(
                        doc.createTextNode(String.valueOf(listaTareas.get(a).getFinaliza())));
                supercar.appendChild(carname4);

                Element carname5 = doc.createElement("Descripcion");
                carname5.appendChild(
                        doc.createTextNode(String.valueOf(listaTareas.get(a).getDescripcion())));
                supercar.appendChild(carname5);

                Element carname6 = doc.createElement("Estado");
                carname6.appendChild(
                        doc.createTextNode(String.valueOf(listaTareas.get(a).getEstado())));
                supercar.appendChild(carname6);

            }

            // write the content into xml file
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(".\\"+fichero));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult =
                    new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void lecturaXML(String arxivo){
        String fichero = ".\\"+arxivo+".xml";

        try {
            File stocks = new File(fichero);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();

            System.out.println("arrel " + doc.getDocumentElement().getNodeName());
            NodeList nodes = (NodeList) doc.getElementsByTagName("Tareas").item(0);

            for (int i=0; i< nodes.getLength(); i++){
                Node node = nodes.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Nombre: " + obtenirContingut("Nombre", element));
                    String nombre = obtenirContingut("Nombre", element);
                    System.out.println("Tiempo: " + obtenirContingut("Tiempo", element));
                    Integer tiempo = Integer.parseInt(obtenirContingut("Tiempo", element));
                    System.out.println("Subtareas: " + obtenirContingut("Subtareas", element));
                    Integer subtareas = Integer.parseInt(obtenirContingut("Subtareas", element));
                    System.out.println("Inicio: " + obtenirContingut("Inicio", element));
                    Integer inicio = Integer.parseInt(obtenirContingut("Inicio", element));
                    System.out.println("Finaliza: " + obtenirContingut("Finaliza", element));
                    Integer finaliza = Integer.parseInt(obtenirContingut("Finaliza", element));
                    System.out.println("Descripcion: " + obtenirContingut("Descripcion", element));
                    String descripcion = obtenirContingut("Descripcion", element);
                    System.out.println("Estado: " + obtenirContingut("Estado", element));
                    Integer estado = Integer.parseInt(obtenirContingut("Estado", element));

                    Tarea tareaXML = new Tarea(nombre,tiempo,subtareas,inicio,finaliza,descripcion,estado);
                    listaTareas.add(tareaXML);
                }

            }

        }catch (Exception ex){
            System.out.println("aun no tienes tareas");
        }
    }

    public void crearXMLTareas(String arxivo){
        String fichero = arxivo+".xml";

        int a = 0;
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder =
                    dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            // root element
            Element rootElement = doc.createElement("Tareas");
            doc.appendChild(rootElement);

            for (a=0;a<listaSubTareas.size();a++) {
                //  supercars element
                Element supercar = doc.createElement("Tarea");
                rootElement.appendChild(supercar);

                // carname element
                Element carname = doc.createElement("Nombre");
                carname.appendChild(
                        doc.createTextNode(listaSubTareas.get(a).getNombre()));
                supercar.appendChild(carname);

                Element carname1 = doc.createElement("Tiempo");
                carname1.appendChild(
                        doc.createTextNode(String.valueOf(listaSubTareas.get(a).getTiempo())));
                supercar.appendChild(carname1);

                Element carname2 = doc.createElement("Inicio");
                carname2.appendChild(
                        doc.createTextNode(String.valueOf(listaSubTareas.get(a).getInicio())));
                supercar.appendChild(carname2);

                Element carname3 = doc.createElement("Finaliza");
                carname3.appendChild(
                        doc.createTextNode(String.valueOf(listaSubTareas.get(a).getFinaliza())));
                supercar.appendChild(carname3);

                Element carname4 = doc.createElement("Estado");
                carname4.appendChild(
                        doc.createTextNode(String.valueOf(listaSubTareas.get(a).getEstado())));
                supercar.appendChild(carname4);
            }

            // write the content into xml file
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(".\\"+fichero));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult =
                    new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void lecturaXMLTareas(String arxivo){
        String fichero = ".\\"+arxivo+".xml";

        try {
            File stocks = new File(fichero);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();

            System.out.println("arrel " + doc.getDocumentElement().getNodeName());
            NodeList nodes = (NodeList) doc.getElementsByTagName("Tareas").item(0);

            for (int i=0; i< nodes.getLength(); i++){
                Node node = nodes.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Nombre: " + obtenirContingut("Nombre", element));
                    String nombre = obtenirContingut("Nombre", element);
                    System.out.println("Tiempo: " + obtenirContingut("Tiempo", element));
                    Integer tiempo = Integer.parseInt(obtenirContingut("Tiempo", element));
                    System.out.println("inicio: " + obtenirContingut("Inicio", element));
                    Integer inicio = Integer.parseInt(obtenirContingut("Inicio", element));

                    System.out.println("Finaliza: " + obtenirContingut("Finaliza", element));
                    Integer finaliza = Integer.parseInt(obtenirContingut("Finaliza", element));
                    System.out.println("Estado: " + obtenirContingut("Estado", element));
                    Integer estado = Integer.parseInt(obtenirContingut("Estado", element));

                    Subtarea subtareaXML = new Subtarea(nombre,tiempo,inicio,finaliza,estado);
                    listaSubTareas.add(subtareaXML);
                }

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void crearXMLUsuario(){
        int a = 0;
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder =
                    dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            // root element
            Element rootElement = doc.createElement("Users");
            doc.appendChild(rootElement);

            for (a=0;a<listaUsuarios.size();a++) {
                //  supercars element
                Element supercar = doc.createElement("User");
                rootElement.appendChild(supercar);

                // carname element
                Element carname = doc.createElement("Nombre");
                carname.appendChild(
                        doc.createTextNode(listaUsuarios.get(a).getNombre()));
                supercar.appendChild(carname);

                Element carname1 = doc.createElement("Contraseña");
                carname1.appendChild(
                        doc.createTextNode(String.valueOf(listaUsuarios.get(a).getContraseña())));
                supercar.appendChild(carname1);

            }

            // write the content into xml file
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer =
                    transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(".\\usuarios.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult =
                    new StreamResult(System.out);
            transformer.transform(source, consoleResult);

            System.out.println(source.getNode());
            System.out.println(source);
            System.out.println(doc);
            System.out.println(doc.getParentNode());
            System.out.println(doc.getDocumentURI());
            System.out.println(result);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void lecturaXMLUsuario() throws FileNotFoundException{
        try {
            File stocks = new File(".\\usuarios.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();

            System.out.println("arrel " + doc.getDocumentElement().getNodeName());
            NodeList nodes = (NodeList) doc.getElementsByTagName("Users").item(0);

            for (int i=0; i< nodes.getLength(); i++){
                Node node = nodes.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Nombre: " + obtenirContingut("Nombre", element));
                    String nombre = obtenirContingut("Nombre", element);
                    System.out.println("Contraseña: " + obtenirContingut("Contraseña", element));
                    String contraseña = obtenirContingut("Contraseña", element);

                    Usuario usuarioXML = new Usuario(nombre,contraseña);
                    listaUsuarios.add(usuarioXML);
                }

            }

            System.out.println(stocks.getAbsolutePath());

        }catch (FileNotFoundException ex){
            System.out.println("aun no hay usuarios");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }



}
