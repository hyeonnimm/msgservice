package msgservice.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import msgservice.config.kafka.KafkaProcessor;
import msgservice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RateRepository rateRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MsgSent'"
    )
    public void wheneverMsgSent_IncreaseRate(@Payload MsgSent msgSent) {
        MsgSent event = msgSent;
        System.out.println(
            "\n\n##### listener IncreaseRate : " + msgSent + "\n\n"
        );

        // Sample Logic //
        Rate.increaseRate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SendFailed'"
    )
    public void wheneverSendFailed_DecreaseRate(
        @Payload SendFailed sendFailed
    ) {
        SendFailed event = sendFailed;
        System.out.println(
            "\n\n##### listener DecreaseRate : " + sendFailed + "\n\n"
        );

        // Sample Logic //
        Rate.decreaseRate(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
