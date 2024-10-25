package googledrive.infra;

import googledrive.config.kafka.KafkaProcessor;
import googledrive.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class FileStorageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private FileStorageRepository fileStorageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1(
        @Payload FileUploaded fileUploaded
    ) {
        try {
            if (!fileUploaded.validate()) return;

            // view 객체 생성
            FileStorage fileStorage = new FileStorage();
            // view 객체에 이벤트의 Value 를 set 함
            fileStorage.setId(fileUploaded.getId());
            fileStorage.setFileSize(fileUploaded.getFileSize());
            fileStorage.setFileName(fileUploaded.getFileName());
            fileStorage.setUploadYn(fileUploaded.getUploadResult());
            // view 레파지 토리에 save
            fileStorageRepository.save(fileStorage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileIndexed_then_UPDATE_1(
        @Payload FileIndexed fileIndexed
    ) {
        try {
            if (!fileIndexed.validate()) return;
            // view 객체 조회

            List<FileStorage> fileStorageList = fileStorageRepository.findByFileId(
                fileIndexed.getFileId()
            );
            for (FileStorage fileStorage : fileStorageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                fileStorage.setIndexYn(fileIndexed.getIndexResult());
                // view 레파지 토리에 save
                fileStorageRepository.save(fileStorage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
