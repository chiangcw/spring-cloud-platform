package com.chiangcw.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hello")
@Api("问候类")
public class HelloWorldController
{
    @RequestMapping(path = "/friend", method = RequestMethod.GET)
    @ApiOperation(value="问候朋友")
    public String helloWorld()
    {
        return "jiaojiao";

    }
}
