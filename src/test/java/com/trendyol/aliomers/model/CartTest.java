package com.trendyol.aliomers.model;

import com.trendyol.aliomers.entity.Campaign;
import com.trendyol.aliomers.entity.Category;
import com.trendyol.aliomers.entity.Product;
import com.trendyol.aliomers.service.CampaignService;
import com.trendyol.aliomers.service.CategoryService;
import com.trendyol.aliomers.service.ProductService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @author aliomers on 14.09.2020
 */

public class CartTest {

    private static Cart cart = new Cart();

    private static ProductService productService = ProductService.getInstance();
    private static Optional<Product> product = productService.list().stream().findAny();

    private static CampaignService campaignService = CampaignService.getInstance();
    private static Optional<Campaign> campaign = campaignService.list().stream().findAny();

    private static CategoryService categoryService = CategoryService.getInstance();
    private static Optional<Category> category = categoryService.list().stream().findAny();


    @Test
    public void successfulAddProductTest() {
        try {
            cart.addProduct(new CartItem(product.get(), 7));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddProductTest() {
        try {
            cart.addProduct(null);
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfulRemoveProductTest() {
        try {
            cart.addProduct(new CartItem(product.get(), 7));
            cart.removeProduct(product.get());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidRemoveProductTest() {
        try {
            cart.addProduct(new CartItem(product.get(), 7));
            cart.removeProduct(null);
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfulAddCampaignTest() {
        try {
            cart.addCampaign(campaign.get());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidAddCampaignTest() {
        try {
            cart.addCampaign(null);
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void successfulRemoveCampaignTest() {
        try {
            cart.removeCampaign(category.get());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void invalidRemoveCampaignTest() {
        try {
            cart.removeCampaign(null);
        } catch (NullPointerException e) {
            Assert.assertEquals(NullPointerException.class, e.getClass());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
