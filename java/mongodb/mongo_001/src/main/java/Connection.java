import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by genji on 2/4/17.
 */
public class Connection {

    MongoClient mongoClient;

    public Connection(){
        mongoClient = new MongoClient( "localhost" );
    }

    public static void main(String[] args) {

        Connection con = new Connection();

        // If DB does not exists it will be created
        MongoDatabase database = con.mongoClient.getDatabase("testdb");

        for (String name : database.listCollectionNames()) {

            System.out.println(name);
        }

        MongoCollection<Document> coll = database.getCollection("cars");
        con.showAll(coll);

        /* add a new  document
        System.out.println(" ... insert a new document in car collection ... \n");
        Document doc = new Document("name", "Scassona").append("price", 0);
        coll.insertOne(doc);
        con.showAll(coll);

        doc = coll.find().first();
        System.out.println(" ... findOne ..");
        System.out.println(doc.toJson());
        con.mongoClient.close();
        */
    }

    void showAll(MongoCollection<Document> coll){

        /* WITHOUT LAMBDA
        Block<Document> printDocumentBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());
            }
        };
        */

        Block<Document> printDocumentBlock = d -> System.out.println(d.toJson());
        Block<Document> printDocumentBlock2 =
                d -> System.out.println("name: " + d.get("name") + ", price: " + d.get("price"));


        coll.find().forEach(printDocumentBlock2);

        /* old fashion ****
        MongoCursor<Document> cursor = coll.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
         */


    }
}
