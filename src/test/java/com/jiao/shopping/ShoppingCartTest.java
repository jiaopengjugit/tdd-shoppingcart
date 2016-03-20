package com.jiao.shopping;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jiaopengju on 16/3/20.
 */
public class ShoppingCartTest {

    ShoppingCart shoppingCart;

    @Before
    public void setUp() throws Exception {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testShouldShoppingCartNotNull() throws Exception {
        Assert.assertNotNull(shoppingCart);
    }

    @Test
    public void testShouldGetProductAmount() throws Exception {
        Assert.assertEquals(0, shoppingCart.getAmount());
    }

    @Test
    public void testShouldAddProduct() throws Exception {
        shoppingCart.addProduct(Product.APPLE);
        Assert.assertEquals(1, shoppingCart.getAmount());
    }

    @Test
    public void testShouldGetSpecifyProductAmount() throws Exception {
        Assert.assertEquals(0, shoppingCart.getProductNumber(Product.BANANA));
    }

    @Test
    public void testShouldReturnTwoWhenAddSpecifyProductTwice() throws Exception {
        shoppingCart.addProduct(Product.ORANGE);
        shoppingCart.addProduct(Product.ORANGE);
        Assert.assertEquals(2, shoppingCart.getProductNumber(Product.ORANGE));
    }

    @Test
    public void testShouldReturnOneWhenAddOneProduct() throws Exception {
        shoppingCart.addProduct(Product.ORANGE);
        Assert.assertEquals(1, shoppingCart.getProductNumber(Product.ORANGE));
    }

    @Test
    public void testShouldRemoveSpecifyProduct() throws Exception {
        shoppingCart.addProduct(Product.BANANA);
        shoppingCart.removeProduct(Product.BANANA);
        Assert.assertEquals(0, shoppingCart.getProductNumber(Product.BANANA));
    }

    @Test
    public void testShouldThrowRuntimeExceptionWhenRemoveNonExistProduct() throws Exception {
        RuntimeException exception = null;
        try {
            shoppingCart.removeProduct(Product.ORANGE);
        } catch (RuntimeException e){
            exception = e;
        }
        Assert.assertNotNull(exception);
    }

    @Test
    public void testShouldGetTotalCostOfTheShoppingCart() throws Exception {
        shoppingCart.addProduct(Product.BANANA);
        shoppingCart.addProduct(Product.APPLE);
        Assert.assertEquals(7.32, shoppingCart.getTotalCost(),0.01);
    }

    @Test
    public void testShouldReturnZeroWhenGetEmptyShoppingCartTotalCost() throws Exception {
        Assert.assertEquals(0, shoppingCart.getTotalCost(), 0.01);
    }
}
