import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SmartTransportSystem extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String source = request.getParameter("source");
        String destination = request.getParameter("destination");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM buses WHERE source=? AND destination=?");
            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            out.println("<html><body><h2>Available Buses</h2>");
            boolean found = false;

            while (rs.next()) {
                found = true;
                out.println("<p><b>Bus Name:</b> " + rs.getString("bus_name")
                        + "<br><b>Departure:</b> " + rs.getString("departure_time")
                        + "<br><b>Arrival:</b> " + rs.getString("arrival_time")
                        + "<br><b>Price:</b> ₹" + rs.getDouble("price") + "</p><hr>");
            }

            if (!found) {
                out.println("<p>No buses found for this route!</p>");
            }

            out.println("</body></html>");
            con.close();

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
