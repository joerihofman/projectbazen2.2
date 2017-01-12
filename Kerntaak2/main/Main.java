package main;

import connectie.Connectie;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Main {

    public static void main (String[] args) {

        /////////CONNECTIE DEEL////////
        Connectie con = new Connectie();
        System.out.println("iets gebeurt");

        /////////READER DEEL/////////
        try {
            File inputFile = new File("overige_bestanden/output.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :"
                    + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("MEASUREMENT");
            System.out.println("----------------------------");
            for (int temporary = 0; temporary < nList.getLength(); temporary++) {
                Node nNode = nList.item(temporary);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Weatherstation: "
                            + eElement
                            .getElementsByTagName("STN")
                            .item(0)
                            .getTextContent());
                    System.out.println("Date: "
                            + eElement
                            .getElementsByTagName("DATE")
                            .item(0)
                            .getTextContent());
                    System.out.println("Time: "
                            + eElement
                            .getElementsByTagName("TIME")
                            .item(0)
                            .getTextContent());
                    System.out.println("Temperature: "
                            + eElement
                            .getElementsByTagName("TEMP")
                            .item(0)
                            .getTextContent());
                    System.out.println("Dawnpoint: "
                            + eElement
                            .getElementsByTagName("DEWP")
                            .item(0)
                            .getTextContent());
                    System.out.println("Airpressure at base: "
                            + eElement
                            .getElementsByTagName("STP")
                            .item(0)
                            .getTextContent());
                    System.out.println("Airpressure at sea: "
                            + eElement
                            .getElementsByTagName("SLP")
                            .item(0)
                            .getTextContent());
                    System.out.println("Visibility: "
                            + eElement
                            .getElementsByTagName("VISIB")
                            .item(0)
                            .getTextContent());
                    System.out.println("Windspeed: "
                            + eElement
                            .getElementsByTagName("WDSP")
                            .item(0)
                            .getTextContent());
                    System.out.println("Rainfall: "
                            + eElement
                            .getElementsByTagName("PRCP")
                            .item(0)
                            .getTextContent());
                    System.out.println("Snowfall: "
                            + eElement
                            .getElementsByTagName("SNDP")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
