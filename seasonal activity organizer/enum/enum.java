package supriya;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}
enum Activity {
    HIKING, SWIMMING, SKIING, PUMPKIN_CARVING
}
public class SeasonalActivityOrganizer {
    
    private Map<Season, EnumSet<Activity>> seasonalActivities;

    public SeasonalActivityOrganizer() {
        seasonalActivities = new HashMap<>();
        for (Season season : Season.values()) {
            seasonalActivities.put(season, EnumSet.noneOf(Activity.class));
        }
    }

    public Set<Activity> getActivitiesForSeason(Season season) {
        if (seasonalActivities.containsKey(season)) {
            return seasonalActivities.get(season);
        } else {
            System.out.println("Unknown season: " + season);
            return EnumSet.noneOf(Activity.class); // Return an empty set
        }
    }

    public Set<Activity> addActivityForSeason(Activity activity, Season season) {
        if (seasonalActivities.containsKey(season)) {
            seasonalActivities.get(season).add(activity);
            return seasonalActivities.get(season);
        } else {
            System.out.println("Unknown season: " + season);
            return EnumSet.noneOf(Activity.class); // Return an empty set
        }
    }

    public Set<Activity> removeActivityFromAllSeasons(Activity activity) {
        for (EnumSet<Activity> activities : seasonalActivities.values()) {
            activities.remove(activity);
        }
        return getAllActivities(); 
    }

    public Set<Activity> getAllActivities() {
        EnumSet<Activity> allActivities = EnumSet.noneOf(Activity.class);
        for (EnumSet<Activity> activities : seasonalActivities.values()) {
            allActivities.addAll(activities);
        }
        return allActivities;
    }

    public static void main(String[] args) {
        SeasonalActivityOrganizer organizer = new SeasonalActivityOrganizer();

        // Adding activities for different seasons
        organizer.addActivityForSeason(Activity.HIKING, Season.SPRING);
        organizer.addActivityForSeason(Activity.SWIMMING, Season.SUMMER);
        organizer.addActivityForSeason(Activity.SKIING, Season.WINTER);

        // Getting all activities
        System.out.println(organizer.getAllActivities());

        // Getting activities for specific seasons
        System.out.println(organizer.getActivitiesForSeason(Season.SPRING));
        System.out.println(organizer.getActivitiesForSeason(Season.SUMMER));
        System.out.println(organizer.getActivitiesForSeason(Season.WINTER));

        // Removing an activity from all seasons
        organizer.removeActivityFromAllSeasons(Activity.HIKING);
        System.out.println(organizer.getActivitiesForSeason(Season.SPRING));
    }
