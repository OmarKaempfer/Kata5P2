package Kata5P2.main;

import Kata5P2.model.Histogram;
import Kata5P2.model.Mail;
import Kata5P2.view.HistogramDisplay;
import Kata5P2.view.MailHistogramBuilder;
import Kata5P2.view.MailListReader;

import java.io.IOException;
import java.util.List;

public class Kata5P2 {
    private String fileName = "email.txt";
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histogramDisplay;

    public static void main(String[] args) throws IOException {
        Kata5P2 kata5P2 = new Kata5P2();
        kata5P2.control();
    }

    public void control() {
        input();
        process();
        output();
    }

    public void input() {
        MailListReader mailListReader = new MailListReader();
        try {
            mailList = mailListReader.read(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process() {
        MailHistogramBuilder mailHistogramBuilder = new MailHistogramBuilder();
        histogram = mailHistogramBuilder.build(mailList);
    }

    public void output() {
        histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();
    }
}
