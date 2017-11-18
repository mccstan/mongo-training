package crud.read;

import org.bson.Document;
import util.ConnectUtil;

import static com.mongodb.client.model.Filters.*;


/**
 * Created by mccstan on 18/11/2017.
 */
public class ReadWithFilterOperators {
    public static void main(String[] args){
        // Utilisation d'un filtre avec opérateurs
        ConnectUtil.collection.find(
                and(
                        gte("grades.score",10),
                        lte("grades.score",15),
                        eq("cuisine", "Bakery")
                ))
                .forEach(ConnectUtil.printBlock);

        ConnectUtil.mongoClient.close();
    }
}
