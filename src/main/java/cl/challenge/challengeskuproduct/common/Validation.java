package cl.challenge.challengeskuproduct.common;

import cl.challenge.challengeskuproduct.exception.ProductNotFoundException;

public class Validation {

    public static <T> T checkProductNull(final T resource) throws ProductNotFoundException {
        if(resource==null){
            throw new ProductNotFoundException();
        }
        return resource;
    }
}
