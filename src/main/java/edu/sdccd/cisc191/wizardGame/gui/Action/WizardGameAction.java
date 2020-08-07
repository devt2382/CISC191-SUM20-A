package edu.sdccd.cisc191.wizardGame.gui.Action;

import javax.swing.*;
import java.awt.event.ActionListener;

import edu.sdccd.cisc191.wizardGame.Game;
import edu.sdccd.cisc191.wizardGame.gui.screen.Window;
import edu.sdccd.cisc191.wizardGame.option.Option;

/**
 * Super class of actions triggered by buttons within the WizardGame GUI. Subclasses
 * that inherit {@code WizardGameAction} are stored within a map in {@code ActionManager}.
 *
 * @author Seth Steen-Fuentes
 *
 * 08/05/2020
 */

public abstract class WizardGameAction extends AbstractAction implements Option<WizardGameAction>, ActionListener {

    protected final Window frame;

    public static final String ACTION_ID = "ACTION_ID";

    public WizardGameAction(Window frame, String id) {
        this.frame = frame;

        putValue(ACTION_ID, id);

    }

    protected ActionManager getActionManager() {
        return frame.getActionManager();
    }

    protected Game getGame()                { return frame.getGame(); }
    protected Window getWindow()              { return getGame().getFrame(); }

    public abstract String getId();
}