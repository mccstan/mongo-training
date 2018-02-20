package crud.delete;


import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import util.ConnectUtil;

import static com.mongodb.client.model.Filters.eq;


/**
 * Created by mccstan on 18/11/2017.
 */
public class DeleteOneDocument {
    public static void main(String[] args){

        // Supprimer un Document
        DeleteResult result =  ConnectUtil.collection.deleteOne(
                eq("_id", new ObjectId("5a1098dec093d45b79070e2b"))
        );

        System.out.println("ACK : " + result.wasAcknowledged() +
                "\ndeletecount : " + result.getDeletedCount());

        ConnectUtil.mongoClient.close();

    }
}
