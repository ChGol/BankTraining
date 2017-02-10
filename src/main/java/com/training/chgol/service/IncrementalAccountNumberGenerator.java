package com.training.chgol.service;

import java.util.concurrent.atomic.AtomicLong;

public class IncrementalAccountNumberGenerator implements AccountNumberGenerator {

    private AtomicLong counter = new AtomicLong();

    @Override
    public String getNext() {
        return String.format("%026d", counter.incrementAndGet());
    }

}
