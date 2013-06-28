package com.examples.amqmobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: sverma
 * Date: 18/10/12
 * Time: 7:38 PM
 */

@Controller
public class AMQMobileController {

    @Autowired
    AMQMsgProducer amqMsgProducer;

    @RequestMapping (value = "/amqmobile/form.html", method = RequestMethod.GET)
    public void getForm(Model model) {
        System.out.println("AMQController: Adding amq mobile in a model");
        amqMsgProducer.produce();
        System.out.println("AMQController: Msg send");
    }
}
