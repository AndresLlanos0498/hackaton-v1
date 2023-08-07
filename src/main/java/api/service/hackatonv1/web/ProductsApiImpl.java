package api.service.hackatonv1.web;

import api.service.hackatonv1.ecommerce.business.ProductsService;
import api.service.hackatonv1.ecommerce.model.ProductDto;
import com.hackatonv1.openapi.api.ProductsApiDelegate;
import com.hackatonv1.openapi.model.NewProduct;
import com.hackatonv1.openapi.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
@Slf4j
public class ProductsApiImpl implements ProductsApiDelegate {

    private ProductsService productsService;
    private ProductsMapper productsMapper;

    @Override
    public ResponseEntity<Void> addProduct(NewProduct newProduct) {
        return ProductsApiDelegate.super.addProduct(newProduct);
    }

    @Override
    public ResponseEntity<Product> getProductById(Integer productId) {
        ProductDto productDto = productsMapper.requestToDomain(productId);
        Product product = productsService.getById(productDto).blockingGet();
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<List<Product>> getProducts() {
        return ProductsApiDelegate.super.getProducts();
    }

    @Override
    public ResponseEntity<Void> updateProductById(Integer productId, Product product) {
        return ProductsApiDelegate.super.updateProductById(productId, product);
    }
}
