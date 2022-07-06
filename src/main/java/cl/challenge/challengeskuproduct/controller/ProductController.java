package cl.challenge.challengeskuproduct.controller;

import cl.challenge.challengeskuproduct.hateoas.model.ProductModel;
import cl.challenge.challengeskuproduct.hateoas.model.ProductModelAssembler;
import cl.challenge.challengeskuproduct.persistence.model.Product;
import cl.challenge.challengeskuproduct.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    private IProductService service;

    private ProductModelAssembler productModelAssembler;

    private PagedResourcesAssembler<Product> pagedResourcesAssembler;

    @Autowired
    public ProductController(IProductService service, ProductModelAssembler productModelAssembler, PagedResourcesAssembler<Product> pagedResourcesAssembler) {

        this.service = service;
        this.productModelAssembler = productModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping("{sku}")
    public ResponseEntity<ProductModel> getProducBySku(@PathVariable("sku") String sku){
        return this.service.findBySku(sku)
                .map(productModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound()
                        .build());
    }

    @GetMapping("/list")
    public ResponseEntity<PagedModel<ProductModel>> getAllProducts(Pageable pageable){
        Page<Product> productPage = this.service.findPaginated(pageable);
        PagedModel<ProductModel> pagedModel = this.pagedResourcesAssembler.toModel(productPage, this.productModelAssembler);
        return new ResponseEntity<>(pagedModel, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<CollectionModel<ProductModel>> getAllProducts(){
        List<Product> productsList = this.service.findAll();
        return new ResponseEntity<>(
                this.productModelAssembler.toCollectionModel(productsList),
                HttpStatus.OK
        );
    }
    @PostMapping
    public ResponseEntity<ProductModel> save(@RequestBody Product product){
        return new ResponseEntity<>(this.productModelAssembler.toModel(this.service.create(product)), HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<ProductModel> update(@RequestBody Product product){
        return new ResponseEntity<>(this.productModelAssembler.toModel(this.service.update(product)), HttpStatus.CREATED);
    }
    @DeleteMapping("{sku}")
    public ResponseEntity<?> delete(@PathVariable("sku") String sku){
        this.service.deleteBySku(sku);
        return  ResponseEntity.ok("Deleted");
    }

}