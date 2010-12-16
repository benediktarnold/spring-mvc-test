package mvc.controller;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/mvc-context.xml")
@TestExecutionListeners(value = { DependencyInjectionTestExecutionListener.class})
public class DispatcherServletIntegrationTest {

   @Autowired
   private ApplicationContext applicationContext;

   private MockHttpServletRequest request;

   private MockHttpServletResponse response;

   private DispatcherServlet servlet;

   @Before
   public void setUp() throws ServletException {
      request = new MockHttpServletRequest();
      request.setMethod("GET");
      response = new MockHttpServletResponse();

      servlet = new MockDispatcherServlet(applicationContext);
   }

   @Test
   public void testFound() throws Exception {
      request.setRequestURI("/person/carl");
      servlet.service(request, response);
      Assert.assertEquals(200, response.getStatus());
   }

   @Test
   public void testNotFound() throws Exception {
      request.setRequestURI("/person/bob");
      servlet.service(request, response);
      Assert.assertEquals(404, response.getStatus());
   }

}
