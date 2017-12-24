package Model.ProductModel.ProductManagement;

import Model.ProductModel.AttributeManagement.AttributeRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn
public class Product extends Content {

    @Column
    private String name;
    @Column
    private String persianName;
    @Column
    private Long price;
    @Column
    @Enumerated
    private ProductStatus status;
    @Column
    private Integer remainingCount;
    @Column
    private String briefDescription;
    @Column
    private Integer visitCount;
    @Column
    private Integer sellCount;
    @Column
    private Date releaseDate;
    @Column
    private String review;
    @ManyToOne
    @JoinColumn
    private Brand brand;
    @ManyToOne
    @JoinColumn
    private AttributeRepository attributes;
    @Column
    @OneToMany
    private List<Color> colors;
    @ManyToOne
    @JoinColumn
    private Guaranty guaranty;
    @Column
    private Long discount;

    public Product(String name, String persianName, Long price, ProductStatus status, Integer remainingCount, String briefDescription, Integer visitCount, Integer sellCount, Date releaseDate, String review, Brand brand, AttributeRepository attributes, List<Color> colors, Guaranty guaranty, Long discount) {
        this.name = name;
        this.persianName = persianName;
        this.price = price;
        this.status = status;
        this.remainingCount = remainingCount;
        this.briefDescription = briefDescription;
        this.visitCount = visitCount;
        this.sellCount = sellCount;
        this.releaseDate = releaseDate;
        this.review = review;
        this.brand = brand;
        this.attributes = attributes;
        this.colors = colors;
        this.guaranty = guaranty;
        this.discount = discount;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public String getPersianName() {
        return persianName;
    }

    public Long getPrice() {
        return price;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public Integer getRemainingCount() {
        return remainingCount;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getReview() {
        return review;
    }

    public Brand getBrand() {
        return brand;
    }

    public AttributeRepository getAttributes() {
        return attributes;
    }

    public List<Color> getColors() {
        return colors;
    }

    public Guaranty getGuaranty() {
        return guaranty;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setContents(){
        //QUERY PRODUCT BY NAME
    }

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(this);
        return products;
    }

}
