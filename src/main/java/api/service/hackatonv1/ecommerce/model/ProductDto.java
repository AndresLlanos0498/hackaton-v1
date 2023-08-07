package api.service.hackatonv1.ecommerce.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private double price;
    private String description;
    private Integer stock;
}
