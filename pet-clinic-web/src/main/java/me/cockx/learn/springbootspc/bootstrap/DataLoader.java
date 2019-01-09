package me.cockx.learn.springbootspc.bootstrap;

import me.cockx.learn.springbootspc.model.*;
import me.cockx.learn.springbootspc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petService1, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService1;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {

        if(petService.findAll().size()==0){
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        dog = petService.save(dog);
        PetType cat = new PetType();
        cat.setName("Cat");
        cat = petService.save(cat);

        Pet pet1 = new Pet();
        pet1.setPetType(dog);
        pet1.setBirthDate(LocalDate.of(1993,5,3));
        pet1.setName("Mikiki");

        Pet pet2 = new Pet();
        pet2.setPetType(cat);
        pet2.setBirthDate(LocalDate.of(1997,5,21));
        pet2.setName("Sivona");

        Specialty spec1 = new Specialty();
        spec1.setDescription("Radiology");
        Specialty spec2 = new Specialty();
        spec2.setDescription("Surgery");
        Specialty spec3 = new Specialty();
        spec3.setDescription("Dentistry");

        spec1 = specialtyService.save(spec1);
        spec2 = specialtyService.save(spec2);
        spec3 = specialtyService.save(spec3);


        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Machigan");
        owner1.setAddress("Maridian Lane 15");
        owner1.setCity("Goro City");
        owner1.setTelephone("0148478573");

        Owner owner2 = new Owner();
        owner2.setFirstName("Mike");
        owner2.setLastName("Tennison");
        owner2.setAddress("Jhonson street 34");
        owner2.setCity("Suanari");
        owner2.setTelephone("0234348454");

        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);

        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Loading Owners...");

        Visit visit1 = new Visit();
        visit1.setPet(pet1);
        visit1.setLocalDate(LocalDate.MAX);
        visit1.setDescription("Regular checkup at the Veterinary at the end of the universe.");
        visitService.save(visit1);
        System.out.println("Loading Visits...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Minne");
        vet1.setLastName("Rechelle");
        vet1.getSpecialties().add(spec1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Goran");
        vet2.setLastName("Rapustido");
        vet2.getSpecialties().add(spec2);
        vet2.getSpecialties().add(spec3);

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loading Vets...");
    }
}
