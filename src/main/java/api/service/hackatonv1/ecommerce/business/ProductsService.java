package api.service.hackatonv1.ecommerce.business;

import api.service.hackatonv1.ecommerce.model.ProductDto;
import com.hackatonv1.openapi.model.Product;
import io.reactivex.Single;

public interface ProductsService {

    Single<Product> getById(ProductDto productDto);
}
