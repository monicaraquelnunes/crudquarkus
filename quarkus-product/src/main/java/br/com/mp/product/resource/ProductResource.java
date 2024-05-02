package br.com.mp.product.resource;

import br.com.mp.product.entity.Product;
import br.com.mp.product.repository.ProductRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductRepository productRepository;

    @GET
    public List<Product> List(){
        return productRepository.listAll();
    }

    @POST
    public Response create(@Valid Product product){
        Product productEntity = productRepository.save(product);
        return Response.ok(productEntity).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update (@PathParam("id") Long id, Product product){
        Product productUpdated = productRepository.update(id, product);
        return Response.ok(productUpdated).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id){
        productRepository.remove(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
