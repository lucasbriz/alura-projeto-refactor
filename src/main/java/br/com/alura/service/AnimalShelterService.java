package br.com.alura.service;

import java.io.IOException;

public interface AnimalShelterService {

  void listAnimalShelter() throws InterruptedException, IOException;
  void createAnimalShelter() throws IOException, InterruptedException;

}
