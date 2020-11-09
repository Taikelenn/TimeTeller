package ee.kasumata.timeteller.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import ee.kasumata.timeteller.time.TimeTeller;
import ee.kasumata.timeteller.time.TimeTellerImpl;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public class TellTimeAction extends AnAction {
    @NotNull
    private final TimeTeller timeTeller;

    public TellTimeAction() {
        this(new TimeTellerImpl());
    }

    public TellTimeAction(TimeTeller timeTeller) {
        this.timeTeller = timeTeller;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Messages.showMessageDialog(timeTeller.getFormattedTime(), "Sample Title", null);
    }
}
