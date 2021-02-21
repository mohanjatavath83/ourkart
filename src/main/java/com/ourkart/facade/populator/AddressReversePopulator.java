package com.ourkart.facade.populator;

import com.ourkart.data.AddressData;
import com.ourkart.model.AddressModel;
import org.springframework.stereotype.Component;

@Component
public class AddressReversePopulator implements Populator<AddressData, AddressModel> {

    @Override
    public AddressModel populate(AddressData addressData)
    {
        AddressModel addressModel = new AddressModel();
        addressModel.setLine1(addressData.getLine1());
        addressModel.setLine2(addressData.getLine2());
        addressModel.setLine3(addressData.getLine3());
        addressModel.setCity(addressData.getCity());
        addressModel.setCountry(addressData.getCountry());
        addressModel.setPostalcode(addressData.getPostalcode());
        addressModel.setIsdefault(addressData.isIsdefault());

        return addressModel;
    }
}
