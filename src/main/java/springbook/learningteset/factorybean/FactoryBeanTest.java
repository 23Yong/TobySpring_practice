package springbook.learningteset.factorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-applicationContext.xml")
public class FactoryBeanTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void getFactoryBean() throws Exception {
        Object factory = context.getBean("&message");
        assertThat((MessageFactoryBean) factory, is(MessageFactoryBean.class));
    }

    @Test
    public void getMessageFromFactoryBean() {
        Object message = context.getBean("message");

        assertThat((Message) message, is(Message.class));
        assertThat(((Message)message).getText(), is("Factory Bean"));
    }
}
