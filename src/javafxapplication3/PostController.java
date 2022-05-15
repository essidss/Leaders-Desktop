package javafxapplication3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import Modal.Account;
import Modal.Posts;
import Modal.Post;
import Modal.Reactions;
import Services.ServicePosts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.String.format;

import java.net.URL;
import java.text.DateFormat;
import static java.text.MessageFormat.format;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class PostController implements Initializable {

    @FXML
    private ImageView imgProfile;

    @FXML
    private Label username;

    @FXML
    private ImageView imgVerified;

    @FXML
    private Label date;

    @FXML
    private ImageView audience;

    @FXML
    private Label caption;

    @FXML
    private ImageView imgPost;

    @FXML
    private Label nbReactions;

    @FXML
    private Label nbComments;

    @FXML
    private Label nbShares;

    @FXML
    private HBox reactionsContainer;

    @FXML
    private ImageView imgLike;

    @FXML
    private ImageView imgLove;

    @FXML
    private ImageView imgCare;

    @FXML
    private ImageView imgHaha;

    @FXML
    private ImageView imgWow;

    @FXML
    private ImageView imgSad;

    @FXML
    private ImageView imgAngry;

    @FXML
    private HBox likeContainer;

    @FXML
    private ImageView imgReaction;

    @FXML
    private Label reactionName;

    private long startTime = 0;
    private Reactions currentReaction;
    // private Post post;
    private Posts post;
    final DateFormat format = DateFormat.getInstance();

    @FXML
    public void onLikeContainerPressed(MouseEvent me) {
        startTime = System.currentTimeMillis();
    }

    @FXML
    public void onLikeContainerMouseReleased(MouseEvent me) {
        if (System.currentTimeMillis() - startTime > 500) {
            reactionsContainer.setVisible(true);
        } else {
            if (reactionsContainer.isVisible()) {
                reactionsContainer.setVisible(false);
            }
            if (currentReaction == Reactions.NON) {
                setReaction(Reactions.LIKE);
            } else {
                setReaction(Reactions.NON);
            }
        }
    }

    @FXML
    public void onReactionImgPressed(MouseEvent me) {
        switch (((ImageView) me.getSource()).getId()) {
            case "imgLove":
                setReaction(Reactions.LOVE);
                break;
            case "imgCare":
                setReaction(Reactions.CARE);
                break;
            case "imgHaha":
                setReaction(Reactions.HAHA);
                break;
            case "imgWow":
                setReaction(Reactions.WOW);
                break;
            case "imgSad":
                setReaction(Reactions.SAD);
                break;
            case "imgAngry":
                setReaction(Reactions.ANGRY);
                break;
            default:
                setReaction(Reactions.LIKE);
                break;
        }
        reactionsContainer.setVisible(false);
    }

    public void setReaction(Reactions reaction) {
            ServicePosts sa = new ServicePosts();

        Image image = new Image(getClass().getResourceAsStream(reaction.getImgSrc()));
        imgReaction.setImage(image);
        reactionName.setText(reaction.getName());
        reactionName.setTextFill(Color.web(reaction.getColor()));

//        if (currentReaction == Reactions.NON) {
//            post.setTotalReactions(post.getTotalReactions() + 1);
//            sa.likedarticle(post); 
//       // post.setLiked(1);
//
//        }
//
//        currentReaction = reaction;
//
//        if (currentReaction == Reactions.NON) {
//            post.setTotalReactions(post.getTotalReactions() - 1);
//            sa.Dislikedarticle(post);
//        }
//
//        nbReactions.setText(String.valueOf(post.getTotalReactions()));
    }

    public void setData(Posts post) {
        this.post = post;
        Image img;
        // img = new Image(getClass().getResourceAsStream(post.getAccount().getProfileImg()));
        //imgProfile.setImage(img);
        /* username.setText(post.getAccount().getName());
        if(post.getAccount().isVerified()){
            imgVerified.setVisible(true);
        }else{
            imgVerified.setVisible(false);
        }*/
        final Calendar cal = Calendar.getInstance();

        date.setText(format.format(cal.getTime()));

        //audience.setImage(img);

        /*if(post.getCaption() != null && !post.getCaption().isEmpty()){
            caption.setText(post.getCaption());
        }else{
            caption.setManaged(false);
        }*/
       /* if (post.getImage() != null && !post.getImage().isEmpty()) {
            img = new Image(getClass().getResourceAsStream(post.getImage()));
            imgPost.setImage(img);
        } else {
            imgPost.setVisible(true);
            imgPost.setManaged(true);
        }*/
          
        Image image = null;
        try {
            System.out.println("C:\\Users\\hp\\Documents\\NetBeansProjects\\JavaFXApplication3\\src\\img\\" + post.getPicture());
            image = new Image(new FileInputStream("C:\\Users\\hp\\Documents\\NetBeansProjects\\JavaFXApplication3\\src\\img\\" + post.getPicture()));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        System.out.println(""+image);
         // img= post.getImage();
        //System.out.println(""+img);



        imgPost.setImage(image);
        caption.setText(post.getContent());

        nbReactions.setText(String.valueOf(post.getId()));
        System.out.println("nb"+nbReactions);
//        nbComments.setText(post.getNbComments() + " comments");
//        nbShares.setText(post.getNbShares() + " shares");

        currentReaction = Reactions.NON;
    }

    private Posts getPost() {
        Post post = new Post();
        Posts article = new Posts();

        Account account = new Account();
        account.setName("Mahmoud Hamwi");
        account.setProfileImg("/img/user.png");
        account.setVerified(true);
        post.setAccount(account);
        Date d = new Date();
        // article.setContent(article.getContent());
        // article.setDate(d);
        post.setCaption("Hello everybody.");
        post.setImage("/img/img2.jpg");
        post.setTotalReactions(10);
        post.setNbComments(2);
        post.setNbShares(3);
//        article.setNbComments(10);

        return article;
    }

    public void setArticle(Posts article) {
        //Article articles = new Posts(id);
        // caption.setText(String.valueOf(id));
        caption.setText(article.getTitle());

//        nbReactions.setText(String.valueOf(article.getTotalReactions()));
//        nbComments.setText(article.getNbComments() + " comments");
//        nbShares.setText(article.getNbShares() + " shares");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData(getPost());

    }

}
