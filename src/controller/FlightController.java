package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Flight;
import services.FareCalculator;



@WebServlet("/flight")
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FlightController() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numberOfPersons=Integer.parseInt(request.getParameter("persons"));
		String classtype=request.getParameter("class");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String triptype=request.getParameter("trip");

		int rates;
		if(classtype.equals("executive")){
			rates=7500;
		}
		else {
			rates=5000;
		}
		LocalDate start=LocalDate.parse(from);		
		LocalDate end=LocalDate.parse(to);

		Flight flight=new Flight(numberOfPersons,classtype,rates,start,end,triptype);
		flight.setNoOfPersons(numberOfPersons);
		flight.setRates(rates);
		flight.setClassType(classtype);
		flight.setFrom(start);
		flight.setTo(end);

		FareCalculator fare=new FareCalculator();

		double rate=fare.book(flight);
		request.setAttribute("flight", flight);
		request.setAttribute("flightfare", rate);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/flightView.jsp");
		dispatcher.forward(request, response);
	}

}
