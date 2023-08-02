package edeal.recruitment.custom;

import edeal.recruitment.ProjectBean;

import java.util.Date;

public class ProjectBeanCustom extends ProjectBean {

  String etat;

  public ProjectBeanCustom(String titre, int numero, Date dateDebut, Date dateFin, String etat) {
    super(titre, numero, dateDebut, dateFin);
    this.etat = etat;
  }

  public ProjectBeanCustom(String titre, int numero, Date dateDebut, Date dateFin) {
    super(titre, numero, dateDebut, dateFin);
  }
}
