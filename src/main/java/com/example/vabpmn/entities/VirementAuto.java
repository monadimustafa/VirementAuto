package com.example.vabpmn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class VirementAuto
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String id_client;
    private String num_compte;
    private String nom;
    private Integer mon_total;
    private Date dateVir;
    private Integer nbr_oper;
    private boolean conforme;
    private String status;
    private String initiateur;
    private String name;
    @Lob
    private byte[] fileData;
}
