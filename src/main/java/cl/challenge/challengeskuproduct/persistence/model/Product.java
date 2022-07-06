package cl.challenge.challengeskuproduct.persistence.model;

import lombok.*;
import org.hibernate.validator.constraints.URL;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @Pattern(regexp = "(FAL-[1-9]\\d{6,7})")
    private String sku;
    @Column(length = 50, nullable = false)
    @Size(min=3, max=50)
    @NotBlank
    private String name;
    @Column(length = 50, nullable = false)
    @Size(min=3, max=50)
    @NotBlank
    private String brand;
    @NotBlank
    private String size;
    @Min(1)
    @Max(9999999)
    private Double price;
    @Column(name = "principal_image")
    @URL
    private String principalImage;
    @ElementCollection
    private List<String> otherImages = new ArrayList<>();

}