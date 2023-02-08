/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazapartahoteles;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author AntonioJesusMorenoRo
 */
public class HelpInside {
    
    public static Tooltip setTooltip( String s){
                final Tooltip t = new Tooltip();
                t.setShowDelay( Duration.seconds(1));
                t.setHideDelay(Duration.seconds(10));
                t.setText(s); 
        return t;
    }
    
        public static Tooltip setTooltip(Button b, String s){
                final Tooltip t = new Tooltip();
                t.setShowDelay( Duration.seconds(1));
                t.setHideDelay(Duration.seconds(3));
                t.setText(s);
                
                b.setTooltip(t);
                b.borderProperty();
                //CORNFLOWERBLUE
		b.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, new CornerRadii(20), new Insets(3))));
              
        return t;
    }
        
    public static String readStringFromURL(String requestURL) throws IOException
{
    try (Scanner scanner = new Scanner(new URL(requestURL).openStream(),
            StandardCharsets.UTF_8.toString()))
    {
        scanner.useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }
}    
    
}
