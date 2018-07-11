package com.db.controller;

import com.db.entities.BookInfo;
import com.db.repository.BookInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class BookInfoController {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @GetMapping("/getBookInfo")
    public BookInfo getBookInfo() {
        return bookInfoMapper.selectByPrimaryKey(BigInteger.valueOf(1L));
    }

}
