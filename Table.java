import java.util.ArrayList;

public class Table {
	int MAXPLAYER = 4;//長度為4的MAXPLAYER
	private Deck deck;//一型別為Deck的變數(instance field)，存放所有的牌
	private Player[] player;//一型別為Player[] 的變數(instance field)，存放所有的玩家
	private Dealer dealer;//一型別為Dealer 的變數(instance field)，存放一個莊家
	private int[] pos_betArray;// int[] pos_betArray，存放每個玩家在一局下的注(instance field)
	public Table(int nDeck){//Constructor, 輸入參數為 int nDeck
		deck=new Deck(nDeck);//，實體化，deck存入上述新增的Deck變數(instance field) 
		player=new Player[MAXPLAYER];//Player[]的變數(instance field)，宣告一個長度是MAXPLAYER 的Player array
	}
	public void set_player(int pos, Player p){//將Player放到牌桌上 ，pos為牌桌位置，最多MAXPLAYER人，p則為Player instance
		if(player.length>=pos&&pos>=0)
			player[pos]= p;//Player p 等於player[pos]，pos為牌桌位置
		}
	public Player[] get_player()//回傳所有在牌桌上的player
	{return player;}
	public void set_dealer(Dealer d)//將Dealer放到牌桌上
	{dealer=d;}
	public Card get_face_up_card_of_dealer(){return dealer.getOneRoundCard().get(1);}//回傳dealer打開的那張牌，也就是第二張牌
	private void ask_each_player_about_bets()
	{pos_betArray=new int[player.length];//實體化pos_betArray的長度
		for(int i=0;i<player.length;i++)
		{player[i].say_Hello();//請每個玩家打招呼
		pos_betArray[i]=player[i].make_bet();}//請每個玩家下注，每個玩家下的注要存在pos_betArray供之後使用
	}
	private void distribute_cards_to_dealer_and_players()//發牌給玩家跟莊家
	{ArrayList<Card> player1Card=new ArrayList<Card>();//實體化一個Card的變數player1Card來存放deck.getOneCard()
	 Player player1=player[0];//令一個變數為player1=player[0]
	 player1Card.add(deck.getOneCard(true));//先發兩張打開的牌給玩家，將卡加在player1Card裡
	 player1Card.add(deck.getOneCard(true));
	 player1.setOneRoundCard(player1Card);//將卡建立在player1.setOneRoundCard()裡
	 ArrayList<Card> player2Card=new ArrayList<Card>();//實體化一個Card的變數player2Card來存放deck.getOneCard()
	 Player player2=player[1];//令一個變數為player2=player[1]
	 player2Card.add(deck.getOneCard(true));//發兩張打開的牌給玩家，將卡加在player2Card裡
	 player2Card.add(deck.getOneCard(true));
	 player2.setOneRoundCard(player2Card);//將卡建立在player2.setOneRoundCard()裡
	 ArrayList<Card> player3Card=new ArrayList<Card>();//實體化一個Card的變數player3Card來存放deck.getOneCard()
	 Player player3=player[2];//令一個變數為player3=player[2]
	 player3Card.add(deck.getOneCard(true));//發兩張打開的牌給玩家，將卡加在player3Card裡
	 player3Card.add(deck.getOneCard(true));
	 player3.setOneRoundCard(player3Card);//將卡建立在player3.setOneRoundCard()裡
	 ArrayList<Card> player4Card=new ArrayList<Card>();//實體化一個Card的變數player4Card來存放deck.getOneCard()
	 Player player4=player[3];//令一個變數為player4=player[3]
	 player4Card.add(deck.getOneCard(true));//發兩張打開的牌給玩家，將卡加在player4Card裡
	 player4Card.add(deck.getOneCard(true));
	 player4.setOneRoundCard(player4Card);//將卡建立在player4.setOneRoundCard()裡
	 ArrayList<Card> dealer1Card=new ArrayList<Card>();//實體化一個Card的變數dealer1Card來存放deck.getOneCard()
	// Dealer dealer1= dealer;
	 dealer1Card.add(deck.getOneCard(false));//發一張蓋的牌給莊家，將卡加在dealer1Card裡
	 dealer1Card.add(deck.getOneCard(true));//發一張打開的牌給莊家，將卡加在dealer1Card裡
	 dealer.setOneRoundCard(dealer1Card);//將卡建立在dealer.setOneRoundCard()裡
	 System.out.print("Dealer's face up card is "); //將Dealer打開的卡印出來
	 Card c=get_face_up_card_of_dealer();//呼叫method get_face_up_card_of_dealer()
	 c.printCard();}//將get_face_up_card_of_dealer()回傳的卡印出來
	
	private void ask_each_player_about_hits(){//問每個玩家
		for(int i=0;i<player.length;i++)
		{
		System.out.print(player[i].getName()+ "’s cards now: ");//請在畫面上印出"玩家的名字+ "’s cards now: "
		player[i].printAllCard();//目前兩張的牌
		hitsCard(i,player[i].getOneRoundCard());}//呼叫hitsCard()的method要傳入i值和player[i].getOneRoundCard()
		}
		private void hitsCard(int a,ArrayList<Card> cards){//目的是要知道player要不要牌
			boolean hit;//用hit儲存要不要牌
		   do{
			  hit=player[a].hit_me(this);//問每個玩家要不要牌
			 if(hit){//如果玩家要牌
			 	cards.add(deck.getOneCard(true));//就加一張牌進去
			 	player[a].setOneRoundCard(cards);
				//將cards建立在player的setOneRoundCard，將新的牌用setOneRoundCard()設定回玩家物件
			   System.out.print("Hit! ");//在畫面上印出"Hit! "
			   System.out.print(player[a].getName()+"'s Cards now:");//玩家的名字+ "’s cards now: "
			   player[a].printAllCard();//，並把玩家要牌後的完整牌印出
			 	if( player[a].getTotalValue()>21)//如果爆了，請不要再問玩家是否要牌
				   {hit=false;//將hit設為false
				   System.out.println(player[a].getName()+", hit is over!");}	
				 }
			 else{
				 System.out.println(player[a].getName()+", Pass hit!");//如果玩家不要牌了，請在畫面上印出 玩家的名字+"Pass hit!"
				 System.out.println(player[a].getName()+", hit is over!");
					
				}
			 }while(hit);//do while至少執行一次
			
		}
			private void ask_dealer_about_hits(){//詢問莊家是否要牌
				hitsDealerCard(dealer.getOneRoundCard());}//呼叫hitsDealerCard來判斷要不要牌，傳入dealer.getOneRoundCard()
			private void hitsDealerCard(ArrayList<Card> cardss){//判斷莊家要不要牌
				boolean hits;//用hits儲存要不要牌
				do{
					hits=dealer.hit_me(this);//問莊家要不要牌
					if( dealer.getTotalValue()>21)//如果爆了，請不要再莊家是否要牌
					  {hits=false;}//將hits設為false
				if(hits){//如果莊家要牌
					cardss.add(deck.getOneCard(true));//就加一張牌進去
					dealer.setOneRoundCard(cardss);//將新的牌用setOneRoundCard()設定回莊家物件
					if( dealer.getTotalValue()>21)//如果爆了，請不要再莊家是否要牌
					  {hits=false;}	//將hits設為false
					}
				
			       }while(hits);//do while至少執行一次
			  	System.out.print("Dealer's hit is over!");}//完成後，印出"Dealer's hit is over!"
			private void calculate_chips()//比較莊家跟每一個玩家的牌
			 {System.out.print("Dealer's card value is "+ dealer.getTotalValue()+ " ,Cards:");//印出dealer所有牌的總和
			  dealer.printAllCard(); //印出dealer所有的牌
			for(int b=0;b<player.length;b++)//用for迴圈來得出每位player
				{System.out.print("Palyer"+ (b+1)+"'s Cards:");//印出現在player是誰
			     player[b].printAllCard();//印出現在player所有的牌
			     System.out.print(player[b].getName()+" card value is "+player[b].getTotalValue());////印出現在player所有牌的總和
			     if(dealer.getTotalValue()>21&&player[b].getTotalValue()>21)//平手的情況，莊家和玩家都爆掉
				  {System.out.println(",chips have no change! The Chips now is: "+player[b].get_current_chips());}//chips不變
			     if(dealer.getTotalValue()<21&&player[b].getTotalValue()<21&&dealer.getTotalValue()==player[b].getTotalValue())//平手的情況，莊家和玩家都沒爆掉但點數相同
			      {System.out.println(",chips have no change! The Chips now is: "+player[b].get_current_chips());}//chips不變
			     if(dealer.getTotalValue()<=21&&player[b].getTotalValue()<=21&&dealer.getTotalValue()>player[b].getTotalValue())//莊家贏，玩家輸，玩家點數小於莊家
			      { player[b].increaseChips(-pos_betArray[b]);//玩家的chips減掉下注的錢，下注的錢被收走
				     System.out.println(", Loss "+pos_betArray[b]+" Chips, the Chips now is: "+player[b].get_current_chips());}//玩家輸
			     if(dealer.getTotalValue()<=21&&player[b].getTotalValue()>21)//莊家贏，玩家輸，玩家點數爆掉
			      {player[b].increaseChips(-pos_betArray[b]);//玩家的chips減掉下注的錢，下注的錢被收走
				     System.out.println(", Loss "+pos_betArray[b]+" Chips, the Chips now is: "+player[b].get_current_chips());}//玩家輸
			     if(dealer.getTotalValue()>21&&player[b].getTotalValue()<=21)//玩家贏，莊家輸，莊家點數爆掉
			      {player[b].increaseChips(pos_betArray[b]);//玩家的chips加上下注的錢，得到下注的錢
				     System.out.println(",Get "+pos_betArray[b]+" Chips, the Chips now is: "+player[b].get_current_chips());}//玩家贏
			     if(dealer.getTotalValue()<=21&&player[b].getTotalValue()<=21&&dealer.getTotalValue()<player[b].getTotalValue())//玩家贏，莊家輸，莊家點數小於玩家
			      {player[b].increaseChips(pos_betArray[b]);//玩家的chips加上下注的錢，得到下注的錢
			      System.out.println(",Get "+pos_betArray[b]+" Chips, the Chips now is: "+player[b].get_current_chips());}//玩家贏
			  }
			}
			public int[] get_players_bet()//得到player下注的錢
			 {return pos_betArray; }
			
			public void play(){
				ask_each_player_about_bets();//問每個player的籌碼
				distribute_cards_to_dealer_and_players();//發牌給玩家和莊家
				ask_each_player_about_hits();//問每個玩家要不要牌
				ask_dealer_about_hits();//問莊家要不要牌
				calculate_chips();//計算chips有三種情形平手，玩家贏和玩家輸
			}
}
