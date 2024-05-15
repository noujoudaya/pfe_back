package sir.zproject.pfe_back.service.facade;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import sir.zproject.pfe_back.bean.Image;

import java.io.IOException;

public interface ImageService {
    ResponseEntity<String> uploadImage(MultipartFile file, String cin) throws IOException;

    byte[] compressBytes(byte[] data);

    Image getImage(Long imageId) throws IOException;


    byte[] decompressBytes(byte[] data);
}
