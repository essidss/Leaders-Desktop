/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import Model.Event;
import Model.Categorie;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.controlsfx.control.Notifications;
import Services.ServiceC;
import Services.ServiceE;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author HP
 */


public class AddeventController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ServiceE srep = new ServiceE();
    
  
    
    private AnchorPane paneMain;
    private javafx.stage.Stage stage;
    private Scene scene;
    private Parent root;
    private Event rep;
    @FXML
    private Circle C1;
   
    @FXML
    private TextField date;
    @FXML
    private ComboBox<Categorie> cat;
    @FXML
    private TextField name;
    @FXML
    private TextField lieu;
    @FXML
    private TextArea description;
    @FXML
    private TextField picture;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<Categorie> postslist = srep.getpostsList();
            try {

            } catch (Exception ex) {
            }
            cat.setItems(postslist);

            System.out.println(postslist);
            // TODO

        } catch (SQLException ex) {
        }
//        ToggleSwitch button =new ToggleSwitch();
//    
//        SimpleBooleanProperty isON=button.switchOnProperty();
//        isON.addListener((observable,oldValue,newValue) ->{
//        
//        
//        
//        
//        if(newValue){
//        
//        button.getScene().getRoot().getStylesheets().add(getClass().getResource("styles.css").toString());
//            System.out.println("adding css dark");
// }else {        button.getScene().getRoot().getStylesheets().remove(getClass().getResource("styles.css").toString());
//            System.out.println("removing css dark");
//
//        }
//        });
//        
////        paneMain.getChildren().add(button); 
//    }    

    }

    @FXML
    private void addcmnt(ActionEvent event) throws MessagingException {
        ServiceE spost = new ServiceE();
        System.out.println(name.getText().length());
        Rotate(C1);
        if (name.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Vous navez pas saisie le nom");
            alert.show();

        } else {
           
           // System.out.println(p.toString());
         //   if (ValidateFields()) {
       // if (ValidateFields2()) {
                // if (ValidateFields3(reponse.getText())) {
                     
                         int rec   =  cat.getSelectionModel().getSelectedItem().getId();
                 
                        spost.ajouterEvent(new Event( name.getText(), date.getText(), lieu.getText(), description.getText(), picture.getText(),rec));
//                         Event  p= new Event( "momo", "2020-02-07",55);
//
//                         System.out.println(p);
  Properties properties = new Properties();
    properties.put("mail.smtp.auth", true);
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", 587);
    properties.put("mail.smtp.starttls.enable", true);
    properties.put("mail.transport.protocl", "smtp");
    Session session = Session.getInstance(properties,new Authenticator(){
        
        @Override
    protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication("zouhour.gawa@esprit.tn","191Jft4490");

    }
    });
    Message message = new MimeMessage(session);
    message.setSubject("Esprit-Connect Service Club");
    Address addressTo=new InternetAddress("narjes.gawa@esprit.tn");
    message.setRecipient (Message.RecipientType. TO, addressTo);
    MimeMultipart multipart = new MimeMultipart();
    
    MimeBodyPart attachment = new MimeBodyPart();
//    attachment.attachFile(new File("C:/Users/ASUS/Desktop/memoire Les réseaux sociaux pdf.pdf"));*/
    
    /*MimeBodyPart attachment2 = new MimeBodyPart();
    attachment2.attachFile("C:\\Users\\tlich\\Desktop\");*/
    
   MimeBodyPart messageBodyPart=new MimeBodyPart();
    messageBodyPart.setContent("<hl>Bienvenu ,Votre demande a ete accepter !</h1>","text/html");
                              
    multipart.addBodyPart (messageBodyPart);
  //  multipart.addBodyPart(attachment);
  // multipart.addBodyPart(attachment2);
    
    message.setContent(multipart);
    Transport.send(message);
       
                        
                        
                        
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);//
                        alert.setTitle("AJOUTER PUBLICATION!");
                        alert.setHeaderText("information!");
                        alert.setContentText("PUBLICATION A ETE AJOUTEE AVEC SUCCES!");
                        alert.showAndWait();

                  // }
           //   }
           // }
        }
        try {
            Calendar(name.getText(),date.getText(),date.getText());
        } catch (IOException ex) {
        }
        
        
    }
    
    
    
    
    

    public void GettextVal(String txtval) {
        System.out.println("text value from one controller - " + txtval);
    }

//    @FXML
//    private void returcmnt(ActionEvent event) {
//        try {
//            root = FXMLLoader.load(getClass().getResource("commentgrid.fxml"));
//            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//        }
//        Notifications notificationBuilder = Notifications.create()
//                .title("retour vers commentaires").text("retour envoyé avec succès").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
//                .position(Pos.CENTER_LEFT)
//                .onAction(new EventHandler<ActionEvent>() {
//                    public void handle(ActionEvent event) {
//                        System.out.println("clicked ON ");
//                    }
//                });
//        notificationBuilder.darkStyle();
//        notificationBuilder.show();
//
//    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//   void setData(Comment comment) {
//        this.comment = comment;
//        cntTF.setText(comment.getContenu());
//        repTF.setText(String.valueOf(comment.getResp()));
//        labTF.setText(comment.getLabel());
//    
//  
//        
//}
    private boolean ValidateFields() {
        //Date myDate = Date.valueOf(datePK.getValue().toString());
        if (name.getText().isEmpty() | date.getText().isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please enter into the fields");
            alert.showAndWait();
            return false;
        }
        return true;
    }

//    private boolean ValidateFields2() {
//        ServiceReclam bs = new ServiceReclam();
//        if (Integer.parseInt(bs.calculer_nbp(cntTF.getText())) != 0) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Validate Fields");
//            alert.setHeaderText(null);
//            alert.setContentText("Please enter a non existant course name");
//            // bs.calculer_nbseance(Add_Nom_Co.getText())
//            //alert.setContentText(bs.calculer_nbseance(Add_Nom_Co.getText()));
//            alert.showAndWait();
//            return false;
//        }
//        return true;
//    }

    public void Rotate(Circle c) {
        RotateTransition rt = new RotateTransition(Duration.millis(3000), c);
        rt.setByAngle(360);
        rt.setCycleCount(5);
        rt.setAutoReverse(true);

        rt.play();

    }

    @FXML
    private void g(KeyEvent event) {

    }

    private boolean ValidateFields3(String S) {
        ServiceE sc = new Services.ServiceE();

        String word = "shit";
        
        String result = "";
        // Creating the censor which is an asterisks
        // "*" text of the length of censor word
        String stars = "";
        for (int i = 0; i < word.length(); i++) {
            stars += '*';
        }

        // Iterating through our list
        // of extracted words
        int index = 0;
        String[] word_list = S.split("\\s+");
        for (String i : word_list) {
            if (i.compareTo(word) == 0) // changing the censored word to
            // created asterisks censor
            {
                word_list[index] = stars;
            }
            index++;
        }

        // join the words
        for (String i : word_list) {
            result += i + ' ';
        }

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("bad word");
        alert.setHeaderText(null);
        alert.setContentText(""+result);
        alert.showAndWait();
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    //Calendrier
    public void Calendar(String Titre , String Datedeb , String Datefin) throws MalformedURLException, IOException{
        // Using Calendar api
          URL url = new URL("https://www.googleapis.com/calendar/v3/calendars/c_3rhcqs2ssrg9l5u7q4532v5u0k@group.calendar.google.com/events/");
HttpURLConnection http = (HttpURLConnection)url.openConnection();
http.setRequestMethod("POST");
http.setDoOutput(true);
http.setRequestProperty("Authorization", "Bearer ya29.A0ARrdaM9qjghmk4GxOvdygGZkhTTyYT3WRO68CHlf-xgjF4YHlBVHdnjMRVxq_s5zujE0cGOMxVrG0THTc3rdhSiB_DeupbX0eF3BTXwHUaL6PsIXkqccATeUtJf2WQreAEmMpwJdfP6jFCJ87CO-nvqxw68v");
String data = "{\n\"summary\": \""+Titre+"\",\n  \"location\": \" GEEK Application\",\n  \"start\": {\n    \"dateTime\": \""+Datedeb+"T10:00:00.000-07:00\"\n  },\n  \"end\": {\n    \"dateTime\": \""+Datefin+"T10:25:00.000-07:00\"\n    }\n\n}";
//String data = "{\n\"summary\": \"tournament\",\n  \"location\": \"Arena Application\",\n  \"start\": {\n    \"dateTime\": \""+tfDateDebut.getValue().format(DateTimeFormatter.ISO_DATE)+"T10:00:00.000-07:00\"\n  },\n  \"end\": {\n    \"dateTime\": \""+tfDateFin.getValue().format(DateTimeFormatter.ISO_DATE)+"\n    },\n\"etag\": \"\", \n      \"backgroundColor\": \"#b80672\", \n      \"timeZone\": \"UTC\", \n      \"accessRole\": \"reader\",\n\"kind\": \"calendar#calendarListEntry\", \n      \"foregroundColor\": \"#ffffff\", \n      \"defaultReminders\": [], \n      \"colorId\": \"2\"\n\n}\n";
byte[] out = data.getBytes(StandardCharsets.UTF_8);

OutputStream stream = http.getOutputStream();
stream.write(out);

System.out.println(http.getResponseCode() + " " + http.getResponseMessage() + " Event added to Calendar Successfully");
http.disconnect();
        
        // end Calenda
    }
    
    
   
    
    
    
    
    
    
    
    
    @FXML
    private void rett(ActionEvent event) {
          try {
            root = FXMLLoader.load(getClass().getResource("eventaffichage.fxml"));
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
        }
    }
    
    
    
    
    
    }


