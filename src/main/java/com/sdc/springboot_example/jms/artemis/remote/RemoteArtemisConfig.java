/**
 * EmbeddedArtemisConfig.java
 */
package com.sdc.springboot_example.jms.artemis.remote;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQTopicConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

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
@Profile(Application.PROFILE_JMS_ARTEMIS_REMOTE)
public class RemoteArtemisConfig {

    @Value("${artemis.remote.broker-url}")
    private String brokerUrl;
    
    @Value("${artemis.remote.user}")
    private String username;
    
    @Value("${artemis.remote.password}")
    private String password;
    
    
    @Bean
    public JmsTemplate artemisJmsTemplate() throws JMSException{
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(remoteActiveMQConnectionFactory());
        jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
        jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
        return jmsTemplate;
    }
    
    @Bean
    public ConnectionFactory remoteActiveMQConnectionFactory() throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQTopicConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUser(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    // Needed to send messages in JSON format
    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_tre_message");
        return converter;
    }
    
    
    @Bean
    public DefaultJmsListenerContainerFactory remoteArtemisJmsListenerContainerFactory() throws JMSException {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConcurrency(concurrency);
        factory.setPubSubDomain(true); // enable for Pub Sub to topic. Not Required for Queue.
//        factory.setSubscriptionShared(true);
//        factory.setSubscriptionDurable(true);
//        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConnectionFactory(remoteActiveMQConnectionFactory());
        factory.setMessageConverter(jacksonJmsMessageConverter());
//        factory.setSessionTransacted(true);
        return factory;
    }
    
    
}
