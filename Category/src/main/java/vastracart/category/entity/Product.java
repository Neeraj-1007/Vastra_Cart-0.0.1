package vastracart.category.entity;

import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vastracart.category.Response;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Setter
@ToString
public class Product extends Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_COMPANY")
    private String company;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "COLOR")
    @ElementCollection(targetClass=String.class)
    private List<String> colour;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "DESCRIPTION")
    private String description;


//private Category category;

    @Column(name = "FEATURED")
    private String featured;
}
