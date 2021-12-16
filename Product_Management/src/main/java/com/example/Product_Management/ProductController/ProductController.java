package com.example.Product_Management.ProductController;

import com.example.Product_Management.DTO.Product;
import com.example.Product_Management.Model.ProductTO;
import com.example.Product_Management.ServiceUtils.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping("/addProduct")
    public ProductTO addProduct(@RequestBody ProductTO productTO) { return service.addProductToCart(productTO);}

    @GetMapping("/productByName/{userName}")
    public List<ProductTO> findByName(@PathVariable String userName){ return service.findByName(userName);}

    @GetMapping("/showAllProduct")
    public List<Product> findAllMasterProduct(){ return service.showAllProduct();}

    @GetMapping("/showByPrice")
    public List<Product> showByPrice(){ return service.showByPrice();}

}
