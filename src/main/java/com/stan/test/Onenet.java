package com.stan.test;
//
//import java.util.Scanner;
//
//import org.apache.commons.cli.CommandLine;
//import org.apache.commons.cli.CommandLineParser;
//import org.apache.commons.cli.DefaultParser;
//import org.apache.commons.cli.HelpFormatter;
//import org.apache.commons.cli.Options;
//import org.apache.commons.cli.ParseException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.eclipse.paho.client.mqttv3.MqttClient;
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.eclipse.paho.client.mqttv3.MqttCallback;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.eclipse.paho.client.mqttv3.MqttMessage;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//
//import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
//import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
//
//public class Onenet implements MqttCallback {
//
//	public static void main(String[] args) throws MqttException {
//		String brokertUrl = "tcp://183.230.40.39:6002";
//		String clientId = "28166093"; // 设备ID
//		String userName = "125506"; // 产品ID
//		String password = "pi"; // 鉴权信息
//		String[] lineArray;
//		String line;
//		Onenet client = new Onenet(brokertUrl, clientId, true, false, userName, password); // 建立连接
//		CliParser cli = new CliParser();
//		Scanner in = new Scanner(System.in);
//		while (true) {
//			System.out.print("mqtt cli >");
//			// read command line string[]
//			line = in.nextLine();
//			if (line.equals(""))
//				continue;
//			lineArray = line.split(" ");
//
//			// Thread current = Thread.currentThread();
//			// System.out.println(current.getName());
//			// System.out.println(current.getId());
//			// System.out.println(current.getThreadGroup());
//			// System.out.println(current.getStackTrace());
//			// System.out.println(current.toString());
//
//			try {
//				if (cli.argsParse(lineArray, client))
//					;
//				else
//					cli.printHelp();
//				if (cli.getQuit()) {
//					System.out.println("exit");
//					break;
//				}
//			} catch (MqttException me) {
//
//				// Display full details of any exception that occurs
//				System.out.println("reason " + me.getReasonCode());
//				System.out.println("msg " + me.getMessage());
//				System.out.println("loc " + me.getLocalizedMessage());
//				System.out.println("cause " + me.getCause());
//				System.out.println("excep " + me);
//				me.printStackTrace();
//			}
//		}
//		in.close();
//		System.exit(0);
//
//	}
//
//	private MqttConnectOptions conOpt;
//	private MqttClient client;
//	private String brokerUrl;
//	private boolean quietMode; // 是否向终端打印调试信息
//
//	public Onenet(String brokerUrl, String clientId, boolean cleanSession, boolean quietMode, String userName,
//			String password) throws MqttException {
//		this.brokerUrl = brokerUrl;
//		String tmpDir = System.getProperty("java.io.tmpdir");
//		System.out.println(tmpDir);
//		MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(tmpDir);
//
//		try {
//			// Construct the connection options object that contains connection parameters
//			// such as cleanSession and LWT
//			conOpt = new MqttConnectOptions();
//			conOpt.setCleanSession(cleanSession);
//			if (password != null) {
//				conOpt.setPassword(password.toCharArray());
//			}
//			if (userName != null) {
//				conOpt.setUserName(userName);
//			}
//
//			// Construct an MQTT blocking mode client
//			client = new MqttClient(brokerUrl, clientId, dataStore);
//
//			// Set this wrapper as the callback handler
//			client.setCallback(this);
//			client.connect(conOpt); // establish the connection
//
//		} catch (MqttException e) {
//			e.printStackTrace();
//			log("Unable to set up client: " + e.toString());
//			System.exit(1);
//		}
//		log("Connected to OneNET server.");
//		log("If the field, CleanSession, is false, It is better to show the topics the client subscribed");
//	}
//
//	// MqttSecurityException
//	public void publish(String topicName, int qos, byte[] payload) throws MqttException {
//
//		String time = new Timestamp(System.currentTimeMillis()).toString();
//		log("Publishing at: " + time + " to topic \"" + topicName + "\" qos " + qos);
//
//		// Create and configure a message
//		MqttMessage message = new MqttMessage(payload);
//		message.setQos(qos);
//
//		// Send the message to the server, control is not returned until
//		// it has been delivered to the server meeting the specified
//		// quality of service.
//		client.publish(topicName, message);
//	}
//
//	public void subscribe(String topicName, int qos) throws MqttException {
//		log("subscribing at: " + " to topic \"" + topicName + "\" qos " + qos);
//		// Create and configure a message
//		// Send the message to the server, control is not returned until
//		// it has been delivered to the server meeting the specified
//		// quality of service.
//		client.subscribe(topicName, qos);
//	}
//
//	public void unsubscribe(String topicName) throws MqttException {
//		log("unsubscribing at: " + " to topic \"" + topicName);
//		client.unsubscribe(topicName);
//	}
//
//	public void connect() throws MqttException {
//		log("Connecting to " + brokerUrl + " with client ID " + client.getClientId());
//		client.connect(conOpt);
//		log("Connected");
//	}
//
//	public void disconnect() throws MqttException {
//		client.disconnect();
//		log("Disconnected");
//	}
//
//	/****************************************************************/
//	/* Methods to implement the MqttCallback interface */
//	/****************************************************************/
//
//	/**
//	 * @see MqttCallback#connectionLost(Throwable)
//	 */
//	public void connectionLost(Throwable cause) {
//		// Called when the connection to the server has been lost.
//		// An application may choose to implement reconnection
//		// logic at this point. This sample simply exits.
//		log("Connection to " + brokerUrl + " lost!" + cause);
//		System.exit(1);
//	}
//
//	/**
//	 * @see MqttCallback#deliveryComplete(IMqttDeliveryToken)
//	 */
//	public void deliveryComplete(IMqttDeliveryToken token) {
//		System.out.println("delivery Completed:");
//	}
//
//	/**
//	 * @throws InterruptedException
//	 * @see MqttCallback#messageArrived(String, MqttMessage)
//	 */
//	public void messageArrived(String topic, MqttMessage message) throws MqttException, InterruptedException {
//		// Called when a message arrives from the server that matches any
//		// subscription made by the client
//		// Thread current = Thread.currentThread();
//		// System.out.println(current.getPriority());
//		// System.out.println(current.getName());
//		// System.out.println(current.activeCount());
//		// System.out.println(current.getId());
//		// System.out.println(current.getThreadGroup());
//		// System.out.println(current.getStackTrace());
//		// System.out.println(current.hashCode());
//		// System.out.println(current.toString());
//
//		String time = new Timestamp(System.currentTimeMillis()).toString();
//		System.out.println("Time:\t" + time + "  Topic:\t" + topic + "  Message:\t" + new String(message.getPayload())
//				+ "  QoS:\t" + message.getQos());
//		if (topic.equals("/paper")) {
//			ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
//			byte[] json = new String(message.getPayload()).getBytes();
//			try {
//				// 尝试从JSON中读取对象
//				PaperInfo info = mapper.readValue(json, PaperInfo.class);
//				System.out.println(info);
//				Wanfang wf = new Wanfang(info, "E:\\Liusong\\paper\\");
//				if (wf.download()) {
//					System.out.println("download finished");
//					publish("/result", 1, "succeed".getBytes());
//				} else
//					System.out.println("download failed");
//			} catch (IOException e) {
//				// e.printStackTrace();
//				System.out.println("json format error");
//				return;
//			}
//		}
//	}
//
//	/**
//	 * Utility method to handle logging. If 'quietMode' is set, this method does
//	 * nothing
//	 *
//	 * @param message
//	 *            the message to log
//	 */
//	private void log(String message) {
//		if (!quietMode) {
//			System.out.println(message);
//		}
//	}
//
//}
//
//class CliParser {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private Options options;
//	private CommandLineParser parser;
//	private CommandLine cmd;
//	private boolean quit = false;
//
//	public CliParser() {
//		options = new Options();
//		options.addOption("a", true, "action");
//		options.addOption("t", true, "topic");
//		options.addOption("m", true, "message");
//		options.addOption("q", true, "Qos 0-2");
//		options.addOption("quit", false, "quit");
//		parser = new DefaultParser();
//	}
//
//	public boolean argsParse(String[] args, Onenet onenet) throws MqttException {
//		try {
//			cmd = parser.parse(options, args);
//		} catch (ParseException exp) {
//			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
//		}
//		if (cmd.hasOption("quit")) {
//			onenet.disconnect();
//			quit = true;
//			return true;
//		}
//		String action = cmd.getOptionValue("a");
//		String topic = cmd.getOptionValue("t");
//		String qos = cmd.getOptionValue("q");
//		String message = cmd.getOptionValue("m");
//		int qos2;
//		if (action == null) {
//			log("-a opt miss");
//			return false;
//		}
//
//		if (action.equals("subscribe") || action.equals("publish")) {
//			if (topic == null || qos == null) {
//				log("topic | qos miss");
//				return false;
//			}
//			try {
//				qos2 = Integer.parseInt(qos);
//			} catch (Exception e) {
//				log("qos is number");
//				return false;
//			}
//			if (qos2 == 0 || qos2 == 1 || qos2 == 2) {
//				if (action.equals("publish")) {
//					if (message == null) {
//						log("message miss");
//						return false;
//					}
//					onenet.publish(topic, qos2, message.getBytes());
//					log("action:" + action);
//					log("topic:" + topic);
//					log("message:" + message);
//					return true;
//				} else {
//					onenet.subscribe(topic, qos2);
//					log("action:" + action);
//					log("topic:" + topic);
//					return true;
//				}
//			} else {
//				log("invalid qos");
//				return false;
//			}
//
//		} else if (action.equals("list")) {
//			log("已订阅主题");
//			return true;
//		} else if (action.equals("unsubscribe")) {
//			if (topic == null) {
//				log("topic value miss");
//				return false;
//			} else {
//				onenet.unsubscribe(topic);
//				log("unsubscribe");
//				return true;
//			}
//
//		} else {
//			log("action err");
//			return false;
//		}
//	}
//
//	public void printHelp() {
//		HelpFormatter formatter = new HelpFormatter();
//		formatter.printHelp("mqtt", options);
//	}
//
//	private void log(String s) {
//		System.out.println(s);
//	}
//
//	public boolean getQuit() {
//		return quit;
//	}
//}
//
//class PaperInfo {
//	private String name;
//	private String url;
//	private String emailAdd;
//
//	// public PaperInfo(String name,String url,String emailAdd){
//	// this.name = name;
//	// this.url = url;
//	// this.emailAdd = emailAdd;
//	// }
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}
//
//	public String getEmailAdd() {
//		return emailAdd;
//	}
//
//	public void setEmailAdd(String emailAdd) {
//		this.emailAdd = emailAdd;
//	}
//
//	public String toString() {
//		return "name:" + name + "  url:" + url + "  emailAdd:" + emailAdd;
//	}
//}
