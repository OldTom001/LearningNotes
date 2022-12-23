package com.jeff;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson2.JSON;
import com.jeff.dao.BookDao;
import com.jeff.domain.Book;
import org.apache.http.HttpHost;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest; //有重名包, 不要导错
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchClients;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;

import java.io.IOException;
import java.util.List;


@SpringBootTest
class SpringBoot18EsApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    RestHighLevelClient client;

    @Test
    void testBookDao(){
        Book book = bookDao.selectById(1);
    }

/*    @Test
    void testCreateClient() throws IOException {
        HttpHost host = HttpHost.create("http://localhost:9200");
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);

        client.close();
    }*/

    @Test
    //创建索引, 不带body
    void testCreateIndex() throws IOException {
         CreateIndexRequest request = new CreateIndexRequest("books");
         client.indices().create(request, RequestOptions.DEFAULT);
     }

    @Test
    //创建索引, 带body
    void testCreateIndexByIK() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        String json = "{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //设置请求中的参数
        request.source(json, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }
    @Test
    //添加文档
    void testCreateDoc() throws IOException {
        Book book = bookDao.selectById(2);
        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        String json = JSON.toJSONString(book);
        request.source(json,XContentType.JSON);
        client.index(request,RequestOptions.DEFAULT);
    }

    @Test
//批量添加文档
    void testCreateDocAll() throws IOException {
        List<Book> bookList = bookDao.selectList(null);
        BulkRequest bulk = new BulkRequest();
        for (Book book : bookList) {
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json,XContentType.JSON);
            bulk.add(request);
        }
        client.bulk(bulk,RequestOptions.DEFAULT);
    }

    @Test
//按id查询
    void testGet() throws IOException {
        GetRequest request = new GetRequest("books","1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        System.out.println(json);
    }

    @Test
//按条件查询
    void testSearch() throws IOException {
        SearchRequest request = new SearchRequest("books");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("all","spring"));
        request.source(builder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits(); //hit: 命中
        for (SearchHit hit : hits) {
            String source = hit.getSourceAsString();
            //System.out.println(source);
            Book book = JSON.parseObject(source, Book.class);
            System.out.println(book);
        }
    }

}
