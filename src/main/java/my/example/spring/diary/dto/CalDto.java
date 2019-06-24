package my.example.spring.diary.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CalDto {

    private String summary;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String description;
    private String eventId;
    private String calendarId;
}
