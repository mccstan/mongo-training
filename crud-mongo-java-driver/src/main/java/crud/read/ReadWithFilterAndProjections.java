package crud.read;

import util.ConnectUtil;

import static com.mongodb.client.model.Filters.*;

import org.bson.Document;



/**
 * Created by mccstan on 18/11/2017.
 */
public class ReadWithFilterAndProjections {
    public static void main(String[] args){
        // Utilisation d'un filtre et projection
        ConnectUtil.collection.find(
                // Filtres
                and(
                        gte("grades.score",10),
                        lte("grades.score",15),
                        eq("cuisine", "Bakery")
                ))
                .limit(100)
                // Projection
                .projection(new Document("name", 1)
                    .append("borough", 1)
                    .append("cuisine",1)
                .append("_id", 0))
                .forEach(ConnectUtil.printBlock);

        ConnectUtil.mongoClient.close();
    }
}
