package X;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class Invoice {
    String readInvoice()
    {
        StringBuilder output;
        try
        {
            Connection con = Database.connect();
            if (con == null)
            {return "Error while connecting to the database for reading."; }
            // Prepare the html table to be displayed
            output = new StringBuilder("<table border=\"1\">"
                    + "<tr>"
                    + "<th>patient name</th>"
                    + "<th>Specialist Name</th>"
                    + "<th>Hospital Name</th>"
                    + "<th>Doctor Name</th>"
                    + "<th>Update</th>"
                    + "<th>Remove</th>"
                    + "</tr>");



            String query = "select * from invoice";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // iterate through the rows in the result set
            while (rs.next())
            {
                String ID = Integer.toString(rs.getInt("ID"));
                String inv_no = rs.getString("inv_no");
                String pro_code = rs.getString("pro_code");
                String pro_des = rs.getString("pro_des");
                String price = rs.getString("price");
                String qty = rs.getString("qty");
                String subtot = rs.getString("subtot");
                // Add into the html table


                output.append("<td>").append(ID).append("</td>");
                output.append("<td>").append(inv_no).append("</td>");
                output.append("<td>").append(pro_code).append("</td>");
                output.append("<td>").append(pro_des).append("</td>");
                output.append("<td>").append(price).append("</td>");
                output.append("<td>").append(qty).append("</td>");
                output.append("<td>").append(subtot).append("</td>");
                // buttons
                output.append("<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>" + "<td><form method=\"post\" action=\"appointment.jsp\">" + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">" + "<input name=\"AppointmentID\" type=\"hidden\" value=\"").append(ID).append("\">").append("</form></td></tr>");
            }
            con.close();
            // Complete the html table
            output.append("</table>");
        }
        catch (Exception e)
        {
            output = new StringBuilder("Error while reading the appointments.");
            System.err.println(e.getMessage());
        }
        return output.toString();
    }

    String AddInvoice(String ID, String inv_no, String pro_code, String pro_des,String price,String qty,String subtot)
    {
        String output;
        try
        {

            Connection con = Database.connect();
            if (con == null)
            {return "Error while connecting to the database for inserting."; }
            // create a prepared statement
            String query = " insert into invoice(ID,inv_no,pro_code,pro_des,price,qty,subtot)"
                    + " values (?, ?, ?, ?, ?, ? ,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, ID);
            preparedStmt.setString(2, inv_no);
            preparedStmt.setString(3, pro_code);
            preparedStmt.setString(4, pro_des);
            preparedStmt.setString(5, price);
            preparedStmt.setString(5, qty);
            preparedStmt.setString(5, subtot);
            preparedStmt.execute();
            con.close();
            output = "Inserted successfully";
        }
        catch (Exception e)
        {
            output = "Error while inserting the item.";
            System.err.println(e.getMessage());
        }
        return output;
    }

    String updateInvoice(String ID, String inv_no, String pro_code, String pro_des, String price, String qty, String subtot)
    {
        String output;
        try
        {
            Connection con = Database.connect();
            if (con == null)
            {return "Error while connecting to the database for updating."; }
            // create a prepared statement
            String query = "UPDATE invoice SET inv_no=?,pro_code=?,pro_des=?,price=?,qty=?,subtot=? WHERE ID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setString(1, inv_no);
            preparedStmt.setString(2, pro_code);
            preparedStmt.setString(3, pro_des);
            preparedStmt.setString(4, price);
            preparedStmt.setString(5, qty);
            preparedStmt.setString(5, ID);
            // execute the statement
            preparedStmt.execute();
            con.close();
            output = "Updated successfully";
        }
        catch (Exception e)
        {
            output = "Error while updating the item.";
            System.err.println(e.getMessage());
        }
        return output;
    }

    public String deleteInvoice(String AppointmentID)
    {
        String output;
        try
        {
            Connection con = Database.connect();
            if (con == null)
            {return "Error while connecting to the database for deleting."; }
            // create a prepared statement
            String query = "delete from invoice where ID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            // binding values
            preparedStmt.setInt(1, Integer.parseInt(AppointmentID));
            // execute the statement
            preparedStmt.execute();
            con.close();
            output = "Deleted successfully";
        }
        catch (Exception e)
        {
            output = "Error while deleting the item.";
            System.err.println(e.getMessage());
        }
        return output;
    }
}
