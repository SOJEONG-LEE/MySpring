package tommy.spring.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
//		List<String> addressList = bean.getAddressList();
//		for (String address : addressList) {
//			System.out.println(address.toString());
//		} 
		
//		Map<String, String> addressList = bean.getAddressList();
//		for(String key : addressList.keySet()) {
//			System.out.println(String.format("키 : %s, 값 : %s", key, addressList.get(key)));
//		}
		
//		Properties addressList = bean.getAddressList();
//		for(String key : addressList.stringPropertyNames()){
//			System.out.println(String.format("키 : %s, 값 : %s", key, addressList.get(key)));
//		}
		
		// Set은 순서가 없기떄문에 동일한 데이터를 허용하지 않는다.
		Set<String> addressList = bean.getAddressList();
		for(String key : addressList) {
			System.out.println(key);
		}
		
		factory.close();
		
		
	}

}
