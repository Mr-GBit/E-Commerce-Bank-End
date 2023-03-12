package com.backend.ECommerce.controller;
import com.backend.ECommerce.model.productEntity;
import com.backend.ECommerce.service.*;
import com.backend.ECommerce.service.productService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
@AllArgsConstructor
public class productController{
    private final productService productService;
    @GetMapping(path = "/getAllProduct")
    private ResponseEntity<List<productEntity>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }
    @GetMapping(path = "{productId}")
    private ResponseEntity<Optional<productEntity>> getProduct(@PathVariable ("productId") BigInteger productId){
        return new ResponseEntity<>(productService.getProduct(productId),HttpStatus.OK);
    }
    @PostMapping
    private ResponseEntity<productEntity> addNewProduct(@RequestBody productEntity productEntity){
        return new ResponseEntity<>(productService.addProduct(productEntity),HttpStatus.CREATED);
    }
    @PutMapping(path = "{productId}")
    private ResponseEntity<productEntity> updateProduct (@PathVariable ("productId") BigInteger productId,
                                                         @RequestBody productEntity productEntity){
        return new ResponseEntity<>(productService.updateProduct(productId,productEntity),HttpStatus.OK);
    }
    @DeleteMapping(path = "{productId}")
    public ResponseEntity<BigInteger> deleteCustomer (@PathVariable ("productId")BigInteger productId){
        return new ResponseEntity<>(productService.deleteProduct(productId),HttpStatus.GONE);
    }
}
