/**
 * TreMessageConverter.java
 */
package com.sdc.springboot_example.jms.artemis.remote.no_message_type;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.sdc.springboot_example.model.tre.TreStatusMessage;

/**
 * @author Simone.DeCristofaro
 * Oct 26, 2020
 */
public class TreMessageConverter extends MappingJackson2MessageConverter {

    /**
    * {@inheritDoc}
    */
    @Override
    protected JavaType getJavaTypeForMessage(Message message) throws JMSException {
    
        return TypeFactory.defaultInstance().constructType(TreStatusMessage.class);
        
    }
}
