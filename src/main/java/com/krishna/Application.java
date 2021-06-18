package com.krishna;

import com.krishna.api.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
         int SIZE = 10;
         Game game = new Game();
         game.initGame(SIZE);
         int p1x=  new Random().nextInt(SIZE);
         int p1y=  new Random().nextInt(SIZE);
         int p2x=  new Random().nextInt(SIZE);

         int p2y=  new Random().nextInt(SIZE);

         game.addShip(1,4, p1x, p1y, p2x, p2y);
         game.startGame(SIZE);

    }

}
