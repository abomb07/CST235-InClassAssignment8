package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import data.OrdersDataService;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {

	@EJB
	OrdersDataService service;
	
    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) 
    {
        try
        {
        	if(message instanceof TextMessage)
        	{
        		System.out.println("===== OrderMessageService.onMessage() with a Text Message: " + ((TextMessage) message).getText());
        	}
        	else if(message instanceof ObjectMessage)
        	{
        		System.out.println("==== OrderMedssageService.onMessage() with a send order message");
        	}
        	else
        	{
        		System.out.println("===== OrderMedssageService.onMessage() with a unknown message type");
        	}
        }
        catch (JMSException e)
        {
        	e.printStackTrace();
        }
    }

}
