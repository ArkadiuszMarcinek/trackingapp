package testutils

import com.example.trackingapp.models.dto.Recipient
import com.example.trackingapp.models.dto.Sender
import spock.lang.Specification

class RequestUtilsForTest extends Specification {

    static Recipient getRecipient() {
        return Recipient.builder()
                .name("RecipientName")
                .lastName("RecipientLName")
                .street("RecipientStreet")
                .postalCode("21-151")
                .city("RecipientCity")
                .email("recipient@email.com")
                .phoneNumber("123456789")
                .build()
    }
    static Sender getSender() {
        return Sender.builder()
                .name("SenderName")
                .lastName("SenderLName")
                .street("SenderStreet")
                .postalCode("21-131")
                .city("SenderCity")
                .email("sender@email.com")
                .phoneNumber("987654321")
                .build()
    }
}
