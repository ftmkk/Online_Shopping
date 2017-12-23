package Model.Product.ProductManagement;

import Model.Product.AttributeManagement.AttributeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;

public class Product {

    private String name;
    private String persianName;
    private Long price;
    private Map<Date, Long> priceHistory;
    private ProductStatus status;
    private Integer remainingCount;
    private String briefDescription;
    private Integer visitCount;
    private Integer sellCount;
    private Date releaseDate;
    private List<String> images;
    private String review;
    private Brand brand;
    private AttributeRepository attributes;
    private List<Color> colors;
    private Guaranty guaranty;
    private Long discount;

    public Product(String name, String persianName, Long price, Map<Date, Long> priceHistory, ProductStatus status, Integer remainingCount, String briefDescription, Integer visitCount, Integer sellCount, Date releaseDate, List<String> images, String review, Brand brand, AttributeRepository attributes, List<Color> colors, Guaranty guaranty, Long discount) {
        this.name = name;
        this.persianName = persianName;
        this.price = price;
        this.priceHistory = priceHistory;
        this.status = status;
        this.remainingCount = remainingCount;
        this.briefDescription = briefDescription;
        this.visitCount = visitCount;
        this.sellCount = sellCount;
        this.releaseDate = releaseDate;
        this.images = images;
        this.review = review;
        this.brand = brand;
        this.attributes = attributes;
        this.colors = colors;
        this.guaranty = guaranty;
        this.discount = discount;
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

    public Map<Date, Long> getPriceHistory() {
        return priceHistory;
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

    public List<String> getImages() {
        return images;
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
