package com.vaadin.tests.components.window;

import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class TestTooSmallSubwindowSize extends TestBase {

    @Override
    protected String getDescription() {
        return "The size of the subwindow (outer size) is set to 60x60 pixels. Minimum size for the content area is 150x100, which means the window and shadow should be around 155x155 and the content area 150x100. The decoration at the lower left corner of the window must not be missing either.";
    }

    @Override
    protected Integer getTicketNumber() {
        return 2579;
    }

    @Override
    protected void setup() {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        Window w = new Window("Scroll", layout);
        Label desc = new Label(
                "This is a new child window with a preset"
                        + " width, height and position. Resizing has been"
                        + " disabled for this window. Additionally, this text label"
                        + " is intentionally too large to fit the window. You can"
                        + " use the scrollbars to view different parts of the window content.");
        layout.addComponent(desc);

        // Set window position
        w.setPositionX(100);
        w.setPositionY(100);

        // Set window size
        w.setWidth(60, Window.UNITS_PIXELS);
        w.setHeight(60, Window.UNITS_PIXELS);

        // Disable resizing
        w.setResizable(true);

        getMainWindow().addWindow(w);
    }

}
