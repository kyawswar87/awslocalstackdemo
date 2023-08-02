package com.aws.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class NotificationController {
    @Autowired
    ReceiveSendNotifications msgService;

    // Send emails for all parseable notifications
    @RequestMapping(value = "/process", method = RequestMethod.GET)
    @ResponseBody
    List<String> processNotifications(HttpServletRequest request, HttpServletResponse response) {
        return msgService.processNotifications();
    }


    //  Lists all message bodies
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> listMessages(HttpServletRequest request, HttpServletResponse response) {
        return msgService.listMessages();
    }


    //  Purge the message queue
    @RequestMapping(value = "/purge", method = RequestMethod.GET)
    @ResponseBody
    void purgeQueue(HttpServletRequest request, HttpServletResponse response) {
        msgService.purgeQueue();
    }
}
