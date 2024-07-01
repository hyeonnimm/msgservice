package msgservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msgservice.ReservationApplication;
import msgservice.domain.Reserved;

@Entity
@Table(name = "MsgList_table")
@Data
//<<< DDD / Aggregate Root
public class MsgList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String msgTitle;

    private String msgContent;

    private Date reserveDt;

    @ElementCollection
    private List<String> dstNum;

    private String callbackNum;

    private Long reserveQt;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();
    }

    public static MsgListRepository repository() {
        MsgListRepository msgListRepository = ReservationApplication.applicationContext.getBean(
            MsgListRepository.class
        );
        return msgListRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(MsgSent msgSent) {
        //implement business logic here:

        /** Example 1:  new item 
        MsgList msgList = new MsgList();
        repository().save(msgList);

        */

        /** Example 2:  finding and process
        
        repository().findById(msgSent.get???()).ifPresent(msgList->{
            
            msgList // do something
            repository().save(msgList);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(SendCompleted sendCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        MsgList msgList = new MsgList();
        repository().save(msgList);

        */

        /** Example 2:  finding and process
        
        repository().findById(sendCompleted.get???()).ifPresent(msgList->{
            
            msgList // do something
            repository().save(msgList);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(SendFailed sendFailed) {
        //implement business logic here:

        /** Example 1:  new item 
        MsgList msgList = new MsgList();
        repository().save(msgList);

        */

        /** Example 2:  finding and process
        
        repository().findById(sendFailed.get???()).ifPresent(msgList->{
            
            msgList // do something
            repository().save(msgList);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
