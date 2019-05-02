package ExponentialDist;

//import java.util.Random;
//
//public class PseudoErlangK2Dist extends Dist{
//   public static final int REAPEAT = 10000;
//   public int lambda;
//   public double prob;
//   public int[] recordEachInterval;
//   //----------------------------
//   public double compareMean;
//   public double compareVariance;
//   int failureCount=0;
//   //----------------------------
//   
//   public PseudoErlangK2Dist(int domain, int lambda) { //도메인 1000, 람다 4
//      super(domain);
//      this.lambda = lambda;
//      this.prob = lambda/domain;
//      recordEachInterval = new int[domain];
//      
//      for(int i=0;i<this.recordEachInterval.length;i++) {
//         this.recordEachInterval[i] = 0;
//      }
//   }
//   
//   public void simulatePseudoErlangK2Dist() {
//       //0 ~ domain-1 중에서 난수 하나 뽑아서 그 난수가 람다보다 작다면 success!
//      int i=0, j=0;
//      
//      for(i=0;i<REAPEAT;i++) {
//         Random rnd = new Random();
//         int firstSuccess = 0, secondSuccess = 0, thirdSuccess = 0, fourthSuccess = 0;
//         //int tmp1, tmp2;
//         for(j=0;j<domain;j++) {
//            int isThisSuccess = rnd.nextInt(domain);
//            //System.out.println(j + "th : " + isThisSuccess);
////            if(isThisSuccess < lambda && firstSuccess == 0) { //관측이 성공 && 아직 성공 X
////               firstSuccess = j;
////            }
////            
////            if(isThisSuccess < lambda && firstSuccess == j-1) { //관측이 성공 && 직전 관측에 성공 -> 첫번째 연속된 두 번의 성공
////               secondSuccess = j;
////            }
////            
////            if(isThisSuccess < lambda && secondSuccess != 0 ) { //관측이 성공 && 이미 두 번 성공
////               thirdSuccess = j;
////            }
////            
////            if(isThisSuccess < lambda && firstSuccess != 0 && thirdSuccess == j-1) { //관측이 성공 && 직전 관측에 성공 -> 두번째 연속된 두 번의 성공
////               fourthSuccess = j;
////               break;
////            }
//         }
//         //System.out.println("두 번째 연속된 두 번의 성공이 관측된 직후 : " + fourhtSuccess + "  " + secondSuccess);
//         if(fourthSuccess - secondSuccess < 0) {
//            failureCount++;
//            System.out.println("At " + i + "th repeat, " +  j + "th try, Something went wrong");
//            System.out.println(fourthSuccess + " - " + secondSuccess + " = " + (fourthSuccess - secondSuccess));
//            //System.exit(0);
//         }
//         if(fourthSuccess != 0) {
//            //System.out.println("At " + i + "th repeat, " + (thirdSuccess - firstSuccess));
//            this.recordEachInterval[fourthSuccess - secondSuccess]++;
//         }
//      }
//      double m=0;
//      double p=0;
//      for(i=0;i<this.pointSet.length;i++) {
//         this.pointSet[i].x = i;
//         this.pointSet[i].value = (double)i/domain;
//         this.pointSet[i].y = (double)(this.recordEachInterval[i])/REAPEAT;
//         
////         if(this.pointSet[i].y != 0) {
////            //System.out.println("(" + pointSet[i].x + ", " + pointSet[i].y + ") : " + pointSet[i].value);
////            m = m + (this.pointSet[i].value*this.pointSet[i].y);   
////            //System.out.println((this.pointSet[i].value*this.pointSet[i].y) + "를 더해서 " + m + "이 되었다.");
////            p += pointSet[i].y;
////         }
//         compareMean += (double)i/domain * (double)(this.recordEachInterval[i])/(REAPEAT);
//         compareVariance += (double)i/domain * (double)i/domain * (double)(this.recordEachInterval[i])/(REAPEAT);
//      }
//      //System.out.println(m);
//      //System.out.println(p);
//      compareVariance -= compareMean * compareMean;
//      
//   }
//   
//   public void showData() {
//      System.out.println("Show data : ");
////      for(int i=0;i<pointSet.length;i++) 
////         System.out.println("(" + pointSet[i].x + ", " + pointSet[i].y + ") : " + pointSet[i].value);
//      System.out.println("failureCount : " + failureCount);
//      System.out.println("Domain : 0 <= x <= " + (domain-1));
//      System.out.println("k : " + 2 + ", lambda : " + lambda);
//      System.out.println("Mean : " + getMean());
//      System.out.println("compareMean : " + compareMean);
//      System.out.println("Variance : " + getVariance());
//      System.out.println("compareVariance : " + compareVariance);
//   }
//}

import java.util.Random;

public class PseudoErlangK2Dist extends Dist{
   public static final int REAPEAT = 100;
   public int ramda;
   public double prob;
   public int[] recordEachInterval;
   public int failureCount;
   
   public PseudoErlangK2Dist(int domain, int ramda) { // 1000,  4
      super(domain);
      this.ramda = ramda;
      this.prob = ramda/domain;
      recordEachInterval = new int[domain];
      
      for(int i=0;i<this.recordEachInterval.length;i++) {
         this.recordEachInterval[i] = 0;
      }
   }
   
   public void simulatePseudoErlangK2Dist() {
      int i=0, j=0;
      
      for(i=0;i<REAPEAT;i++) {
         Random rnd = new Random();
         int firstSuccess = -1, secondSuccess = -1, thirdSuccess = -1;
         //int tmp1, tmp2;
         for(j=0;j<domain;j++) {
            int isThisSuccess = rnd.nextInt(domain);
            //System.out.println(j + "th : " + isThisSuccess);
            if(isThisSuccess < ramda && firstSuccess == -1) {
               firstSuccess = j;
            }
            
            if(isThisSuccess < ramda && firstSuccess != -1  && secondSuccess == -1) {
               secondSuccess = j;
            }
            
            if(isThisSuccess < ramda && secondSuccess != -1) {
               thirdSuccess = j;
               break;
               //break;
            }
         }
         if(thirdSuccess - firstSuccess < 0) {
            failureCount++;
            //System.out.println("At " + i + "th repeat, " +  j + "th try, Something went wrong");
            //System.out.println(thirdSuccess + " - " + firstSuccess + " = " + (thirdSuccess - firstSuccess));
            //System.exit(0);
         }
         if(thirdSuccess != -1) {
            //System.out.println("At " + i + "th repeat, " + (thirdSuccess - firstSuccess));
            this.recordEachInterval[thirdSuccess - firstSuccess]++;
         }
         System.out.println(firstSuccess + " " + secondSuccess + " " + thirdSuccess);
      }
      double m=0;
      double p=0;
      for(i=0;i<this.pointSet.length;i++) {
         this.pointSet[i].x = i;
         this.pointSet[i].value = (double)i/domain;
         this.pointSet[i].y = (double)(this.recordEachInterval[i])/(REAPEAT-failureCount);
      }
      //System.out.println(m);
      //System.out.println(p);
      
         
   }

}