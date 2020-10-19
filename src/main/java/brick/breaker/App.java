/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package brick.breaker;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Brick Breaker Clone.
 * Implemented with Processing library for Graphics.
 */
public class App extends PApplet {

  private static final int WIDTH = 1200;
  private static final int HEIGHT = 1000;

  private static Ball ball;
  private static Paddle paddle;
  private static PVector mouse;

  /**
   * Pre-configuration for {@link App}.
   * Used to pass variables to {@link PApplet}
   */
  public void settings() {
    size(WIDTH, HEIGHT);
  }

  /**
   * Pre-run configuration for {@link PApplet}.
   * All code is only run once per instance of app.
   * Used to set window size / instantiate objects.
   */
  public void setup() {
    rectMode(CENTER);
    ball = new Ball()
      .setSize(new PVector(50, 50))
      .setPosition(new PVector(width / 2, 5 * height / 6));
    paddle = new Paddle()
      .setSize(new PVector(100f, 15f))
      .setPosition(new PVector(width / 2, 5 * height / 6));
    mouse = new PVector();
  }

  /**
   * Runtime code for {@link PApplet}.
   * All code is run at 60 fps by default.
   */
  public void draw() {
    fill(125);
    rect(width / 2, height / 2, width, height);
    fill(255);
    rect(width / 2, height / 2, width / 2, height);
    float mouseHorizontal = constrain(mouseX,
        width / 4 + paddle.getSize().x / 2,
        3 * width / 4 - paddle.getSize().x / 2);
    mouse.set(mouseHorizontal, 0);
    paddle.render(this);
    paddle.update(mouse);
    if (ball.isColliding(paddle)) {
      fill(255, 0, 0);
    } else {
      fill(255);
    }
    ball.render(this);
  }

  /**
   *  Starts program with an instance of {@link PApplet}.
   *
   *  @param args command line arguments
   */
  public static void main(String[] args) {
    String[] processingArgs = { "App" };
    App app = new App();
    PApplet.runSketch(processingArgs, app);
  }
}
