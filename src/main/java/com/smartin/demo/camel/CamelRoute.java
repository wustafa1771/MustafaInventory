package com.smartin.demo.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.smartin.demo.service.InventoryService;
@Component
public class CamelRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	/*
        from("direct:getAllServices")
        .bean(InventoryService.class, "getAllServices")
        .log("Received Body ${body}");*/
	}

}
