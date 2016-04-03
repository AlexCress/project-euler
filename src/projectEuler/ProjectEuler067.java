package projectEuler;


/**
 * Uses ProjectEuler018 implementation as this is the same problem only on a larger scale.
 * Solves a 100-row number triangle in about 1ms.
 * 
 * @author Alex
 *
 */
public class ProjectEuler067 {
	
	public int solve(String fileName){
		ProjectEuler018 pe = new ProjectEuler018(fileName);
		return pe.solve();
	}
}
