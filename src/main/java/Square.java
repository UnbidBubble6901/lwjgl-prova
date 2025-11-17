import org.joml.Vector2f;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Square {

    public int windowH;
    public int windowW;

    public Vector2f pos = new Vector2f();
    public Vector2f size = new Vector2f();
    public Vector2f vel = new Vector2f();


    public void Draw(){

        glBegin(GL_QUADS);
        glColor3f(1.0f, 1.0f, 1.0f);    
        glVertex2f(pos.x, pos.y);       
        glVertex2f(pos.x + size.x, pos.y);        
        glVertex2f(pos.x, pos.y + size.y);
        glVertex2f(pos.x + size.x, pos.y + size.y);
        glEnd();

    }

    public void Update(){

        if(pos.x + size.x >= windowW || pos.x <= windowW){
            vel.x *= -1;
        }
        if(pos.y + size.y >= windowH || pos.y <= windowH){
            vel.y *= -1;
        }
    }
}
