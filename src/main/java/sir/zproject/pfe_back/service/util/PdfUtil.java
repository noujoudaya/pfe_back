/*package sir.zproject.pfe_back.service.util;

import com.itextpdf.html2pdf.HtmlConverter;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import sir.zproject.pfe_back.bean.BulletinPaie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;*/
package sir.zproject.pfe_back.service.util;

import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import sir.zproject.pfe_back.bean.BulletinPaie;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.Map;

public class PdfUtil {
/*
    public static Resource htmlToPdf(BulletinPaie bulletinPaie, TemplateEngine templateEngine, String template) throws IOException {
        Context context = new Context();
        Map<String, Object> variables = new LinkedHashMap<>();
        variables.put("bulletinPaie", bulletinPaie);

        context.setVariables(variables);
        String html = templateEngine.process(template, context);

        try {
            // Ensure the directory exists
            File directory = new File("src\\main\\resources\\pdf\\");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Use timestamp to create a unique filename
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String filename = bulletinPaie.getCode() + "_temp.pdf";
            String fileLocation = directory.getAbsolutePath() + "\\" + filename;

            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            HtmlConverter.convertToPdf(html, outputStream);
            Path filePath = Paths.get(fileLocation);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("Generated PDF is not readable: " + fileLocation);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }*/

    private final TemplateEngine templateEngine;

    public PdfUtil(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public static Resource htmlToPdf(BulletinPaie bulletinPaie, TemplateEngine templateEngine, String template) throws IOException {
        Context context = new Context();


        context.setVariable("bulletinPaie", bulletinPaie);
        String html = templateEngine.process(template, context);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            HtmlConverter.convertToPdf(html, outputStream);
            byte[] pdfBytes = outputStream.toByteArray();
            return new ByteArrayResource(pdfBytes);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }



}
