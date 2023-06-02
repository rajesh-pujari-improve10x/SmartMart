package com.improve10x.smartmart.network;

import com.improve10x.smartmart.Constants;
import com.improve10x.smartmart.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeAPiServices {

    @GET(Constants.CATEGORIES_END_POINT)
    Call<List<String>> fetchCategories();

    @GET("products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

}
