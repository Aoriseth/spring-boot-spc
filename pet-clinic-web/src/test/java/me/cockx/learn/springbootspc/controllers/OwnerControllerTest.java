package me.cockx.learn.springbootspc.controllers;

import me.cockx.learn.springbootspc.model.Owner;
import me.cockx.learn.springbootspc.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    private Set<Owner> ownerSet;

    private MockMvc mvc;

    @BeforeEach
    void setUp() {
        ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().firstName("Jill").build());
        ownerSet.add(Owner.builder().firstName("Mero").build());

        mvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);
        mvc.perform(get("/owners/")).andExpect(status().isOk())
            .andExpect(view().name("owners/index"))
            .andExpect(model().attribute("owners",hasSize(2)));

    }

    @Test
    void findOwners() throws Exception {
        mvc.perform(get("/owners/find")).andExpect(status().isOk())
            .andExpect(view().name("notImplemented"));

        verifyZeroInteractions(ownerService);
    }
}