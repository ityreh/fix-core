package de.ityreh.finance.fix.tool.views;

import java.io.IOException;

public class SessionView extends MenuView {
    public SessionView() throws IOException {
        super();
    }

    @Override
    protected void initNodes() throws IOException {
        fxList.addAll(loadMenu(), loadView("/fxml/session.fxml"));
    }
}
