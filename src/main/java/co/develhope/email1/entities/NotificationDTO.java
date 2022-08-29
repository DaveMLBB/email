package co.develhope.email1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class NotificationDTO {
    private String contactId;
    private String title;
    private String text;
}
