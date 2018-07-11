package com.ll.listener;

import org.springframework.boot.CommandLineRunner;

public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner: " + args);
    }
}
