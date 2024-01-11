package br.com.alura.service;

import java.io.IOException;

public interface PetService {

  void listPets() throws IOException, InterruptedException;
  void importPetFile() throws IOException, InterruptedException;

}
