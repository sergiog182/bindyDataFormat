package com.dataformats.aggregators;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.dataformats.clases.Order;

public class AggregateOrders implements AggregationStrategy{

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		List<Order> ordenes = null; 
		Order newOrder = newExchange.getIn().getBody(Order.class);
		if (oldExchange == null) {
			ordenes = new ArrayList<Order>();
		} else {
			ordenes = oldExchange.getIn().getBody(ArrayList.class);
		}
		
		ordenes.add(newOrder);
		newExchange.getIn().setBody(ordenes);
		return newExchange;
	}

}
