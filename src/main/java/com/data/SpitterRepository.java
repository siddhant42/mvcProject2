package com.data;

public interface SpitterRepository {
Spitter save(Spitter spitter);
Spitter findByUsername(String userName);
}
