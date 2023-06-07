package com.example.vabpmn.Controller;

import com.example.vabpmn.Dto.VirementAutoDto;
import com.example.vabpmn.Services.VAService;
import com.example.vabpmn.entities.VirementAuto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor
@CrossOrigin("*")
public class VAController {

    private VAService vaService;
    @GetMapping("/listVADtoInit")
    public List<VirementAutoDto> getListVADto(){
        return vaService.getListVADtoInit();
    }
    @GetMapping("/listVaValide")
    public List<VirementAutoDto> getListVaValide(){
        return vaService.getListVAValide();
    }
    @GetMapping("/listVaRejete")
    public List<VirementAutoDto> getListVARejete(){
        return vaService.getListVARejete();
    }
    @GetMapping("/listVaConfirm")
    public List<VirementAutoDto> getListVAConfirme(){
        return vaService.getListVAConfirme();
    }

    @PostMapping("/addva")
    //INITIATION DE LA DEMANDE DE VIREMENT AUTOMATIQUE
    public VirementAutoDto initieVA(@RequestBody VirementAutoDto virementAutoDto){
        virementAutoDto.setStatus("initie");
       return vaService.initierVA(virementAutoDto);
    }
    //CONFIRMATION DU VIREMENT AUTOMATIQUE PAR LE GESTIONNAIRE
    @PutMapping("/confirmVa/{id}")
    public VirementAutoDto confirmerVA(@PathVariable Long id, @RequestBody VirementAutoDto virementAutoDto){
        virementAutoDto.setId(id);
        virementAutoDto.setStatus("confirme");
        return vaService.confirmVa(virementAutoDto);
    }
    //VALIDATION DU VIREMENT AUTOMATIQUE
    @PutMapping("/validVa/{id}")
    public void validerVA(@PathVariable Long id, @RequestBody VirementAuto virementAuto){
        virementAuto.setId(id);
        virementAuto.setStatus("valide");
        vaService.rejetVA(virementAuto);
    }

    // REJETTER VIREMENT PAR GESTIONNAIRE OU VLAIDATEUR
    @PutMapping("/rejetVa/{id}")
    public void rejetVA(@PathVariable Long id, @RequestBody VirementAuto virementAuto)
    {
        virementAuto.setId(id);
        virementAuto.setStatus("rejete");
        vaService.rejetVA(virementAuto);
    }
}
