import java.util.ArrayList;
import java.util.List;

public class Blockchain {

	private List<Block> chain;
	
	public Blockchain() {
		chain = new ArrayList<Block>();
		chain.add(ilkBlockOlustur());
	}
	
	private Block ilkBlockOlustur() {
		Block ilkBlock = new Block("0x200", new java.util.Date(), "<transactions>");
		ilkBlock.setPreviousHash(null);
		ilkBlock.Hashle();
		return ilkBlock;
	}
	
	public void blockEkle(Block block) {
		Block yeniBlock = block;
		yeniBlock.setPreviousHash(chain.get(chain.size()-1).getHash());
		yeniBlock.Hashle();
		this.chain.add(yeniBlock);
	}
	
	public void displayChain() {
		
		for(int i=0; i<chain.size(); i++) {
			System.out.println("Block: " + i);
			System.out.println("Version: " + chain.get(i).getVersion());
			System.out.println("Timestamp: " + chain.get(i).getTimestamp());
			System.out.println("PreviousHash: " + chain.get(i).getPreviousHash());
			System.out.println("Hash: " + chain.get(i).getHash());
			System.out.println();
		}
		
	}
	
	public Block sonBlockGetir() {
		return this.chain.get(chain.size()-1);
	}
	
	public void isValid() {
		
		for(int i=chain.size()-1; i>0; i--) {
			if(   !(chain.get(i).getHash().equals(chain.get(i).Hashle()))   ) {
				System.out.println("Chain gecerli degildir.");
				return;
			}
			
			if(  !(chain.get(i).getPreviousHash().equals(chain.get(i-1).Hashle()))  ) {
				System.out.println("Chain gecerli degildir.");
				return;
			}
		}
		
		System.out.println("Chain gecerlidir.");
		
	}
	
	
}
