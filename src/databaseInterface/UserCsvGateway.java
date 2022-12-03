package databaseInterface;

import model.request.UserRequestModel;
import model.response.UserResponseModel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface UserCsvGateway {
    /**
     * This method is for reading users.csv file.
     *
     * @param userPath the path of the users.csv file
     * @return a map of users
     * @throws IOException if the file is not found
     */
    default Map<Integer, UserRequestModel> usersReader(String userPath) throws IOException {

        File csvFile = new File(userPath);
        Map<String, Integer> headers = new LinkedHashMap<>();
        Map<Integer, UserRequestModel> users = new HashMap<>();
        headers.put("id", 0);
        headers.put("user-type", 1);
        headers.put("password", 2);
        headers.put("name", 3);
        headers.put("time", 4);

        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        reader.readLine(); // skip header
        String row;
        while ((row = reader.readLine()) != null) {
            String[] col = row.split(",");
            int id = Integer.parseInt(col[headers.get("id")]);
            String userType = String.valueOf(col[headers.get("user-type")]);
            String password = String.valueOf(col[headers.get("password")]);
            String name = String.valueOf(col[headers.get("name")]);
            String time = String.valueOf(col[headers.get("time")]);


            UserRequestModel user = new UserRequestModel(id, userType, name, password, time);
            users.put(id, user);
        }

        reader.close();
        return users;
    }

    /**
     * This method is for writing users.csv file.
     *
     * @param userPath the path of the users.csv file
     * @param users a map of users
     */

    default void usersWriter(Map<Integer, UserResponseModel> users, String userPath) {


        Map<String, Integer> headers = new LinkedHashMap<>();
        headers.put("id", 0);
        headers.put("user-type", 1);
        headers.put("password", 2);
        headers.put("name", 3);
        headers.put("time", 4);

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(userPath));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (UserResponseModel user : users.values()) {
                String line = (
                        user.get().get(0)+","+
                                user.get().get(1)+","+
                                user.get().get(3)+","+
                                user.get().get(2)+","+
                                user.get().get(4));

                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
