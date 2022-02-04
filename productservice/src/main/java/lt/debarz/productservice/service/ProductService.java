package lt.debarz.productservice.service;

import lombok.AllArgsConstructor;
import lt.debarz.productservice.model.Product;
import lt.debarz.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Returns the product with the specified id.
     *
     * @param id        ID of the product to retrieve.
     * @return          The requested Product if found.
     */
    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }

    /**
     * Returns all products in the database.
     *
     * @return          All products in the database.
     */
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    /**
     * Updates the specified product, identified by its id.
     *
     * @param product   The product to update.
     * @return          True if the update succeeded, otherwise false.
     */
    public boolean update(Product product){
        return productRepository.update(product);
    }

    /**
     * Saves the specified product to the database.
     *
     * @param product   The product to save to the database.
     * @return          The saved product.
     */
    public Product save(Product product){
        product.setVersion(1);
        return productRepository.save(product);
    }

    /**
     * Deletes the product with the specified id.
     * @param id        The id of the product to delete.
     * @return          True if the operation was successful.
     */
    public boolean delete(Integer id){
        return productRepository.delete(id);
    }
}
