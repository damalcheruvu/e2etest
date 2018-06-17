package com.e2e.vehicle.reg.client;

import com.e2e.vehicle.reg.model.VehicleRegistrationDetails;
import com.e2e.vehicle.reg.model.VehicleRegistrationFile;
import com.e2e.vehicle.reg.service.VehicleRegistrationService;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

/**
 *
 */
public class VehicleRegistrationClientImpl implements VehicleRegistrationClient {
    private VehicleRegistrationService vehicleRegistrationService;

    @Inject
    public VehicleRegistrationClientImpl(VehicleRegistrationService vehicleRegistrationService) {
        this.vehicleRegistrationService = vehicleRegistrationService;
    }

    public List<VehicleRegistrationFile> findAllVehicleRegistrationDirectoryDetails(String path) {
        List<VehicleRegistrationFile> fileDetailsList = null;
        try {
            fileDetailsList = vehicleRegistrationService.findAllVehicleRegistrationFilesDetails(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileDetailsList;
    }

    public VehicleRegistrationFile findVehicleRegistrationFileDetailsFromFile(String filename) {
        return vehicleRegistrationService.findVehicleRegistrationFileDetailsFromFile(filename);
    }

    public VehicleRegistrationDetails findVehicleRegistrationDetailsFromFile(String filename) {
        return vehicleRegistrationService.findVehicleRegistrationDetailsFromFile(filename);
    }
}
