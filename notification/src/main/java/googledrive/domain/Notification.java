package googledrive.domain;

import googledrive.NotificationApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Notification_table")
@Data
//<<< DDD / Aggregate Root
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String sendMsg;

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = NotificationApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notifyToUser(FileUploaded fileUploaded) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        UserNotified userNotified = new UserNotified(notification);
        userNotified.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);

            UserNotified userNotified = new UserNotified(notification);
            userNotified.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
