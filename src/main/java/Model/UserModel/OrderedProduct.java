package Model.UserModel;

import Model.ProductModel.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class OrderedProduct extends Product {

    @Column
    private Integer count;

    @JoinColumn
    @ManyToOne(cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Color color;

    @Column
    private Long totalPrice;


    public OrderedProduct(String name, String persianName, Long price, ProductStatus status, Integer remainingCount, String briefDescription, Integer visitCount, Integer sellCount, Date releaseDate, String review, Brand brand, List<Attribute> attributes, List<Color> colors, Guaranty guaranty, Long discount, Integer count, Color color, Long totalPrice) {
        super(name, persianName, price, status, remainingCount, briefDescription, visitCount, sellCount, releaseDate, review, brand, attributes, colors, guaranty, discount);
        this.count = count;
        this.color = color;
    }

    public OrderedProduct(Integer count, Color color, Long totalPrice, Product product) {

        this.count = count;
        this.color = color;
        this.totalPrice = totalPrice;
        this.setName(product.getName());
        this.setPersianName(product.getPersianName());
        this.setPrice(product.getPrice());
        this.setStatus(product.getStatus());
        this.setRemainingCount(product.getRemainingCount());
        this.setBriefDescription(product.getBriefDescription());
        this.setVisitCount(product.getVisitCount());
        this.setSellCount(product.getSellCount());
        this.setReleaseDate(product.getReleaseDate());
        this.setReview(product.getReview());
        this.setBrand(product.getBrand());
        this.setAttributes(product.getAttributes());
        this.setColors(product.getColors());
        this.setGuaranty(product.getGuaranty());
        this.setDiscount(product.getDiscount());

    }
    public OrderedProduct(Product product) {

        this.setName(product.getName());
        this.setPersianName(product.getPersianName());
        this.setPrice(product.getPrice());
        this.setStatus(product.getStatus());
        this.setRemainingCount(product.getRemainingCount());
        this.setBriefDescription(product.getBriefDescription());
        this.setVisitCount(product.getVisitCount());
        this.setSellCount(product.getSellCount());
        this.setReleaseDate(product.getReleaseDate());
        this.setReview(product.getReview());
        this.setBrand(product.getBrand());
        this.setAttributes(product.getAttributes());
        this.setColors(product.getColors());
        this.setGuaranty(product.getGuaranty());
        this.setDiscount(product.getDiscount());

    }


    public void setCount(Integer count) {
        this.count = count;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderedProduct() {
    }

    @Override
    public String toString() {
        return "OrderedProduct{" +
                "count=" + count +
                ", color=" + color +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
