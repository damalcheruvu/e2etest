package com.e2e.vehicle.reg.model;


public class VehicleRegistrationFile {

    private String fileName;
    private Long fileSize;
    private String fileMimeType;
    private String fileExtension;
    private VehicleRegistrationDetails vehicleDetails;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public VehicleRegistrationDetails getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleRegistrationDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleRegistrationFile that = (VehicleRegistrationFile) o;

        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (fileSize != null ? !fileSize.equals(that.fileSize) : that.fileSize != null) return false;
        if (fileMimeType != null ? !fileMimeType.equals(that.fileMimeType) : that.fileMimeType != null) return false;
        if (fileExtension != null ? !fileExtension.equals(that.fileExtension) : that.fileExtension != null)
            return false;
        return vehicleDetails != null ? vehicleDetails.equals(that.vehicleDetails) : that.vehicleDetails == null;
    }

    @Override
    public int hashCode() {
        int result = fileName != null ? fileName.hashCode() : 0;
        result = 31 * result + (fileSize != null ? fileSize.hashCode() : 0);
        result = 31 * result + (fileMimeType != null ? fileMimeType.hashCode() : 0);
        result = 31 * result + (fileExtension != null ? fileExtension.hashCode() : 0);
        result = 31 * result + (vehicleDetails != null ? vehicleDetails.hashCode() : 0);
        return result;
    }
}
