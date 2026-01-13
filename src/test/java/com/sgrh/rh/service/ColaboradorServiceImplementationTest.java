package com.sgrh.rh.service;

import com.sgrh.rh.repository.ColaboradorRepository;
import com.sgrh.rh.service.implementation.ColaboradorServiceImplementation;
import com.sgrh.rh.util.ColaboradorMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ColaboradorServiceImplementationTest {

    @Mock
    private ColaboradorRepository colaboradorRepository;

    @Mock
    private ColaboradorMapper colaboradorMapper;

    @InjectMocks
    private ColaboradorServiceImplementation service;
}
