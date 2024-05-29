package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.BulletinPaieRubrique;
import sir.zproject.pfe_back.ws.dto.BulletinPaieRubriqueDto;

@Component
public class BulletinPaieRubriqueConverter {
    private final RubriqueConverter rubriqueConverter;

    public BulletinPaieRubriqueConverter(RubriqueConverter rubriqueConverter) {
        this.rubriqueConverter = rubriqueConverter;
    }

    public BulletinPaieRubrique toBean(BulletinPaieRubriqueDto dto) {
        BulletinPaieRubrique bean = new BulletinPaieRubrique();
        if (dto.getBulletinPaieId() != null && dto.getRubriqueId() != null) {
            bean.getId().setBulletinPaieId(dto.getBulletinPaieId());
            bean.getId().setRubriqueId(dto.getRubriqueId());
        }
        bean.setMontant(dto.getMontant());
        bean.setNombre(dto.getNombre());
        bean.setRubrique(rubriqueConverter.toBean(dto.getRubrique()));
        return bean;
    }

    public BulletinPaieRubriqueDto toDto(BulletinPaieRubrique bean) {
        BulletinPaieRubriqueDto dto = new BulletinPaieRubriqueDto();
        dto.setBulletinPaieId(bean.getId().getBulletinPaieId());
        dto.setRubriqueId(bean.getId().getRubriqueId());
        dto.setMontant(bean.getMontant());
        dto.setNombre(bean.getNombre());
        dto.setRubrique(rubriqueConverter.toDto(bean.getRubrique()));
        return dto;
    }
}
