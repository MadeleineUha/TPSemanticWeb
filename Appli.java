import org.apache.jena.rdf.model.*;
import org.apache.jena.util.*;
import org.apache.jena.query.*;
import java.io.*;

public class Appli {

	public static void main(String[] args) {
		Model model = ModelFactory.createDefaultModel();
		model.read("C:\\Users\\user\\Dropbox\\Mon PC (LAPTOP-V112BDMS)\\Documents\\Ensisa\\Web Semantic\\modele.ttl");
		String str = "prefix : <http://www.job.com#/>\n"+"select * where { ?a rdf:type "+args[0]+" .}\n";
		Query query = QueryFactory.create(str);
		QueryExecution result = QueryExecutionFactory.create(query,model);
		ResultSet iterator = result.execSelect();
		while (iterator.hasNext())            {
			QuerySolution solution = iterator.nextSolution();
			System.out.println(solution.get("?a").toString() + " " +solution.get("?b").toString() + " " +solution.get("?c"));
		}
	}}
