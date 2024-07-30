package nnw.task.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import nnw.task.validation.ValidAddressLine;
import nnw.task.validation.ValidZACountry;

import java.time.LocalDateTime;

@ValidZACountry(message = "Province is required for ZA country")
@ValidAddressLine(message = "At least one address line is required")
public class Address {
    long id;

    @NotNull(message = "Address Detail cannot be empty")
    AddressLineDetail addressLineDetail;
    AddressType type;
    ProvinceOrState provinceOrState;
    String cityOrTown;

    @NotNull(message = "Country cannot be empty")
    Country country;

    @Pattern(regexp = "\\d+", message = "Postal code must be numerical")
    String postalCode;

    String suburbOrDistrict;

    LocalDateTime lastUpdated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AddressLineDetail getAddressLineDetail() {
        return addressLineDetail;
    }

    public void setAddressLineDetail(AddressLineDetail addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public ProvinceOrState getProvinceOrState() {
        return provinceOrState;
    }

    public void setProvinceOrState(ProvinceOrState provinceOrState) {
        this.provinceOrState = provinceOrState;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getSuburbOrDistrict() {
        return suburbOrDistrict;
    }

    public void setSuburbOrDistrict(String suburbOrDistrict) {
        this.suburbOrDistrict = suburbOrDistrict;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
