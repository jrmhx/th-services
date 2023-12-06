package com.treasurehunt.fraud;

import com.treasurehunt.clients.fraud.FraudCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud")
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;

    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "check/{userId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("userId")
            Integer userId
    ){
        boolean isFraudlentUser = fraudCheckService.isFraudulentUser(userId);
        log.info("fraud check on user {}", userId);
        return new FraudCheckResponse(isFraudlentUser);
    }
}
