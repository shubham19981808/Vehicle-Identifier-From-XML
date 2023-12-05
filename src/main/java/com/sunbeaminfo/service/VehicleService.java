package com.sunbeaminfo.service;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

public class VehicleService {

    private static final String VEHICLE = "vehicle";
    private static final String WHEEL_ELEMENT = "wheel";
    private static final String POSITION = "position";
    private static final String FRAME_MATERIAL = "material";
    private static final String POWERTRAIN_TYPE = "powertrain";
    private static final String HUMAN = "human";

    public static void readXmlAndIdentifyVehicles(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList vehicleList = doc.getElementsByTagName(VEHICLE);

            for (int temp = 0; temp < vehicleList.getLength(); temp++) {
                Element vehicleElement = (Element) vehicleList.item(temp);
                identifyAndPrintVehicle(vehicleElement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void identifyAndPrintVehicle(Element vehicleElement) {
        String frameMaterial = getTextContent(vehicleElement, FRAME_MATERIAL);

        NodeList wheelsList = vehicleElement.getElementsByTagName(WHEEL_ELEMENT);
        boolean isPlastic = false;
        boolean isMetal = false;
        String wheelPosition = null; // Initialize wheelPosition outside the loop
        for (int i = 0; i < wheelsList.getLength(); i++) {
            Element wheelElement = (Element) wheelsList.item(i);
            String wheelMaterial = getTextContent(wheelElement, FRAME_MATERIAL);
            wheelPosition = getTextContent(wheelElement, POSITION); // Updated line

            if ("plastic".equalsIgnoreCase(frameMaterial) && "plastic".equalsIgnoreCase(wheelMaterial)) {
                isPlastic = true;
            } else if ("metal".equalsIgnoreCase(frameMaterial) && "metal".equalsIgnoreCase(wheelMaterial)) {
                isMetal = true;
            }

            
        }

        String powertrainType = getPowertrainType(vehicleElement);

        if (isPlastic) {
            if ("bernoulli".equalsIgnoreCase(powertrainType)) {
                System.out.println("Vehicle_id: " + getTextContent(vehicleElement, "id") + ", Vehicle_type : HangGlider");
            } else {
                System.out.println("Vehicle_id: " + getTextContent(vehicleElement, "id") + ", Vehicle_type : Big_Wheel");
            }

        } else if (isMetal && "human".equalsIgnoreCase(powertrainType)) {
            System.out.println("Vehicle_id: " + getTextContent(vehicleElement, "id") + ", Vehicle_type : Bicycle");
        } else if (isMetal && "internalcombustion".equalsIgnoreCase(powertrainType) && ("front".equalsIgnoreCase(wheelPosition) || "rear".equalsIgnoreCase(wheelPosition))) {
            System.out.println("Vehicle_id: " + getTextContent(vehicleElement, "id") + ", Vehicle_type : Motorcycle");
        } else if (isMetal && "internalcombustion".equalsIgnoreCase(powertrainType) && ("frontright".equalsIgnoreCase(wheelPosition) || "frontleft".equalsIgnoreCase(wheelPosition) || "rearright".equalsIgnoreCase(wheelPosition) || "rearleft".equalsIgnoreCase(wheelPosition))) {
            System.out.println("Vehicle_id: " + getTextContent(vehicleElement, "id") + ", Vehicle_type : Car");
        } else {
            System.out.println("Vehicle_id: " + getTextContent(vehicleElement, "id") + ", Vehicle_type : Unknown_vehicle");
        }

        System.out.println();
    }

    private static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }

    private static String getPowertrainType(Element vehicleElement) {
        Element powertrainElement = (Element) vehicleElement.getElementsByTagName(POWERTRAIN_TYPE).item(0);
        NodeList childNodes = powertrainElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                return childNodes.item(i).getNodeName();
            }
        }
        return null;
    }
}