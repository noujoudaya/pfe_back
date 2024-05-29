package sir.zproject.pfe_back.service.util;

import org.springframework.stereotype.Service;



import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import sir.zproject.pfe_back.bean.BulletinPaie;
import java.io.FileOutputStream;



import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;


@Service
public class PdfService {

    /*private final TemplateEngine templateEngine;

    public PdfService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String generateHtml(BulletinPaie bulletinPaie) {
        Context context = new Context();
        context.setVariable("bulletinPaie", bulletinPaie);
        return templateEngine.process("bulletinPaie", context);
    }
    public String htmlToPdf(String processedHtml,Long code) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {

            PdfWriter pdfwriter = new PdfWriter(byteArrayOutputStream);

            DefaultFontProvider defaultFont = new DefaultFontProvider(false, true, false);

            ConverterProperties converterProperties = new ConverterProperties();

            converterProperties.setFontProvider(defaultFont);
            converterProperties.setTagWorkerFactory(new CustomTagWorkerFactory());
            HtmlConverter.convertToPdf(processedHtml, pdfwriter, converterProperties);


            FileOutputStream fout = new FileOutputStream("src/main/resources/pdf/" + code + ".pdf");

            byteArrayOutputStream.writeTo(fout);
            byteArrayOutputStream.close();

            byteArrayOutputStream.flush();
            fout.close();

            return null;

        } catch(Exception ex) {

            //exception occured
        }

        return null;
    }*/

}
