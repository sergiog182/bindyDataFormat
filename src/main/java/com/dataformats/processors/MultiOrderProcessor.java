package com.dataformats.processors;

import java.util.ArrayList;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.dataformats.clases.Order;

public class MultiOrderProcessor implements Processor{

	@Override
	public void process(Exchange ex) throws Exception {
		ArrayList<Order> orders = ex.getIn().getBody(ArrayList.class);
		for (Order order : orders) {
			if (Integer.parseInt(order.getTotal()) > 1000000) {
				order.setApproved("Aprovada");
			} else {
				order.setApproved("No aprovada");
			}
			order.setItemsQuantity(Integer.toString((Integer.parseInt(order.getOrderId()) * 2)));
		}
	}

}
