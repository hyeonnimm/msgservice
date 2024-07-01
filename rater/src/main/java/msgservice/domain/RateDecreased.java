package msgservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import msgservice.domain.*;
import msgservice.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RateDecreased extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long userRate;
    private String history;

    public RateDecreased(Rate aggregate) {
        super(aggregate);
    }

    public RateDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
