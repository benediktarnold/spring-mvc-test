package mvc.controller;

import mvc.model.Person;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class EasyRestController {

   @ExceptionHandler(PersonNotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public void handlePersonNotFound() {
      //ich weiß, eine logausgabe ist besser ;-)
      System.out.println("EasyRestController.handlePersonNotFound()");
   }

   @RequestMapping("/person/{name}")
   public @ResponseBody
   Person getPerson(@PathVariable String name) throws PersonNotFoundException {
      if ("bob".equals(name)) {
         throw new PersonNotFoundException(name);
      }
      else
         return new Person(name);
   }

}
