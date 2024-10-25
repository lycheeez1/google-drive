package googledrive.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "FileStorage_table")
@Data
public class FileStorage {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Integer fileSize;
    private String fileName;
    private String videoUrl;
    private String fileId;
    private String userId;
    private String uploadYn;
    private String indexYn;
}
