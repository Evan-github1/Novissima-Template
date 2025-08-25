/*
    this is not supposed to be in org.firstinspires.ftc.teamcode. DON'T MOVE IT
    it's a regular java class with a regular main method, not an opmode
    read my doc for more info

    copy and paste the following into the terminal to run this class:
        cd TeamCode/src/main/java
        javac DesktopControlClient.java
        java DesktopControlClient
*/

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class DesktopControlClient {
    private static Socket socket;
    private static Scanner read;
    private static DataOutputStream out;
    private static DataInputStream in;

    private static final String PHONE_IP = "";

    public static void main(String[] args) throws IOException, UnknownHostException {
        // connect to the phone
        socket = new Socket(PHONE_IP, 1234); // 1234 is the port
        System.out.println("Connected to the phone!");

        // init streams and stuff
        read = new Scanner(System.in);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());

        while (true) {
            System.out.println("\n");
            String input = read.nextLine();

            out.writeUTF(input);
            out.flush();
        }
    }
}
