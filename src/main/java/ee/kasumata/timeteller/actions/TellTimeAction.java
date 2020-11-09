package ee.kasumata.timeteller.actions;

import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import ee.kasumata.timeteller.time.TimeTeller;
import ee.kasumata.timeteller.time.TimeTellerImpl;
import org.jetbrains.annotations.NotNull;

public class TellTimeAction extends AnAction {
    @NotNull
    private final TimeTeller timeTeller;

    @NotNull
    private final NotificationGroup notificationGroup;

    public TellTimeAction() {
        this(new TimeTellerImpl());
    }

    public TellTimeAction(@NotNull TimeTeller timeTeller) {
        this.timeTeller = timeTeller;
        this.notificationGroup = new NotificationGroup("Time Teller", NotificationDisplayType.BALLOON);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Notification notification = notificationGroup.createNotification(
                "Current time",
                null,
                "Current local time: " + timeTeller.getFormattedTime(),
                NotificationType.INFORMATION
        );
        Notifications.Bus.notify(notification);
    }
}
