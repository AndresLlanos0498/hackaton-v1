package api.service.hackatonv1.ecommerce.config;

import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosAsyncDatabase;
import com.azure.cosmos.CosmosClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy(value = false)
@Configuration
@ConfigurationProperties
public class CosmosConfig {

    @Value("${azure.cosmosdb.uri}")
    private String uri;
    @Value("${azure.cosmosdb.key}")
    private String key;
    @Value("${azure.cosmosdb.database}")
    private String database;
    @Value("${azure.cosmosdb.collection}")
    private String collection;
    @Value("${azure.cosmosdb.is-local}")
    private boolean isLocal;
    @Value("${azure.cosmosdb.content-response-on-write-enabled:false}")
    private boolean contentResponseOnWriteEnabled;

    @Bean
    public CosmosAsyncClient cosmosAsyncClient() {
        return getBuilderWithConnectionMode(isLocal)
                .endpoint(uri)
                .key(key)
                .contentResponseOnWriteEnabled(contentResponseOnWriteEnabled)
                .buildAsyncClient();
    }

    private CosmosClientBuilder getBuilderWithConnectionMode(boolean isLocalClient) {
        CosmosClientBuilder builder = new CosmosClientBuilder();
        if (isLocalClient) {
            return builder.gatewayMode();
        }
        return builder.directMode();
    }

    @Bean
    public CosmosAsyncDatabase cosmosAsyncDatabase(CosmosAsyncClient client) {
        return client.getDatabase(database);
    }

    @Bean
    public CosmosAsyncContainer deviceByDeviceIdContainer(CosmosAsyncDatabase database) {
        return database.getContainer(collection);
    }


}
