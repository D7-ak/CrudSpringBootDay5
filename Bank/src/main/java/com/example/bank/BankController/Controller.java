package com.example.bank.BankController;

import com.example.bank.ApiResponse.ApiRresponse;
import com.example.bank.BankClass.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class Controller {
    ArrayList<Customers> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customers> getCostomers(){
        return customers;
    }

    @PostMapping("/add")
    public ApiRresponse addCosromers(@RequestBody Customers customer){
        customers.add(customer);
        return new ApiRresponse("added successfully");
    }

    @PutMapping("/update/{index}")
    public ApiRresponse updateCustomers(@PathVariable int index,@RequestBody Customers cosromer){
        this.customers.set(index,cosromer);
        return new ApiRresponse("updated successfully");
    }

    @DeleteMapping("delete/{index}")
    public ApiRresponse deleteCustomers(@PathVariable int index){
        customers.remove(index);
        return new ApiRresponse("deleted successfully");
    }

    @PutMapping("/deposit/{index}/{amount}")
    public ApiRresponse depositCustomer(@PathVariable int index,@PathVariable int amount){
        customers.get(index).setBalance(customers.get(index).getBalance()+amount);
        return new ApiRresponse("deposit successfully");
    }

    @PutMapping("/withdraw/{index}/{amount}")
    public ApiRresponse withdrawCustomer(@PathVariable int index,@PathVariable int amount){
        if(amount>customers.get(index).getBalance()){
            return new ApiRresponse("no enough balance");
        }
        customers.get(index).setBalance(customers.get(index).getBalance()+amount);
        return new ApiRresponse("withdraw successfully");
    }
}