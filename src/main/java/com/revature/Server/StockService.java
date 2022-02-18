package com.revature.Server;

import com.revature.yahoo.stock.api.StockCommands;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StockService extends HttpServlet {
    private final FileRepository fileRepository;

    public StockService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //language=HTML
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "    <Title>Stock History" +
                "</Title>\n" +
                "</Head>\n" +
                "<Body>\n" +
                "<h1>Welcome to Stock History App</h1>\n" +
                "<p>This app will allow to see the price of a stock</p>\n" +
                "<p>Input the stock ticker. Ex: IBM, AAPL, or VOO</p>\n" +
                "<p>Date for as yyyy-mm-dd</p>\n" +
                "<form action='' method='get'>\n" +
                "    <div class=\"form-example\">\n" +
                "        <label for=\"ticker\">Stock Ticker: </label>\n" +
                "        <input type=\"text\" name=\"ticker\" id=\"ticker\" required>\n" +
                "    </div>\n" +
                "    <div class=\"form-example\">\n" +
                "        <label for=\"startDate\">Start Date: </label>\n" +
                "        <input type=\"text\" name=\"startDate\" id=\"startDate\" required>\n" +
                "    </div>\n" +
                "    <div class=\"form-example\">\n" +
                "        <label for=\"endDate\">Start Date: </label>\n" +
                "        <input type=\"text\" name=\"endDate\" id=\"endDate\" required>\n" +
                "    </div" +
                ">\n" +
                "    <div class=\"form-example\">\n" +
                "        <label for=\"interval\">Interval (You can type: yearly, monthly, or daily): </label>\n" +
                "        <input type=\"text\" name=\"interval\" id=\"interval\" required>\n" +
                "    </div>\n" +
                "    <input type=\"submit\" value=\"StockInput\"/>\n" +
                "</form>\n" +
                "</Body>\n" +
                "</Html>";
        resp.getWriter().println(HTMLForm);
        String ticker = req.getParameter("ticker");
        System.out.println("Ticker: " + ticker);
        String startDate = req.getParameter("startDate");
        System.out.println("Start: " + ticker);
        String endDate = req.getParameter("endDate");
        System.out.println("End: " + ticker);
        String interval = req.getParameter("interval");
        System.out.println("Interval: " + ticker);
        commandsObj(ticker, startDate, endDate, interval);
    }

    public StockCommands commandsObj(String ticker, String startDate, String endDate, String interval) {
        return new StockCommands(ticker, startDate, endDate, interval);
    }
}
