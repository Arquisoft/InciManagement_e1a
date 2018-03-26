package com.asw.steps;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.asw.InciManagerApplication;
import com.asw.Kafka.producer.KafkaProducer;
import com.asw.controllers.IncidencesController;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes=InciManagerApplication.class, loader= SpringBootContextLoader.class)
@SpringBootTest
@WebAppConfiguration
public class KafkaSteps {

  @Autowired
  private KafkaProducer kafkaProducer;

  @Autowired
  //private com.asw.Kafka.listener.MessageListener messageListener;

  private io.reactivex.Observable<String> observable;
  
  private static final Logger LOG = LoggerFactory.getLogger(IncidencesController.class);

  @When("^the producer sends the message \"([^\"]*)\" to the topic \"([^\"]*)\"$")
  public void the_producer_sends_the_message_to_the_topic(String message, String topic) throws Throwable {
//	observable = messageListener.getObservable();
    kafkaProducer.send(topic, message);
  }

  @Then("^the consumer receives the message \"([^\"]*)\" from the topic \"([^\"]*)\"$")
  public void the_consumer_receives_the_message_from_the_topic(String message, String topic) throws Throwable {
    String receivedMessage = observable.blockingFirst();
    System.out.println("Message received: " + receivedMessage);
    assertTrue(receivedMessage.equals(message));
  }

}