package labs.pm.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import static labs.pm.data.Rating.*;

public class Product {

    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this(id,name,price,NOT_RATED);
    }

    public Product(){
        this(0,"no name",BigDecimal.ZERO);
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

    public BigDecimal getPrice() {
        return price;
    }

    /*public void setPrice(final BigDecimal price) {
        this.price = price;
    }*/

    public BigDecimal getDiscount(){
        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

    public Product applyRating (Rating newRating){
        return new Product(id,name,price,newRating);
    }

    @Override
    public String toString() {
        return id+", "+name+", "+price+", "+getDiscount()+", "+rating.getStars();
    }
}
