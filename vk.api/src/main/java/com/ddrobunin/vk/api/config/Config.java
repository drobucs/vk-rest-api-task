package com.ddrobunin.vk.api.config;

import com.ddrobunin.vk.api.web.JsonPlaceholderAlbumsApi;
import com.ddrobunin.vk.api.web.JsonPlaceholderPostsApi;
import com.ddrobunin.vk.api.web.JsonPlaceholderUsersApi;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
@EnableCaching
@RequiredArgsConstructor
public class Config implements WebMvcConfigurer {
    @Value("${api.jsonplaceholder.url}")
    private String jsonPlaceholderUrl;


    private Retrofit getRetrofit() {
        var client = new OkHttpClient.Builder().build();
        return new Retrofit.Builder()
                .baseUrl(jsonPlaceholderUrl)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean
    public JsonPlaceholderPostsApi getJsonPlaceholderPostsApi() {
        return getRetrofit().create(JsonPlaceholderPostsApi.class);
    }

    @Bean
    public JsonPlaceholderUsersApi getJsonPlaceholderUsersApi() {
        return getRetrofit().create(JsonPlaceholderUsersApi.class);
    }

    @Bean
    public JsonPlaceholderAlbumsApi getJsonPlaceholderAlbumsApi() {
        return getRetrofit().create(JsonPlaceholderAlbumsApi.class);
    }
}
