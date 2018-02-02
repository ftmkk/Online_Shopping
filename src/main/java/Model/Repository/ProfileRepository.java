package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.UserInfo.Address;
import Model.Entities.UserInfo.Profile;

public class ProfileRepository {

    public static void addAddress(Profile profile, Address address){
        profile.getAddressList().add(address);
        Hibernate.update(address);
    }
}
