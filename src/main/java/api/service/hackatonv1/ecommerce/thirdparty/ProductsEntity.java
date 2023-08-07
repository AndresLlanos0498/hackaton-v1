package api.service.hackatonv1.ecommerce.thirdparty;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Document(collection = "Items")
@NoArgsConstructor
@AllArgsConstructor
@SuppressFBWarnings
public class ProductsEntity implements Serializable {
    @Id
    private String id;
    @PartitionKey
    private String name;
    private double price;
    private String description;
    private Integer stock;
}
