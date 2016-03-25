package com.realdolmen.course.controller;

/**
 * Created by heleneshaikh on 25/03/16.
 */


import com.realdolmen.course.domain.Adress;
import com.realdolmen.course.domain.Customer;
import com.realdolmen.course.domain.CustomerOrder;
import com.realdolmen.course.repository.CustomerManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CustomerOrderManagerClient", urlPatterns = {"/CustomerOrderManagerClient"})
public class CustomerOrderManagerClient extends HttpServlet {
    private static Set _printedObjSet = new HashSet();
    @EJB
    CustomerManager customerOrderManager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerOrderManagerClient</title>");
            out.println("</head>");
            out.println("<body>");
            outH1(out, "Servlet CustomerOrderManagerClient at " + request.getContextPath());


            Adress addr = createAddress();
            Customer cust = createCustomer(addr);
            createCustomerOrder(cust);
            createCustomerOrder(cust);
            customerOrderManager.persistEntity(cust);

            //  Display the new Customer, along with referenced objects
            printData(out);

            outH3(out, "</body>");
            outH3(out, "</html>");
        } finally {
            out.close();
        }
    }

    private static void printCustomer(PrintWriter out, Customer customer) {
        if (!_printedObjSet.add(customer)) {
            out.println("[Customer " + customer.getId() + " already printed]");
            return;
        }

        out.println("<table border=\"1\">");
        out.println("<caption><b>" + customer.getClass().getSimpleName() + "</b></>");
        printAttribute(out, "id", customer.getId());
        printAttribute(out, "version", customer.getVersion());
        printAttribute(out, "email", customer.getEmail());
        printAttribute(out, "customerOrders", customer.getCustomerOrders());
        printAttribute(out, "billingAddress", customer.getBillingAdress());
        printAttribute(out, "shippingAddress", customer.getShippingAdress());
        out.println("</table>");
    }

    private static void printAddress(PrintWriter out, Adress address) {
        if (!_printedObjSet.add(address)) {
            out.println("[Address " + address.getId() + " already printed]");
            return;
        }

        out.println("<table border=\"1\">");
        out.println("<caption><b>" + address.getClass().getSimpleName() + "</b></>");
        printAttribute(out, "id", address.getId());
        printAttribute(out, "version", address.getVersion());
        printAttribute(out, "city", address.getCity());
        printAttribute(out, "state", address.getState());
        printAttribute(out, "street1", address.getStreet1());
        printAttribute(out, "street2", address.getStreet2());
        printAttribute(out, "version", address.getVersion());
        printAttribute(out, "zipCode", address.getZipCode());
        out.println("</table>");
    }

    private static void printCustomerOrder(PrintWriter out, CustomerOrder customerOrder) {
        if (!_printedObjSet.add(customerOrder)) {
            out.println("[CustomerOrder " + customerOrder.getId() + " already printed]");
            return;
        }

        out.println("<table border=\"1\">");
        out.println("<caption><b>" + customerOrder.getClass().getSimpleName() + "</b></>");
        printAttribute(out, "id", customerOrder.getId());
        printAttribute(out, "version", customerOrder.getVersion());
        printAttribute(out, "creationDate", customerOrder.getCreationDate());
        printAttribute(out, "status", customerOrder.getStatus());
        printAttribute(out, "customer", customerOrder.getCustomer());
        out.println("</table>");
    }

    private static void outH1(PrintWriter out, String text) {
        out.println("<h1>" + text + "</h1>");
    }

    private static void outH3(PrintWriter out, String text) {
        out.println("<h3>" + text + "</h3>");
    }

    private static void outH4(PrintWriter out, String text) {
        out.println("<h4>" + text + "</h4>");
    }

    private void cleanTables(PrintWriter out) {
        for (Customer c : customerOrderManager.getCustomerFindAll()) {
            outH4(out, "Deleting customer (and referenced objects) " + c.getId());
            customerOrderManager.removeCustomer(c);
        }
        for (Adress a : customerOrderManager.getAdressFindAll()) {
            outH4(out, "Deleting address " + a.getId());
            customerOrderManager.removeAdress(a);
        }
        for (CustomerOrder cuo : customerOrderManager.getCustomerOrderFindAll()) {
            outH4(out, "Deleting customer order " + cuo.getId());
            customerOrderManager.removeCustomerOrder(cuo);
        }
    }

    private Adress createAddress() {
        final Adress address = new Adress();
        address.setCity("Redwood Shores");
        address.setState("CA");
        address.setStreet1("200 Oracle Pkwy");
        address.setStreet2("MS212659");
        address.setZipCode(94065);
        return address;
    }

    private Customer createCustomer(Adress address) {
        Customer cust = new Customer();
        cust.setEmail("wineapp-info@apress.com");
        cust.setBillingAdress(address);
        cust.setShippingAdress(address);
        return cust;
    }

    private CustomerOrder createCustomerOrder(Customer cust) {
        CustomerOrder co = new CustomerOrder();
        co.setCreationDate(new Timestamp(System.currentTimeMillis()));
        co.setStatus("Pending");
        if (cust != null) {
            cust.addCustomerOrder(co);
        }
        return co;
    }

    private void printData(PrintWriter out) {
        for (Customer customer : (List<Customer>) customerOrderManager.getCustomerFindAll()) {
            printCustomer(out, customer);
        }
    }

    private static void printAttribute(PrintWriter out, String attr, Object val) {
        out.println("<tr>");
        out.println("<td>" + attr + "</td>");
        out.println("<td>");
        if (val instanceof Adress) {
            printAddress(out, (Adress) val);
        } else if (val instanceof Customer) {
            printCustomer(out, (Customer) val);
        } else if (val instanceof CustomerOrder) {
            printCustomerOrder(out, (CustomerOrder) val);
        } else if (val instanceof List) {
            for (Object obj : (List) val) {
                if (obj instanceof Adress) {
                    printAddress(out, (Adress) obj);
                } else if (obj instanceof Customer) {
                    printCustomer(out, (Customer) obj);
                } else if (obj instanceof CustomerOrder) {
                    printCustomerOrder(out, (CustomerOrder) obj);
                } else {
                    out.print(obj);
                }
            }
        } else {
            out.print(val);
        }
        out.println("</td>");
        out.println("</tr>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
