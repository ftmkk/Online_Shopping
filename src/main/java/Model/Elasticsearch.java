package Model;

import Model.ProductModel.Product;
import com.google.gson.Gson;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.node.Node;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

public class Elasticsearch {

    public static Client getClient(){
        Node node = nodeBuilder()
                .settings(Settings.builder()
                        .put("path.home", "/usr/share/elasticsearch/bin"))
                .clusterName("shopping").client(true).node();
        Client client = node.client();
        return client;
    }

    public static void add(Product product){
        Client client = getClient();

        //Gson gson = new Gson();
        //String jsonObj = gson.toJson(obj);

        XContentBuilder builder = null;
        try {
            builder = jsonBuilder()
                    .startObject()
                    .field("name", "kimchy")
                    .field("postDate",10000)
                    .field("message", "trying out Elasticsearch")
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        client
                .prepareIndex()
                .setIndex("onlineshopping")
                .setType("product")
                .setSource(builder).get();
    }



}
