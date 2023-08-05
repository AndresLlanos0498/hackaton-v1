package com.hackatonv1.openapi.api;

import com.hackatonv1.openapi.model.NewProduct;
import com.hackatonv1.openapi.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link ProductsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-05T16:11:04.886920600-05:00[America/Lima]")
public interface ProductsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /products : Añadir un nuevo producto
     *
     * @param newProduct  (required)
     * @return Producto añadido exitosamente (status code 201)
     *         or Error del servidor (status code 500)
     * @see ProductsApi#addProduct
     */
    default ResponseEntity<Void> addProduct(NewProduct newProduct) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /products/{productId} : Obtener un producto por ID
     *
     * @param productId ID del producto a obtener (required)
     * @return Producto encontrado (status code 200)
     *         or Producto no encontrado (status code 404)
     *         or Error del servidor (status code 500)
     * @see ProductsApi#getProductById
     */
    default ResponseEntity<Product> getProductById(Integer productId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"price\" : 0.8008281904610115, \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"stock\" : 6 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /products : Obtener lista de productos
     *
     * @return Lista de productos exitosa (status code 200)
     *         or Error del servidor (status code 500)
     * @see ProductsApi#getProducts
     */
    default ResponseEntity<List<Product>> getProducts() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"price\" : 0.8008281904610115, \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"stock\" : 6 }, { \"price\" : 0.8008281904610115, \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"stock\" : 6 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /products/{productId} : Modificar datos de un producto por ID
     *
     * @param productId ID del producto a modificar (required)
     * @param product  (required)
     * @return Producto modificado exitosamente (status code 200)
     *         or Producto no encontrado (status code 404)
     *         or Error del servidor (status code 500)
     * @see ProductsApi#updateProductById
     */
    default ResponseEntity<Void> updateProductById(Integer productId,
        Product product) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
