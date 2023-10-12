package org.example;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.List;
public class Connect {
    private static final String url = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    public Connect() {
        restTemplate = new RestTemplate();
        httpHeaders = new HttpHeaders();
        String headerStr = restTemplate.headForHeaders(url, String.class).get("Set-cookie").get(0);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Cookie", headerStr);
        System.out.println(httpHeaders);
    }
    public List getUsers() {
        HttpEntity<String> entity = new HttpEntity<>("", httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, entity, List.class).getBody();
    }

    public String save(User user) {
        HttpEntity<User> entity = new HttpEntity<>(user, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }

    public String patch(User user) {
        HttpEntity<User> entity = new HttpEntity<>(user,httpHeaders);
        return restTemplate.exchange(url,HttpMethod.PUT,entity, String.class).getBody();
    }
    public String delete(Long id) {
        HttpEntity<String> entity = new HttpEntity<>("",httpHeaders);
        return restTemplate.exchange(url + "/" + id,HttpMethod.DELETE,entity,String.class).getBody();
    }

}
