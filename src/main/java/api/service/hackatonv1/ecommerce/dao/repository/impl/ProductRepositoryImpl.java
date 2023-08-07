package api.service.hackatonv1.ecommerce.dao.repository.impl;

import static reactor.adapter.rxjava.RxJava2Adapter.fluxToObservable;

import api.service.hackatonv1.ecommerce.dao.repository.ProductRepository;
import api.service.hackatonv1.ecommerce.thirdparty.ProductsEntity;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    CosmosAsyncContainer container;

    private static final String FIND_BY_ID = "SELECT * FROM c WHERE c.id='%s'";

    @Override
    public Observable<ProductsEntity> findByProductId(String productId) {

        return fluxToObservable(container.queryItems(String.format(FIND_BY_ID, productId),
                new CosmosQueryRequestOptions(), ProductsEntity.class));
    }
}
