package br.com.amarobackend.controller;

import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.amarobackend.service.ProductService;

public class ProductControllerTest extends AbstractControllerTest<ProductController> {

    @MockBean
    private ProductService productService;

}
