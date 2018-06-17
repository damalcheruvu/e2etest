package com.e2e.vehicle.reg.service;

import com.e2e.vehicle.reg.model.VehicleRegistrationDetails;
import com.e2e.vehicle.reg.model.VehicleRegistrationFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class VehicleRegistrationServiceImpl implements VehicleRegistrationService {
    List<VehicleRegistrationFile> fileDetailsList = null;
    public List<VehicleRegistrationFile> findAllVehicleRegistrationFilesDetails(String path) throws IOException {
        fileDetailsList = new ArrayList<VehicleRegistrationFile>();

        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return null;

        for (File f : list) {
            fileDetailsList.add(populateVehicleRegistrationFileDetails(f));
        }
        return fileDetailsList;
    }

    public VehicleRegistrationFile findVehicleRegistrationFileDetailsFromFile(String fileName) {
        VehicleRegistrationFile fileDetails = fileDetailsList.stream()
                .filter(Objects::nonNull)
                .filter(x -> fileName.equals(x.getFileName()))
                .findAny()
                .orElse(null);
        return fileDetails;
    }

    public VehicleRegistrationDetails findVehicleRegistrationDetailsFromFile(String fileName) {
        VehicleRegistrationFile fileDetails = fileDetailsList.stream()
                .filter(Objects::nonNull)
                .filter(x -> fileName.equals(x.getFileName()))
                .findFirst()
                .orElse(null);
        return fileDetails.getVehicleDetails();
    }

    private VehicleRegistrationFile populateVehicleRegistrationFileDetails(File file) throws IOException {

        VehicleRegistrationFile fileDetails = new VehicleRegistrationFile();
        fileDetails.setFileName(file.getName());
        fileDetails.setFileSize(file.length());

        String extension = "";
        int i = file.getName().lastIndexOf('.');
        if (i > 0) {
            extension = file.getName().substring(i + 1);
        }
        fileDetails.setFileExtension(extension);
        fileDetails.setFileMimeType(extension);
        VehicleRegistrationDetails vd = setVehicleDetals(file);
        if (vd == null) {
            return null;
        }
        fileDetails.setVehicleDetails(vd);
        return fileDetails;
    }

    private VehicleRegistrationDetails setVehicleDetals(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        String line = "";
        String[] info;
        if (scanner.hasNext()) {
            line = scanner.nextLine();
        }
        scanner.close();
        if (line.contains(",")) {
            info = line.split(",");
        } else {
            info = line.split("\\s+");
        }
        VehicleRegistrationDetails vehicleDetails = new VehicleRegistrationDetails();
        if (info.length != 4) {
            return null;
        }
        vehicleDetails.setVehicleModel(info[0].toUpperCase().trim());
        vehicleDetails.setVehicleRegistrationNumber(info[1].toUpperCase().trim());
        vehicleDetails.setVehicleColour(info[2].toUpperCase().trim());

        return vehicleDetails;
    }
}
