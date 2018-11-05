/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.balls;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
//import java.util.Scanner;
/**
 *
 * @author ravi_
 */
public class BouncingBalls extends Application {
    Circle ball1;
    Thread Ball1Move;
    
    
    @Override
    public void start(Stage primaryStage) {
        ball1 = new Circle(30);
        ball1.setFill(Color.RED);
        
        Pane root = new Pane();
        double width = 200;
        double height = 350;
        root.setPrefWidth(width);
        root.setPrefHeight(height);
        root.getChildren().add(ball1);
        ball1.setCenterX(50);
        ball1.setCenterY(100);
        Scene scene = new Scene(root, 350, 300);
        
        primaryStage.setTitle("Bouncing Balls");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Ball1Move = new Thread( () -> {
            boolean move = true;   
            
            //System.out.println("(Width,Height) -> ("+ root.getWidth() +","+root.getHeight()+")");
            
            double posX = 0;
            double posY = 0;
            double iterateX = 10;
            double iterateY = 10;
            //new Scanner(System.in).nextLine();
            while(move){
                posX = ball1.getCenterX()+iterateX;
                posY = ball1.getCenterY()+iterateY;
                ball1.setCenterX(posX);
                ball1.setCenterY(posY);
                
                try{
                Thread.sleep(50);
                }catch(Exception e){}
                
                if( posX <= 30 || posX >= root.getWidth()-30 ) {
                    iterateX = - iterateX;
                }
                if( posY <= 30 || posY >= root.getHeight()-30 )  {
                    iterateY = - iterateY;
                }
                
                //System.out.println("X:" + posX + " " + "Y:" + posY);
            }
            }); Ball1Move.start();
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
