package com.dataformats.router;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import com.dataformats.clases.*;
import com.dataformats.processors.*;
import com.dataformats.aggregators.*;

public class MainRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		DataFormat bindy = new BindyCsvDataFormat(Order.class);
		
		from("file:files/incoming?include=order_.*csv&noop=true")
		.unmarshal(bindy)
		.log("${body}")
		.process(new OrderProcessor())
		.marshal(bindy)
		.to("file:files/outgoing?fileExist=append");
		
		from("file:files/incoming?include=multiorder.*csv&noop=true")
		.unmarshal(bindy)
		// Se utiliza split para separar las ordenes
		.split(body(), new AggregateOrders())
		.log("${body}")
		.process(new OrderProcessor())
		.end()
		
		// Este codigo funciona si no se utiliza el Split
		//.process(new MultiOrderProcessor())
		
		.marshal(bindy)
		.to("file:files/outgoing?fileExist=append");
	}

}
