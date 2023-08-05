package api.service.hackatonv1.ecommerce.dao.repository;

import api.service.hackatonv1.ecommerce.thirdparty.ProductsEntity;
import io.reactivex.Observable;

import java.util.Observable;

public interface ProductRepository {

    public Observable<ProductsEntity> findByProductId(String productId);
}
