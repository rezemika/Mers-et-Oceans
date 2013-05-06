package mods.mersetoceans.client.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import net.minecraft.client.gui.GuiWinGame;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;

public class ReadObj {
	
	private static Map OBJs = new Hashtable() ;

	private String fichier;
	private String name;

	private ArrayList vertex = new ArrayList(1);
	private ArrayList texture = new ArrayList(1);
	private Hashtable faces = new Hashtable();

	private Icon defaultIcon;
	private Hashtable faceIcon = new Hashtable();

	private double[] defaultoffset = new double[3];
	public Hashtable offset = new Hashtable();

	private Icon icon;


	/* ReadObj.init( String URI )
	 * Utile pour le rendu dans le monde, et dans l'inventaire.
	 * Méthode : static
	 * Retourne : un objet ReadObj unique pour chaque uri
	 * Attribut : String URI : URI du fichier .obj d'on la racine est /mcp/src/minecraft/
	 */
	public static ReadObj init( String fichier ) {
		
		if( !OBJs.containsKey(fichier) )
			new ReadObj( fichier );
		
		return (ReadObj) OBJs.get(fichier);
		
	}
	
	private ReadObj(String URI) {
		
		fichier = URI;
		OBJs.put( fichier , this );
		
		try {
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(GuiWinGame.class.getResourceAsStream(fichier), Charset.forName("UTF-8")));
			stockage( bufferedreader );
		} catch (Exception exception) {
            exception.printStackTrace();
        }
	}

	private void stockage( BufferedReader bufferedreader ) throws IOException {
		
        String s = "";
		Hashtable listing = new Hashtable();
		String[][] f;
		double[] p;
		String[] sp;

		p = new double[2]; p[0] = 0; p[1] = 0; texture.add(p);
		p = new double[2]; p[0] = 1; p[1] = 0; texture.add(p);
		p = new double[2]; p[0] = 1; p[1] = 1; texture.add(p);
		p = new double[2]; p[0] = 0; p[1] = 1; texture.add(p);
		
		
		while ((s = bufferedreader.readLine()) != null) {
			if( s.matches("^o .*") ) {
				name = s.replaceAll("^o (.*)", "$1");
				faces.put(name, new ArrayList(1));
				double[] poffset = new double[3];
				offset.put(name, poffset);
			}
			if( s.matches("^v .*") ) {
				p = new double[3];
				sp = s.replaceAll("^v (.*)", "$1").split(" ");
				for(int i = 0; i < sp.length; i++) p[i] = Double.parseDouble(sp[i]);
				vertex.add( p );
			}
			if( s.matches("^vt .*") ) {
				p = new double[2];
				sp = s.replaceAll("^vt (.*)", "$1").split(" ");
				for(int i = 0; i < sp.length; i++) p[i] = Double.parseDouble(sp[i]);
				texture.add( p );
			}
			if( s.matches("^f .*") ) {
				f = new String[4][2];
				sp = s.replaceAll("^f (.*)", "$1").split(" ");
				for(int i = 0; i < sp.length; i++) f[i] = sp[i].split("/");
				((ArrayList) faces.get(name)).add( f );
			}
		}
		
		//System.out.println( fichier );
	}

	public void render(int x, int y, int z) {
		
        Enumeration tn = faces.keys();
        while(tn.hasMoreElements()) {
	        String str = (String) tn.nextElement();
	        render(x, y, z, str);
        }
        
	}

	/*
	 * obj.render( int x, int y, int z )
	 * Utile pour le rendu dans le monde uniquement.
	 * Cette méthode effectue le rendu, elle doit être fait en dernier.
	 * Attribut :
	 * int x : Position du Block sur l'axe X
	 * int y : Position du Block sur l'axe Y
	 * int z : Position du Block sur l'axe Z
	 */
	public void render(int x, int y, int z, String str) {

		Tessellator tess = Tessellator.instance;
		
        int t, v;
        double dx, dy, pu, pv, iu, iv, lu, lv, px, py, pz;
        double[] point;
		
        ArrayList face = (ArrayList) faces.get(str);
        
        for (int i = 0; i < face.size(); i++) {
            for( int j = 0; j < 4 ; j++ ) {
            	
            	v = getVindex(face, i, j);
    	        t = getTindex(face, i, j);
            	icon = getIcon(str, i);
            	
    	        iu = icon.getMinU();
    	        iv = icon.getMinV();
    	        lu = icon.getMaxU()-iu;
    	        lv = icon.getMaxV()-iv;
    	        
            	pu = ((double[]) texture.get(t))[0];
            	pv = ((double[]) texture.get(t))[1];
            	
    	        point = (double[]) vertex.get(v);
    	        px = x-point[0]+1+((double[]) offset.get(str))[0]+defaultoffset[0];
    	        py = y+point[1]+((double[]) offset.get(str))[1]+defaultoffset[1];
    	        pz = z-point[2]+((double[]) offset.get(str))[2]+defaultoffset[2];
    	        dx = iu+(lu*pu);
    	        dy = iv+(lv*(1-pv));
    	        tess.addVertexWithUV(px, py, pz, dx, dy);
            }
		}
		
	}

	/*
	 * obj.renderInventory( Renderer renderer )
	 * Utile pour le rendu dans l'inventaire uniquement.
	 * Cette méthode effectue le rendu dans l'inventaire et en item, elle doit être fait en dernier.
	 * Attribut : Renderer renderer : Instance de la classe Renderer
	 */
	public void renderInventory(RenderBlocks renderer) {
		
		Tessellator tess = Tessellator.instance;
        GL11.glTranslatef(-.5F, -.5F, -.5F);

        int t, v;
        double dx, dy, pu, pv, iu, iv, lu, lv;
        double[] point;
        
        Enumeration tn = faces.keys();
        while(tn.hasMoreElements()) {
	        String str = (String) tn.nextElement();
	        ArrayList face = (ArrayList) faces.get(str);
	        
	        for (int i = 0; i < face.size(); i++) {
	            tess.startDrawingQuads();
	            tess.setNormal(0, 1, 0);
	            for( int j = 0; j < 4 ; j++ ) {
	            	
	            	v = getVindex(face, i, j);
	    	        t = getTindex(face, i, j);
	            	icon = getIcon(str, i);

	            	iu = icon.getInterpolatedU(renderer.renderMinX * 16.0D);
	    	        iv = icon.getInterpolatedV(renderer.renderMinZ * 16.0D);
	    	        lu = icon.getInterpolatedU(renderer.renderMaxX * 16.0D)-iu;
	    	        lv = icon.getInterpolatedV(renderer.renderMaxZ * 16.0D)-iv;
	    	        
	            	pu = ((double[]) texture.get(t))[0];
	            	pv = ((double[]) texture.get(t))[1];

	    	        point = (double[]) vertex.get(v);
	    	        dx = iu+(lu*pu);
	    	        dy = iv+(lv*(1-pv));
	    	        tess.addVertexWithUV(point[0], point[1], point[2]+1, dx, dy);
	    	        
	            }
	            tess.draw();
			}
        }
    
        GL11.glTranslatef(.5F, .5F, .5F);
        
	}
	
	
	
	
	
	


	/*
	 * obj.icon( Icon icon, String name, int face )
	 * Utile pour le rendu dans le monde et dans l'inventaire.
	 * Cette méthode définie une texture pour une face du .obj
	 * Attribut :
	 * Icon icon : Icon définie dans votre classe Block.
	 * String name: le nom de l'élément, inscrit dans le .obj sur les lignes commençant par "o "
	 * int face : le numéro de la face, vous pouvez compter dans le .obj, les lignes "f "
	 */
	public void icon( Icon icon, String forme, int face ) {
		faceIcon.put(forme+face, icon);
	}
	
	/*
	 * obj.icon( Icon icon, String name )
	 * Utile pour le rendu dans le monde et dans l'inventaire.
	 * Cette méthode définie une texture pour un des éléments du .obj
	 * Attribut :
	 * Icon icon : Icon définie dans votre classe Block.
	 * String name: le nom de l'élément, inscrit dans le .obj sur les lignes commençant par "o "
	 */
	public void icon( Icon icon, String name ) {
		icon( icon, name, 0 );
	}
	
	/*
	 * obj.icon( Icon icon )
	 * Utile pour le rendu dans le monde et dans l'inventaire.
	 * Cette méthode définie une texture pour l'ensemble du modèle .obj
	 * Attribut : Icon icon : Icon définie dans votre classe Block.
	 */
	public void icon( Icon icon ) {
		defaultIcon = icon;
	}

	/*
	 * obj.offset( Float offset, String axe, String name )
	 * Utile pour le rendu dans le monde uniquement.
	 * Cette méthode déplace l'ensemble de l'élément choisit sur l'axe choisit.
	 * Attribut :
	 * Float offset : Icon définie dans votre classe Block.
	 * String axe : le nom de l'axe "x" "y" ou "z"
	 * String name: le nom de l'élément, inscrit dans le .obj sur les lignes commençant par "o "
	 */
	public void offset(double off, String axe, String element) {
		int naxe = 0;
		if(axe == "y") naxe = 1;
		if(axe == "z") naxe = 2;
		((double[]) offset.get(element))[naxe] = off;
	}

	/*
	 * obj.offset( Float offset, String axe )
	 * Utile pour le rendu dans le monde uniquement.
	 * Cette méthode déplace l'ensemble le modèle sur l'axe choisit.
	 * Attribut :
	 * Float offset : Icon définie dans votre classe Block.
	 * String axe : le nom de l'axe "x" "y" ou "z"
	 */
	public void offset(double off, String axe) {
		int naxe = 0;
		if(axe == "y") naxe = 1;
		if(axe == "z") naxe = 2;
		defaultoffset[naxe] = off;
	}
	
	
	
	
	
	

	private int getVindex(ArrayList face, int i, int j) {
    	
    	if( ((String[][]) face.get(i))[j][0] != null )
    		return Integer.parseInt(((String[][]) face.get(i))[j][0])-1;
    	
    	return Integer.parseInt(((String[][]) face.get(i))[j-1][0])-1;
		
	}
	
	private int getTindex(ArrayList face, int i, int j) {
        
        if( ((String[][]) face.get(i))[j].length == 2 )
        	if( ((String[][]) face.get(i))[j][1] != null )
        		return Integer.parseInt(((String[][]) face.get(i))[j][1])+3;
        
        return j;
		
	}
	
	private Icon getIcon(String str, int i) {
		return faceIcon.get(str+i) != null ? (Icon) faceIcon.get(str+i) : ( faceIcon.get(str+0) != null ? (Icon) faceIcon.get(str+0) : ( defaultIcon ) );
    }
	
}