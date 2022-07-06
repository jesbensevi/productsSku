package cl.challenge.challengeskuproduct.service.implementation;

import cl.challenge.challengeskuproduct.persistence.dao.IProductDAO;
import cl.challenge.challengeskuproduct.persistence.model.Product;
import cl.challenge.challengeskuproduct.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private IProductDAO dao;

    @Autowired
    public ProductService(IProductDAO dao) {
        this.dao = dao;
    }


    @Override
    public Optional<Product> findBySku(String sku) {
        return this.dao.findById(sku);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) this.dao.findAll();
    }

    @Override
    public Page<Product> findPaginated(Pageable pageable) {
        return this.dao.findAll(pageable);

    }

    @Override
    public Product create(Product entity) {
        return this.dao.save(entity);
    }

    @Override
    public Product update(Product entity) {
        return this.dao.save(entity);
    }

    @Override
    public void delete(Product entity) {
        this.dao.delete(entity);
    }

    @Override
    public void deleteBySku(String sku) {
        this.dao.deleteById(sku);
    }
}