package com.dataformats.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.dataformats.clases.Order;

public class OrderProcessor implements Processor{

	@Override
	public void process(Exchange ex) throws Exception {
		Order order = ex.getIn().getBody(Order.class);
		if (Integer.parseInt(order.getTotal()) > 1000000) {
			order.setApproved("Aprovada");
		} else {
			order.setApproved("No aprovada");
		}
		order.setItemsQuantity(Integer.toString((Integer.parseInt(order.getOrderId()) * 2)));
	}

}
