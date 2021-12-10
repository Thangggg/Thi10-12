package ReadAndWite;

import Model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public void writer(String filePath, List<User> list){
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i)+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public List<User> readFile(String FILE_PATH) {
        List<User> userList = new ArrayList<>();
        File file = new File(FILE_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine())!=null){
                String[] str  = line.split(",");
                String name = (str[0]);
                String numberPhone = str[1];
                String address = (str[2]);
                String email  = (str[3]);
                String facebook = str[4];
                String group = str[5];
                String gender = str[6];
                User user = new User(name,numberPhone,address,email,facebook,group,gender);
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
