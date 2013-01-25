package com.mersetoceans.common.maree;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

import com.mersetoceans.MersEtOceans;
import com.mersetoceans.common.TileEntityVague;

public class TimerVague extends TimerTask {
	
	public void run() {

		if( MersEtOceans.vagues != null ) {

			World world = Minecraft.getMinecraft().theWorld;
			
			for( Iterator<ArrayList[]> i = MersEtOceans.vagues.iterator(); i.hasNext();) {
        		ArrayList[] vague = (ArrayList[]) i.next();

        		ArrayList<int[]> vagueLO = vague[0];
        		ArrayList<double[]> vagueLP = vague[1];
    			System.out.println(vagueLP.size());

        		int[] vagueO = vagueLO.get(0);
        		
				vagueO[0] = ++vagueO[0];
				
				int nbs = vagueLP.size();
    			for( int k = 0; k < nbs; k++ ) /*if( vagueLP.get(k) == null )*/ {
    				double[] vagueP = vagueLP.get(k);
    				
	    			world.setBlock((int) vagueP[0], (int) vagueP[1], (int) vagueP[2], 0);
    				
    				vagueP[0] = vagueO[1] + (vagueO[0] * Math.cos(vagueP[3]));
    				vagueP[2] = vagueO[2] + (vagueO[0] * Math.sin(vagueP[3]));
					
	    			if( world.getBlockId( (int) vagueP[0], (int) vagueP[1], (int) vagueP[2] ) == 0 )
		    			world.setBlock( (int) vagueP[0], (int) vagueP[1], (int) vagueP[2], MersEtOceans.vague.blockID);
	    			
	    			if( world.getBlockId( (int) vagueP[0], (int) vagueP[1]-1, (int) vagueP[2] ) != 9 )
	    				vagueLP.remove(k);
	    			
	    			int big = vagueO[0]%10;

	    			if( big == 0 ) {
	    				
	    				double[] NvagueP = {0, vagueP[1], 0, vagueP[3]};
		    			
	    				if( world.getBlockId( (int) NvagueP[0], (int) NvagueP[1], (int) NvagueP[2] ) == 0 ) {
	    					
		    				NvagueP[0] = Math.cos(vagueP[3]+Math.PI/2)+vagueP[0];
		    				NvagueP[2] = Math.sin(vagueP[3]+Math.PI/2)+vagueP[2];
		    				NvagueP[3] = -Math.atan2( NvagueP[2]-vagueO[2], NvagueP[0]-vagueO[1] );
	    				
			    			world.setBlock( (int) NvagueP[0], (int) NvagueP[1], (int) NvagueP[2], MersEtOceans.vague.blockID);

			        		vagueLP.add(NvagueP);
	    				}
		        		
		        		//--------

	    				if( world.getBlockId( (int) NvagueP[0], (int) NvagueP[1], (int) NvagueP[2] ) == 0 ) {
	    					
		    				NvagueP[0] = Math.cos(vagueP[3]-Math.PI/2)+vagueP[0];
		    				NvagueP[2] = Math.sin(vagueP[3]-Math.PI/2)+vagueP[2];
		    				NvagueP[3] = -Math.atan2( NvagueP[2]-vagueO[2], NvagueP[0]-vagueO[1] );
		    				
				    		world.setBlock( (int) NvagueP[0], (int) NvagueP[1], (int) NvagueP[2], MersEtOceans.vague.blockID);
		    				
			        		vagueLP.add(NvagueP);
	    				}
	    				
	    			}
	    			
    			}
			}
			
		}
    	
    }
}