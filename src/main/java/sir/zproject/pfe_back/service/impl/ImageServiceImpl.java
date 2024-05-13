package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Image;
import sir.zproject.pfe_back.dao.EmployeDao;
import sir.zproject.pfe_back.dao.ImageDao;
import sir.zproject.pfe_back.service.facade.EmployeService;
import sir.zproject.pfe_back.service.facade.ImageService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private sir.zproject.pfe_back.dao.ImageDao ImageDao;
    @Autowired
    private EmployeService employeService;
    @Autowired
    private EmployeDao employeDao;

    @Override
    public ResponseEntity<String> uploadImage(MultipartFile file, String cin) throws IOException {

        // Compress the image bytes before saving it in the database
        Image img = new Image(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
        ImageDao.save(img);

        // Find the employe by cin
        Employe employe = employeService.findByCin(cin);

        // Check if employe is not null and image is present
        if (employe != null) {
            Optional<Image> image = ImageDao.findById(img.getId());
            if (image.isPresent()) {
                employe.setImage(image.get());
                employeDao.save(employe); // Save the updated employe
                return ResponseEntity.status(HttpStatus.OK).body("Image uploaded successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image not found.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employe not found.");
        }
    }
    // compress the image bytes before storing it in the database
    @Override
    public  byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }

        return outputStream.toByteArray();
    }

    @Override
    public Image getImage(Long imageId) throws IOException {

        Optional<Image> retrievedImage = ImageDao.findById(imageId);
        Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }

    @Override
    // uncompress the image bytes before returning it to the angular application
    public  byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }


}







