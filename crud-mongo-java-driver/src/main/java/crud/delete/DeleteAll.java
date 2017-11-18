package crud.delete;


import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import util.ConnectUtil;

import static com.mongodb.client.model.Filters.eq;


/**
 * Created by mccstan on 18/11/2017.
 */
public class DeleteAll {
    public static void main(String[] args){

        // Supprimer un Document
        DeleteResult result =  ConnectUtil.collection.deleteMany(new Document());

        System.out.println("ACK : " + result.wasAcknowledged() +
                "\ndeletecount : " + result.getDeletedCount());

        ConnectUtil.mongoClient.close();

    }
}
