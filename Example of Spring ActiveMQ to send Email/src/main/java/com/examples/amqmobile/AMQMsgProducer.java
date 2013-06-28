package com.examples.amqmobile;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * User: sverma
 * Date: 5/12/12
 * Time: 10:59 AM
 */

@Service("amqMsgProducer")
public class AMQMsgProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    public void produce() {

        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {

                AMQMobile amqMobile = new AMQMobile();
                amqMobile.setCompany("newCompany");
                amqMobile.setModel("iPhone5");
                amqMobile.setPrice(45000);

                ObjectMessage message = session.createObjectMessage(amqMobile);

                System.out.println("Sending on ["+jmsTemplate.getDefaultDestination()+"] object as " + amqMobile);

                return message;
            }
        });
    }
}
