package Hello_World;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import java.util.ArrayList; 
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/Service")

 
public class Hello_World {

@GET
@Path("/sample")
@Produces(MediaType.TEXT_PLAIN)
public String sample() {
 return "Hello World" ;
}



@POST
@Path("/prodlist")
@Produces("application/json") 
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

public List<Product> updateProduct(@FormParam("prodid") String prodid,@FormParam("name") String name,
		@FormParam("price") String price) {
	List<Product> al=new ArrayList<Product>();
    Product p1=new Product("p1","Shirt","1200");
    Product p2=new Product("p2","Pant","1500");
    Product p3=new Product("p3","Shoe","2200");
    Product p4 = new Product(prodid,name,price);
    
    al.add(p1);
    al.add(p2);
    al.add(p3);
    al.add(p4);
    
    return al;   
}


@GET
@Path("/prodlist/{prodid}")
@Produces(MediaType.APPLICATION_JSON)
public Product getproductbyparam (@PathParam("prodid") String prodid) {
    List<Product> al=new ArrayList<Product>();
    Product p1=new Product("p1","Shirt1","1200");
    Product p2=new Product("p2","Shirt2","1400");
    Product p3=new Product("p3","Shirt3","1600");
    al.add(p1);
    al.add(p2);
    al.add(p3);
     
    for (int cnt=0;cnt<3;cnt++)
    {
    	if (al.get(cnt).getProdid().equals(prodid))
    		return al.get(cnt);
    }
    
    return null;
    
}

@GET
@Path("/prodlist")
@Produces(MediaType.APPLICATION_JSON)
public Product getproductbyqueryparam (@QueryParam("prodid") String prodid) {
    List<Product> al=new ArrayList<Product>();
    Product p1=new Product("p1","Shirt1","1200");
    Product p2=new Product("p2","Shirt2","1400");
    Product p3=new Product("p3","Shirt3","1600");
    al.add(p1);
    al.add(p2);
    al.add(p3);
     
    for (int cnt=0;cnt<3;cnt++)
    {
    	if (al.get(cnt).getProdid().equals(prodid))
    		return al.get(cnt);
    }
    
    return null;
    
}


@PUT
@Path("/prodlist")
@Produces("application/xml") 
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

public List<Product> updateProduct(@FormParam("prodid") String  prodid,
        @FormParam("price") String price){
{
	List<Product> al=new ArrayList<Product>();
    Product p1=new Product("p1","Shirt","1200");
    Product p2=new Product("p2","Pant","1500");
    Product p3=new Product("p3","Shoe","2200");
   
    al.add(p1);
    al.add(p2);
    al.add(p3);
    for (int cnt=0;cnt<3;cnt++)
    {
    	if (al.get(cnt).getProdid().equals(prodid))
    		al.get(cnt).setPrice(price);
    	    return al;
    }
    return null;   
}
}

@DELETE
@Path("/prodlist/{prodid}")
@Produces("application/json") 
 
public List<Product> deleteProduct(@PathParam("prodid") String  prodid) {
{
	List<Product> al=new ArrayList<Product>();
    Product p1=new Product("p1","Shirt","1200");
    Product p2=new Product("p2","Pant","1500");
    Product p3=new Product("p3","Shoe","2200");
   
    al.add(p1);
    al.add(p2);
    al.add(p3);
    for (int cnt=2;cnt>=0;cnt--)
    {
    	if (al.get(cnt).getProdid().equals(prodid))
    		al.remove(cnt);
    	    
    }
    return al;   
}
}


}