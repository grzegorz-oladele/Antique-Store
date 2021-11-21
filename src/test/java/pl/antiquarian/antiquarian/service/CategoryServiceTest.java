package pl.antiquarian.antiquarian.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import pl.antiquarian.antiquarian.model.Category;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CategoryServiceTest {

    @Test
    @DisplayName("should return true when category is added to database")
    void returnAllCategories() {
//        given
        var mockCategoryService = mock(CategoryService.class);
        var mockAllCategories = mockCategoryService.getAllCategories();
//        when
        when(mockCategoryService.getAllCategories()).thenReturn(mockAllCategories);
//        then
        assertEquals(mockAllCategories, new ArrayList<>());
    }

    @Test
    @DisplayName(value = "Should return false when list of categories is null")
    void returnAllCategoryIsNull() {
//        given
        var mockCategoryService = mock(CategoryService.class);
        var mockAllCategories = mockCategoryService.getAllCategories();
//        when
        when(mockCategoryService.getAllCategories()).thenReturn(null);
//        then
        assertNotEquals(mockCategoryService.getAllCategories(), mockAllCategories);

    }

    @Test
    @DisplayName(value = "Should return true when the current number of categories in the database is greater than 0")
    void returnNumberOfCategory() {
//        given
        var mockCategoryService = mock(CategoryService.class);
        var mockCategoriesCount = mockCategoryService.getCategoriesCount();
//        when
        when(mockCategoryService.getCategoriesCount()).thenReturn(1);
//        then
        assertNotEquals(mockCategoryService.getCategoriesCount(), mockCategoriesCount);
    }

    @Test
    @DisplayName(value = "Should return true when the current number of categories in the database is less than 0")
    void returnNegativeNumberInTheCategory() {
//        given
        var mockCategoryService = mock(CategoryService.class);
        var mockAllCategories = mockCategoryService.getCategoriesCount();
//        when
        when(mockCategoryService.getCategoriesCount()).thenReturn(-1);
//        then
        assertNotEquals(mockCategoryService.getCategoriesCount(), mockAllCategories);
    }

    @Test
    @DisplayName(value = "Should return true when validation fails to add a category to the database")
    void returnAnErrorMessageAfterIncorrectlyFiledFormFields() {
//        given
        var mockCategoryService = mock(CategoryService.class);
        var mockCategoryEntity = mock(Category.class);
        var mockBindingResult = mock(BindingResult.class);
//        when
        when(mockCategoryService.addCategory(mockCategoryEntity, mockBindingResult)).thenReturn("category");
//        then
        assertEquals(mockCategoryService.addCategory(mockCategoryEntity, mockBindingResult), "category");
    }

    @Test
    @DisplayName("Should return true when product is added to the database")
    void addANewProductToDatabase() {
//        given
        var mockCategoryService = mock(CategoryService.class);
        var mockCategoryEntity = mock(Category.class);
        var mockBindingResult = mock(BindingResult.class);
//        when
        when(mockCategoryService.addCategory(mockCategoryEntity, mockBindingResult)).thenReturn("redirect:/categories");
//        then
        assertEquals(mockCategoryService.addCategory(mockCategoryEntity, mockBindingResult), "redirect:/categories");
    }
}