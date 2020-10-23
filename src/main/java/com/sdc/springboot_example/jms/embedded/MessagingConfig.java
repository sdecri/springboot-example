/**
 * MessagingConfig.java
 */
package com.sdc.springboot_example.jms.embedded;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

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
@Profile(Application.PROFILE_RECEIVER_1)
public class MessagingConfig {

    @Autowired
    private ConnectionFactory connectionFactory;
    
    @Value("${queue1}")
    private String queue;

    @Bean
    public DefaultMessageListenerContainer messageListener() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(this.connectionFactory);
        container.setDestinationName(queue);
        container.setMessageListener(new Consumer());
        return container;
    }
    
}
