package tommy.spring.store.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tommy.spring.store.service.PlaceOrderService;
import tommy.spring.store.vo.PurchaseOrderRequest;
import tommy.spring.store.vo.PurchaseOrderResult;

public class OrderServiceTestThree {

	private PlaceOrderService placeOrderService;

	public static void main(String[] args) {
		OrderServiceTestThree test = new OrderServiceTestThree();
		test.order();
	}

	public OrderServiceTestThree() {
		String[] configLocations = new String[] { "applicationContext.xml", "transactionThree.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		placeOrderService = (PlaceOrderService) context.getBean("placeOrderService");
	}

	public void order() {
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(3);
		orderRequest.setAddress("서울 강남구");
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
		System.out.println("주문상태 정보");
		System.out.println("아이템 : " + orderResult.getItem().getId());
		System.out.println("가격 : " + orderResult.getPaymentInfo().getPrice());
	}
}
