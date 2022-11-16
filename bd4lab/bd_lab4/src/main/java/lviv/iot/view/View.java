package lviv.iot.view;

import lviv.iot.controller.impl.*;
import lviv.iot.model.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class View {
    private static final String KEY_EXIT = "Q";
    private final static Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new HashMap<>();

    private final AdressController adressController = new AdressController();
    private final DataController dataController = new DataController();
    private final DeveloperController developerController = new DeveloperController();
    private final GpsController gpsController = new GpsController();
    private final IntervalOfUpdatesController intervalOfUpdatesController = new IntervalOfUpdatesController();
    private final LocationController locationController = new LocationController();
    private final MeteostationController meteostationController = new MeteostationController();
    private final ServiceWorkController serviceWorkController = new ServiceWorkController();

    public View(){
        menu.put("11", this::getaAllAdress);
        menu.put("12", this::getAdressById);
        menu.put("13", this::createAdress);
        menu.put("14", this::updateAdress);
        menu.put("15", this::deleteAdress);

        menu.put("21", this::getData);
        menu.put("22", this::getDataById);
        menu.put("23", this::createData);
        menu.put("24", this::updateData);
        menu.put("25", this::deleteData);

        menu.put("31", this::getAllDevelopers);
        menu.put("32", this::getDevelopersById);
        menu.put("33", this::createDeveloper);
        menu.put("34", this::updateDeveloper);
        menu.put("35", this::deleteDeveloper);

        menu.put("41", this::getGps);
        menu.put("42", this::getGpsById);
        menu.put("43", this::createGps);
        menu.put("44", this::updateGps);
        menu.put("45", this::deleteGps);

        menu.put("51", this::getAllIntervalOfUpdates);
        menu.put("52", this::getIntervalOfUpdatesById);
        menu.put("53", this::createIntervalOfUpdates);
        menu.put("54", this::updateIntervalOfUpdates);
        menu.put("55", this::deleteIntervalOfUpdates);

        menu.put("61", this::getAllLocation);
        menu.put("62", this::getLocationById);
        menu.put("63", this::createLocation);
        menu.put("64", this::updateLocation);
        menu.put("65", this::deleteLocation);

        menu.put("71", this::getAllMeteostation);
        menu.put("72", this::getMeteostationById);
        menu.put("73", this::createMeteostation);
        menu.put("74", this::updateMeteostation);
        menu.put("75", this::deleteMeteostation);

        menu.put("81", this::getAllServiceWork);
        menu.put("82", this::getServiceWorkById);
        menu.put("83", this::createServiceWork);
        menu.put("84", this::updateServiceWork);
        menu.put("85", this::deleteServiceWork);

    }
    private void getaAllAdress() throws SQLException {
        adressController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getAdressById() throws SQLException {
        out.println(adressController.findById(getId()));
        massageItsAll();
    }
    private void createAdress() throws SQLException {
        adressController.create(getAdressFromInput());
        massageCreated();
    }
    private void updateAdress() throws SQLException {
        Integer id = getId();
        Adress adress = getAdressFromInput();
        adress.setId(id);
        adressController.update(adress.getId(), adress);
        massageUpdate();
    }
    private void deleteAdress() throws SQLException {
        adressController.delete(getId());
        massageDeleted();
    }
    private Adress getAdressFromInput() {
        out.println("Adress id: \n");
        Integer id = Integer.parseInt(scanner.nextLine());
        out.println("Adress:  \n: ");
        String adress = scanner.nextLine();
        out.println("Street: \n");
        String street = scanner.nextLine();
        out.println("Building: \n");
        String build = scanner.nextLine();
        return new Adress(id, adress, street, build);

    }
//chd
    private void getData() throws SQLException {
        dataController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getDataById() throws SQLException {
        out.println(dataController.findById(getId()));
        massageItsAll();
    }
    private void createData() throws SQLException {
        dataController.create(getDataFromInput());
        massageCreated();
    }
    private void updateData() throws SQLException {
        Integer id = getId();
        Data data = getDataFromInput();
        data.setId(id);
        dataController.update(data.getId(), data);
        massageUpdate();
    }
    private void deleteData() throws SQLException {
        dataController.delete(getId());
        massageDeleted();
    }
    private Data getDataFromInput() {
        out.println("Data id: \n");
        Integer id = Integer.parseInt(scanner.nextLine());
        out.println("Temperature: \n");
        Integer temperature = Integer.parseInt(scanner.nextLine());
        out.println("Humidity: \n");
        Integer humidity = Integer.parseInt(scanner.nextLine());
        out.println("Wind speed: \n");
        Integer wind_speed = Integer.parseInt(scanner.nextLine());
        out.println("Atmospheric pressure: \n");
        Integer atmospheric_pressure = Integer.parseInt(scanner.nextLine());
        out.println("Wind direction: \n");
        Integer wind_direction = Integer.parseInt(scanner.nextLine());
        out.println("Interval of updates id: \n");
        Integer interval_of_updates_id = Integer.parseInt(scanner.nextLine());



        return new Data(id, temperature, humidity, wind_speed, atmospheric_pressure, wind_direction, interval_of_updates_id);

    }
//
    private void getAllDevelopers() throws SQLException {
        developerController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getDevelopersById() throws SQLException {
        out.println(developerController.findById(getId()));
        massageItsAll();
    }
    private void createDeveloper() throws SQLException {
        developerController.create(getDeveloperFromInput());
        massageCreated();
    }
    private void updateDeveloper() throws SQLException {
        Integer id = getId();
        Developer developer = getDeveloperFromInput();
        developer.setId(id);
        developerController.update(developer.getId(), developer);
        massageUpdate();
    }
    private void deleteDeveloper() throws SQLException {
        developerController.delete(getId());
        massageDeleted();
    }
    private Developer getDeveloperFromInput() {
        out.println("id \n: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        out.println("Name \n: ");
        String name = scanner.nextLine();
        out.println("Surname \n:");
        String surname = scanner.nextLine();
        out.println("Telephone number \n:");
        String telephone_num = scanner.nextLine();

        return new Developer(id, name, surname,telephone_num);

    }

    private void getGps() throws SQLException {
        gpsController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getGpsById() throws SQLException {
        out.println(gpsController.findById(getId()));
        massageItsAll();
    }
    private void createGps() throws SQLException {
        gpsController.create(getGpsFromInput());
        massageCreated();
    }
    private void updateGps() throws SQLException {
        Integer id = getId();
        Gps gps = getGpsFromInput();
        gps.setId(id);
        gpsController.update(gps.getId(), gps);
        massageUpdate();
    }
    private void deleteGps() throws SQLException {
        gpsController.delete(getId());
        massageDeleted();
    }
    private Gps getGpsFromInput() {
        out.println("Id: \n ");
        Integer id = Integer.parseInt(scanner.nextLine());
        out.println("Latitude: \n ");
        String latitude = scanner.nextLine();
        out.println("Longtitude \n" );
        String longtitude = scanner.nextLine();
        return new Gps(id, latitude, longtitude);

    }

    private void getAllIntervalOfUpdates() throws SQLException {
        intervalOfUpdatesController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getIntervalOfUpdatesById() throws SQLException {
        out.println(intervalOfUpdatesController.findById(getId()));
        massageItsAll();
    }
    private void createIntervalOfUpdates() throws SQLException {
        intervalOfUpdatesController.create(getIntervalOfUpdatesFromInput());
        massageCreated();
    }
    private void updateIntervalOfUpdates() throws SQLException {
        Integer id = getId();
        IntervalOfUpdates interval = getIntervalOfUpdatesFromInput();
        interval.setId(id);
        intervalOfUpdatesController.update(interval.getId(), interval);
        massageUpdate();
    }
    private void deleteIntervalOfUpdates() throws SQLException {
        intervalOfUpdatesController.delete(getId());
        massageDeleted();
    }
    private IntervalOfUpdates getIntervalOfUpdatesFromInput() {
        out.println("Id: \n");
        Integer id = Integer.parseInt(scanner.nextLine());
        out.println("Interval: \n");
        Integer interval = Integer.parseInt(scanner.nextLine());
        return new IntervalOfUpdates(id, interval);
    }

    private void getAllLocation() throws SQLException {
        locationController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getLocationById() throws SQLException {
        out.println(locationController.findById(getId()));
        massageItsAll();
    }
    private void createLocation() throws SQLException {
        locationController.create(getLocationFromInput());
        massageCreated();
    }
    private void updateLocation() throws SQLException {
        Integer id = getId();
        Location location = getLocationFromInput();
        location.setId(id);
        locationController.update(location.getId(), location);
        massageUpdate();
    }
    private void deleteLocation() throws SQLException {
        locationController.delete(getId());
        massageDeleted();
    }
    private Location getLocationFromInput() {
        out.println("Id: \n");
        Integer id = Integer.parseInt(scanner.nextLine());
        out.println("City: \n");
        String city = scanner.nextLine();
        out.println("Adress id: ");
        Integer adress_id = Integer.parseInt(scanner.nextLine());
        out.println("Gps id: \n");
        Integer gps_id = Integer.parseInt(scanner.nextLine());

        return new Location(id, city, adress_id, gps_id);
    }

    private void getAllMeteostation() throws SQLException {
        meteostationController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getMeteostationById() throws SQLException {
        out.println(meteostationController.findById(getId()));
        massageItsAll();
    }
    private void createMeteostation() throws SQLException {
        meteostationController.create(getMeteostationFromInput());
        massageCreated();
    }
    private void updateMeteostation() throws SQLException {
        Integer id = getId();
        Meteostation meteostation = getMeteostationFromInput();
        meteostation.setId(id);
        meteostationController.update(meteostation.getId(), meteostation);
        massageUpdate();
    }
    private void deleteMeteostation() throws SQLException {
        meteostationController.delete(getId());
        massageDeleted();
    }
    private Meteostation getMeteostationFromInput() {
        out.println("Id: \n");
        Integer id = Integer.parseInt(scanner.nextLine());
        out.println("Installation date: ");
        Date installation_date = Date.from(Instant.parse(scanner.nextLine()));
        out.println("Data id: \n" );
        Integer data_id = Integer.parseInt(scanner.nextLine());
        out.println("Interval of updates id: \n");
        Integer interval_of_updates_id = Integer.parseInt(scanner.nextLine());
        out.println("Location id: \n");
        Integer location_id = Integer.parseInt(scanner.nextLine());
        out.println("Location id: \n");
        Integer service_work_id = Integer.parseInt(scanner.nextLine());
        out.println("Location id: \n");
        Integer developer_id = Integer.parseInt(scanner.nextLine());
        return new Meteostation(id, installation_date, data_id, interval_of_updates_id, location_id, service_work_id, developer_id);

    }

    private void getAllServiceWork() throws SQLException {
        serviceWorkController.findAll().forEach(out::println);
        massageItsAll();
    }
    private void getServiceWorkById() throws SQLException {
        out.println(serviceWorkController.findById(getId()));
        massageItsAll();
    }
    private void createServiceWork() throws SQLException {
        serviceWorkController.create(getServiceWorkFromInput());
        massageCreated();
    }
    private void updateServiceWork() throws SQLException {
        Integer id = getId();
        ServiceWork serviceWork = getServiceWorkFromInput();
        serviceWork.setId(id);
        serviceWorkController.update(serviceWork.getId(), serviceWork);
        massageUpdate();
    }
    private void deleteServiceWork() throws SQLException {
        serviceWorkController.delete(getId());
        massageDeleted();
    }
    private ServiceWork getServiceWorkFromInput() {

        out.println("Date: \n");
        Date date = Date.from(Instant.parse(scanner.nextLine()));
        out.println("Description: \n");
        String description = scanner.nextLine();
        Integer id =Integer.parseInt(scanner.nextLine());
        return new ServiceWork(id, date, description);
    }

    private Integer getId() {
        out.println("Id:");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    private String getName() {
        out.println("Name:");
        return scanner.nextLine();
    }

    private void massageItsAll() {
        out.println("----------------------------------------\n"
                + "That's all!\n"
                + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageDeleted() {
        out.println("Deleted!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageCreated() {
        out.println("Created!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private void massageUpdate() {
        out.println("Update!\n" + "----------------------------------------\n" + "Select a table and action: ");
    }

    private static void displayMenu() {
        out.println(
                "|--------------------------------------|---------------|\n" +
                        "| 1: Adress                            |   1: GET ALL  |\n" +
                        "| 2: Data                              |   2: GET      |\n" +
                        "| 3: Developer                         |   3: CREATE   |\n" +
                        "| 4: Gps                               |   4: UPDATE   |\n" +
                        "| 5: IntervalOfUpdates                 |   5: DELETE   |\n" +
                        "| 6: Location                          |_______________|\n" +
                        "| 7: Meteostation                      |               |\n" +
                        "| 8: ServiceWork                       |               |\n" +
                        "|                                      |   Q - exit    |\n" +
                        "|--------------------------------------|---------------|\n"
        );
    }

    public void show() throws SQLException {
        displayMenu();
        out.println("Select a table and action: ");
        String input = scanner.nextLine();

        while (!input.equals(KEY_EXIT)) {
            out.println("----------------------------------------");
            menu.get(input).print();
            input = scanner.nextLine();
        }
    }

}
