/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jan.smartenergybackend.mongo;

import de.jan.smartenergybackend.de.MongoDBClient;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author kohlbrecher
 */
public class MongoConnectionTest {
    
    @Test
    public void avarageTest(){
        MongoDBClient mongoDBClient = new MongoDBClient();
        mongoDBClient.insertSmartMeterValue(1, 10, 1000, 100L);
        assertEquals(100L, mongoDBClient.getSmartMeterValueAvarage(10, 1000));
    }   
}
