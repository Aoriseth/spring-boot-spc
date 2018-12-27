package be.faros.springbootspc.bootstrap;

import be.faros.springbootspc.model.Owner;
import be.faros.springbootspc.model.Vet;
import be.faros.springbootspc.services.OwnerService;
import be.faros.springbootspc.services.VetService;
import be.faros.springbootspc.services.map.OwnerServiceMap;
import be.faros.springbootspc.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService =  new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Machigan");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mike");
        owner2.setLastName("Tennison");

        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Loading Owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Minne");
        vet1.setLastName("Rechelle");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Goran");
        vet2.setLastName("Rapustido");

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loading Vets");

    }
}