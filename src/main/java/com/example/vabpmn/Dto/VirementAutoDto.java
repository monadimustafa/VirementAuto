package com.example.vabpmn.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class VirementAutoDto {
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
    private PieceJointe pieceJointe;
}
