package nnw.task;

import nnw.task.model.Address;
import nnw.task.model.AddressLineDetail;
import nnw.task.model.Country;
import nnw.task.model.ProvinceOrState;

public class PrettyPrint implements AddressPrinter{
    StringBuilder builder;
    @Override
    public String print(Address address) {
         builder = new StringBuilder();
        appendAddressDetail(address.getAddressLineDetail());
        appendCity(address.getCityOrTown());
        appendProvinceOrState(address.getProvinceOrState());
        appendPostalCode(address.getPostalCode());
        appendCountry(address.getCountry());

        String addressString = builder.toString().strip();

        if(addressString.isBlank()){
            return addressString;
        }
        return addressString.substring(0, addressString.lastIndexOf('-'));
    }

    private void appendAddressDetail(AddressLineDetail detail){
        if (detail == null){
            return;
        }
        if(detail.getLine1() != null && !detail.getLine1().isBlank()){
            String line1 = detail.getLine1();
            appendItem(line1.strip());
        }
        if (detail.getLine2() != null && !detail.getLine2().isBlank()){
            String line2 = detail.getLine2();
            appendItem(line2.strip());
        }
    }

    private void appendCity(String city){
        if(city == null || city.isBlank()){
            return;
        }
        appendItem(city.strip());
    }

    private void appendProvinceOrState(ProvinceOrState province){
        if(province == null || province.getName() == null || province.getName().isBlank()){
            return;
        }
        String provinceName = province.getName();
        appendItem(provinceName.strip());
    }

    private void appendPostalCode(String postalCode){
        if(postalCode == null || postalCode.isBlank()){
            return;
        }
        appendItem(postalCode.strip());
    }

    private void appendCountry(Country country){
        if(country == null || country.getName() == null || country.getName().isBlank()){
            return;
        }
        String countryName = country.getName();
        appendItem(countryName.strip());
    }

    private void appendItem(String item){
        builder.append(String.format("%s - ", item));
    }
}
