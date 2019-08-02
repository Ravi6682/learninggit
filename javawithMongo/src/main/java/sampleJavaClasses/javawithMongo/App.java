package sampleJavaClasses.javawithMongo;

import java.util.Iterator;

import org.bson.Document;

//import com.mongodb.DBCollection;
//import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
//import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		MongoCollection<Document> mgCollection = getCollectionObject();

		FindIterable<Document> iterDoc = mgCollection.find();

		int i = 1;

		// Getting the iterator
		Iterator it = iterDoc.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
			System.out.println("I value is : "+i);
			i++;
		}

	}
		
	// This method return collection Object
	private static MongoCollection<Document> getCollectionObject() {
		String dbName = "ravitestdb";
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase(dbName);
		
		System.out.println(" In SIde getcollection method");
		
		MongoCollection<Document> mgCollection = database.getCollection("post");
		return mgCollection;
	}
}
