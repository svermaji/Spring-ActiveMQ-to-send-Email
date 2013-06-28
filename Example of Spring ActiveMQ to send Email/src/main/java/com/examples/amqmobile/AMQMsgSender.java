package com.examples.amqmobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: sverma
 * Date: 4/12/12
 * Time: 5:21 PM
 */


@Service ("amqMsgSender")
public class AMQMsgSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue reqAMQMobileEmailQueue;

    /**
     * Sends message using JMS Template.
     *
     *
     * @param msg the msg
     * @throws JMSException the jMS exception
     */
    public void sendMessage(AMQMobile msg) throws JMSException
    {
        System.out.println("About to put message on queue. Queue[" + reqAMQMobileEmailQueue.toString() + "] Message[" + msg + "]");
        jmsTemplate.convertAndSend(reqAMQMobileEmailQueue, msg);
    }

    /**
     * Sets the jms template.
     *
     * @param template the jms template
     */
    public void setJmsTemplate(JmsTemplate template)
    {
        this.jmsTemplate = template;
    }

}
