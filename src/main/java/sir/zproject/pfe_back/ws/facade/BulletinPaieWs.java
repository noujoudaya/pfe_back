package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring6.SpringTemplateEngine;
import sir.zproject.pfe_back.bean.BulletinPaie;
import sir.zproject.pfe_back.service.facade.BulletinPaieService;
import sir.zproject.pfe_back.service.facade.EmployeService;
import sir.zproject.pfe_back.service.impl.BulletinPaieServiceImpl;
import sir.zproject.pfe_back.service.util.PdfService;
import sir.zproject.pfe_back.ws.converter.BulletinPaieConverter;
import sir.zproject.pfe_back.ws.dto.BulletinPaieDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("bulletin")
public class BulletinPaieWs {
    @Autowired
    private BulletinPaieService bulletinPaieService;
    @Autowired
    private BulletinPaieServiceImpl bulletinPaieServiceImpl;
    @Autowired
    private BulletinPaieConverter bulletinPaieConverter;
    @Autowired
    private SpringTemplateEngine springTemplateEngine;
    @Autowired
    private PdfService pdfService;
    @Autowired
    private EmployeService employeService;

    @GetMapping("/employe/matricule/{matricule}")
    public List<BulletinPaieDto> findByEmployeMatricule( @PathVariable Long matricule) {
        List<BulletinPaie> bulletinPaies = bulletinPaieService.findByEmployeMatricule(matricule);
        return bulletinPaieConverter.toDto(bulletinPaies);
    }
    @GetMapping("/employe/nom/{nom}")
    public List<BulletinPaieDto> findByEmployeNom(@PathVariable String nom) {
        List<BulletinPaie> bulletinPaies =  bulletinPaieService.findByEmployeNom(nom);
        return bulletinPaieConverter.toDto(bulletinPaies);
    }
    @GetMapping("/employe/prenom/{prenom}")
    public List<BulletinPaieDto> findByEmployePrenom(@PathVariable String prenom) {
        List<BulletinPaie> bulletinPaies =  bulletinPaieService.findByEmployePrenom(prenom);
        return bulletinPaieConverter.toDto(bulletinPaies);
    }
    @GetMapping("/month/{month}")
    public BulletinPaieDto findByMonth(@PathVariable String month) {
        BulletinPaie bulletinPaie = bulletinPaieService.findByMonth(month);
        return bulletinPaieConverter.toDto(bulletinPaie);
    }
    @GetMapping("/year/{year}")
    public List<BulletinPaieDto> findByYear(@PathVariable int year) {
        List<BulletinPaie> bulletinPaies =  bulletinPaieService.findByYear(year);
        return bulletinPaieConverter.toDto(bulletinPaies);
    }
    @GetMapping("/code/{code}")
    public BulletinPaieDto findByCode(@PathVariable Long code) {
        BulletinPaie bulletinPaie = bulletinPaieService.findByCode(code);
        return bulletinPaieConverter.toDto(bulletinPaie);
    }
    @GetMapping("/entreprise/ice/{ice}")
    public List<BulletinPaieDto> findByEntrepriseIce(@PathVariable String ice) {
        List<BulletinPaie> bulletinPaies =   bulletinPaieService.findByEntrepriseIce(ice);
        return bulletinPaieConverter.toDto(bulletinPaies);
    }

  @DeleteMapping("/entreprise/ice/{ice}")
    public int deleteByEntrepriseIce(@PathVariable String ice) {
        return bulletinPaieService.deleteByEntrepriseIce(ice);
    }
@GetMapping("/")
    public List<BulletinPaieDto> findAll() {
    List<BulletinPaie> bulletinPaies = bulletinPaieService.findAll();
    return bulletinPaieConverter.toDto(bulletinPaies);
    }
    @DeleteMapping("/employe/matricule/{matricule}")
    public int deleteByEmployeMatricule(@PathVariable  Long matricule) {
        return bulletinPaieService.deleteByEmployeMatricule(matricule);
    }
@PostMapping("/")
    public int save(@RequestBody BulletinPaie bulletinPaie) {
        return bulletinPaieService.save(bulletinPaie);
    }

/*    @GetMapping("/pdf/code/{code}")
    public Resource toPdf(@PathVariable Long code) throws IOException {
        BulletinPaieDto bulletinPaieDto = findByCode(code);
        BulletinPaie bulletinPaie = bulletinPaieConverter.toBean(bulletinPaieDto);
        return bulletinPaieService.toPdf(bulletinPaie);
    }*/
/*   @PostMapping(value = "/generate/document")
    public String generateDocument(@RequestBody BulletinPaie bulletin) {
        BulletinPaieDto bulletinPaieDto = findByCode(bulletin.getCode());
        BulletinPaie bulletinPaie = bulletinPaieConverter.toBean(bulletinPaieDto);
        String finalHtml = pdfService.generateHtml(bulletinPaie);
        pdfService.htmlToPdf(finalHtml, bulletinPaie.getCode());
        return "Success";
    }*/
    @PostMapping("/pdf")
    public Resource pdf(@RequestBody BulletinPaieDto bulletinPaieDto) throws IOException {
        BulletinPaie bulletinPaie = bulletinPaieConverter.toBean(bulletinPaieDto);
        return bulletinPaieService.toPdf(bulletinPaie);

    }
  @PostMapping("/calculer/")
    public BulletinPaieDto bulletinCalculated(@RequestBody BulletinPaie bulletinPaie) throws IOException {
        return bulletinPaieServiceImpl.bulletinCalculated(bulletinPaie);
    }
    @GetMapping("/pdf/code/{code}")
    public Resource getPdfByCode(@PathVariable String code) throws IOException {
        return bulletinPaieService.getPdfByCode(code);
    }
    @PostMapping("/save/")
    public int saveBulletin(@RequestBody BulletinPaie bulletinPaie) {
        return bulletinPaieServiceImpl.saveBulletin(bulletinPaie);
    }
}
