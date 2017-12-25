package Controller.Search.TfIdf;

import Model.ProductModel.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macintosh on 12/23/17.
 */


public class DocumentParser {


    private HashMap<Product , String[] > termsDocsArray = new HashMap<>();
    private List<String> allTerms = new ArrayList<String>(); //to hold all terms
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>();


    public void parseFiles(List<Product> products ,String query) throws IOException
    {
        for (Product f : products)
        {
            String[] tokenizedTerms = f.getName().split(" ");   //to get individual terms
            termsDocsArray.put(f,tokenizedTerms);
        }

        String[] tokens = query.split(" ");
        for(String tok : tokens){
            allTerms.add(tok);
        }

    }

    /**
     * Method to create termVector according to its tfidf score.
     */
    public HashMap<Product , Double> tfIdfCalculator()
    {
        HashMap<Product ,Double> result = new HashMap<>();
        double tf; //term frequency
        double idf; //inverse document frequency
        double tfidf; //term frequency inverse document frequency
        for ( Map.Entry<Product, String[]> entry : termsDocsArray.entrySet())
        {
            double[] tfidfvectors = new double[allTerms.size()];
            int count = 0;
            for (String terms : allTerms)
            {
                tf = new TfIdf().tfCalculator(entry.getValue(), terms);
                idf = new TfIdf().idfCalculator((List<String[]>) termsDocsArray.values(), terms);
                tfidf = tf * idf;
                tfidfvectors[count] = tfidf;
                result.put(entry.getKey() , tfidf);
                count++;
            }
            tfidfDocsVector.add(tfidfvectors);  //storing document vectors;
        }
        return result;
    }

    // Method to calculate cosine similarity between all the documents.

    public void getCosineSimilarity()
    {
        for (int i = 0; i < tfidfDocsVector.size(); i++)
        {
            for (int j = 0; j < tfidfDocsVector.size(); j++)
            {
                if(i!=j)
                    System.out.println("between " + i + " and " + j + "  =  "+ new CosineSimilarity().cosineSimilarity (tfidfDocsVector.get(i),  tfidfDocsVector.get(j)));
            }
        }
    }
}
