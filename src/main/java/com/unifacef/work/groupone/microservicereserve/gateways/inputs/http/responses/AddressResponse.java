package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses;

import com.unifacef.work.groupone.microservicereserve.domains.Address;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddressResponse implements Serializable {

    private static final long serialVersionUID = 9189520552888285300L;

    @ApiModelProperty(position = 0)
    private String street;

    @ApiModelProperty(position = 1)
    private String district;

    @ApiModelProperty(position = 2)
    private String zip;

    @ApiModelProperty(position = 3)
    private String city;

    @ApiModelProperty(position = 4)
    private String complement;

    @ApiModelProperty(position = 5)
    private String uf;

    public AddressResponse(final Address address){
       this.street = address.getStreet();
       this.district = address.getDistrict();
       this.zip = address.getZip();
       this.city = address.getCity();
       this.complement = address.getComplement();
       this.uf = address.getUf();
    }
}
