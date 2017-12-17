import java.util.ArrayList;

public class Player extends Person {//Player.java繼承Person
        private String name;//name參數
		private int chips;//chips參數
		private int bet;//bet參數
//刪掉Player.java內重複宣告的變數與方
//		private ArrayList<Card> oneRoundCard;//oneRoundCard參數法
		int total;//為了加總oneRandCard的點數
    public Player(String name, int chips){//把player的名字傳入和chips傳入
    	this.name=name;//把傳入的name傳到private String name
    	this.chips=chips;//把傳入的chips傳到private int chips
    }
		public String getName(){//getName()的方法
			return name;}
		public int make_bet(){//makeBet()下注的方法
			if(chips>=0)//如果chips大於0
				bet=1;//就下注一元
			return bet;
		}
//刪掉Player.java內重複宣告的變數與方法
//		public void setOneRoundCard(ArrayList<Card> cards){//setOneRoundCard的方法
//			oneRoundCard=cards;//oneRoundCard另成cards
//		}
		
		public boolean hit_me(Table table){//看要不要牌
			
			total=getTotalValue();//total呼叫getTotalValue方法
			if(total<=16)//如果total小於17的話就要牌，反之不要
				{return true;}
			else
				{return false;}
		}
//刪掉Player.java內重複宣告的變數與方法
//		public int getTotalValue(){//getTotalValue的方法
//			total=0;//total清空
//			for(Card values: oneRoundCard)//取oneRoundCard的每張卡設為values
//			{ if(values.getRank()<10)//如果卡的值小於10的話，直接加到total
//				{total=total+values.getRank();}
//			  else//其他就是10.11.12.13是加10
//				{total=total+10;}}
//			return total;
//		}
		public int get_current_chips(){//取得現在的clips
			return chips;
		}
		public void increaseChips (int diff){//chips的改變
			chips=chips+diff;
		}
		public void say_Hello(){//sayHello的方法
			System.out.println("Hello, I am " + name + ".");
			System.out.println("I have " + chips + " chips.");
		}
}
