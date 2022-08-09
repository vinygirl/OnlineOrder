package com.laioffer.onlineorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.onlineorder.entity.Customer;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");//data format

        ObjectMapper mapper = new ObjectMapper();
        Customer customer= new Customer();
        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);

        response.getWriter().println(mapper.writeValueAsString(customer));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject object = new JSONObject(IOUtils.toString(request.getReader()));
        String name = object.getString("name");
        int age = object.getInt("age");
    }
    public void destory() {
    }
 }