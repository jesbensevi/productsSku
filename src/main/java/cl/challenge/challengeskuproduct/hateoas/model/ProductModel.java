package cl.challenge.challengeskuproduct.hateoas.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
public class ProductModel extends RepresentationModel<ProductModel> {

    private String sku;
    private String name;
    private String brand;
    private String size;
    private Double price;
    private String principalImage;
    private List<String> otherImages;
}

