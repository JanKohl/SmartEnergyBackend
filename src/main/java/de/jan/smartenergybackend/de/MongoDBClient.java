/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jan.smartenergybackend.de;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author kohlbrecher
 */
public class MongoDBClient {
    
    private final MongoClient mongoClient;
    private final String databaseName = "smartMeter";
    private final String measurementCollection = "measurement";
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoDBClient() {
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase(databaseName);
        collection = database.getCollection(measurementCollection);
        
    }
    
    /**
     * Insert a measured value into the DB.
     * 
     * @param smartMeterId The specific smart meter ID
     * @param startTime The start time where the measurement has been started
     * @param endTime The end time where the measurement has been stoped
     * @param value the measured value
     */
    public void insertSmartMeterValue(int smartMeterId, int startTime, int endTime, long value){
        
        Document document = new Document("smartmeterId", smartMeterId)
                                        .append("starttime", startTime)
                                        .append("endtime", endTime)
                                        .append("value", value);

        collection.insertOne(document);
    }
    
    /**
     * 
     * @param startTime
     * @param entTime
     * @return The avarage of the measured values in the given time slot
     */
    public long getSmartMeterValueAvarage(int startTime, int entTime) {
        FindIterable<Document> findIt = collection.find();
        MongoCursor<Document> mongoCurser = findIt.iterator();
        int count = 0;
        long sum = 0;
        while (mongoCurser.hasNext()) {
            Document next = mongoCurser.next();
            sum += next.getLong("value");
            count++;
        }
        if(count > 0){
            return sum/count;
        } else {
            return -1;
        }
    }
}
