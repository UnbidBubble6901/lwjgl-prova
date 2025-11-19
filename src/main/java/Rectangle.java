import org.joml.Vector2f;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

@SuppressWarnings("unused")

public class Rectangle {

    public int windowH = GameProperties.windowH;
    public int windowW = GameProperties.windowW;

    public Vector2f pos = new Vector2f();
    public Vector2f size = new Vector2f();

    public Rectangle(Vector2f pos, Vector2f size){

        this.pos = pos;
        this.size = size;

    }

    public void Draw(){

        glBegin(GL_QUADS);
        glColor3f(1.0f, 1.0f, 1.0f);    
        glVertex2f(pos.x, pos.y);       
        glVertex2f(pos.x + size.x, pos.y);
        glVertex2f(pos.x + size.x, pos.y + size.y);        
        glVertex2f(pos.x, pos.y + size.y);
        glEnd();

    }


}
