package Model.ProductModel.ProductInfo;

import Model.DatabaseOperations.Hibernate;
import Model.ProductModel.Categorization.Content;
import Model.DatabaseOperations.Elasticsearch;
import Model.ProductModel.Feedback.FeedbackManagement;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.net.UnknownHostException;
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
    @LazyCollection(LazyCollectionOption.FALSE)
    private Brand brand;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Attribute> attributes;

    @Column
    @OneToMany(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Color> colors;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Guaranty guaranty;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private FeedbackManagement feedbackManagement;

    @Column
    private Long discount;


    public Product(String name, String persianName, Long price, ProductStatus status, Integer remainingCount, String briefDescription, Integer visitCount, Integer sellCount, Date releaseDate, String review, Brand brand, List<Attribute> attributes, List<Color> colors, Guaranty guaranty, Long discount,FeedbackManagement FeedbackManagement) {
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
        this.feedbackManagement = FeedbackManagement;
    }

    public Product() {
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


    public void setPrice(Long price) {
        this.price = price;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public void setRemainingCount(Integer remainingCount) {
        this.remainingCount = remainingCount;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public void setGuaranty(Guaranty guaranty) {
        this.guaranty = guaranty;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }


    public void addToElastic() throws UnknownHostException {
        Elasticsearch.add(this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", status=" + status +
                ", remainingCount=" + remainingCount +
                ", briefDescription='" + briefDescription + '\'' +
                ", visitCount=" + visitCount +
                ", sellCount=" + sellCount +
                ", releaseDate=" + releaseDate +
                ", review='" + review + '\'' +
                ", brand=" + brand +
                ", attributes=" + attributes +
                ", colors=" + colors +
                ", guaranty=" + guaranty +
                ", discount=" + discount +
                '}';
    }

    public FeedbackManagement getFeedbackManagement() {
        return feedbackManagement;
    }

    public void setFeedbackManagement(FeedbackManagement feedbackManagement) {
        this.feedbackManagement = feedbackManagement;
    }
}
