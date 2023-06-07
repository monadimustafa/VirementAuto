package com.example.vabpmn.Mapper;

import com.example.vabpmn.Dto.VirementAutoDto;
import com.example.vabpmn.entities.VirementAuto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class mapper {

    public VirementAutoDto fromVirementAuto(VirementAuto virementAuto){
        VirementAutoDto virementAutoDto = new VirementAutoDto();
        BeanUtils.copyProperties(virementAuto,virementAutoDto);
        return virementAutoDto;
    }
    public VirementAuto fromVirementAujtoDto(VirementAutoDto virementAutoDto){
        VirementAuto virementAuto = new VirementAuto();
        BeanUtils.copyProperties(virementAutoDto,virementAuto);
        return virementAuto;
    }
}
