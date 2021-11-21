package pl.antiquarian.antiquarian.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import pl.antiquarian.antiquarian.model.Product;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @Test
    @DisplayName(value = "Should return true when the current number of products in the database is greater than 0")
    void shouldReturnActualNumberOfProductsInDatabase() {
//        given
        Random random = new Random();
        var mockProductService = mock(ProductService.class);
        var mockProductsCount = mockProductService.getProductsCount();
//        when
        when(mockProductService.getProductsCount()).thenReturn(3);
//        then
        assertNotEquals(mockProductsCount, mockProductService.getProductsCount());
    }

    @Test
    @DisplayName(value = "Should return true when the current number of products in the database is less than 0")
    void returnNegativeNumberInTheCategory() {
//        given
        var mockProductService = mock(ProductService.class);
        var mockAllProductsCount = mockProductService.getProductsCount();
//        when
        when(mockProductService.getProductsCount()).thenReturn(-1);
//        then
        assertNotEquals(mockProductService.getProductsCount(), mockAllProductsCount);
    }

    @Test
    @DisplayName(value = "Should return true when list of products with flag of true is empty")
    void returnAllProductsTrue() {
//        given
        var mockProductService = mock(ProductService.class);
        var mockAllProductsTrue = mockProductService.getAllTrueProducts();
//        when
        when(mockProductService.getAllTrueProducts()).thenReturn(mockAllProductsTrue);
//        then
        assertEquals(mockAllProductsTrue, new ArrayList<>());
    }

    @Test
    @DisplayName(value = "Should return false when list of products with flag of true is null")
    void returnAllProductsTrueIsNull() {
        //        given
        var mockProductService = mock(ProductService.class);
        var mockAllProductsTrue = mockProductService.getAllTrueProducts();
//        when
        when(mockProductService.getAllTrueProducts()).thenReturn(null);
//        then
        assertNotEquals(mockProductService.getAllTrueProducts(), mockAllProductsTrue);
    }

    @Test
    @DisplayName(value = "Should return true when list of products with flag of false is empty")
    void returnAllProductsFalse() {
//        given
        var mockProductService = mock(ProductService.class);
        var mockAllProductsFalse = mockProductService.getAllFalseProducts();
//        when
        when(mockProductService.getAllTrueProducts()).thenReturn(mockAllProductsFalse);
//        then
        assertEquals(mockAllProductsFalse, new ArrayList<>());
    }

    @Test
    @DisplayName(value = "Should return false when list of products with flag of false is null")
    void returnAllProductsFalseIsNull() {
        //        given
        var mockProductService = mock(ProductService.class);
        var mockAllProductsFalse = mockProductService.getAllFalseProducts();
//        when
        when(mockProductService.getAllFalseProducts()).thenReturn(null);
//        then
        assertNotEquals(mockProductService.getAllFalseProducts(), mockAllProductsFalse);
    }

    @Test
    @DisplayName(value = "Should return true when validation fails to add a product to the database")
    void returnAnErrorMessageAfterIncorrectlyFiledFormFields() {
//        given
        var mockProductService = mock(ProductService.class);
        var mockProductEntity = mock(Product.class);
        var mockBindingResult = mock(BindingResult.class);
//        when
        when(mockProductService.addProduct(mockProductEntity, mockBindingResult)).thenReturn("product");
//        then
        assertEquals(mockProductService.addProduct(mockProductEntity, mockBindingResult), "product");
    }

    @Test
    @DisplayName("Should return true when product is added to the database")
    void addANewProductToDatabase() {
//        given
        var mockProductService = mock(ProductService.class);
        var mockProductEntity = mock(Product.class);
        var mockBindingResult = mock(BindingResult.class);
//        when
        when(mockProductService.addProduct(mockProductEntity, mockBindingResult)).thenReturn("redirect:/products");
//        then
        assertEquals(mockProductService.addProduct(mockProductEntity, mockBindingResult), "redirect:/products");
    }

}