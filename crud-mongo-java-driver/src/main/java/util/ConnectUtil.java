package util;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by mccstan on 18/11/2017.
 */
public class ConnectUtil {
    public static Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };

    // Connection à la base de données, collection restaurants
    public static MongoClient mongoClient = new MongoClient();
    public static MongoDatabase database = mongoClient.getDatabase("mongo-training");
    public static MongoCollection<Document> collection = database.getCollection("restaurants");

    public static Document createOneRestaurant(){
        Document document = new Document("name", "Soat's Barkery")
                .append("restaurant_id", "900061322")
                .append("borough", "Paris")
                .append("cuisine", "Barkery")
                .append("address", new Document("building", "Sequana")
                        .append("coord", Arrays.asList(-73.7032601, 40.7386417))
                        .append("street", "Pont Henry Levassor")
                        .append("zipcode", "75013")

                )
                .append("grades", Arrays.asList(new Document("date", new Date())
                        .append("grade", "A")
                        .append("score", 25)
                ));


        return document;
    }

    public static List<Document> createMultipleRestaurant(){

        Document document1 = new Document("name", "Soat's Barkery")
                .append("restaurant_id", "900061322")
                .append("borough", "Paris")
                .append("cuisine", "Barkery")
                .append("address", new Document("building", "Sequana")
                        .append("coord", Arrays.asList(-73.7032601, 40.7386417))
                        .append("street", "Pont Henry Levassor")
                        .append("zipcode", "75013")

                )
                .append("grades", Arrays.asList(new Document("date", new Date())
                        .append("grade", "A")
                        .append("score", 25)
                ));

        Document document2 = new Document("name", "Hippopotamus")
                .append("restaurant_id", "9000613299")
                .append("borough", "Paris")
                .append("cuisine", "American")
                .append("address", new Document("building", "Bastille Building")
                        .append("coord", Arrays.asList(-73.7032601, 40.7386417))
                        .append("street", "Roquette")
                        .append("zipcode", "75011")

                )
                .append("grades", Arrays.asList(new Document("date", new Date())
                        .append("grade", "A")
                        .append("score", 25)
                ));

        List<Document> documents = new ArrayList<Document>();
        documents.add(document1);
        documents.add(document2);

        return documents;
    }
}
