package X;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;



@Path("/")
public class Service {

    
    ///invoice

    @GET
    @Path("/invoice/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String readInvoice(Invoice invoice)
    {
        return invoice.readInvoice();
    }
    
    @POST
    @Path("/invoice/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertInvoice(
            @FormParam("ID") String ID,
            @FormParam("Inv_no") String inv_no,
            @FormParam("Pro_code") String Pro_code,
            @FormParam("Pro_des") String Pro_des,
            @FormParam("Price") String Price,
            @FormParam("qty") String qty,
            @FormParam("subtot") String subtot,Invoice invoice)
    {
        return invoice.AddInvoice(ID,inv_no,Pro_code,Pro_des,Price,qty,subtot);
    }


    @PUT
    @Path("/invoice/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateInvoice(String itemData,Invoice invoice)
    {
        //Convert the input string to a JSON object
        JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
        //Read the values from the JSON object
        String ID = itemObject.get("AppointmentID").getAsString();
        String inv_no = itemObject.get("inv_no").getAsString();
        String pro_code = itemObject.get("pro_code").getAsString();
        String pro_des = itemObject.get("i,pro_des").getAsString();
        String price = itemObject.get("price").getAsString();
        String qty = itemObject.get("qty").getAsString();
        String subtot = itemObject.get("subtot").getAsString();
        return invoice.updateInvoice(ID, inv_no,pro_code,pro_des,price,qty,subtot);
    }

    @DELETE
    @Path("/invoice/delete")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteInvoice(String itemData, Invoice invoice)
    {
        //Convert the input string to an XML document
        Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());
        //Read the value from the element <itemID>
        String ID= doc.select(" ID").text();
        return invoice.deleteInvoice( ID);
    }

    ///Products

    @GET
    @Path("/Products/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String readProducts(Products products)
    {
        return products.readProducts();
    }
    
    @POST
    @Path("/Products/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertProducts(
            @FormParam("ID") String ID,
            @FormParam("Inv_no") String inv_no,
            @FormParam("Pro_code") String Pro_code,
            @FormParam("Pro_des") String Pro_des,
            @FormParam("Price") String Price,
            @FormParam("qty") String qty,
            @FormParam("subtot") String subtot,Products products)
    {
        return products.AddProducts(ID,inv_no,Pro_code,Pro_des,Price,qty,subtot);
    }


    @PUT
    @Path("/Products/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateProducts(String itemData,Products products)
    {
        //Convert the input string to a JSON object
        JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
        //Read the values from the JSON object
        String ID = itemObject.get("AppointmentID").getAsString();
        String inv_no = itemObject.get("inv_no").getAsString();
        String pro_code = itemObject.get("pro_code").getAsString();
        String pro_des = itemObject.get("i,pro_des").getAsString();
        String price = itemObject.get("price").getAsString();
        String qty = itemObject.get("qty").getAsString();
        String subtot = itemObject.get("subtot").getAsString();
        return products.updateProducts(ID, inv_no,pro_code,pro_des,price,qty,subtot);
    }

    @DELETE
    @Path("/Products/delete")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteProducts(String itemData, Products products)
    {
        //Convert the input string to an XML document
        Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());
        //Read the value from the element <itemID>
        String ID= doc.select(" ID").text();
        return products.deleteProducts( ID);
    }

    ///Register

    @GET
    @Path("/Register/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String readRegister(Register register)
    {
        return register.readRegister();
    }

    @POST
    @Path("/Register/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertRegister(
            @FormParam("ID") String ID,
            @FormParam("Inv_no") String inv_no,
            @FormParam("Pro_code") String Pro_code,
            @FormParam("Pro_des") String Pro_des,
            @FormParam("Price") String Price,
            @FormParam("qty") String qty,
            @FormParam("subtot") String subtot,Register register)
    {
        return register.AddRegister(ID,inv_no,Pro_code,Pro_des,Price,qty,subtot);
    }


    @PUT
    @Path("/Register/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateRegister(String itemData,Register register)
    {
        //Convert the input string to a JSON object
        JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
        //Read the values from the JSON object
        String ID = itemObject.get("AppointmentID").getAsString();
        String inv_no = itemObject.get("inv_no").getAsString();
        String pro_code = itemObject.get("pro_code").getAsString();
        String pro_des = itemObject.get("i,pro_des").getAsString();
        String price = itemObject.get("price").getAsString();
        String qty = itemObject.get("qty").getAsString();
        String subtot = itemObject.get("subtot").getAsString();
        return register.updateRegister(ID, inv_no,pro_code,pro_des,price,qty,subtot);
    }

    @DELETE
    @Path("/Products/delete")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteRegister(String itemData, Register register)
    {
        //Convert the input string to an XML document
        Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());
        //Read the value from the element <itemID>
        String ID= doc.select(" ID").text();
        return register.deleteRegister( ID);
    }
}

