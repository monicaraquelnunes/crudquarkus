package br.com.mp.product.repository;

import br.com.mp.product.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    @Transactional
    public Product save(Product product){
        persist(product);
        return product;
    }

    @Transactional
    public Product update(Long id, Product product) {
        Product productEntity = findById(id);

        productEntity.setName(product.getName());
        productEntity.setBrand(product.getBrand());
        productEntity.setPrice(product.getPrice());
        persist(productEntity);
        return productEntity;
    }

    @Transactional
    public void remove(Long id){
        Product productEntity = findById(id);
        delete(productEntity);
    }
}
