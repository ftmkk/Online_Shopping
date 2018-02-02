package Model.DatabaseOperations;

import Model.Entities.ProductInfo.*;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.AbstractQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.client.RestClient;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.google.gson.Gson;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class Elasticsearch {

    public static Logger logger = Logger.getLogger(String.valueOf(Elasticsearch.class));
    private static SearchSourceBuilder sourceBuilder;
    private RestClient client;
    private static Gson gson;

    public static void main(String[] args) throws UnknownHostException {

        List<Attribute> attrL1 = new ArrayList<>();
        AttributeGroup attrG = new AttributeGroup("CATEGORY_1","kategory");
        attrL1.add(new Attribute("wight","2.3 kg",attrG));
        List<Color> colors1 = new ArrayList<>();
        colors1.add(new Color("White","sefid", 0,0,0));

/*        Product p1 = new Product(
                "p1",
                "P1",
                50000000L,
                ProductStatus.AVAILABLE,
                233,
                "THis is product p1!",
                2234,
                923,
                null,
                "THis is review of product p1!",
                new Brand("Samsung","SAMSUNG"),
                attrL1,
                colors1,
                new Guaranty("12 months MICROTELL"),
                3000L);*/

        Client client = getClient();
        //client.prepareDelete("onlineshopping","product","AWDHvwg_W2MtLdBt5RiP").execute().actionGet();
        //deleteDocument("AWDav5uTv0ci70SiEVmd");
        //add(p1);
        List<Product> products = matchAllQuery();
        System.out.println(products.size());
    }


    public static Client getClient() throws UnknownHostException {

        Settings settings = Settings.builder()
                .put("cluster.name", "my-application").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

/*        Client client = TransportClient.builder().build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));*/

        return client;
    }

    public static void add(Product product) throws UnknownHostException {
        Client client = getClient();

        //Gson gson = new Gson();
        //String jsonObj = gson.toJson(obj);

        XContentBuilder builder = null;
        try {
            builder = jsonBuilder()
                    .startObject()
                    .field("name", product.getName())
                    .field("persian_name",product.getPersianName())
                    .field("price", product.getPrice())
                    .field("status" , product.getStatus())
                    .field("remainingCount",product.getRemainingCount())
                    .field("briefDescription",product.getBriefDescription())
                    .field("visitCount",product.getVisitCount())
                    .field("sellCount",product.getSellCount())
                    .field("releaseDate",product.getReleaseDate())
                    .field("review",product.getReview())
                    .startObject("Brand").field("name",product.getBrand().getName()).field("persian_name",product.getBrand().getPersianName()).endObject()
                    .startObject("attributes").field("value",product.getAttributes().get(0).getValue()).field("Title",product.getAttributes().get(0).getTitle()).endObject()
                    .startObject("colors").field("name",product.getColors().get(0).getName()).field("perian_name",product.getColors().get(0).getPersianName()).field("Color_R",product.getColors().get(0).getR()).field("Color_G",product.getColors().get(0).getG()).field("Color_B",product.getColors().get(0).getB()).endObject()
                    .startObject("guaranty").field("name",product.getGuaranty().getId()).field("name",product.getGuaranty().getName()).endObject()
                    .field("discount",product.getDiscount())
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.prepareIndex()
                .setIndex("onlineshopping")
                .setType("product")
                .setSource(builder).execute().actionGet();
    }


    public static List<Product> matchAllQuery(){

        List<Product> result = new ArrayList<>();

        try {
            result = getDocuments(QueryBuilders.matchAllQuery());
        } catch (Exception ex){
            logger.info("The exception was thrown in matchAllQuery method." + ex);
        }

        return result;
    }

    private static List<Product> getDocuments(AbstractQueryBuilder builder) throws IOException {
        List<Product> result = new ArrayList<>();
        Client client = getClient();
        sourceBuilder.query(builder);
        SearchRequest searchRequest = getSearchRequest();

        SearchResponse searchResponse = client.search(searchRequest).actionGet();
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            Product doc = gson.fromJson(hit.getSourceAsString(), Product.class);
            doc.setId(Integer.valueOf(hit.getId()));
            result.add(doc);
        }

        return result;
    }

    private static SearchRequest getSearchRequest(){
        SearchRequest searchRequest = new SearchRequest("onlineshopping");
        searchRequest.source(sourceBuilder);
        return searchRequest;
    }

    public static void deleteDocument(String id) throws UnknownHostException {
        Client client = getClient();
        try {
            DeleteRequest deleteRequest = new DeleteRequest("onlineshopping", "product", id);
            client.delete(deleteRequest);
        } catch (Exception ex){
            logger.info("The exception was thrown in deleteDocument method." + ex);
        }
    }

    public List<Product> wildcardQuery(String query){

        List<Product> result = new ArrayList<>();

        try {
            result = getDocuments(QueryBuilders.wildcardQuery("_all", "*" + query.toLowerCase() + "*"));
        } catch (Exception ex){
            logger.info("The exception was thrown in wildcardQuery method." + ex);
        }

        return result;
    }

}