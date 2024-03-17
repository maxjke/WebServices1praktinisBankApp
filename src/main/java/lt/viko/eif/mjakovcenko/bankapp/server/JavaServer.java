package lt.viko.eif.mjakovcenko.bankapp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * JavaServer class represents information about server needed to start server and send file over network
 */
public class JavaServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private OutputStream out;

    /**
     * Start method opens server socket with given port, accepts client socket and calls sendFile method.
     * @param port
     * @param file
     */
    public void start(int port, String file) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for connection...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            out = clientSocket.getOutputStream();
            sendFile(file);

            System.out.println("File sent. Closing connection...");
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            stop();
        }
    }

    /**
     * Creates new file with given file path. Puts file bytes into output stream.
     * @param filePath
     * @throws IOException
     */

    private void sendFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(bytes, 0, bytes.length);

        out.write(bytes, 0, bytes.length);
        out.flush();
        bis.close();
    }

    /**
     * Closes all sockets and streams.
     */
    public void stop() {
        try {
            if (out != null) out.close();
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

}

