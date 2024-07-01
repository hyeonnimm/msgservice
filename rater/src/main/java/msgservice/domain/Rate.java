package msgservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msgservice.RaterApplication;
import msgservice.domain.RateDecreased;
import msgservice.domain.RateIncreased;

@Entity
@Table(name = "Rate_table")
@Data
//<<< DDD / Aggregate Root
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long userRate;

    private String history;

    @PostPersist
    public void onPostPersist() {
        RateIncreased rateIncreased = new RateIncreased(this);
        rateIncreased.publishAfterCommit();

        RateDecreased rateDecreased = new RateDecreased(this);
        rateDecreased.publishAfterCommit();
    }

    public static RateRepository repository() {
        RateRepository rateRepository = RaterApplication.applicationContext.getBean(
            RateRepository.class
        );
        return rateRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increaseRate(MsgSent msgSent) {
        //implement business logic here:

        /** Example 1:  new item 
        Rate rate = new Rate();
        repository().save(rate);

        RateIncreased rateIncreased = new RateIncreased(rate);
        rateIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(msgSent.get???()).ifPresent(rate->{
            
            rate // do something
            repository().save(rate);

            RateIncreased rateIncreased = new RateIncreased(rate);
            rateIncreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void decreaseRate(SendFailed sendFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        Rate rate = new Rate();
        repository().save(rate);

        RateDecreased rateDecreased = new RateDecreased(rate);
        rateDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(sendFailed.get???()).ifPresent(rate->{
            
            rate // do something
            repository().save(rate);

            RateDecreased rateDecreased = new RateDecreased(rate);
            rateDecreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
