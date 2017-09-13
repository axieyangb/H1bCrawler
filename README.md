# H1bCrawler
Only support Mongo db right now.
You need to assign your database info in src/DatabaseAccess/Database.java file
   private final static String databaseAddress= "";
        private final static int databasePort= 27017;
        private final static String databaseUserName= "";
        private final static String databasePassword="";
         private final static String databaseName= "";

If you want to use other relational database, please write your own database access layer.

Thanks,

Hope everyone who are still struggling in RFE would got a good result.
