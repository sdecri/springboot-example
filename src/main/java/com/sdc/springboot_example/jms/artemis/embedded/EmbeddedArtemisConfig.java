/**
 * EmbeddedArtemisConfig.java
 */
package com.sdc.springboot_example.jms.artemis.embedded;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.sdc.springboot_example.Application;

/**
 * The @Configuration annotation tells Spring to configure any declared methods annotated with the @Bean annotations.
 * We have @Autowired a ConnectionFactory for creating a connection with the default user identity to the broker.
 * In this case it will create the connection to the ArtemisMQ server with the default credentials.
 * 
 * Finally, the @Bean messageListener defines a bean that will return a DefaultMessageListenerContainer instance. 
 * The DefaultMessageListenerContainer will be responsible for connecting to the queue and listening through 
 * the consumer’s MessageListener interface implementation.
 * 
 * @author Simone.DeCristofaro
 * Oct 15, 2020
 */
@Configuration
@EnableJms
@Profile(Application.PROFILE_JMS_ARTEMIS_EMBEDDED)
public class EmbeddedArtemisConfig {

    @Value("${active-mq.broker-url}")
    private String brokerUrl;
    
    @Autowired
    private ConnectionFactory connectionFactory;
    
    
    @Bean
    public JmsTemplate artemisJmsTemplate() throws JMSException{
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
        return jmsTemplate;
    }
    

    @Bean
    public DefaultJmsListenerContainerFactory embeddedArtemisJmsListenerContainerFactory() throws JMSException {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConcurrency(concurrency);
        factory.setPubSubDomain(true); // enable for Pub Sub to topic. Not Required for Queue.
//        factory.setSubscriptionShared(true);
//        factory.setSubscriptionDurable(true);
//        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(messageConverter);
//        factory.setSessionTransacted(true);
        return factory;
    }
    
}
