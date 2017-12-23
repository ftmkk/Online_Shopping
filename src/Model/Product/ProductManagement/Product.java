package Model.Product.ProductManagement;

import Model.Product.AttributeManagement.AttributeRepository;

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
    private List<AttributeRepository> attrs;
    private List<Color> colors;
    private Guaranty guaranty;
    private Long discount;


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

    public List<AttributeRepository> getAttrs() {
        return attrs;
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

}
