package com.example.Product_Management.ServiceUtils;

import com.example.Product_Management.DTO.MasterProduct;
import com.example.Product_Management.DTO.Product;
import com.example.Product_Management.Model.ProductTO;
import com.example.Product_Management.Repository.MasterProductRepository;
import com.example.Product_Management.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    MasterProductRepository masterProductRepository;

    public ProductTO addProductToCart(ProductTO product){
        ProductTO responseObjectProduct = new ProductTO();
        Product productDB = new Product();
        List<MasterProduct> listMasterProduct = masterProductRepository.findAll();
        for(MasterProduct m : listMasterProduct){
            if (product.getProductName().equalsIgnoreCase(m.getProductName()) && m.getProductCount() > 0){
                if(product.getProductName() != null){
                    productDB.setProductName(product.getProductName());
                    responseObjectProduct.setProductName(product.getProductName());
                }
                if(product.getProductNumber() != null){
                    productDB.setProductNumber(product.getProductNumber());
                    responseObjectProduct.setProductNumber(product.getProductNumber());
                }
                if(product.getCount() != null){
                    productDB.setCount(product.getCount());
                    responseObjectProduct.setCount(product.getCount());
                }
                if(product.getProductDetails() != null){
                    productDB.setProductDetails(product.getProductDetails());
                    responseObjectProduct.setProductDetails(product.getProductDetails());
                }
                if(product.getUserId() != null){
                    productDB.setUser(product.getUserId());
                    responseObjectProduct.setUserId(product.getUserId());
                }
                if(product.getPrice() != null){
                    productDB.setPrice(product.getPrice());
                    responseObjectProduct.setPrice(product.getPrice());
                }

                m.setProductCount(m.getProductCount()- product.getCount());
                masterProductRepository.save(m);
                productRepository.save(productDB);
            }
        }
        return  responseObjectProduct;
    }

    public List<ProductTO> findByName(String userName) {
        List<ProductTO> responseObjectProduct = new ArrayList<>();
        List<Product> productDB = productRepository.findByUser(userName);
        for(Product p : productDB){
            ProductTO resObjPro = new ProductTO();
            resObjPro.setProductDetails(p.getProductDetails());
            resObjPro.setProductNumber(p.getProductNumber());
            resObjPro.setCount(p.getCount());
            resObjPro.setProductDetails(p.getProductDetails());
            responseObjectProduct.add(resObjPro);
        }
        return responseObjectProduct;
    }

    public List<Product> showAllProduct() {
        List<Product> listMasterProduct = new ArrayList<>();
        List<MasterProduct> listMasterProductDB = masterProductRepository.findAll();
        for(MasterProduct m : listMasterProductDB){
            Product product =  new Product();
            if(m.getProductCount() > 0){
                product.setProductDetails(m.getProductDescription());
                product.setProductName(m.getProductName());
                product.setPrice(m.getProductPrice());
                listMasterProduct.add(product);
            }
        }
        return listMasterProduct;
    }

    public List<Product> showByPrice() {
        List<Product> listMasterProduct = new ArrayList<>();
        List<MasterProduct> listMasterProductDB = masterProductRepository.findAll();
        listMasterProductDB.sort(Comparator.comparing(MasterProduct :: getProductPrice));
        for(MasterProduct m : listMasterProductDB) {
            Product product = new Product();
            product.setProductDetails(m.getProductDescription());
            product.setProductName(m.getProductName());
            product.setPrice(m.getProductPrice());
            listMasterProduct.add(product);
        }
        return listMasterProduct;
    }
}
