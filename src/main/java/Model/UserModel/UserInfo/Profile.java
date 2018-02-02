package Model.UserModel.UserInfo;


import javax.persistence.*;

@Entity
public class Profile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



}
