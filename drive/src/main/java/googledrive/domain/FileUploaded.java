package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class FileUploaded extends AbstractEvent {

    private Long id;
    private Integer fileSize;
    private String fileName;
    private Date uploadDate;
    private String uploadResult;

    public FileUploaded(Drive aggregate) {
        super(aggregate);
    }

    public FileUploaded() {
        super();
    }
}
//>>> DDD / Domain Event
