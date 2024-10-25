package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileUploaded extends AbstractEvent {

    private Long id;
    private Integer fileSize;
    private String fileName;
    private Date uploadDate;
    private String uploadResult;
}
