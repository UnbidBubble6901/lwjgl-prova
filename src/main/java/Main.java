import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;
import org.joml.Vector2f;


import java.nio.*;
import java.util.Vector;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

@SuppressWarnings("unused")

public class Main {


    Paddle player1 = new Paddle(new Vector2f(10, GameProperties.windowH / 2 - 50), new Vector2f(10, 100), 5, 1);
    Paddle player2 = new Paddle(new Vector2f(GameProperties.windowW - 20, GameProperties.windowH / 2 - 50), new Vector2f(10, 100), 5, 2);
    Ball ball = new Ball(new Vector2f(GameProperties.windowW / 2, GameProperties.windowH / 2), 10, new Vector2f(10, 5));


    public void run() {
        init();
        loop();
        cleanup();
    }

    private void init() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        GameProperties.window = glfwCreateWindow(GameProperties.windowW, GameProperties.windowH, "LWJGL Window", NULL, NULL);
        if (GameProperties.window == NULL) {
            throw new RuntimeException("Failed to create GLFW window");
        }

        glfwMakeContextCurrent(GameProperties.window);
        glfwSwapInterval(1);
        glfwShowWindow(GameProperties.window);

        GL.createCapabilities();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 800, 0, 600, -1, 1);  // left, right, bottom, top, near, far
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }

    private void loop() {
        while (!glfwWindowShouldClose(GameProperties.window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            ball.Update();
            player1.Update();
            player2.Update();
            ball.Draw();
            player1.Draw();
            player2.Draw();


            glfwSwapBuffers(GameProperties.window);
            glfwPollEvents();
        }
    }

    private void cleanup() {
        glfwDestroyWindow(GameProperties.window);
        glfwTerminate();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}


