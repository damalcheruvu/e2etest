package com.e2e.vehicle.reg.client;

import com.e2e.vehicle.reg.model.VehicleRegistrationDetails;
import com.e2e.vehicle.reg.model.VehicleRegistrationFile;

import java.io.IOException;
import java.util.List;

public interface VehicleRegistrationClient {

    /**
     * This method is to get all VehicleRegistrationFile`s from given directory path
     * @param path
     * @return
     * @throws IOException
     */
    public List<VehicleRegistrationFile> findAllVehicleRegistrationDirectoryDetails(String path) throws IOException;

    /**
     * This method is to get all VehicleRegistrationFile from given file name
     * @param filename
     * @return
     */
    public VehicleRegistrationFile findVehicleRegistrationFileDetailsFromFile(String filename);

    /**
     * This method is to get all VehicleRegistrationDetails from given file name
     * @param filename
     * @return
     */
    public VehicleRegistrationDetails findVehicleRegistrationDetailsFromFile(String filename);
}
