package Model.Product.ProductManagement;


public class Guaranty {

    private Integer id;
    private String name;

    public Guaranty(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
