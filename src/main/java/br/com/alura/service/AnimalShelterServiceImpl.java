package br.com.alura.service;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.domain.AnimalShelter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnimalShelterServiceImpl implements AnimalShelterService {

  private final ClientHttpConfiguration client;

  public AnimalShelterServiceImpl(ClientHttpConfiguration client) {
    this.client = client;
  }

  public void listAnimalShelter() throws InterruptedException, IOException {
    String uri = "http://localhost:8080/abrigos";
    HttpResponse<String> response = client.startGetRequest(uri);
    String responseBody = response.body();

    AnimalShelter[] animalShelters = new ObjectMapper().readValue(responseBody, AnimalShelter[].class);
    List<AnimalShelter> shelterList = Arrays.stream(animalShelters).toList();

    System.out.println("Abrigos cadastrados:");
    for (AnimalShelter animalShelter : shelterList) {
      long id = animalShelter.getId();
      String nome = animalShelter.getName();
      System.out.println(id +" - " +nome);
    }
  }

  public void createAnimalShelter() throws IOException, InterruptedException {
    System.out.println("Digite o nome do abrigo:");
    String name = new Scanner(System.in).nextLine();
    System.out.println("Digite o telefone do abrigo:");
    String telephone = new Scanner(System.in).nextLine();
    System.out.println("Digite o email do abrigo:");
    String email = new Scanner(System.in).nextLine();

    AnimalShelter animalShelter = new AnimalShelter(name, telephone, email);

    String uri = "http://localhost:8080/abrigos";

    HttpResponse<String> response = client.startPostRequest(uri, animalShelter);

    int statusCode = response.statusCode();
    String responseBody = response.body();
    if (statusCode == 200) {
      System.out.println("Abrigo cadastrado com sucesso!");
      System.out.println(responseBody);
    } else if (statusCode == 400 || statusCode == 500) {
      System.out.println("Erro ao cadastrar o abrigo:");
      System.out.println(responseBody);
    }
  }
}
