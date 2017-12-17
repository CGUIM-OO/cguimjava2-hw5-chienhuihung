import java.util.ArrayList;
import java.util.Random;

//import Card.Suit;


public class Deck {
	
	private ArrayList<Card>openCard=new ArrayList<>( );//實體化openCard
	ArrayList<Card>usedCard=new ArrayList<>( );//先將ArrayList的usedCard實體化
	public int nUsed;//先另一個int為nUsed，目的是來儲存有幾張牌被使用過
		int index;//先另一個int為index，目的是要將Card的第index位取出，放在usedCard裡
		
		public void shuffle() {//洗牌功能
			openCard.clear();//因為洗牌，所有牌都回收，所以openCard要清空
			index=-1;//另index為-1,每次只要洗牌index就會變-1
			usedCard.clear();//因為洗牌，所有牌都回收，所以用過的牌也就是usedCard要清空
			nUsed=0;//因為洗牌，所有牌都回收，所以也就沒有用過的牌，所以nUsed為0
			Random rnd = new Random();//有個亂數方法叫rnd
			for(int i=0;i<52;i++)//因為一副牌有52張，所以每張牌都換順序執行52次，i=0，就是cards的第0位，也就是第一張開始
			{int j = rnd.nextInt(51+1);//j是在0到51任一個數，目的是將第i+1張(cards的第i位)跟第j位換
			cards.add(cards.get(i));//先將第i為的值存在第52位也就是第53張牌
			cards.set(i, cards.get(j));//再將第j位的值放在第i位
			cards.set(j, cards.get(52));//之後把cards的第52位，也就是第i位的值，放在第j位
			cards.remove(cards.get(52));//把第52位的值刪掉
		    //以上就是shuffle的做法，先把被蓋住的值儲存在另一個地方，之後再從那個地方取出值放入
		    }
		}
		
		public Card getOneCard(boolean isOpened){//getOneCard的方法，傳入boolean參數，有回傳值(把卡片內容回傳回去)
			index++;//由於shuffle把index設為-1所以+1後是取第0位，之後就+1繼續往後取
			nUsed++;//每取一張排nUsed就+1，因為被用過
			if (nUsed>52)//如果nUsed大於52張
				{shuffle();//就要shuffle因為一副牌只有52張
				index++;//因為shuffle會將index變為-1所以要+1，也就是取shuffle後第0張牌
				nUsed++;//因為shuffle會將nUsed變為零，所以要+1變為使用過1張
				}
				
			if (isOpened==true)//傳入參數如果是true的話
				openCard.add(cards.get(index));//將此卡傳入openCard
			usedCard.add(cards.get(index));//把cards的第index位加入usedCard裡面，方便以後分析使用過後得牌，cards的第index位的值等於usedCard的第index位
			return usedCard.get(index);//把usedCard的第index位的值回傳回去(包含花色和大小)
			
			}
		public ArrayList<Card> getOpenedCard(){//getOpenedCard()的方法
			return openCard;
			}
		private ArrayList<Card> cards;
		//TODO: Please implement the constructor (30 points)
		public Deck(int nDeck){
			 cards=new ArrayList<Card>();
			//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
			//Hint: Use new Card(x,y) and 3 for loops to add card into deck
			//Sample code start
			//Card card=new Card(1,1); ->means new card as clubs ace
			//cards.add(card);
			//Sample code end
			for(int i=1;i<=nDeck;i++)//看有幾副牌，要重複幾次print一副撲克牌
				{for(Card.Suit s : Card.Suit.values())//每副撲克牌有四種花色，從第一個花色到第四個花色
					{for(int y=1;y<=13;y++)//每個花色有13張牌，從1到13
					 {Card card =new Card(s,y);//new一個card，分別是前面花色，後面數值，把花色和值存在卡中
						 cards.add(card);//把含有花色值和數值的card，加入ArrayList的cards裡
						 }
					}
				}
			shuffle();//整副牌都完成後，洗牌，讓牌沒有順序
		}	
		
		//TODO: Please implement the method to print all cards on screen (10 points)
		public void printDeck(){
			//Hint: print all items in ArrayList<Card> cards, 
			//TODO: please implement and reuse printCard method in Card class (5 points)
	        for(Card c:cards)//把ArratList的cards一個一個被取出，存在c裡
			{c.printCard();}//把所有c給print出來
	        
			}
		
		public ArrayList<Card> getAllCards(){
			return cards;
		}
	
}
