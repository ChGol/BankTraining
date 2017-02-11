package com.training.chgol.service;

import org.springframework.stereotype.Component;

@Component
public class FakeAccountNumberGenerator implements AccountNumberGenerator {

    @Override
    public String getNext() {
        return "00000000000000000000000001";
    }

}
