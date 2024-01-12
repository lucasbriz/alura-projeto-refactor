package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.AnimalShelterService;
import br.com.alura.service.AnimalShelterServiceImpl;
import br.com.alura.service.PetService;
import br.com.alura.service.PetServiceImpl;
import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {
        ClientHttpConfiguration client = new ClientHttpConfiguration();
        AnimalShelterService animalShelterService = new AnimalShelterServiceImpl(client);
        PetService petService = new PetServiceImpl(client);

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                String optionsMenu = """
                    DIGITE O NÚMERO DA OPERAÇÃO DESEJADA:
                    1 -> Listar abrigos cadastrados
                    2 -> Cadastrar novo abrigo
                    3 -> Listar pets do abrigo
                    4 -> Importar pets do abrigo
                    5 -> Sair
                    """;

                System.out.print(optionsMenu);

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                if (opcaoEscolhida == 1) {
                    animalShelterService.listAnimalShelter();
                } else if (opcaoEscolhida == 2) {
                    animalShelterService.createAnimalShelter();
                } else if (opcaoEscolhida == 3) {
                    petService.listPets();
                } else if (opcaoEscolhida == 4) {
                    petService.importPetFile();
                } else if (opcaoEscolhida == 5) {
                    break;
                } else {
                    System.out.println("NÚMERO INVÁLIDO!");
                    opcaoEscolhida = 0;
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
