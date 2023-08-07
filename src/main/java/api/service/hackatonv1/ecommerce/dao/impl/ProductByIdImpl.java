package api.service.hackatonv1.ecommerce.dao.impl;

import api.service.hackatonv1.ecommerce.dao.ProductById;
import api.service.hackatonv1.ecommerce.dao.repository.ProductRepository;
import api.service.hackatonv1.ecommerce.model.ProductDto;
import api.service.hackatonv1.ecommerce.thirdparty.ProductsEntity;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
@Slf4j
@AllArgsConstructor
public class ProductByIdImpl implements ProductById {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Single<ProductDto> getProductById(String productId) {
        return productRepository.findByProductId(productId)
                .subscribeOn(Schedulers.io())
                .toList()
                .flatMap(productsList -> {
                    if (productsList.isEmpty()) {
                        return Single.just(new ProductsEntity()); // Proporciona un ProductsEntity vacío si no se encuentra ningún producto
                    } else {
                        return Single.just(productsList.get(0));
                    }
                })
                .map(productsEntity -> convertToResponse(productsEntity, productId));
    }

    private ProductDto convertToResponse(ProductsEntity productsEntity, String productId) {
        if (productsEntity == null) {
            log.info("No se econtro respuesta en la bd");
        }

        return ProductDto.builder()
                .id(productId)
                .name(productsEntity.getName())
                .description(productsEntity.getDescription())
                .price(productsEntity.getPrice())
                .stock(productsEntity.getStock())
                .build();
    }

}
