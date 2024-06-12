package RentalSystem.CarRentalSystem;


import entity.*;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class App {
    public static void main(String[] args) 
    {
        // Create some sample data
        City city = new City();
        city.setName("New York");

        Employee employee = new Employee();
        employee.setName("Mayuri Gund");
        employee.setSalary(50000.0);
        employee.setCity(city);

        Customer customer = new Customer();
        customer.setName("Sakshi Pachpute");
        customer.setPhone("123-456-7890");
        customer.setEmail("sakshipachpute@gmail.com");
        customer.setCity(city);

        Car car = new Car();
        car.setModel("BMW");
        car.setDailyPrice(50.0);

        Reservation reservation = new Reservation();
        reservation.setReserveDate(new Date());
        reservation.setDays(5);
        reservation.setCustomer(customer);
        reservation.setCar(car);

        Place place = new Place();
        place.setAvailability(true);
        place.setCity(city);

        // Get a session and perform operations
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Save the entities
        session.save(city);
        session.save(employee);
        session.save(customer);
        session.save(car);
        session.save(reservation);
        session.save(place);

        transaction.commit();

        // Fetch and display entities
        City fetchedCity = session.get(City.class, city.getId());
        System.out.println("Fetched City: " + fetchedCity.getName());

        Employee fetchedEmployee = session.get(Employee.class, employee.getId());
        System.out.println("Fetched Employee: " + fetchedEmployee.getName() + ", " + fetchedEmployee.getSalary());

        Customer fetchedCustomer = session.get(Customer.class, customer.getId());
        System.out.println("Fetched Customer: " + fetchedCustomer.getName() + ", " + fetchedCustomer.getEmail());

        Car fetchedCar = session.get(Car.class, car.getId());
        System.out.println("Fetched Car: " + fetchedCar.getModel() + ", " + fetchedCar.getDailyPrice());

        Reservation fetchedReservation = session.get(Reservation.class, reservation.getId());
        System.out.println("Fetched Reservation: " + fetchedReservation.getReserveDate() + ", " + fetchedReservation.getDays());

        Place fetchedPlace = session.get(Place.class, place.getId());
        System.out.println("Fetched Place: " + fetchedPlace.getAvailability());

        // Update entities
        transaction = session.beginTransaction();
        fetchedCity.setName("Los Angeles");
        session.update(fetchedCity);
        transaction.commit();

        // Fetch and display updated entities
        fetchedCity = session.get(City.class, fetchedCity.getId());
        System.out.println("Updated City: " + fetchedCity.getName());

        // Delete entities
        transaction = session.beginTransaction();
        session.delete(fetchedEmployee);
        session.delete(fetchedCustomer);
        session.delete(fetchedCar);
        session.delete(fetchedReservation);
        session.delete(fetchedPlace);
        session.delete(fetchedCity);
        transaction.commit();

        session.close();
        HibernateUtil.shutdown();
    }

        		
 }       		
        		
        		
        		
        		
