package com.e2e.vehicle.reg.model;

public class VehicleRegistrationDetails {

    private String vehicleModel;
    private String vehicleRegistrationNumber;
    private String vehicleColour;

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleRegistrationDetails that = (VehicleRegistrationDetails) o;

        if (vehicleModel != null ? !vehicleModel.equals(that.vehicleModel) : that.vehicleModel != null) return false;
        if (vehicleRegistrationNumber != null ? !vehicleRegistrationNumber.equals(that.vehicleRegistrationNumber) : that.vehicleRegistrationNumber != null)
            return false;
        return vehicleColour != null ? vehicleColour.equals(that.vehicleColour) : that.vehicleColour == null;
    }

    @Override
    public int hashCode() {
        int result = vehicleModel != null ? vehicleModel.hashCode() : 0;
        result = 31 * result + (vehicleRegistrationNumber != null ? vehicleRegistrationNumber.hashCode() : 0);
        result = 31 * result + (vehicleColour != null ? vehicleColour.hashCode() : 0);
        return result;
    }
}
