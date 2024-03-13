package com.ddrobunin.vk.api.services;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.function.Supplier;


public class BaseDtoService {
    protected <R> R execute(Supplier<Call<R>> invoker) {
        try {
            Response<R> res = invoker.get().execute();
            return res.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
