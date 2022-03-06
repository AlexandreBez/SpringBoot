/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.junit;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Lucas
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    
    @Mock
    List<String> lista;
    
    @Test
    public void primeiroTesteMockito() {
        // List<String> lista = Mockito.mock(ArrayList.class);
        //        Mockito.when(lista.size()).thenReturn(2);
      
        //        int size = 0;
        //        if (1 == 2) {
        //            size = lista.size();
        //            size = lista.size();
        //        }
        
        lista.size();
        lista.add("");
        
        InOrder inOrder = Mockito.inOrder(lista);
        inOrder.verify(lista.size());
        inOrder.verify(lista.add(""));
        
        //Assertions.assertThat(size).isEqualTo(20);
        
        //Mockito.verify(lista, Mockito.times(1)).size();
        //Mockito.verify(lista, Mockito.never()).size();
    }
}
