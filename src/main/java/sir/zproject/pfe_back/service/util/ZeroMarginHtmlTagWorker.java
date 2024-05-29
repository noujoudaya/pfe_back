package sir.zproject.pfe_back.service.util;

import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.attach.impl.tags.HtmlTagWorker;
import com.itextpdf.layout.Document;
import com.itextpdf.styledxmlparser.node.IElementNode;

public class ZeroMarginHtmlTagWorker extends HtmlTagWorker {
    public ZeroMarginHtmlTagWorker(IElementNode element, ProcessorContext context) {
        super(element, context);
        Document doc = (Document) getElementResult();
        doc.setMargins(0, 0, 0, 0);
    }
}
