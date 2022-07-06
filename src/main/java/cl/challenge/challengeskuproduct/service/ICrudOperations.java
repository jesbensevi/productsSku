package cl.challenge.challengeskuproduct.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICrudOperations<T> {

    Optional<T> findBySku(final String sku);
    List<T> findAll();
    Page<T> findPaginated(Pageable pageable);
    T create(final T entity);
    T update(final T entity);
    void delete(final T entity);
    void deleteBySku(final String sku);



}