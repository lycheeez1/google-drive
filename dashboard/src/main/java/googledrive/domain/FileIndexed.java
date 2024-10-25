package googledrive.domain;

import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class FileIndexed extends AbstractEvent {

    private Long id;
    private String fileId;
    private String userId;
    private String indexResult;
}
