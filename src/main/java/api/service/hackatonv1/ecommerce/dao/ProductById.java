package api.service.hackatonv1.ecommerce.dao;

import api.service.hackatonv1.ecommerce.model.ProductDto;
import io.reactivex.Single;

public interface ProductById {
    Single<ProductDto> getProductById(String productId);
}
