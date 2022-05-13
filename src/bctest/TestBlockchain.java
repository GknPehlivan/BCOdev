public class TestBlockchain {

	public static void main(String args[]) 
        {
		
		Blockchain gpCoin = new Blockchain();
		
		Block a = new Block("0x200", new java.util.Date(), "<transactions>");
		Block b = new Block("0x200", new java.util.Date(), "<transactions>");
		Block c = new Block("0x200", new java.util.Date(), "<transactions>");
		
		gpCoin.blockEkle(a);
		gpCoin.blockEkle(b);
		gpCoin.blockEkle(c);				
		
		gpCoin.displayChain();
		
		gpCoin.isValid();

	}	
}
