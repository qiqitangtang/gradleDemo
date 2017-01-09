package com.roobo.demo.concurrent.test;

import java.util.concurrent.atomic.AtomicLong;

/**
 ID序列生成器
*/
public class IdGenerator {

    private final AtomicLong sequenceNumber = new AtomicLong(0);

    public long next() {
        return sequenceNumber.addAndGet(1);
    }


    public static void main(String[] args) {
        IdGenerator idGenerator1 = new IdGenerator();
        System.out.println(idGenerator1.next());
        IdGenerator idGenerator2 = new IdGenerator();
        System.out.println(idGenerator2.next());
    }
}