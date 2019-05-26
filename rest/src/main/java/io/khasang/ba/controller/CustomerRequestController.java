package io.khasang.ba.controller;

import io.khasang.ba.entity.CustomerRequest;
import io.khasang.ba.service.CustomerRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer_request")
public class CustomerRequestController {

    @Autowired
    private CustomerRequestService customerRequestService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public CustomerRequest addRequest(@RequestBody CustomerRequest customerRequest) {
        customerRequestService.addRequest(customerRequest);
        return customerRequest;
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public CustomerRequest getRequestById(@PathVariable(value = "id") long id) {
        return customerRequestService.getRequestById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<CustomerRequest> getAllRequests() {
        return customerRequestService.getAllRequests();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public CustomerRequest updateRequest(@RequestBody CustomerRequest customerRequest) {
        return customerRequestService.updateRequest(customerRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public CustomerRequest deleteRequest(@PathVariable(value = "id") long id) {
        return customerRequestService.deleteRequest(id);
    }
}
