package DatabaseAccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

import java.lang.reflect.Type;


public class Database {
	protected MongoDatabase database;
	private final MongoClient mongoClient;
        private final static String databaseAddress= "";
        private final static int databasePort= 27017;
        private final static String databaseUserName= "";
        private final static String databasePassword="";
         private final static String databaseName= "";
	public Database() {
            
            // data
		ServerConfig conf = new ServerConfig(databaseAddress,databasePort,databaseUserName,databasePassword);
		MongoCredential credential = MongoCredential.createCredential(conf.getUserName(), "admin", conf.getPassword().toCharArray());
		mongoClient = new MongoClient(new ServerAddress(conf.getServerName(), conf.getPort()), Arrays.asList(credential));
		database = mongoClient.getDatabase(databaseName);
	}
	
	public MongoCollection<Document> getCollection(String collectionName){
		return database.getCollection(collectionName);
	}
	
	
	public <T> void insertOne(T target, String collectionName) {
		MongoCollection<Document> coll = getCollection(collectionName);
		GsonBuilder gb = new GsonBuilder();
		Gson gson  =gb.create();
		String jStr = gson.toJson(target);
		Document doc = Document.parse(jStr);
		coll.insertOne(doc);
	}
	
	
	public <T extends Iterable<?>> void insertMany(T targets , String collectionName) {
		MongoCollection<Document> coll = getCollection(collectionName);
		List<Document> docs = new ArrayList<>();
		GsonBuilder gb = new GsonBuilder();
		for(Iterator<?> i = targets.iterator();i.hasNext();) {
			String jStr = gb.create().toJson(i.next());
			docs.add(Document.parse(jStr));
		}
		coll.insertMany(docs);
	}
	
	public BlockingQueue<String> getAllContentForSpecificField(String name, String collectionName){
		MongoCollection<Document> coll = getCollection(collectionName);
		// you could put where clause here
		BasicDBObject query = new BasicDBObject();
		
		MongoCursor<Document> cursor = coll.find(query).projection(Projections.fields(Projections.include(name), Projections.excludeId())).iterator();
		BlockingQueue<String> res = new LinkedBlockingQueue<>();
		try {
			while(cursor.hasNext()) {
				String field = cursor.next().getString(name);
				if(!field.isEmpty()) {
					res.add(field);
				}
				
			}
			return res;
		} finally{
			cursor.close();
		}
	}
	
	public <T> BlockingQueue<T> getTopNContent(String collectionName, int limit, Class<T> typeClass){
		MongoCollection<Document> coll = getCollection(collectionName);

		
		MongoCursor<Document> cursor = coll.find().limit(limit).iterator();
		BlockingQueue<T> res = new LinkedBlockingQueue<>();
		try {
			while(cursor.hasNext()) {
				String field = cursor.next().toJson();
				T obj = new GsonBuilder().create().fromJson(field,typeClass);
				res.add(obj);		
			}
			return res;
		} finally{
			cursor.close();
		}
	}
	
	public void deleteById(String collectionName, String id) {
		MongoCollection<Document> coll = getCollection(collectionName);
		coll.deleteOne(new Document("_id", new ObjectId(id)));
	}
}