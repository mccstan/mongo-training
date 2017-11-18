package crud.update;


import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import util.ConnectUtil;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;


/**
 * Created by mccstan on 18/11/2017.
 */
public class UpdateOneDocument {
    public static void main(String[] args){

        //
        UpdateResult result =  ConnectUtil.collection.updateOne(
                eq("_id", new ObjectId("5a1098dec093d45b79070dda")),
                combine(set("cuisine", "French"), currentDate("lastModified"))
        );

        System.out.println("ACK : " + result.wasAcknowledged() +
                "\nModifiedCount : " + result.getModifiedCount() +
                "\nmatchCount : " + result.getMatchedCount());

        ConnectUtil.mongoClient.close();
    }
}