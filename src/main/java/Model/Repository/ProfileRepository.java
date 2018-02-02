package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.UserModel.UserInfo.Address;
import Model.UserModel.UserInfo.Profile;

public class ProfileRepository {

    public static void addAddress(Profile profile, Address address){
        profile.getAddressList().add(address);
        Hibernate.update(address);
    }
}
