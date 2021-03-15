package com.yykj.framework.application;

import com.yykj.framework.bean.Order;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Stream 是 Java8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。
 * 使用Stream API 对集合数据进行操作，就类似于使用 SQL 执行的数据库查询。
 * 也可以使用 Stream API 来并行执行操作。简而言之，Stream API 提供了一种高效且易于使用的处理数据的方式
 * 针对大数据进行,类似Spark
 * @author YYKJ
 */
public class AppDataStream {
	
	public static void main(String[] args) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order("产品A", 9.9, 10));
		orders.add(new Order("产品B", 20.1, 6));
		orders.add(new Order("电脑", 35.9, 8));
		orders.add(new Order("产品C", 35.9, 8));
		orders.add(new Order("手机", 35.9, 8));
		
		Stream<Order> filter = orders.stream().filter((ele) -> (ele.getName().contains("产")));
		DoubleStream mapToDouble = filter.mapToDouble( (orderObj) -> (orderObj.getAmount() * orderObj.getPrice()) );
		DoubleSummaryStatistics stat = mapToDouble.summaryStatistics();
		System.out.println("购买种类数量:" +  stat.getCount());
		System.out.println("购买总价:" +  stat.getSum());
		System.out.println("购买最高价:" +  stat.getMax());
		System.out.println("购买最低价:" +  stat.getMin());
		System.out.println("购买平均价:" +  stat.getAverage());
	}
}
