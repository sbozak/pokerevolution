package game;



public class Hand implements Comparable {

  public final static int HIGHCARD = 0, // Value of hands
                          PAIR = 1,
                          TWOPAIR = 2,
                          TRIPS = 3,
                          STRAIGHT = 4,
                          FLUSH = 5,
                          FULLHOUSE = 6,
                          FOUROFAKIND = 7,
                          STRAIGHTFLUSH = 8;
  private int _handValue;
  private int _topCard;
  private int _secondCard;
  private int _kicker1;
  private int _kicker2;
  private int _kicker3;
  private Card[] _fiveCardHand;

  public Hand(Card[] cards_) {
    sortCardsHighToLow(cards_);
    _topCard=cards_[4].getRank().value;
    _secondCard=cards_[3].getRank().value;
    _kicker1=cards_[2].getRank().value;
    _kicker2=cards_[1].getRank().value;
    _kicker3=cards_[0].getRank().value;
    _handValue = checkFiveCardHand(cards_);
    _fiveCardHand = cards_;
  }

  public int checkFiveCardHand(Card[] myHand){
    if(checkForStraightFlush(myHand)){
      _topCard=myHand[4].getRank().value;
      return STRAIGHTFLUSH;
    }
    if(checkForFourOfAKind(myHand)){
      return FOUROFAKIND;
    }
    if (checkForFullHouse(myHand)){
      return FULLHOUSE;
    }
    if (checkForFlush(myHand)){
      return FLUSH;
    }
    if (checkForStraight(myHand)){
      return STRAIGHT;
    }
    if (checkForTrips(myHand)){
      return TRIPS;
    }
    if (checkForTwoPair(myHand)){
      return TWOPAIR;
    }
    if (checkForPair(myHand)){
      return PAIR;
    }
    _handValue=0;
    return HIGHCARD;
  }

  private static Card[] sortCardsHighToLow(Card[] myHand)
  {
    //myHand[0] is the lowest card
    //myHand[4] is the highest card
    for (int i = (myHand.length-1); i >= 1; i--)
          for (int j = 0; j <= (i-1); j++)
              if (myHand[j].getRank().value > myHand[j+1].getRank().value){
                Card temp = myHand[j];
                myHand[j]=myHand[j+1];
                myHand[j+1]=temp;
              }
    return myHand;
  }

  private boolean checkForStraightFlush(Card[] myHand){
    if(checkForStraight(myHand)&&checkForFlush(myHand)){
      _topCard=myHand[4].getRank().value;

      return true;
    }
    return false;
  }
  
  private boolean checkForFourOfAKind(Card[] myHand){
    if(myHand[0].getRank().value==myHand[1].getRank().value&&
       myHand[0].getRank().value==myHand[2].getRank().value&&
       myHand[0].getRank().value==myHand[3].getRank().value)
    {
      _topCard=myHand[0].getRank().value;
      _secondCard=myHand[4].getRank().value;
      return true;
    }
    if(myHand[0].getRank().value==myHand[1].getRank().value&&
       myHand[0].getRank().value==myHand[2].getRank().value&&
       myHand[0].getRank().value==myHand[4].getRank().value)
    {
      _topCard=myHand[0].getRank().value;
      _secondCard=myHand[3].getRank().value;
      return true;
    }
    if(myHand[0].getRank().value==myHand[1].getRank().value&&
       myHand[0].getRank().value==myHand[3].getRank().value&&
       myHand[0].getRank().value==myHand[4].getRank().value)
    {
      _topCard=myHand[0].getRank().value;
      _secondCard=myHand[2].getRank().value;
      return true;
    }
    if(myHand[0].getRank().value==myHand[2].getRank().value&&
       myHand[0].getRank().value==myHand[3].getRank().value&&
       myHand[0].getRank().value==myHand[4].getRank().value)
    {
      _topCard=myHand[0].getRank().value;
      _secondCard=myHand[1].getRank().value;
      return true;
    }
    if(myHand[1].getRank().value==myHand[2].getRank().value&&
       myHand[1].getRank().value==myHand[3].getRank().value&&
       myHand[1].getRank().value==myHand[4].getRank().value)
    {
      _topCard=myHand[1].getRank().value;
      _secondCard=myHand[0].getRank().value;
      return true;
    }
   return false;
 }
  
  private boolean checkForFullHouse(Card[] myHand){
   if(checkForTrips(myHand))
   {
     if(_secondCard==_kicker1){

       return true;
     }
   }
   return false;
 }
 
 private boolean checkForFlush(Card[] myHand){
    if(myHand[0].getSuit()==myHand[1].getSuit()&&
         myHand[0].getSuit()==myHand[2].getSuit()&&
         myHand[0].getSuit()==myHand[3].getSuit()&&
         myHand[0].getSuit()==myHand[4].getSuit())
      {
        _topCard=myHand[4].getRank().value;
        return true;
      }
      return false;

  }
  
  private boolean checkForStraight(Card[] myHand){
    if((myHand[0].getRank().value)==(myHand[1].getRank().value-1)&&
       (myHand[0].getRank().value)==(myHand[2].getRank().value-2)&&
       (myHand[0].getRank().value)==(myHand[3].getRank().value-3)&&
       (myHand[0].getRank().value)==(myHand[4].getRank().value-4))
    {
      _topCard=myHand[4].getRank().value;
      return true;
    }
    if(myHand[4].getRank().value==14){
      if ( (myHand[4].getRank().value - 13) == (myHand[0].getRank().value - 1) &&
          (myHand[4].getRank().value - 13) == (myHand[1].getRank().value - 2) &&
          (myHand[4].getRank().value - 13) == (myHand[2].getRank().value - 3) &&
          (myHand[4].getRank().value - 13) == (myHand[3].getRank().value - 4)) {
        _topCard = myHand[3].getRank().value;
        return true;
      }
    }
    return false;
 }
  
 private boolean checkForTrips(Card[] myHand){
   if(myHand[0].getRank().value==myHand[1].getRank().value&&
         myHand[0].getRank().value==myHand[2].getRank().value)
    {
      _topCard=myHand[0].getRank().value;
      _secondCard=myHand[4].getRank().value;
      _kicker1=myHand[3].getRank().value;
      return true;
    }

    if(myHand[0].getRank().value==myHand[1].getRank().value&&
         myHand[0].getRank().value==myHand[3].getRank().value)
    {
      _topCard=myHand[0].getRank().value;
      _secondCard=myHand[4].getRank().value;
      _kicker1=myHand[2].getRank().value;
      return true;
    }

    if(myHand[0].getRank().value==myHand[1].getRank().value&&
         myHand[0].getRank().value==myHand[4].getRank().value)
      {
        _topCard=myHand[0].getRank().value;
        _secondCard=myHand[3].getRank().value;
        _kicker1=myHand[2].getRank().value;
        return true;
      }

      if(myHand[0].getRank().value==myHand[2].getRank().value&&
         myHand[0].getRank().value==myHand[3].getRank().value)
      {
        _topCard=myHand[0].getRank().value;
        _secondCard=myHand[4].getRank().value;
        _kicker1=myHand[1].getRank().value;
        return true;
      }

      if(myHand[0].getRank().value==myHand[2].getRank().value&&
         myHand[0].getRank().value==myHand[4].getRank().value)
      {
        _topCard=myHand[0].getRank().value;
        _secondCard=myHand[3].getRank().value;
        _kicker1=myHand[1].getRank().value;
        return true;
      }

      if(myHand[0].getRank().value==myHand[3].getRank().value&&
         myHand[0].getRank().value==myHand[4].getRank().value)
      {
        _topCard=myHand[0].getRank().value;
        _secondCard=myHand[2].getRank().value;
        _kicker1=myHand[1].getRank().value;
        return true;
      }

      if(myHand[1].getRank().value==myHand[2].getRank().value&&
         myHand[1].getRank().value==myHand[3].getRank().value)
      {
        _topCard=myHand[1].getRank().value;
        _secondCard=myHand[4].getRank().value;
        _kicker1=myHand[0].getRank().value;
        return true;
      }

      if(myHand[1].getRank().value==myHand[2].getRank().value&&
         myHand[1].getRank().value==myHand[4].getRank().value)
      {
        _topCard=myHand[1].getRank().value;
        _secondCard=myHand[3].getRank().value;
        _kicker1=myHand[0].getRank().value;
        return true;
      }

      if(myHand[1].getRank().value==myHand[3].getRank().value&&
         myHand[1].getRank().value==myHand[4].getRank().value)
      {
        _topCard=myHand[1].getRank().value;
        _secondCard=myHand[2].getRank().value;
        _kicker1=myHand[0].getRank().value;
        return true;
      }

      if(myHand[2].getRank().value==myHand[3].getRank().value&&
         myHand[2].getRank().value==myHand[4].getRank().value)
      {
        _topCard=myHand[2].getRank().value;
        _secondCard=myHand[1].getRank().value;
        _kicker1=myHand[0].getRank().value;
        return true;
      }
   return false;
 }
 
 private boolean checkForTwoPair(Card[] myHand){
   if(checkForPair(myHand)){
     //right now, topCard is any pair, secondCard, kickers are unknown but ordered
     if (_secondCard == _kicker1) {
       _kicker1 = _kicker2;
       return true;
     }

     if (_secondCard == _kicker2) {
       return true;
     }

     if (_kicker1 == _kicker2) {
       int second2pair = _secondCard;
       _secondCard = _kicker1;
       _kicker1 = second2pair;
       return true;
     }

   }

   return false;

 }
 
 private boolean checkForPair(Card[] myHand){
   if(myHand[3].getRank().value==myHand[4].getRank().value)
   {
     _topCard=myHand[3].getRank().value;
     _secondCard=myHand[3].getRank().value;
     _kicker1=myHand[2].getRank().value;
     _kicker2=myHand[1].getRank().value;
     return true;
   }
   if(myHand[2].getRank().value==myHand[3].getRank().value)
   {
     _topCard=myHand[2].getRank().value;
     _secondCard=myHand[4].getRank().value;
     _kicker1=myHand[1].getRank().value;
     _kicker2=myHand[0].getRank().value;
     return true;
   }
   if(myHand[1].getRank().value==myHand[2].getRank().value)
   {
     _topCard=myHand[1].getRank().value;
     _secondCard=myHand[4].getRank().value;
     _kicker1=myHand[3].getRank().value;
     _kicker2=myHand[0].getRank().value;
     return true;
   }
   if(myHand[0].getRank().value==myHand[1].getRank().value)
   {
     _topCard=myHand[0].getRank().value;
     _secondCard=myHand[4].getRank().value;
     _kicker1=myHand[3].getRank().value;
     _kicker2=myHand[2].getRank().value;
     return true;
   }
   return false;
 }

 public static Hand getBest7Hand(Card[] myHand){
   Hand combinations[] = new Hand[21];
    int count = 0;
    for(int i = 0; i<3; i++)
      for(int j = i+1; j<4; j++)
        for(int k = j+1; k<5; k++)
          for(int l = k+1; l<6; l++)
            for(int m = l+1; m<7; m++){
              combinations[count] = new Hand(new Card[]{myHand[i], myHand[j],
                  myHand[k], myHand[l], myHand[m]});
              count++;
            }
    Hand bestHand = combinations[0];
    for(int i = 0; i<count; i++){
      if(bestHand.compareTo(combinations[i])<0)
        bestHand = combinations[i];
    }
    return bestHand;
 }

 public static Hand getBest6Hand(Card[] myHand){
  Hand combinations[] = new Hand[7];
   int count = 0;
   for(int i = 0; i<2; i++)
     for(int j = i+1; j<3; j++)
       for(int k = j+1; k<4; k++)
         for(int l = k+1; l<5; l++)
           for(int m = l+1; m<6; m++){
             combinations[count] = new Hand(new Card[]{myHand[i], myHand[j],
                 myHand[k], myHand[l], myHand[m]});
             count++;
           }
   Hand bestHand = combinations[0];
   for(int i = 0; i<count; i++){
     if(bestHand.compareTo(combinations[i])<0)
       bestHand = combinations[i];
   }
   return bestHand;
}


 public static int onADrawOuts(Card[] myHand){
   int draw=0;
   sortCardsHighToLow(myHand);
   if(((myHand[0].getRank().value)==(myHand[1].getRank().value-1)&&
       (myHand[0].getRank().value)==(myHand[2].getRank().value-2)&&
       (myHand[0].getRank().value)==(myHand[3].getRank().value-3))||

       ((myHand[1].getRank().value)==(myHand[2].getRank().value-2)&&
       (myHand[1].getRank().value)==(myHand[3].getRank().value-3)&&
       (myHand[1].getRank().value)==(myHand[4].getRank().value-4))){
      draw+=8;
    }
    else if(myHand[4].getRank().value==14){
      if (((myHand[4].getRank().value - 13) == (myHand[1].getRank().value - 2) &&
          (myHand[4].getRank().value - 13) == (myHand[2].getRank().value - 3) &&
          (myHand[4].getRank().value - 13) == (myHand[3].getRank().value - 4)) ||
           (myHand[0].getRank().value == (myHand[1].getRank().value - 1) &&
           myHand[0].getRank().value == (myHand[2].getRank().value - 2) &&
           myHand[0].getRank().value == (myHand[3].getRank().value - 3))) {
        draw+=8;
      }
    }
    int temp = 0;
    for(int i = 0;i<4;i++){
      if(myHand[i].getSuit()==myHand[i+1].getSuit())
        temp++;
    }
    if(temp>=4)
      draw+=9;

   return draw;
 }

  public int compareTo(Object target){
    //checks if same type of hand (straight, trips, etc)
    if(((Hand)target)._handValue>_handValue)
      return -1;
    if(((Hand)target)._handValue<_handValue)
      return 1;
    //checks the meaningful card (which trip, how high flush)
    if(((Hand)target)._topCard>_topCard)
      return -1;
    if(((Hand)target)._topCard<_topCard)
      return 1;
    //checks the 2nd card such as the 2nd two pair or a kicker
    if(((Hand)target)._secondCard>_secondCard)
      return -1;
    if(((Hand)target)._secondCard<_secondCard)
      return 1;
    //checks next kicker
    if(((Hand)target)._kicker1>_kicker1)
      return -1;
    if(((Hand)target)._kicker1<_kicker1)
      return 1;
    if(((Hand)target)._kicker2>_kicker2)
      return -1;
    if(((Hand)target)._kicker2<_kicker2)
      return 1;
    if(((Hand)target)._kicker3>_kicker3)
      return -1;
    if(((Hand)target)._kicker3<_kicker3)
      return 1;
    return 0;

  }
  public String toString(){
    String nameOfHand="";
    if(_handValue==STRAIGHTFLUSH)
      nameOfHand="Straight Flush";
    else if(_handValue==FOUROFAKIND)
      nameOfHand="Four of a kind";
    else if(_handValue==FULLHOUSE)
      nameOfHand="Full House";
    else if(_handValue==FLUSH)
      nameOfHand="Flush";
    else if(_handValue==STRAIGHT)
      nameOfHand="Straight";
    else if(_handValue==TRIPS)
      nameOfHand="Trips";
    else if(_handValue==TWOPAIR)
      nameOfHand="Two Pair";
    else if(_handValue==PAIR)
      nameOfHand="Pair";
    else
      nameOfHand="High Card";
    return
        nameOfHand + "\n" + _fiveCardHand[0] + "\n" +
        _fiveCardHand[1] + "\n" + _fiveCardHand[2] +
        "\n" + _fiveCardHand[3] + "\n" +
        _fiveCardHand[4];
  }

}