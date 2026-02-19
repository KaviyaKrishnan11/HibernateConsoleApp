package com.kce.main;
import com.kce.entity.Citizen;
import com.kce.entity.Facility;
import com.kce.service.ParkService;

public class MainApp {
    private static ParkService service = new ParkService();
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("--- Municipal Public Park Facility Booking Console ---");

        try {
            Facility f = new Facility();
            f.setFacilityID("FC21");
            f.setFacilityName("Skating Rink A");
            f.setFacilityType("COURT");
            f.setOperatingHours("06:00-20:00");
            f.setLocationDescription("Skyline Park – West Block");
            f.setStatus("ACTIVE");

            boolean ok = service.registerFacility(f);
            System.out.println(ok ? "FACILITY REGISTERED": "FACILITY REGISTRATION FAILED");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Citizen c = new Citizen();
            c.setCitizenID("CT2121");
            c.setFullName("Meenakshi");
            c.setMobile("9998887771");
            c.setEmail("meenakshi@example.com");
            c.setCity("Chennai");
            c.setStatus("ACTIVE");

            boolean ok = service.registerCitizen(c);
            System.out.println(ok ? "CITIZEN REGISTERED": "CITIZEN REGISTRATION FAILED");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            java.sql.Date d =
                    new java.sql.Date(System.currentTimeMillis());
            boolean ok = service.bookFacility("FC21","CT2121",d,"10:00-11:00");

            System.out.println(ok ? "BOOKING CREATED": "BOOKING FAILED");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
