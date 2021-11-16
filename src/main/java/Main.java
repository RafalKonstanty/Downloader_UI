
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main {
    static String download_path = "";
    static String instalation_path = "";


    public static void main(String[] args) throws IOException {
        String[] files = {"ffmpeg.exe", "ffplay.exe", "ffprobe.exe", "youtube-dl.exe"};

        for (int i = 0; i < files.length; i++) {

            InputStream inputFile = Main.class.getResourceAsStream(files[i]);
            File exeFile = new File(files[i]);
            FileOutputStream fileOutputStream = new FileOutputStream(exeFile);
            byte[] bytes = new byte[1000];
            int k = 0;
            while ((k = inputFile.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, k);
            }
        }

        JFrame frame = new JFrame();
        frame.setTitle("Downloader Interface by R.K");
        frame.setLayout(new FlowLayout());

//        JButton button1 = new JButton("Set PATH");
        final JTextField text1 = new JTextField("Paste video link here");
        text1.setColumns(30);
        final JTextField text2 = new JTextField("Paste your youtube-dl.exe path");
        text2.setColumns(30);
        JButton button2 = new JButton("Download VIDEO");
        JLabel label1 = new JLabel("Video URL...\n");
//        JLabel label2 = new JLabel("Installation PATH...\n");
        JButton button3 = new JButton("Download Audio");
        JButton button4 = new JButton("Download Video List");
//        JButton button5 = new JButton("Download Live");

//        button1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                download_path = text1.getText();
//                instalation_path = text2.getText();
//                System.out.println("Video and youtube-dl.exe path set to: " + "\"" + download_path + "\"");
//                System.out.println("Instalation path set to: " + instalation_path);
//            }
//        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Instalation path: " + instalation_path);
                System.out.println("youtube-dl path: " + download_path);
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("cmd /k cd /d \"" + instalation_path + "\" & start cmd.exe /c start youtube-dl.exe -f best " + download_path);
//                    runtime.exec("cmd /k cd \"" + instalation_path + "\" & start cmd.exe /c start " + youtube_dl_path + " -f best " + download_path); //& start youtube-dl.exe " + download_path);
//                    runtime.exec("cmd /k cd \"" + instalation_path + "\" & start cmd.exe /c start youtube-dl.exe --extract-audio --audio-format mp3 " + download_path); //& start youtube-dl.exe " + download_path);
                } catch (IOException exc) {
                    exc.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Wrong file path...");
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Runtime runtime = Runtime.getRuntime();
                try {
//                    runtime.exec("cmd /k cd \""+instalation_path+"\" & start cmd.exe /c start youtube-dl.exe " + download_path); //& start youtube-dl.exe " + download_path);
                    runtime.exec("cmd /k cd \"" + instalation_path + "\" & start cmd.exe /c start youtube-dl.exe --extract-audio --audio-format mp3 " + download_path); //& start youtube-dl.exe " + download_path);
                } catch (IOException exc) {

                    JOptionPane.showMessageDialog(null, "Wrong file path...");
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Runtime runtime = Runtime.getRuntime();
                try {
//                    runtime.exec("cmd /k cd \""+instalation_path+"\" & start cmd.exe /c start youtube-dl.exe " + download_path); //& start youtube-dl.exe " + download_path);
                    runtime.exec("cmd /k cd \"" + instalation_path + "\" & start cmd.exe /c start youtube-dl.exe --extract-audio --audio-format mp3 " + "\"" + download_path + "\""); //& start youtube-dl.exe " + download_path);
                } catch (IOException exc) {

                    JOptionPane.showMessageDialog(null, "Wrong file path...");
                }
            }
        });

//        button5.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                Runtime runtime = Runtime.getRuntime();
//                try {
////                    runtime.exec("cmd /k cd \""+instalation_path+"\" & start cmd.exe /c start youtube-dl.exe " + download_path); //& start youtube-dl.exe " + download_path);
//                    runtime.exec("cmd /k cd \"" + instalation_path + "\" & start cmd.exe /c start youtube-dl.exe -f 95 "  + download_path ); //& start youtube-dl.exe " + download_path);
//                } catch (IOException exc) {
//
//                    JOptionPane.showMessageDialog(null, "Wrong file path...");
//                }
//            }
//        });

        text1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                download_path = text1.getText();
                System.out.println(download_path);
            }

            public void removeUpdate(DocumentEvent e) {
                download_path = text1.getText();
                System.out.println(download_path);
            }

            public void changedUpdate(DocumentEvent e) {
                download_path = text1.getText();
                System.out.println(download_path);
            }

        });
        text2.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                instalation_path = text2.getText();
                System.out.println("Youtube-dl folder: " + instalation_path);
            }

            public void removeUpdate(DocumentEvent e) {
                instalation_path = text2.getText();
                System.out.println(instalation_path);
            }

            public void changedUpdate(DocumentEvent e) {
                instalation_path = text2.getText();
                System.out.println(instalation_path);
            }

        });
        frame.add(label1);
        frame.add(text1);
        frame.add(text2);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
//        frame.add(button5);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);

    }


}
