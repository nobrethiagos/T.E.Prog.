import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class waterTree {
  static class nodeInfo {
    int filled; 
    int parent;
    ArrayList<Integer> children; 
        
    public nodeInfo(int parent) {
      this.filled = 0;
      this.parent = parent;
      this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "NodeInfo{filled=" + filled + ", parent=" + parent + ", children=" + children + '}';
    }
  }

  static Map<Integer, nodeInfo> vertices;

  public static void descendants(Map<Integer, nodeInfo> vertices, int parent, int child) {
    vertices.get(parent).children.add(child);
    if(vertices.get(parent).parent != -1) {
      descendants(vertices, vertices.get(parent).parent, child);
    }
  }

  public static void command1(Map<Integer, nodeInfo> vertices, int agent) {
    vertices.get(agent).filled = 1;
    for(int child : vertices.get(agent).children) {
      vertices.get(child).filled = 1;
    }
  }

  public static void command2(Map<Integer, nodeInfo> vertices, int agent) {
    vertices.get(agent).filled = 0;
    if(vertices.get(agent).parent != -1) {
      command2(vertices, vertices.get(agent).parent);
    }
  }

  public static void command3(Map<Integer, nodeInfo> vertices, int agent) {
    System.out.println(vertices.get(agent).filled);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nVertices = sc.nextInt();
    int command, agent, nCommands;
    vertices = new HashMap<>();

    // long start1 = System.nanoTime();
    
    for (int i = 1; i <= nVertices; i++) {
      vertices.put(i, new nodeInfo(-1)); 
    }
    // System.out.println("Vertices: " + vertices);
    for (int i = 1; i < nVertices; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();
      // System.out.println("Adicionando aresta entre " + v1 + " e " + v2);
      if (v1 == 1 || vertices.get(v1).parent != -1) {
        // System.out.println("Caso 1");
        descendants(vertices, v1, v2);
        vertices.get(v2).parent = v1;
      } else {
        // System.out.println("Caso 2");
        descendants(vertices, v2, v1);
        vertices.get(v1).parent = v2;
      }
    }

    // long end1 = System.nanoTime();
    // System.out.println("Tempo de inicializacao arvore: " + (end1 - start1) + " ms");
    
    nCommands = sc.nextInt();
    for(int i = 0; i < nCommands; i++) {
      command = sc.nextInt();
      agent = sc.nextInt();
      // System.out.println("Vertices: " + vertices);
      switch(command) {
        case 1:

          // long start2 = System.nanoTime();
          
          // System.out.println("Caso 1, agent = " + agent);
          command1(vertices, agent);
          
          // long end2 = System.nanoTime();
          // System.out.println("Tempo caso 1: " + (end2 - start2) + " ms");
          
          break;
        case 2:
          
          // long start3 = System.nanoTime();
          
          // System.out.println("Caso 2, agent = " + agent);
          command2(vertices, agent);
          
          // long end3 = System.nanoTime();
          // System.out.println("Tempo caso 2: " + (end3 - start3) + " ms");
          
          break;
        case 3:
          // long start4 = System.nanoTime();
          
          // System.out.println("Caso 3, agent = " + agent);
          command3(vertices, agent);
          
          // long end4 = System.nanoTime();
          // System.out.println("Tempo caso 3: " + (end4 - start4) + " ms");
      }
    }
    sc.close();
  }
}
