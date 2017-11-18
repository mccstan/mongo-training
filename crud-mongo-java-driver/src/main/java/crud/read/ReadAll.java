package crud.read;


import org.bson.Document;
import util.ConnectUtil;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;


/**
 * Created by mccstan on 18/11/2017.
 */
public class ReadAll {
    public static void main(String[] args){

        // Afficher tous les documents
        ConnectUtil.collection.find()
                .limit(100)
                .forEach(ConnectUtil.printBlock);

        ConnectUtil.mongoClient.close();

    }
}
