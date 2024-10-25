package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class UserNotified extends AbstractEvent {

    private Long id;
    private String userId;
    private String sendMsg;

    public UserNotified(Notification aggregate) {
        super(aggregate);
    }

    public UserNotified() {
        super();
    }
}
//>>> DDD / Domain Event
