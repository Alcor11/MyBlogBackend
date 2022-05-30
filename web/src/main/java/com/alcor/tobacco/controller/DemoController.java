package com.alcor.tobacco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author guchun
 * @description TODO
 * @date 2022/5/24 20:09
 */
@RestController
@RequestMapping("/hello")
public class DemoController {

    @GetMapping("/pi")
    public String hello() {
        return "po";
    }

}
