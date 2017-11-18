package crud.write;


import util.ConnectUtil;


/**
 * Created by mccstan on 18/11/2017.
 */
public class WriteMultiplesDocuments {
    public static void main(String[] args){

        // Ecrire plusieurs documents
        ConnectUtil.collection.insertMany(ConnectUtil.createMultipleRestaurant());

        ConnectUtil.mongoClient.close();

    }
}
