/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewprep;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonali's
 */
public class ClearTripChall {
    

public static void main(String args[] ) {
  
   
int grid[][]= new int[5][5]; 
int i, j, k = 1; 
for(i=0; i<5; i++) 
for(j=0; j<5; j++) { 
grid[i][j] = k; 
k++; 
} 
for(i=0; i<5; i++) { 
for(j=0; j<5; j++) 
System.out.print(grid[i][j] + " "); 
System.out.println(); 
  }

  int input[][] = {  {1,4}, 
                     {6,10}, 
                     {6,15}, 
      		     {5,20}, 
        	     {6,9}
  };
int output[][]=new int[5][];
for ( int c = 0 ; c < 5 ; c++ )
      {
         for ( int d = 0 ; d < 2 ; d++ )
            System.out.print(input[c][d]+"\t");
 
         System.out.println();
      }
  int start=0,dest=0;
  List<Integer> startpostlist=new ArrayList<Integer>();
  List<Integer> destpostlist=new ArrayList<Integer>();
     for(int c=0;c<5;c++){
       start=input[c][0];
       startpostlist=findindex(start,grid);
//       System.out.println(startpostlist);
       dest=input[c][1];
       destpostlist=finddestindex(dest,grid);
//       System.out.println(destpostlist);
       int rowCordOfStart=startpostlist.get(0);
       int colCordOfStart=startpostlist.get(1);
       int rowCordOfDest=destpostlist.get(0);
       int colCordOfDest=destpostlist.get(1);
       
        output[c]=new int[(colCordOfDest-colCordOfStart)+1];
       //case 1 : horizontal move
       if(startpostlist.get(0)==destpostlist.get(0)){
       for(int l=0;l<1;l++){
           for(int m=startpostlist.get(1);m<=destpostlist.get(1);m++){
//               System.out.print("horizontal " + grid[startpostlist.get(0)][m]+ " " +"\t" );
//                System.out.println();
              
              output[l][m]=grid[startpostlist.get(0)][m];
              System.out.print(output[l][m]+ " ");
//              System.out.println();
           }     
       }
       }
       //case2 : vertical move
       else if(rowCordOfStart!=rowCordOfDest && colCordOfStart==colCordOfDest){
       for(int l=startpostlist.get(0);l<=destpostlist.get(0);l++){
           for(int m=0;m<1;m++){
//               System.out.println("vertical " + grid[l][destpostlist.get(1)] +" " +"\t");
//                 System.out.println();
           }
           
       }
     }
   //case 3: path where horizontal and vertical both needed 
   if(startpostlist.get(0)!=destpostlist.get(0)&& startpostlist.get(1)!=destpostlist.get(1) ){
       //start Moving
       
       if(colCordOfStart>colCordOfDest){
           for(int l=rowCordOfStart;l<=rowCordOfDest;l++){
               for(int m=0;m<1;m++){
//                    System.out.print("  vertical path includes " + grid[l][colCordOfStart]+ " " +"\t");
//                     System.out.println();
               }
           }
           for(int l=0;l<1;l++){
               for(int m=colCordOfStart-1;m>=colCordOfDest;m--){
//                   System.out.print("  horizontal path includes " + grid[rowCordOfDest][m]+ " " +"\t");
//                     System.out.println();
               }
               
           }
           
       }
       else{
           for(int l=0;l<1;l++){
           for(int m=colCordOfStart;m<colCordOfDest;m++){
//               System.out.print("horizontal path includes " + grid[rowCordOfStart][m] +" " +"\t" );
//                 System.out.println();
           }
       }
           //start moving vertically
           for(int l=rowCordOfStart;l<=rowCordOfDest;l++){
               for(int m=0;m<1;m++){
//                   System.out.print("  vertical path includes " + grid[l][colCordOfDest]+ " " +"\t");
//                     System.out.println();
               }
           }
       }
   }    
}
     }
 static List<Integer> findindex(int startpost,int[][] matrix){
     List<Integer> list=new ArrayList<Integer>();
     int positionleft=0,positionright=0;
          for(int c=0;c<5;c++){
         for(int d=0;d<5;d++){
             if(startpost==matrix[c][d]){
                 positionleft=c;
                 list.add(c);
                 positionright=d;
                 list.add(d);
             }
         } 
 }  
          return list;
   }
 static List<Integer> finddestindex(int destpost,int[][] matrix){
      List<Integer> list=new ArrayList<Integer>();
     int positionleft=0,positionright=0;
          for(int c=0;c<5;c++){
         for(int d=0;d<5;d++){
             if(destpost==matrix[c][d]){
                 positionleft=c;
                 list.add(c);
                 positionright=d;
                 list.add(d);
             }
         } 
 }  
          return list;
     
 }
}

