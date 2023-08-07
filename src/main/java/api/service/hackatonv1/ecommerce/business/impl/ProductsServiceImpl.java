package api.service.hackatonv1.ecommerce.business.impl;

import api.service.hackatonv1.ecommerce.business.ProductsService;
import api.service.hackatonv1.ecommerce.dao.ProductById;
import api.service.hackatonv1.ecommerce.model.ProductDto;
import com.hackatonv1.openapi.model.Product;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Lazy
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductById productById;

    @Override
    public Single<Product> getById(ProductDto productDto) {
        return productById.getProductById(productDto.getId())
                .map(this::convertToResponse);
    }

    private Product convertToResponse(
            ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        return product;
    }
}
