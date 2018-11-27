package Kata5P2.view;

import Kata5P2.model.Histogram;
import Kata5P2.model.Mail;

import java.util.Iterator;
import java.util.List;

public class MailHistogramBuilder {
    public Histogram<String> build(List<Mail> mailList) {
        Histogram mailHistogram = new Histogram<Mail>();
        Iterator mailIterator = mailList.iterator();

        while(mailIterator.hasNext()) {
            mailHistogram.increment(((Mail)mailIterator.next()).getDomain());
        }

        return mailHistogram;
    }
}
