package br.com.emmanuelneri.aws.sample.consumer;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConsumerListener {

    /*@JmsListener(destination = "${consumer.sqs.message.queue.name}")
    public void messageConsumer(@Headers Map<String, Object> messageAttributes,
                       @Payload String message) {
        // Do something
        System.out.println("Messages attributes: " + messageAttributes);
        System.out.println("Body: " + message);
    }*/

    @JmsListener(destination = "${consumer.sqs.message.queue.name}")
    public void messageConsumer(@Payload String message) {
        // Do something
        //System.out.println("Messages attributes: " + messageAttributes);
        System.out.println("Body: " + message);
        MyMessage myMessage = JSON.parseObject(message,MyMessage.class);


        //MyMessage myMessage = message.getPayload();
        System.out.println("UDID: " + myMessage.getUdid()+"; userId:"+myMessage.getUserId());

    }

}
