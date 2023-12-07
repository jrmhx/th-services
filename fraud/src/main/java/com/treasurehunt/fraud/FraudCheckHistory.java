package com.treasurehunt.fraud;

import javax.persistence.*;
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
