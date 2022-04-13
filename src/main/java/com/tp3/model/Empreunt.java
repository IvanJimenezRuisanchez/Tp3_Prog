package com.tp3.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Empreunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpreunt;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String status;

    public Empreunt(Client user , Document document , LocalDate dateFin, String status) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.status = status;
        this.dateDebut = LocalDate.now();
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_document")
    private Document document;


    public void addDocumentToEmpreunt(Document document){ this.document = document; }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_user")
    @ToString.Exclude
    private Client client;

    public void addClientResponsable(Client client){ this.client = client; }
}
