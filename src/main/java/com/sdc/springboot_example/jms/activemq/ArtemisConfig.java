package com.sdc.springboot_example.jms.activemq;

import javax.jms.JMSException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import com.sdc.springboot_example.Application;

@Configuration
@Profile(Application.PROFILE_PRODUCER_3)
public class ArtemisConfig {

    @Value("${active-mq.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory senderConnectionFactory() throws JMSException {
      ActiveMQConnectionFactory activeMQConnectionFactory =
          new ActiveMQConnectionFactory();
      activeMQConnectionFactory.setBrokerURL(brokerUrl);

      return activeMQConnectionFactory;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() throws JMSException {
      CachingConnectionFactory cachingConnectionFactory =
          new CachingConnectionFactory(senderConnectionFactory());
      cachingConnectionFactory.setSessionCacheSize(10);

      return cachingConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() throws JMSException{
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(cachingConnectionFactory());
        jmsTemplate.setPubSubDomain(true);  // enable for Pub Sub to topic. Not Required for Queue.
        return jmsTemplate;
    }
}