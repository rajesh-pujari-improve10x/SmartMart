package com.improve10x.smartmart.network;

import com.improve10x.smartmart.Constants;
import com.improve10x.smartmart.cart.Cart;
import com.improve10x.smartmart.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeAPiServices {

    @GET(Constants.CATEGORIES_END_POINT)
    Call<List<String>> fetchCategories();

    @GET(Constants.PRODUCTS_END_POINT + "/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET(Constants.PRODUCT_DETAILS_END_POINT + "/{productId}")
    Call<Product> fetchProductDetails(@Path("productId") int productId);

    @GET("carts/1?userId=1")
    Call<Cart> fetchCartProducts();
}
