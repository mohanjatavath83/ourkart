package com.ourkart.facade.populator;

import com.ourkart.data.AddressData;
import com.ourkart.data.UserData;
import com.ourkart.model.AddressModel;
import com.ourkart.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserPopulator implements Populator<UserModel,UserData>
{

    public UserData populate(UserModel userModel)
    {
        UserData userData = new UserData();
        userData.setUid(userModel.getUid());
        userData.setFirstName(userModel.getFirstName());
        userData.setLastName(userModel.getLastName());
        userData.setEmail(userModel.getEmail());
        userData.setMobileNumber(userModel.getMobileNumber());

        List<AddressModel> addressModelList = userModel.getAddress();
        if(addressModelList!=null && addressModelList.size()>0)
        {
            List<AddressData> addressDataList = new ArrayList<>();
            for(AddressModel addressModel : addressModelList)
            {
                AddressData addressData = new AddressData();
                addressData.setLine1(addressModel.getLine1());
                addressData.setLine2(addressModel.getLine2());
                addressData.setLine3(addressModel.getLine3());
                addressData.setCity(addressModel.getCity());
                addressData.setCountry(addressModel.getCountry());
                addressData.setPostalcode(addressModel.getPostalcode());
                addressDataList.add(addressData);
            }

            userData.setAddresses(addressDataList);
        }

        return userData;

    }

}
