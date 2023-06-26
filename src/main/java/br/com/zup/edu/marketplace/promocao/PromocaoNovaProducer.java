package br.com.zup.edu.marketplace.promocao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PromocaoNovaProducer {

    Logger logger = LoggerFactory.getLogger(PromocaoNovaProducer.class);

    @Autowired
    private KafkaTemplate<String,Promocao> kafkaTemplate;

    @Value("${spring.kafka.producer.topic}")
    private String topico;

    @Async
    public void enviar(Promocao promocao){
        kafkaTemplate.send(topico,promocao);
        logger.info("nova promocao gerada: {}",promocao.toString());
    }
}
