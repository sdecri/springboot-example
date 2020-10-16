/**
 * MyCurrentConnectionFactory.java
 */
package com.sdc.springboot_example.jms.consumer.struc2;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

/**
 * @author Simone.DeCristofaro
 * Oct 16, 2020
 */
@Configuration
public class MyCurrentConnectionFactoryCreator {

    @Autowired
    private ConnectionFactory deafultConnectionFactory;
    
    private static final Object CONNECTION_FACTORY_SYNC = new Object();
    private ConnectionFactory connectionFactory;

    @Bean
    public DefaultJmsListenerContainerFactory myCurrentConnectionFactory()
//            throws NamingException 
    {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // stuff that can be set to customize the factory
//        factory.setConcurrency(concurrency);
//        factory.setPubSubDomain(pubSubDomain);
//        factory.setSubscriptionShared(subscriptionShared);
//        factory.setSubscriptionDurable(subscriptionDurable);
//        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConnectionFactory(getActiveMQConnectionFactory());
        return factory;
    }
    
    public ConnectionFactory getActiveMQConnectionFactory() {
        synchronized (CONNECTION_FACTORY_SYNC) {
            if (connectionFactory == null) {
//                Properties env = new Properties();
//
//                env.put(Context.INITIAL_CONTEXT_FACTORY,
//                        org.jboss.naming.remote.client.InitialContextFactory.class.getName());
//                env.put(Context.PROVIDER_URL, jndiProviderUrl);
//                if (user != null) {
//                    env.put(Context.SECURITY_PRINCIPAL, user);
//                    env.put(Context.SECURITY_CREDENTIALS, password);
//                }
//                env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//
//                InitialContext initialContext = new InitialContext(env);
//                connectionFactory = (ConnectionFactory) initialContext.lookup("jms/RemoteConnectionFactory");
                this.connectionFactory = deafultConnectionFactory;
            }
        }
        return connectionFactory;
    }    
    
}
