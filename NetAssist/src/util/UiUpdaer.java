package util;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class UiUpdaer
{
	private TextArea textarea_log;

	public UiUpdaer(TextArea textarea_log)
	{
		super();
		this.textarea_log = textarea_log;
	}
	
	public void update(String content) {
		Platform.runLater(()-> {
			String formal = textarea_log.getText();
			textarea_log.setText(formal+"\r\n"+content);
		});
	}
	
}
