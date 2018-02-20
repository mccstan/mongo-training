package crud.write;


import com.mongodb.client.result.UpdateResult;
import util.ConnectUtil;


/**
 * Created by mccstan on 18/11/2017.
 */
public class WriteOneDocument {
    public static void main(String[] args){

        // Ecrire un document
        ConnectUtil.collection.insertOne(ConnectUtil.createOneRestaurant());

        ConnectUtil.mongoClient.close();

    }
}
