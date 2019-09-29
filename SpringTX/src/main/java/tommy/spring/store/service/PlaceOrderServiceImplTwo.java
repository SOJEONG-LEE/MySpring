package tommy.spring.store.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import tommy.spring.store.dao.ItemDAO;
import tommy.spring.store.dao.PaymentInfoDAO;
import tommy.spring.store.dao.PurchaseOrderDAO;
import tommy.spring.store.vo.Item;
import tommy.spring.store.vo.ItemNotFoundException;
import tommy.spring.store.vo.PaymentInfo;
import tommy.spring.store.vo.PurchaseOrder;
import tommy.spring.store.vo.PurchaseOrderRequest;
import tommy.spring.store.vo.PurchaseOrderResult;

public class PlaceOrderServiceImplTwo implements PlaceOrderService {

	private ItemDAO itemDao;
	private PaymentInfoDAO paymentInfoDao;
	private PurchaseOrderDAO purchaseOrderDao;
	private TransactionTemplate transactionTemplate;
	
	@Override
	public PurchaseOrderResult order(final PurchaseOrderRequest orderRequest) throws ItemNotFoundException {
		return transactionTemplate.execute(new TransactionCallback<PurchaseOrderResult>() {
			@Override
			public PurchaseOrderResult doInTransaction(TransactionStatus status) {
				Item item = itemDao.findById(orderRequest.getItemId());
				if (item == null)
					throw new ItemNotFoundException(orderRequest.getItemId());
				PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
				paymentInfoDao.insert(paymentInfo);
				PurchaseOrder order = new PurchaseOrder(item.getId(), orderRequest.getAddress(), paymentInfo.getId());
				purchaseOrderDao.insert(order);
				return new PurchaseOrderResult(item, paymentInfo, order);
			}
		});
	}

	public void setItemDao(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}

	public void setPaymentInfoDao(PaymentInfoDAO paymentInformationDao) {
		this.paymentInfoDao = paymentInformationDao;
	}

	public void setPurchaseOrderDao(PurchaseOrderDAO purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

}
