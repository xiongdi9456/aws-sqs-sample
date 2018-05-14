package br.com.emmanuelneri.aws.samples.producer.service;

import br.com.emmanuelneri.aws.samples.producer.config.MyMessage;
import com.alibaba.fastjson.JSON;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private static final int MAX_BATCH_SEND_SQS = 10;

    @Value("${consumer.sqs.message.queue.name}")
    private String queueName;

    @Autowired
    private AmazonSQS amazonSQS;


    public void sentMyMessage() {
        MyMessage myMessage = new MyMessage(234563L,UUID.randomUUID().toString(),"1234567890",1,1,"aaadddddddaaaaadddddaaaaasdsadas","2018-05-13 13:22:12.228");
        final SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueName)
                .withMessageBody(JSON.toJSONString(myMessage));

        amazonSQS.sendMessage(sendMessageRequest);
    }



}
