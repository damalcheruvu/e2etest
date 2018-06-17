package com.e2e.vehicle.reg.service;

import com.e2e.vehicle.reg.model.VehicleRegistrationDetails;
import com.e2e.vehicle.reg.model.VehicleRegistrationFile;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jeevand
 * Junit tests for FileReaderServiceImpl
 * (As I'm writing this on a linux OS the only way to ensure excel (.xls) files are read is by
 *  testing via unit tests using temporary files.)
 */
public class VehicleRegistrationServiceImplTest {


    private final String testDataPath = "/Users/jeevan/Downloads/come2evehicle/src/test/resources/testData";

    private final String testEmptyDataPath = "/Users/jeevan/Downloads/come2evehicle/src/test/resources/testEmptyData";

    private VehicleRegistrationService fileReaderService;

    @Before
    public void setUp() throws Exception {
        fileReaderService = new VehicleRegistrationServiceImpl();
    }


    @Test
    public void testThreeDirectoriesDown() throws Exception {
        List<VehicleRegistrationFile> fileDetailsList = fileReaderService.findAllVehicleRegistrationFilesDetails(testDataPath);
        assertEquals(11, fileDetailsList.size());
    }

    @Test
    public void testEmptyDirectory() throws Exception {
        List<VehicleRegistrationFile> fileDetailsList = fileReaderService.findAllVehicleRegistrationFilesDetails(testEmptyDataPath);
        assertEquals(null, fileDetailsList);
    }

    @Test
    public void testMimeTypeCSV () throws Exception {
        List<VehicleRegistrationFile> fileDetailsList = fileReaderService.findAllVehicleRegistrationFilesDetails(testDataPath);
        VehicleRegistrationFile fileDetails = fileReaderService.findVehicleRegistrationFileDetailsFromFile("test1.csv");
        assertEquals("csv", fileDetails.getFileMimeType());
    }

    @Test
    public void testVehicleDetailsAddedCSV() throws Exception {
        List<VehicleRegistrationFile> fileDetailsList = fileReaderService.findAllVehicleRegistrationFilesDetails(testDataPath);
        VehicleRegistrationDetails vehicleDetails = fileReaderService.findVehicleRegistrationDetailsFromFile("test1.csv");
        assertEquals("AR07XPH", vehicleDetails.getVehicleRegistrationNumber());
        assertEquals("HONDA", vehicleDetails.getVehicleModel());
        assertEquals("SILVER", vehicleDetails.getVehicleColour());
    }

    @Test
    public void testVehicleDetailsAddedCSV2() throws Exception {
        List<VehicleRegistrationFile> fileDetailsList = fileReaderService.findAllVehicleRegistrationFilesDetails(testDataPath);
        VehicleRegistrationDetails vehicleDetails = fileReaderService.findVehicleRegistrationDetailsFromFile("test2.csv");
        assertEquals("AR07XPH", vehicleDetails.getVehicleRegistrationNumber());
        assertEquals("HONDA", vehicleDetails.getVehicleModel());
        assertEquals("SILVER", vehicleDetails.getVehicleColour());
    }

    @Test
    public void testVehicleDetailsAddedCSV3() throws Exception {
        List<VehicleRegistrationFile> fileDetailsList = fileReaderService.findAllVehicleRegistrationFilesDetails(testDataPath);
        VehicleRegistrationDetails vehicleDetails = fileReaderService.findVehicleRegistrationDetailsFromFile("test3.csv");
        assertEquals("AR07XPH", vehicleDetails.getVehicleRegistrationNumber());
        assertEquals("HONDA", vehicleDetails.getVehicleModel());
        assertEquals("SILVER", vehicleDetails.getVehicleColour());
    }

    @Test
    public void testVehicleDetailsAddedCSV4() throws Exception {
        List<VehicleRegistrationFile> fileDetailsList = fileReaderService.findAllVehicleRegistrationFilesDetails(testDataPath);
        VehicleRegistrationDetails vehicleDetails = fileReaderService.findVehicleRegistrationDetailsFromFile("test4.csv");
        assertEquals("AR07XPH", vehicleDetails.getVehicleRegistrationNumber());
        assertEquals("HONDA", vehicleDetails.getVehicleModel());
        assertEquals("SILVER", vehicleDetails.getVehicleColour());
    }

    @Test
    public void testVehicleDetailsAddedCSV5() throws Exception {
        List<VehicleRegistrationFile> fileDetailsList = fileReaderService.findAllVehicleRegistrationFilesDetails(testDataPath);
        VehicleRegistrationDetails vehicleDetails = fileReaderService.findVehicleRegistrationDetailsFromFile("test5.csv");
        assertEquals("AR07XPH", vehicleDetails.getVehicleRegistrationNumber());
        assertEquals("HONDA", vehicleDetails.getVehicleModel());
        assertEquals("SILVER", vehicleDetails.getVehicleColour());
    }


}
