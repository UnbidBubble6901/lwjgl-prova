import org.joml.Vector2f;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

@SuppressWarnings("unused")

public class Ball {
    public int windowH = GameProperties.windowH;
    public int windowW = GameProperties.windowW;

    public Vector2f pos = new Vector2f();
    public float radius;
    public Vector2f vel = new Vector2f();

    public Ball(Vector2f _pos, float _radius, Vector2f _vel){

        pos = _pos;
        radius = _radius;
        vel = _vel;

    }

    public void Draw(){

        for (int i = 0; i < 360; i++){
            glBegin(GL_TRIANGLES);
            glColor3f(1.0f, 1.0f, 1.0f);
            glVertex2f(pos.x, pos.y);
            glVertex2f((float)(pos.x + radius * Math.cos(i)), (float)(pos.y + radius * Math.sin(i)));
            glVertex2f((float)(pos.x + radius * Math.cos(i + 90)), (float)(pos.y + radius * Math.sin(i + 90)));
            glEnd();
            
        }
        
    }

    public void Update(){

        if(pos.x + radius >= windowW || pos.x <= 0){
            vel.x *= -1;
        }
        if(pos.y + radius >= windowH || pos.y <= 0){
            vel.y *= -1;
        }

        pos.x += vel.x;
        pos.y += vel.y;

        

    }
}
