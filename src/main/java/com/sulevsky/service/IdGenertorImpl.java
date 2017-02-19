package com.sulevsky.service;

import java.util.UUID;

public class IdGenertorImpl implements IdGenerator {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
