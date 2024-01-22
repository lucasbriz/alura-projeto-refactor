package br.com.alura.domain;

public class AnimalShelter {

  private Long id;
  private String name;
  private String telephone;
  private String email;

  public AnimalShelter(String name, String telephone, String email) {
    this.name = name;
    this.telephone = telephone;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
