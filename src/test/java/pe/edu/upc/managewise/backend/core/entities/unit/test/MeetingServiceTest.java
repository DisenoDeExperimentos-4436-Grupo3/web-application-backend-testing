package pe.edu.upc.managewise.backend.core.entities.unit.test;

import org.junit.jupiter.api.Test;
import pe.edu.upc.managewise.backend.meeting.domain.model.commands.CreateMeetingCommand;
import pe.edu.upc.managewise.backend.meeting.domain.model.commands.CreateRecordingCommand;
import pe.edu.upc.managewise.backend.meeting.domain.model.commands.UpdateMeetingCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingServiceTest {
    @Test
    void testCreateMeeting() {

        //Arrange
        String title = "Sprint 1";
        String dateStr = "2025-05-01";
        String timeStr = "45 min";
        String link = "url";


        // Act
        CreateMeetingCommand createMeetingCommand = new CreateMeetingCommand(title, dateStr, timeStr, link);

        // Assert
        assertEquals(title, createMeetingCommand.title());
        assertEquals(dateStr, createMeetingCommand.dateStr());
        assertEquals(timeStr, createMeetingCommand.timeStr());
        assertEquals(link, createMeetingCommand.link());
    }


    @Test
    void testUpdateMeeting() {

        //Arrange
        Long meetingId = 1L;
        String title = "Sprint 1";
        String dateStr = "2025-08-01";
        String timeStr = "45 min";
        String link = "urlCorregida";


        // Act
        UpdateMeetingCommand updateMeetingCommand = new UpdateMeetingCommand(meetingId, title, dateStr, timeStr, link);

        // Assert
        assertEquals(meetingId, updateMeetingCommand.meetingId());
        assertEquals(title, updateMeetingCommand.title());
        assertEquals(dateStr, updateMeetingCommand.dateStr());
        assertEquals(timeStr, updateMeetingCommand.timeStr());
        assertEquals(link, updateMeetingCommand.link());
    }


    @Test
    void testCreateRecording() {

        //Arrange
        Long meetingId = 1L;
        String recordingLink = "url15";
        String duration = "45 min";
        boolean publicAccess = true;


        // Act
        CreateRecordingCommand createRecordingCommand = new CreateRecordingCommand(meetingId, recordingLink, duration, publicAccess);

        // Assert
        assertEquals(meetingId, createRecordingCommand.meetingId());
        assertEquals(recordingLink, createRecordingCommand.recordingLink());
        assertEquals(duration, createRecordingCommand.duration());
        assertEquals(publicAccess, createRecordingCommand.publicAccess());
    }

}
