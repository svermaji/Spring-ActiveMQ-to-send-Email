package com.examples.amqmobile;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import javax.annotation.PostConstruct;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sverma
 * Date: 4/12/12
 * Time: 5:18 PM
 */

public class AMQMobileEmailListener implements MessageListener {

    @Autowired
    MailSender mailSender;

    private static int counter;

    @PostConstruct
    public void initCounter () {
        System.out.println("Transformer: counter initialized");
        counter=0;
    }

    public void onMessage(Message message) {

        System.out.println("OnMessage "+counter+": Email Listener working... " + message);
        System.out.println("OnMessage: Email message instance matched = " + (message instanceof ActiveMQObjectMessage));

        if (message instanceof ActiveMQObjectMessage)
        {
            try
            {
                System.out.println("Converting object to AMQMobile class for email.");
                AMQMobile amqMobile = (AMQMobile) ((ActiveMQObjectMessage) message).getObject();
                System.out.println("OnMessage: Email Object received in Listener as " + amqMobile);

                /* call message sender to put message onto second queue */
                System.out.println("Sending mail for amqMobile " + amqMobile);

                SimpleMailMessage msg = new SimpleMailMessage();

                msg.setTo("sverma@impetus.co.in");

                msg.setFrom("sverma@impetus.co.in");
                msg.setSubject("Transforming from activemq");
                msg.setSentDate(new Date());
                msg.setText("Transforming using spring for mobile " + amqMobile);

                System.out.println("Waiting for 10 sec intentionally bf sending mail...");
                Thread.sleep(10000);

                mailSender.send(msg);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
