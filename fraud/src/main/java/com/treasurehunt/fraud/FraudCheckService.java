package com.treasurehunt.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentUser(Integer userId){
        //TODO: its a fake fraud check. Need update with real logic
        boolean checkResult = false;
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .userId(userId)
                        .checkAt(LocalDateTime.now())
                        .isFraudster(checkResult)
                        .build()
        );
        return checkResult;
    }
}
