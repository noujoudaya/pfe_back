package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.BulletinPaie;
import sir.zproject.pfe_back.ws.dto.BulletinPaieDto;
import sir.zproject.pfe_back.ws.dto.EmployeDto;
import sir.zproject.pfe_back.ws.dto.EntrepriseDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BulletinPaieConverter {
    private final BulletinPaieRubriqueConverter bulletinPaieRubriqueConverter;
    private final EmployeConverter employeConverter;
    private final EntrepriseConverter entrepriseConverter;

    public BulletinPaieConverter(BulletinPaieRubriqueConverter bulletinPaieRubriqueConverter, EmployeConverter employeConverter, EntrepriseConverter entrepriseConverter) {
        this.bulletinPaieRubriqueConverter = bulletinPaieRubriqueConverter;
        this.employeConverter = employeConverter;
        this.entrepriseConverter = entrepriseConverter;
    }

    public BulletinPaie toBean(BulletinPaieDto dto) {
        BulletinPaie bean = new BulletinPaie();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        bean.setMonth(dto.getMonth());
        bean.setYear(dto.getYear());
        bean.setNbrJourTravaille(dto.getNbrJourTravaille());
        bean.setNbrHeuresTravaille(dto.getNbrHeuresTravaille());

        bean.setTauxHoraire(dto.getTauxHoraire());
        bean.setNbrJourCongeNonPaye(dto.getNbrJourCongeNonPaye());
        bean.setNbrJourAbsenceNonJust(dto.getNbrJourAbsenceNonJust());
        bean.setAnciennete(dto.getAnciennete());
        bean.setSalaireBaseMensuelle(dto.getSalaireBaseMensuelle());
        bean.setSalaireBaseImposable(dto.getSalaireBaseImposable());
        bean.setSalaireBruteGlobale(dto.getSalaireBruteGlobale());
        bean.setSalaireBrutImp(dto.getSalaireBrutImp());
        bean.setSalaireNetImp(dto.getSalaireNetImp());
        bean.setSalNetPayer(dto.getSalNetPayer());
        bean.setRetenusCnss(dto.getRetenusCnss());
        bean.setRetenusAmo(dto.getRetenusAmo());
        bean.setRetenusIr(dto.getRetenusIr());
        bean.setTauxIr(dto.getTauxIr());
        bean.setTauxAnc(dto.getTauxAnc());
        bean.setPrimeAnc(dto.getPrimeAnc());
        bean.setHeuresSupp25(dto.getHeuresSupp25());
        bean.setHeuresSupp50(dto.getHeuresSupp50());
        bean.setHeuresSupp100(dto.getHeuresSupp100());
        bean.setBulletinPaieRubriques(dto.getBulletinPaieRubriques().stream()
                .map(bulletinPaieRubriqueConverter::toBean)
                .collect(Collectors.toSet()));
        bean.setEmploye(employeConverter.toBean(dto.getEmploye()));
        bean.setEntreprise(entrepriseConverter.toBean(dto.getEntreprise()));
        return bean;
    }

    public List<BulletinPaie> toBean(List<BulletinPaieDto> dtos) {
        return dtos.stream().map(this::toBean).collect(Collectors.toList());
    }

    public BulletinPaieDto toDto(BulletinPaie bean) {
        BulletinPaieDto dto = new BulletinPaieDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setMonth(bean.getMonth());
        dto.setYear(bean.getYear());
        dto.setNbrJourTravaille(bean.getNbrJourTravaille());
        dto.setNbrHeuresTravaille(bean.getNbrHeuresTravaille());

        dto.setTauxHoraire(bean.getTauxHoraire());
        dto.setNbrJourCongeNonPaye(bean.getNbrJourCongeNonPaye());
        dto.setNbrJourAbsenceNonJust(bean.getNbrJourAbsenceNonJust());
        dto.setAnciennete(bean.getAnciennete());
        dto.setSalaireBaseMensuelle(bean.getSalaireBaseMensuelle());
        dto.setSalaireBaseImposable(bean.getSalaireBaseImposable());
        dto.setSalaireBruteGlobale(bean.getSalaireBruteGlobale());
        dto.setSalaireBrutImp(bean.getSalaireBrutImp());
        dto.setSalaireNetImp(bean.getSalaireNetImp());
        dto.setSalNetPayer(bean.getSalNetPayer());
        dto.setRetenusCnss(bean.getRetenusCnss());
        dto.setRetenusAmo(bean.getRetenusAmo());
        dto.setRetenusIr(bean.getRetenusIr());
        dto.setTauxIr(bean.getTauxIr());
        dto.setTauxAnc(bean.getTauxAnc());
        dto.setPrimeAnc(bean.getPrimeAnc());
        dto.setHeuresSupp25(bean.getHeuresSupp25());
        dto.setHeuresSupp50(bean.getHeuresSupp50());
        dto.setHeuresSupp100(bean.getHeuresSupp100());
        dto.setBulletinPaieRubriques(bean.getBulletinPaieRubriques().stream()
                .map(bulletinPaieRubriqueConverter::toDto)
                .collect(Collectors.toList()));
        dto.setEmploye(employeConverter.toDto(bean.getEmploye()));
        dto.setEntreprise(entrepriseConverter.toDto(bean.getEntreprise()));
        return dto;
    }

    public List<BulletinPaieDto> toDto(List<BulletinPaie> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
