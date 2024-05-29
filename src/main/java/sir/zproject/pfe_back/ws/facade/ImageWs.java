package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sir.zproject.pfe_back.bean.Image;
import sir.zproject.pfe_back.dao.ImageDao;
import sir.zproject.pfe_back.service.facade.ImageService;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("image")
public class ImageWs {

    @Autowired
    private ImageDao imageDao;
    @Autowired
    private ImageService imageService;
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("cin") String cin) throws IOException {
        return imageService.uploadImage(file, cin);
    }
    @GetMapping("/get/{imageId}")
    public Image getImage(@PathVariable Long imageId) throws IOException {

        final Optional<Image> retrievedImage = imageDao.findById(imageId);
        Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getType(),
                imageService.decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }
}
