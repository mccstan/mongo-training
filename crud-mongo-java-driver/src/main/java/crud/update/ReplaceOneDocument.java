package crud.update;


import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import util.ConnectUtil;

import static com.mongodb.client.model.Filters.eq;


/**
 * Created by mccstan on 18/11/2017.
 */
public class ReplaceOneDocument {
    public static void main(String[] args){

        // Remplacer un document
        UpdateResult result =  ConnectUtil.collection.replaceOne(
                eq("_id", new ObjectId("5a1098dec093d45b79070dda")),
                ConnectUtil.createOneRestaurant()
        );

        System.out.println("ACK : " + result.wasAcknowledged() +
                "\nModifiedCount : " + result.getModifiedCount() +
                "\nmatchCount : " + result.getMatchedCount());

        ConnectUtil.mongoClient.close();

    }
}
