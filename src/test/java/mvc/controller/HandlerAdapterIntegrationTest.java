package mvc.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.web.servlet.HandlerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/mvc-context.xml")
@TestExecutionListeners(value = { DependencyInjectionTestExecutionListener.class})
public class HandlerAdapterIntegrationTest {

   @Autowired
   private HandlerAdapter handlerAdapter;

   @Autowired
   private EasyRestController controller;

   private MockHttpServletRequest request;

   private MockHttpServletResponse response;

   @Before
   public void setUp() {
      request = new MockHttpServletRequest();
      response = new MockHttpServletResponse();
   }

   @Test
   public void testFound() throws Exception {
      request.setRequestURI("/person/carl");
      handlerAdapter.handle(request, response, controller);
      Assert.assertEquals(200, response.getStatus());
   }
   
   @Test
   public void testNotFound() throws Exception {
      request.setRequestURI("/person/bob");
      handlerAdapter.handle(request, response, controller);
      Assert.assertEquals(404, response.getStatus());
   }
   
   
}
