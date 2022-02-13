package com.hrpayroll.api.services;

import java.util.HashMap;
import java.util.Map;

import com.hrpayroll.api.model.entity.Payment;
import com.hrpayroll.api.model.entity.Worker;
import com.hrpayroll.feingclientes.WorkerFeingClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeingClients workerFeingClients;
    
    public Payment getPayment(long workerId, int days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", ""+workerId);

        Worker worker = workerFeingClients.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}