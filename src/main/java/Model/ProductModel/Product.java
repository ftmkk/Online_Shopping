package Model.ProductModel;

import Model.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.*;

@Entity
@PrimaryKeyJoinColumn
public class Product extends Content {

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

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    private Brand brand;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    private List<Attribute> attributes;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    private List<Color> colors;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    private Guaranty guaranty;

    @Column
    private Long discount;

    public Product() {
    }

    public void setContents(){

    }

    public Product(String name, String persianName, Long price, ProductStatus status, Integer remainingCount, String briefDescription, Integer visitCount, Integer sellCount, Date releaseDate, String review, Brand brand, List<Attribute> attributes, List<Color> colors, Guaranty guaranty, Long discount) {
        super(name, persianName);
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

    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(this);
        return products;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Brand getBrand() {
        return brand;
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

    public List<Color> getColors() {
        return colors;
    }

    public Guaranty getGuaranty() {
        return guaranty;
    }

    public Long getDiscount() {
        return discount;
    }

    public void save(){
        Session session = Hibernate.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(this);
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }
}
