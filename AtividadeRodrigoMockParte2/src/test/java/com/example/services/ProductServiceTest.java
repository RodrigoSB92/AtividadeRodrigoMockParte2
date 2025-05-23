package com.example.services;

import com.example.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private ProductService productService;
    private Product product;

    @BeforeEach
    void setUp() {

        productService = spy(new ProductService());
        product = new Product(1, "Agulha", 10, "/C:Imagens/agulha.jpg");
    }

    @Test
    void deveSalvarAImagemCorretamente() {

        doReturn(true).when(productService).save(any(Product.class));

        boolean resultado = productService.save(product);

        assertTrue(resultado);

        verify(productService, times(1)).save(product);
    }

    @Test
    void deveRemoverAImagemCorretamente() {

        int productId = 1;

        doNothing().when(productService).remove(productId);

        productService.remove(productId);

        verify(productService, times(1)).remove(productId);
    }

    @Test
    void deveAtualizarAImagemCorretamente() {
        Product produtoAtualizado = new Product(1, "Produto Atualizado", 15.99f, "/novo/caminho/imagem.png");

        doNothing().when(productService).update(produtoAtualizado);

        productService.update(produtoAtualizado);

        verify(productService, times(1)).update(produtoAtualizado);
    }
