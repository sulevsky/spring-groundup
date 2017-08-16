package com.sulevsky.service;

public class IdGeneratorImpl implements IdGenerator {
    private static int lastFreeId = 0;

    @Override
    public String generateId() {
        return lastFreeId++ + "";
    }
}
