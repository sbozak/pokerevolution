package genetics;


import java.util.ArrayList;

public class Genome {
	
	private ArrayList<Gene> _genes;
	
	public Genome(){
		_genes = new ArrayList<Gene>();
	}
	
	public Genome(ArrayList<Gene> genes_){
		_genes = genes_;
	}
	
	public void AddGene(Gene gene_){
		_genes.add(gene_);
	}
	
	public ArrayList<Gene> getGenes(){
		return _genes;
	}
	

}
