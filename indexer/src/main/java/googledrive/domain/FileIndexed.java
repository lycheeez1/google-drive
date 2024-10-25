package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileIndexed extends AbstractEvent {

    private Long id;
    private String fileId;
    private String userId;
    private String indexResult;

    public FileIndexed(Index aggregate) {
        super(aggregate);
    }

    public FileIndexed() {
        super();
    }
}
//>>> DDD / Domain Event
