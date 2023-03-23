package com.liam.softwaredesign.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class healthTest {

    @InjectMocks
    health healthController;


    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void healthCheck(){
        final String compare = "Microservice Is Up And Running";

        final String ret = healthController.healthCheck();

        assertNotNull(ret);
        assertEquals(compare, ret);
    }


}
