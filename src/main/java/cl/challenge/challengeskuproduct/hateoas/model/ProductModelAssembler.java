package cl.challenge.challengeskuproduct.hateoas.model;

import cl.challenge.challengeskuproduct.controller.ProductController;
import cl.challenge.challengeskuproduct.persistence.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductModel > {

    public ProductModelAssembler() {
        super(ProductController.class, ProductModel.class);
    }

    @Override
    public ProductModel toModel(Product entity) {
        ProductModel model = instantiateModel(entity);
        model.add(linkTo(methodOn(ProductController.class)
                .getProducBySku(entity.getSku()))
                .withSelfRel());

        BeanUtils.copyProperties(entity, model);
        return model;
    }

    @Override
    public CollectionModel<ProductModel> toCollectionModel(Iterable<? extends Product> entities) {
        CollectionModel<ProductModel> productModels = super.toCollectionModel(entities);
        productModels.add(linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
        return productModels;

    }
}