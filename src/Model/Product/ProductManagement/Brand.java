package Model.Product.ProductManagement;


public class Brand {

    private Integer id;

    private String name;
    private String persianName;

    public Brand(Integer id, String name, String persianName) {
        this.id = id;
        this.name = name;
        this.persianName = persianName;
    }

    public boolean compare(Brand brand){
        return this.id == brand.id;
    }
}