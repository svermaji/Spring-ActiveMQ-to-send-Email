package com.examples.amqmobile;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created with IntelliJ IDEA.
 * User: sverma
 * Date: 4/12/12
 * Time: 5:18 PM
 */

public class AMQMobileListener implements MessageListener {

    @Autowired
    AMQMsgSender amqMsgSender;

    public void onMessage(Message message) {

        System.out.println("OnMessage: Listener working... " + message);
        System.out.println("OnMessage: message instance matched = " + (message instanceof ActiveMQObjectMessage));

        if (message instanceof ActiveMQObjectMessage)
        {
            try
            {
                System.out.println("Converting object to AMQMobile class.");
                AMQMobile amqMobile = (AMQMobile) ((ActiveMQObjectMessage) message).getObject();
                System.out.println("OnMessage: Object received in Listener as " + amqMobile);

                /* call message sender to put message onto second queue */
                amqMsgSender.sendMessage(amqMobile);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
