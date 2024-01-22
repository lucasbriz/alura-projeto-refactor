package br.com.alura.domain;

public class Pet {

  private Long id;
  private String type;
  private String name;
  private String breed;
  private int age;
  private String color;
  private Float weight;

  public Pet(String type, String name, String breed, int age, String color, Float weight) {
    this.type = type;
    this.name = name;
    this.breed = breed;
    this.age = age;
    this.color = color;
    this.weight = weight;
  }

  public Long getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public String getBreed() {
    return breed;
  }

  public int getAge() {
    return age;
  }

}
