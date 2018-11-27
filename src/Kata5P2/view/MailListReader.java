package Kata5P2.view;

import Kata5P2.model.Mail;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailListReader {

    public List<Mail> read(String fileName) throws IOException {
        File emailtxt = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(emailtxt));
        String line;

        List mailList = new ArrayList<Mail>();

        Pattern pattern = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+");
        Matcher matcher;

        while((line = br.readLine()) != null) {
            matcher = pattern.matcher(line);
            if(matcher.matches()) {
                mailList.add(new Mail(line));
            }
        }

        return mailList;
    }
}
