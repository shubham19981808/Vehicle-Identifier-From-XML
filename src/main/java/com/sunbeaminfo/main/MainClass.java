package com.sunbeaminfo.main;

import com.sunbeaminfo.service.VehicleService;

public class MainClass {

    public static void main(String[] args) {
        if (args.length > 0) {
            String xmlFilePath = args[0];
            VehicleService.readXmlAndIdentifyVehicles(xmlFilePath);
        } else {
            System.out.println("Please provide the path to the XML file as a command line argument.");
        }
    }
}
