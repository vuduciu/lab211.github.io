/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import model.Crew;
import model.Flight;
import model.FlightAttendant;
import model.GroundStaff;
import model.Passenger;
import model.Pilot;
import model.Reservation;
import model.Seat;


/**
 *
 * @author bravee06
 */
public class FlightManagementSystem {

    public List<Flight> flights;
    public Validation valid;
    public List<Reservation> reservations;
    public List<Crew> listCrews;
    public FileManage fm;
    int reservationCounter = 1;

    public FlightManagementSystem() {
        flights = new ArrayList<>();
        valid = new Validation();
        reservations = new ArrayList<>();
        listCrews = new ArrayList<>();
        fm = new FileManage();
    }

    public void addNewFlight(Crew c) {
        if(!c.getRole().equals("Admin")){
            System.out.println("Không có quyền để thêm chuyến bay !");
            return ;
        }else if(c.getRole().equals("Admin")) {
            System.out.print("Nhập số chuyến bay (Fxyzt): ");
        String flightNumber = valid.checkFlightNumber("Nhập số chuyến bay (Fxyzt):", flights);

        System.out.print("Nhập nơi khởi hành: ");
        String departureCity = valid.checkString("Nhập nơi khởi hành:");

        String destinationCity = valid.checkString("Nhập nơi đến:");

        String departureTime = valid.checkBeforeDate("Nhập thời gian khởi hành: ");

        String arrivalTime = valid.checkAfterDate("Nhập thời gian đến", departureTime);

        int totalSeats = valid.checkInt("Nhập tổng số ghế: ", 0, Integer.MAX_VALUE);
        int seatID = 1;
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < totalSeats; i++) {
            String seatNumber = "S" + (seatID++);
            Seat newSeat = new Seat(seatNumber);
            seats.add(newSeat);
        }

        // ctrl + space 
        Flight flight = new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime, seats);
        flights.add(flight);

        System.out.println("Chuyến bay đã được thêm vào hệ thống.");
        }
        
    }

    public void bookPassengerReservation() {

        System.out.println("Đặt vé máy bay và đặt chỗ cho hành khách");

        String passengerName = valid.checkString("Nhập tên hành khách:");

        String contactInfo = valid.checkString("Nhập thông tin liên hệ: ");

        // Hiển thị danh sách chuyến bay có sẵn để hành khách chọn
        System.out.println("Danh sách chuyến bay có sẵn:");
        displayFlightList();
        String flightNumber = "";
        Flight selectedFlight = new Flight();
        while (true) {
            flightNumber = valid.checkString("Nhập số hiệu chuyến bay: ");
            // Kiểm tra xem mã chuyến bay có tồn tại hay không
            selectedFlight = getFlightByFlightNumber(flightNumber, flights);
            if (selectedFlight == null) {
                System.out.println("Mã chuyến bay không hợp lệ.");
                continue;
            }
            break;
        }
        // Tạo mã đặt chỗ duy nhất
        String reservationId = "R" + reservationCounter++;
        Passenger passenger = new Passenger(passengerName, contactInfo);
        Reservation reservation = new Reservation(reservationId, selectedFlight, passenger);
        reservations.add(reservation);

        System.out.println("Đặt chỗ thành công. Mã đặt chỗ của bạn là: " + reservationId);

    }

    public void performCheckIn() {

        System.out.println("Quá trình check-in và phân bổ ghế cho hành khách");

        String reservationId = valid.checkString("Nhập mã đặt chỗ của bạn: ");

        // Tìm đặt chỗ dựa trên mã đặt chỗ
        Reservation reservation = findReservationById(reservationId);
        if (reservation == null) {
            System.out.println("Không tìm thấy đặt chỗ với mã này.");
            return;
        }

        Flight flight = reservation.getFlight();

        // Kiểm tra số lượng ghế sẵn có  trên chuyến bay và phân bổ ghế
        List<Seat> availableSeats = findAllAvailableSeat(flight);
        if (availableSeats.size() == 0) {
            System.out.println("Tất cả ghế đã được đặt. Không thể thực hiện check-in.");
            return;
        }
        // Hiển thị danh sách chuyến bay có sẵn để hành khách chọn
        System.out.println("Danh sách các ghế có sẵn trong chuyến bay:");
        displayAvaiSeatList(availableSeats);
        String seatNumber = "";
        Seat selectedSeat = new Seat();
        while (true) {
            seatNumber = valid.checkString("Nhập số ghế chuyến bay mà bạn muốn chọn: ");
            // Kiểm tra xem ghế có tôn tại hay không 
            selectedSeat = getSeatByNumber(seatNumber, availableSeats);
            if (selectedSeat == null) {
                System.out.println("Mã ghế không có.");
                continue;
            }
            break;
        }
        // Đánh dấu ghế đã được đặt
        selectedSeat.occupy();

        // Tạo thẻ lên máy bay với thông tin của hành khách và ghế
        System.out.println("Thẻ lên máy bay:");
        System.out.println("Hành khách: " + reservation.getPassenger());
        System.out.println("Chuyến bay: " + flight.getFlightNumber());
        System.out.println("Ghế số: " + selectedSeat.getSeatNumber());

        System.out.println("Check-in thành công.");
    }

    // Function 4: Crew Management and Administrator Access (50 LOC)
    public void manageCrewAssignments(Crew c) {
        if(!c.getRole().equals("Admin")){
            System.out.println("Không có quyền để thêm chuyến bay !");
            return ;
        }else if(c.getRole().equals("Admin")) {
            System.out.println("Quản lý phi hành đoàn và phân công công việc");

        // Hiển thị danh sách chuyến bay có sẵn để chọn
        System.out.println("Danh sách chuyến bay có sẵn:");
        displayFlightList();

        String flightNumber = valid.checkString("Chọn mã chuyến bay:");
        // Tìm chuyến bay dựa trên mã chuyến bay
        Flight selectedFlight = getFlightByFlightNumber(flightNumber, flights);
        if (selectedFlight == null) {
            System.out.println("Không tìm thấy chuyến bay với mã này.");
            return;
        }
        // Hiển thị danh sách phi hành đoàn có sẵn
        System.out.println("Danh sách phi hành đoàn:");
        displayCrewMembers();

        String option = valid.checkString("Bạn có muốn thêm phi hành đoàn mới hay không ? ( Có / Không ) tương ứng ( Y / N )");
        if (option.equals("Y")) {
            addCrew();
        } else {
            // Nhập thông tin phi hành đoàn để phân công
            String crewMemberID = valid.checkString("Nhập id phi hành đoàn để phân công:");
            // Kiểm tra xem phi hành đoàn có tồn tại trong danh sách hay không
            Crew selectedCrewMember = valid.getCrewByID(crewMemberID, listCrews);
            if (selectedCrewMember == null) {
                System.out.println("Không tìm thấy phi hành đoàn với tên này.");
                return;
            }
            // Phân công công việc cho phi hành đoàn trên chuyến bay
            selectedFlight.assignCrewMember(selectedCrewMember);

            System.out.println("Phân công thành công.");
        }
        }
        

    }

    public void addCrew() {
        // Nhập thông tin phi hành đoàn mới
        String id = valid.checkCrewId("Nhập id của phi hành đoàn mới:", listCrews);
        String name = valid.checkString("Nhập tên phi hành đoàn mới: ");
        int age = valid.checkInt("Nhập tuổi phi hành đoàn:", 18, 100);
        String role = valid.checkRole("Nhập vai trò phi hành đoàn (pilot, flight attendant, ground staff): ");
        // Tạo phi hành đoàn mới và thêm vào danh sách
        Crew newCrew = new Crew(id, name, age, role);
        if (role.equals("pilot")) {
            String licenseNumber = valid.checkString("Nhập giấy phép: ");
            //     public Pilot(String licenseNumber, String id, String name, int age, String role) {
            newCrew = new Pilot(licenseNumber, id, name, age, role);
        } else if (role.equals("flight attendant")) {
            int yearsOfExperience = valid.checkInt("Nhập số năm kinh nghiệm:", 0, 100);
            newCrew = new FlightAttendant(yearsOfExperience, id, name, age, role);
        } else {
            String department = valid.checkString("Nhập phòng ban: ");
            newCrew = new GroundStaff(department, id, name, age, role);
        }

        listCrews.add(newCrew);

        System.out.println("Thêm phi hành đoàn thành công.");
    }
    
    
   public void saveData() {
        fm.saveToFile(flights, "data.dat", "Flight");
        fm.saveToFile(reservations, "data.dat", "Reservation");
        fm.saveToFile(listCrews, "data.dat", "Crews");
    }
    
   public void loadData(){
       List<String> dataString = fm.loadFromFile("data.dat");
       /*
       String firstData = flightNumber + "," + departureCity + ","+ destinationCity + ","+ departureTime + ","+ arrivalTime + ",";
       
        for(Seat s : this.seats){
           firstData += "{"+s.toString()+"}" + ",";
        }
        for(Crew c : assignedCrewMembers){
            firstData += "{"+c.toString()+"}" + ",";
        }
        return firstData;
       */ 
      /*
       Flight 
       ....
       ....
       Reservation
       ....
       ...
       Crews 
       ...
       */
       int flightIndex=0,reservationIndex=0,crewsIndex = 0;
       
       for(int i = 0 ; i < dataString.size();i++){
           if(dataString.get(i).equals("Flight")){
               flightIndex = i;
           }
           if(dataString.get(i).equals("Reservation")){
               reservationIndex = i;
           }
           if(dataString.get(i).equals("Crews")){
               crewsIndex = i;
           }
       }
       for(int i = flightIndex + 1; i < reservationIndex;i++){
           // đọc data của flight 
       }
       for(int i = reservationIndex = 1; i < crewsIndex;i++){
           // đọc data của reservation
       }
       for(int i = crewsIndex + 1;i <  dataString.size();i++){
           // đọc data của crews 
       }
       
   }

    public void displayCrewMembers() {
        for (Crew crewMember : listCrews) {
            System.out.println(crewMember);
        }
    }

    public Reservation findReservationById(String reservationId) {
        for (Reservation r : reservations) {
            if (r.getReservationId().equals(r)) {
                return r;
            }
        }
        return null;
    }

    public List<Seat> findAllAvailableSeat(Flight flight) {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : flight.getSeats()) {
            if (!seat.isOccupied()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;  // Trả về null nếu không còn ghế trống trên chuyến bay
    }

    public Flight getFlightByFlightNumber(String flightNumber, List<Flight> flights) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightNumber)) {
                return f;
            }
        }
        return null;
    }

    public Seat getSeatByNumber(String number, List<Seat> seats) {
        for (Seat s : seats) {
            if (s.getSeatNumber().equals(number)) {
                return s;
            }
        }
        return null;
    }

    public void displayFlightList() {
        System.out.println("Danh sách chuyến bay:");
        for (Flight flight : flights) {
            System.out.println(flight.getFlightNumber() + " - " + flight.getDepartureCity() + " đến " + flight.getDestinationCity());
        }
    }

    public void displayAvaiSeatList(List<Seat> list) {
        System.out.println("Danh sách ghế:");
        for (Seat seat : list) {
            System.out.println(seat.getSeatNumber());
        }
    }
}
