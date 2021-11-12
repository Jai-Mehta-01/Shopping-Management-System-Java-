import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{

    public static void main(String[] args)
    {
        while (true) {
            ServerSocket ss = null;
            try {
                ss = new ServerSocket(143);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Socket s = null;
            try {
                assert ss != null;
                s = ss.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            DataOutputStream dopt = null;
            try {
                assert s != null;
                dopt = new DataOutputStream(s.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            DataInputStream dint = null;
            try {
                dint = new DataInputStream(s.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String writ, read = "";

            try {
                assert dint != null;
                read = dint.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner sc = new Scanner(System.in);
            if (read.equals("4")) {
                System.out.println("User Connected");
                while (!read.equals("over")) {

                    writ = sc.nextLine();
                    try {
                        assert dopt != null;
                        dopt.writeUTF(writ);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        dopt.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        read = dint.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Client:- " + read);
                }
            } else {
                switch (read) {
                    case "1" -> {
                        writ = "Thank you for your response. We are working on your issue";
                        try {
                            assert dopt != null;
                            dopt.writeUTF(writ);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            dopt.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    case "2" -> {
                        writ = "Thank you for your response. We are working on payment issue";
                        try {
                            assert dopt != null;
                            dopt.writeUTF(writ);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            dopt.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            read = dint.readUTF();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        switch (read) {
                            case "1" -> {
                                writ = "We have sent a new code on you email";
                                try {
                                    dopt.writeUTF(writ);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    dopt.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case "2" -> {
                                writ = "Sorry for the inconvenience caused. We are working on your issue";
                                try {
                                    dopt.writeUTF(writ);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    dopt.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case "3" -> {
                                writ = "Your complaint has been booked successfully";
                                try {
                                    dopt.writeUTF(writ);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    dopt.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    case "3" -> {
                        writ = "Thank you for your response. We are working on the product issue";
                        try {
                            assert dopt != null;
                            dopt.writeUTF(writ);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            dopt.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            read = dint.readUTF();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        switch (read) {
                            case "1" -> {
                                writ = "We have received your return request. We are working on it";
                                try {
                                    dopt.writeUTF(writ);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    dopt.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case "2" -> {
                                writ = "Your product will get replaced within 10 days";
                                try {
                                    dopt.writeUTF(writ);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    dopt.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            case "3" -> {
                                writ = "Your complaint has been booked successfully";
                                try {
                                    dopt.writeUTF(writ);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    dopt.flush();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
            try {
                dint.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
