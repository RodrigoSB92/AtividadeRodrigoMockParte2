package com.example.applications;

import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductApplicationTest {

    private ProductService productService;
    private ProductApplication productApplication;
    private Product product;

    @BeforeEach
    void setUp() {

        productService = mock(ProductService.class);


        productApplication = new ProductApplication(productService);


        product = new Product(1, "Agulha", 10, "/C:Imagens/agulha.jpg");
    }

    @Test
    void deveAdicionarProdutoCorretamente() {

        when(productService.save(product)).thenReturn(true);

        productApplication.append(product);

        verify(productService, times(1)).save(product);
    }

    @Test
    void deveRemoverProdutoCorretamente() {

        int productId = 1;

        productApplication.remove(productId);

        verify(productService, times(1)).remove(productId);
    }

    @Test
    void deveAtualizarProdutoCorretamente() {
        int productId = 1;

        productApplication.update(productId, product);

        verify(productService, times(1)).update(product);
    }
}