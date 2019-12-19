package de.ityreh.finance.fix.tool.views;

import java.io.IOException;

public class LogView extends MenuView {
    public LogView() throws IOException {
        super();
    }

    @Override
    protected void initNodes() throws IOException {
        fxList.addAll(loadMenu(), loadView("/fxml/log.fxml"));
    }
}
