/**
 * Sample Skeleton for 'NetAssistView.fxml' Controller Class
 */

package controller;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import util.Utility;

public class NetAssistController {
	
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML
    private ComboBox<String> combobox_type_of_internet;
    
    @FXML
    private ComboBox<String> combobox_local_ip_address;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="label_netType"
    private Label label_netType; // Value injected by FXMLLoader

    @FXML // fx:id="label_port"
    private Label label_port; // Value injected by FXMLLoader

    @FXML // fx:id="textfield_port"
    private TextField textfield_port; // Value injected by FXMLLoader

    @FXML // fx:id="textfield_ipAddress"
    private TextField textfield_ipAddress; // Value injected by FXMLLoader

    @FXML // fx:id="radioButton_UDP"
    private RadioButton radioButton_UDP; // Value injected by FXMLLoader

    @FXML // fx:id="label_ipAddress"
    private Label label_ipAddress; // Value injected by FXMLLoader

    @FXML // fx:id="radioButton_tcpClient"
    private RadioButton radioButton_tcpClient; // Value injected by FXMLLoader

    @FXML // fx:id="radioButton_tcpServer"
    private RadioButton radioButton_tcpServer; // Value injected by FXMLLoader
    @FXML
    private TextArea textarea_send_message;
    
    // 日志显示
    @FXML
    private TextArea textarea_log;
    
    @FXML
    private HBox hbox_des_host;
    
    @FXML
    private TextField textfield_des_host;
    
    @FXML
    private RadioButton radiobutton_ascii;
    
    @FXML
    private RadioButton radiobutton_hex;
    
    @FXML
    private Button button_connect;
    
    @FXML
    private RadioButton radiobutton_send_ascii;
    
    @FXML
    private RadioButton radiobutton_send_hex;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert label_netType != null : "fx:id=\"label_netType\" was not injected: check your FXML file 'NetAssistView.fxml'.";
        assert label_port != null : "fx:id=\"label_port\" was not injected: check your FXML file 'NetAssistView.fxml'.";
        assert textfield_port != null : "fx:id=\"textfield_port\" was not injected: check your FXML file 'NetAssistView.fxml'.";
        assert textfield_ipAddress != null : "fx:id=\"textfield_ipAddress\" was not injected: check your FXML file 'NetAssistView.fxml'.";
        assert radioButton_UDP != null : "fx:id=\"radioButton_UDP\" was not injected: check your FXML file 'NetAssistView.fxml'.";
        assert label_ipAddress != null : "fx:id=\"label_ipAddress\" was not injected: check your FXML file 'NetAssistView.fxml'.";
        assert radioButton_tcpClient != null : "fx:id=\"radioButton_tcpClient\" was not injected: check your FXML file 'NetAssistView.fxml'.";
        assert radioButton_tcpServer != null : "fx:id=\"radioButton_tcpServer\" was not injected: check your FXML file 'NetAssistView.fxml'.";
        // 获取本地所有网卡ip,动态添加到选择框中
        ObservableList<String> options = FXCollections.observableArrayList(Utility.getNetworkAddress());
        combobox_local_ip_address.setItems(options);
        combobox_local_ip_address.getSelectionModel().select(0);
    }
    //连接成功标注，连接成功后，将此变量 值为 true
    private boolean isConnectSuccess = false;
    
    private int connect = 0; // connect 为偶数 ，则为连接 ，奇数，则为断开
    // 点击连接按钮的动作
    public void doConnect(ActionEvent event) {
    	
    	if(connect %2 == 0) {
    		connect++;
    		connectSocket();
    	}else {
			connect++;
			disconnectSocket();
		}
    }
    
    private void connectSocket() {
    	String internet_type = combobox_type_of_internet.getValue();
    	String local_address = combobox_local_ip_address.getValue();
    	String port  = textfield_port.getText();
    	
    	System.out.println("类型为"+internet_type);
    	System.out.println("ip地址为"+local_address+":"+port);
    	System.out.println("开始连接");
    	//下面写连接的逻辑
    	
    	
    	//上面写连接的逻辑
    	// 模拟连接成功 
    	isConnectSuccess = true;
    	// 连接成功 并且 连接选项不为 TCP Server(服务器不需要目标ip)
    	if(isConnectSuccess && !combobox_type_of_internet.getValue().equals("TCP Server"))
    	{
    		hbox_des_host.setDisable(false);
    	}
    	button_connect.setText("断开");
    }
    
    private void disconnectSocket() {
    	//下面写断开的逻辑
    	
    	
    	//上面写断开的逻辑
    	button_connect.setText("连接");
    	hbox_des_host.setDisable(true);
    }
    
    //点击发送按钮的动作
    public void doSendMessage(ActionEvent event) {
    	
    	String message = textarea_send_message.getText();
    	System.out.println("将要发送"+message);
    	System.out.println("开始发送");
    	// 这里写要发送的逻辑
    }
    // 清理发送框数据
    public void doClearBottom(ActionEvent event) {
    	textarea_send_message.clear();
    	System.out.println("清理发送框数据");
    }
    // 清理日志框数据
    public void doClearTop(ActionEvent event) {
    	textarea_log.clear();
    	System.out.println("清理日志框数据");
    }
    
    //清理目标主机输入框
    public void doClearDesHost(ActionEvent event) {
    	textfield_des_host.clear();
    	System.out.println("清理目标主机输入框");
    }
    
    //两个radiobutton的事件函数 接收设置
    public void onAsciiClick(ActionEvent event) {
    	radiobutton_hex.setSelected(false);
    	
    }
    
    public void onHexClick(ActionEvent event) {
    	radiobutton_ascii.setSelected(false);
    
    }
    //两个radiobutton的事件函数 发送设置
    public void onSendAscii(ActionEvent event) {
    	radiobutton_send_hex.setSelected(false);
    	
    }
    public void onSendHex(ActionEvent event) {
    	radiobutton_send_ascii.setSelected(false);
    	
    }
    
    @FXML
    private CheckBox checkbox_log_mode;
    public void changeLogMode(ActionEvent event) {
    	boolean selected = checkbox_log_mode.isSelected();
    
    }
    
    @FXML
    private CheckBox checkbox_auto_enter;
    public void changeAutoEnter(ActionEvent event) {
    	boolean selected = checkbox_auto_enter.isSelected();
    	
    }
    
    @FXML
    private CheckBox checkbox_save_file;
    public void getFileName(ActionEvent event) {
    	//这里写打开对话框 获得文件路径 
    	
    	//
    	
    	
    }
    
    @FXML
    private CheckBox checkbox_pause_disply;
    public void puseDisplay(ActionEvent event) {
    	boolean selected = checkbox_pause_disply.isSelected();
    	
    	textarea_log.setDisable(selected);
    }
    
    // 发送配置
    @FXML
    private CheckBox checkbox_auto_parse;
    public void onChangeAtuoParse(ActionEvent event) {
    	boolean selected = checkbox_auto_parse.isSelected();
    	
    	
    }
    @FXML
    private CheckBox checkbox_send_file_name;
    public void onGetFileNameSend(ActionEvent event) {
    	// 此处写获得文件路径 
    	
    	
    }
    @FXML
    private CheckBox checkbox_send_auto_enter;
    public void onChangeAutoEnterSend(ActionEvent event) {
    	boolean selected = checkbox_send_auto_enter.isSelected();
    	
    }
    
    @FXML
    private CheckBox checkbox_is_cycle;
    @FXML
    private TextField textfield_cycle_t;
    public void onChangeToCycle(ActionEvent event) {
    	boolean selected = checkbox_is_cycle.isSelected();
    
    	
    }
    
    
    
}
