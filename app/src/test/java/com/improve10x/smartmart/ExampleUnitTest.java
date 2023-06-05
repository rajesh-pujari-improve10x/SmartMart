package com.improve10x.smartmart;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.smartmart.cart.Cart;
import com.improve10x.smartmart.cart.CartProduct;
import com.improve10x.smartmart.models.Product;
import com.improve10x.smartmart.network.FakeAPiServices;
import com.improve10x.smartmart.network.FakeApi;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCategory() throws IOException {
        FakeAPiServices service = new FakeApi().createFakeApiServices();
        Call<List<String>> call = service.fetchCategories();
        List<String> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public void getProducts() throws IOException {
        FakeAPiServices services = new FakeApi().createFakeApiServices();
        Call<List<Product>> call = services.fetchProducts("electronics");
        List<Product> products = call.execute().body();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
    }

    @Test
    public void getCartProducts() throws IOException {
        FakeAPiServices services = new FakeApi().createFakeApiServices();
        Call<Cart> call = services.fetchCartProducts();
        Cart cart = call.execute().body();
        assertNotNull(cart);
        System.out.println(new Gson().toJson(cart));

    }
}