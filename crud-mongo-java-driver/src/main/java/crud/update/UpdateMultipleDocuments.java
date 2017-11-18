package crud.update;


import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import util.ConnectUtil;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.currentDate;
import static com.mongodb.client.model.Updates.set;


/**
 * Created by mccstan on 18/11/2017.
 */
public class UpdateMultipleDocuments {
    public static void main(String[] args){

        UpdateResult result =  ConnectUtil.collection.updateMany(
                eq("cuisine", "French"),
                combine(set("cuisine", "French"), currentDate("lastModified"))
        );

        System.out.println("ACK : " + result.wasAcknowledged() +
                "\nModifiedCount : " + result.getModifiedCount() +
                "\nmatchCount : " + result.getMatchedCount());

        ConnectUtil.mongoClient.close();
    }
}
