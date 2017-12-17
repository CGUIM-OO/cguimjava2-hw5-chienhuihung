
public class Card {
	enum Suit {Club, Diamond, Heart, Spade};//Suit的Types為enumerated Types,而裡面有四種花色
	Suit suit;//宣告suit是Suit
		//private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
		private int rank; //1~13
		/**
		 * @param s suit
		 * @param r rank
		 */
		public Card(Suit s,int r){//Card的花色型態改變所以s前面也要改為Suit
			suit =s;
			rank=r;
		}	
		//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
		public void printCard(){
			//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
	     String suitname="";//創一個變數來儲存suit的花色名稱
	     String rankname="";//創一個變數來儲存rank的數值名稱
			if(suit==Suit.Club)//如果suit是Suit裡面的Club的話
				suitname="Clubs";//suit的名稱是Clubs
			else if(suit==Suit.Diamond)//其他的，如果suit是Suit裡面的Diamond的話
				suitname="Diamonds";//suit的名稱是Diamonds
			else if(suit==Suit.Heart)//其他的，如果suit是Suit裡面的Heart的話
				suitname="Hearts";//suit的名稱是Hearts
			else//其他剩下的，也就是suit是Suit.Spade
				suitname="Spades";//suit的名稱是Spades
			if(rank==1)//如果rank是1的話
				rankname="Ace";//rank的名稱是Ace
			else if(rank==11)//其他的，如果rank是11的話
				rankname="Jack";//rank的名稱是Jack
			else if(rank==12)//其他的，如果rank是12的話
				rankname="Queen";//rank的名稱是Queen
			else if(rank==13)//其他的，如果rank是13的話
				rankname="King";//rank的名稱是King
			else//其他剩下的，包含2,3,4,5,6,7,8,9,10
				rankname=(rank+"");//rank的名稱是原本rank的值
			System.out.println(suitname+" "+rankname);//print出花色名稱和值的名稱
		}
		public Suit getSuit(){//suit的回傳形態要改為Suit
			return suit ;
		
		}
		public int getRank(){
			return rank;
		}
	
}
