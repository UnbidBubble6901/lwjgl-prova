import org.joml.Vector2f;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

@SuppressWarnings("unused")

public class Paddle extends Rectangle{

    public float speed;
    public int player;


    public Paddle(Vector2f pos, Vector2f size, float speed, int player){
        super(pos, size);
        this.speed = speed;
        if (player < 1 && player > 2){
            throw new IllegalArgumentException("Player must be either 1 or 2");
        }
        this.player = player;
        
    }

    public void Update(){

        if (player == 1){
            if(1 == glfwGetKey(GameProperties.window, GLFW_KEY_W) && pos.y + size.y <= GameProperties.windowH){
                pos.y += speed;
            }
            if(1 == glfwGetKey(GameProperties.window, GLFW_KEY_S) && pos.y >= 0){
                pos.y -= speed;
            }
        }


        if (player == 2){
            if(1 == glfwGetKey(GameProperties.window, GLFW_KEY_UP) && pos.y + size.y <= GameProperties.windowH){
                pos.y += speed;
            }
            if(1 == glfwGetKey(GameProperties.window, GLFW_KEY_DOWN) && pos.y >= 0){
                pos.y -= speed;
            }
        }

        
    }
    
}
