import org.joml.Vector2f;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Square {

    public int windowH = GameProperties.windowH;
    public int windowW = GameProperties.windowW;

    public Vector2f pos = new Vector2f();
    public Vector2f size = new Vector2f();
    public Vector2f vel = new Vector2f();

    public Square(Vector2f _pos, Vector2f _size, Vector2f _vel){

        pos = _pos;
        size = _size;
        vel = _vel;

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

    public void Update(){

        if(pos.x + size.x >= windowW || pos.x <= 0){
            vel.x *= -1;
        }
        if(pos.y + size.y >= windowH || pos.y <= 0){
            vel.y *= -1;
        }

        pos.x += vel.x;
        pos.y += vel.y;
    }
}
