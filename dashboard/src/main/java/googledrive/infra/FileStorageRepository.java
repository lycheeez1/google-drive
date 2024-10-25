package googledrive.infra;

import googledrive.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "fileStorages",
    path = "fileStorages"
)
public interface FileStorageRepository
    extends PagingAndSortingRepository<FileStorage, Long> {
    List<FileStorage> findByFileId(String fileId);
}
