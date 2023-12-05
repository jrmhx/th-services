package com.treasurehunt.fraud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraud_check_history_id",
            sequenceName = "fraud_check_history_id"
    )
    @GeneratedValue(

    )
    private Integer id;
    private Integer userId;
    private LocalDateTime checkAt;
    private Boolean isFraudster;
}
