package api.service.hackatonv1.web;

import api.service.hackatonv1.ecommerce.model.ProductDto;

public interface ProductsMapper {
    ProductDto requestToDomain(Integer productId);
}
