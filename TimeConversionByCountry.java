import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class TimeConversionByCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get all available time zone IDs
        String[] timeZoneIds = ZoneId.getAvailableZoneIds().toArray(new String[0]);

        // Sort time zone IDs in alphabetical order
        Arrays.sort(timeZoneIds);

        // Taking user input for local time zone
        System.out.println("Select your local time zone:");
        displayTimeZoneOptions(timeZoneIds);
        int localZoneNum = sc.nextInt();
        ZoneId localZoneId = ZoneId.of(timeZoneIds[localZoneNum]);

        // Taking user input for country time zone
        System.out.println("Select the country time zone:");
        displayTimeZoneOptions(timeZoneIds);
        int countryZoneNum = sc.nextInt();
        ZoneId countryZoneId = ZoneId.of(timeZoneIds[countryZoneNum]);

        // Convert local time to country time
        LocalDateTime localDateTime = LocalDateTime.now(localZoneId);
        LocalDateTime countryDateTime = localDateTime.atZone(localZoneId)
                .withZoneSameInstant(countryZoneId).toLocalDateTime();

        // Format date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = formatter.format(localDateTime);
        String countryTime = formatter.format(countryDateTime);

        // Show output
        System.out.println("Local time (" + localZoneId + "): " + localTime);
        System.out.println("Country time (" + countryZoneId + "): " + countryTime);

        sc.close();
    }

    private static void displayTimeZoneOptions(String[] timeZoneIds) {
        for (int i = 0; i < timeZoneIds.length; i++) {
            System.out.println(i + ". " + timeZoneIds[i]);
        }
    }
}
3