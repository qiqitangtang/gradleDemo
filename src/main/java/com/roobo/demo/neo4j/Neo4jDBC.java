//package com.roobo.demo.neo4j;
//
//import org.neo4j.driver.v1.*;
//import org.neo4j.driver.v1.Driver;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//
//import static org.neo4j.driver.v1.Values.parameters;
//
///**
// * Created by NOTE-026 on 2017/3/2/0002.
// */
//public class Neo4jDBC {
//
//    private static void testGraphDriver(){
//        Driver driver = GraphDatabase.driver( "bolt://172.16.101.19:7687", AuthTokens.basic("com/roobo/demo/neo4j", "p@ssw0rd" ) );
//        Session session = driver.session();
//        session.run( "CREATE (a:Person {name: {name}, title: {title}})",
//                parameters( "name", "Arthur", "title", "King" ) );
//
//        StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = {name} " +
//                        "RETURN a.name AS name, a.title AS title",
//                parameters( "name", "Arthur" ) );
//        while ( result.hasNext() )
//        {
//            Record record = result.next();
//            System.out.println( record.get( "title" ).asString() + " " + record.get( "name" ).asString() );
//        }
//
//        session.close();
//        driver.close();
//    }
//
//    private static void testJDBC(){
//        try{
//            Connection con = DriverManager.getConnection("jdbc:com.roobo.demo.neo4j:bolt://172.16.101.19", "com/roobo/demo/neo4j", "p@ssw0rd");
//            // Querying
//            String query = "MATCH (p:Person) WHERE p.name ='Arthur' RETURN p.name, p.title";
//            java.sql.Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                System.out.println("Friend: "+rs.getString("p.name")+" is "+rs.getString("p.title"));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//
//    public static void main(String[] args) {
//        //testGraphDriver();
//        testJDBC();
//    }
//}
