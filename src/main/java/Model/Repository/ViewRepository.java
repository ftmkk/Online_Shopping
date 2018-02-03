package Model.Repository;

import Model.DatabaseOperations.Hibernate;
import Model.Entities.UserInfo.User;
import Model.Entities.UserInfo.View;

import java.util.List;

/**
 * Created by nejati on 03/02/2018.
 */
public class ViewRepository {

    public static boolean addViewUser(View view){
        String key = "user";
        String value = view.getUser().getId().toString();
        boolean result = Hibernate.addIfNotExist(view,key,value);
        View v = (View) Hibernate.getByKey(view.getClass(),key,value);
        view.setId(v.getId());
        return result;
    }

    public static List<View> getByProperty(User user) {
        List<View> views= Hibernate.getByProperty(View.class,user.getId().toString());
        return views;
    }

    public static View getById(Integer id){
        return (View) Hibernate.getById(View.class,id);
    }

    public static List<View> getAll(){
        return (List<View>)(Object) Hibernate.getAll(View.class);
    }

}
