package com.example.vabpmn.Services;

import com.example.vabpmn.Dto.VirementAutoDto;
import com.example.vabpmn.Reositories.PJRepository;
import com.example.vabpmn.Reositories.VARepository;
import com.example.vabpmn.entities.VirementAuto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import com.example.vabpmn.Mapper.mapper;
import org.springframework.web.multipart.MultipartFile;
@Service
@AllArgsConstructor
public class VAService {

    private VARepository vaRepository;
    private PJRepository pjRepository;
    private mapper mapper;

    public List<VirementAutoDto> getListVADtoInit()
    {
        List<VirementAuto> listVA = vaRepository.findByStatus("initie");
        List<VirementAutoDto> listVADto = listVA.stream().map(elem->mapper.fromVirementAuto(elem)).collect(Collectors.toList());
        return listVADto;
    }
    public List<VirementAutoDto> getListVARejete()
    {
        List<VirementAuto> listVA = vaRepository.findByStatus("rejete");
        List<VirementAutoDto> listVADto = listVA.stream().map(elem->mapper.fromVirementAuto(elem)).collect(Collectors.toList());
        return listVADto;
    }
    public List<VirementAutoDto> getListVAValide()
    {
        List<VirementAuto> listVA = vaRepository.findByStatus("valide");
        List<VirementAutoDto> listVADto = listVA.stream().map(elem->mapper.fromVirementAuto(elem)).collect(Collectors.toList());
        return listVADto;
    }
    public List<VirementAutoDto> getListVAConfirme()
    {
        List<VirementAuto> listVA = vaRepository.findByStatus("confirme");
        List<VirementAutoDto> listVADto = listVA.stream().map(elem->mapper.fromVirementAuto(elem)).collect(Collectors.toList());
        return listVADto;
    }

    public VirementAutoDto confirmVa(VirementAutoDto virementAutoDto)
    {
        VirementAuto virementAuto = mapper.fromVirementAujtoDto(virementAutoDto);
        VirementAuto virementAuto1 = vaRepository.save(virementAuto);
        VirementAutoDto virementAutoDto1  =  mapper.fromVirementAuto(virementAuto1);
        return virementAutoDto1;
    }
    public void rejetVA(VirementAuto virementAuto)
    {
        vaRepository.save(virementAuto);
    }
    public VirementAutoDto initierVA(VirementAutoDto virementAutoDto)
    {
        VirementAuto virementAuto = mapper.fromVirementAujtoDto(virementAutoDto);
        PieceJointe pieceJointe = this.uploadFile(virementAutoDto.);
        virementAuto.setPieceJointe();
        VirementAuto viremSaved = vaRepository.save(virementAuto);

        VirementAutoDto virementAutoDto1 = mapper.fromVirementAuto(viremSaved);
        return virementAutoDto1;
    }
    public void uploadFile(MultipartFile file) throws IOException
    {
        uploadFile.setFileName(file.getOriginalFilename());
        uploadFile.setFileType(file.getContentType());
        uploadFile.setData(file.getBytes());
        return pjRepository.save(uploadFile);
    }
}
