package mvc.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

final class MockDispatcherServlet extends DispatcherServlet {
   /**
    * 
    */
   private ServletContext servletContext;
   /**
    * 
    */
   private static final long serialVersionUID = -2399060468360891644L;
   private ApplicationContext applicationContext;

   public MockDispatcherServlet(ApplicationContext context) throws ServletException {
      applicationContext = context;
      servletContext = new MockServletContext();
      ServletConfig servletConfig = new MockServletConfig(servletContext, "servletName");
      this.init(servletConfig);
   }

   @Override
   protected WebApplicationContext findWebApplicationContext() {
      GenericWebApplicationContext webContext = new GenericWebApplicationContext(servletContext);
      webContext.setParent(applicationContext);
      webContext.refresh();
      return webContext;
   }
}