package cl.challenge.challengeskuproduct.persistence.dao;

import cl.challenge.challengeskuproduct.persistence.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDAO extends PagingAndSortingRepository<Product, String> {
}
