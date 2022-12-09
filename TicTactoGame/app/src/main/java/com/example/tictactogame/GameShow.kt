package com.example.tictactogame
fun main(){

    val tictac= Ready()
    tictac.starting()
    while (tictac.running)
    {
        tictac.printGridToConsole()
        if(tictac.checkWhoWinningPlayer(tictac.curSign*-1)) {
        val player = if(tictac.curSign!=0) if(tictac.curSign*-1==1) "O" else "X" else " "
        println("$player side wins!!!")
        println("New game starting, press enter to start...")
        readLine()
        tictac.starting()
       tictac.printGridToConsole()
     }
       else if(tictac.checkDeadLockCondition()) {
        println("Draw, resetting, please enter to start...")
        readLine()
        tictac.starting()
        tictac.printGridToConsole()
       }

        val sign = if (tictac.curSign==1) "O" else "X"
        println("Mark a grid ($sign):");
        val input = readLine().toString()
       if(input.trim().lowercase() == "end") {
          tictac.end()
           break
        }
        else if(!tictac.mark(input))
       println("Invalid input try again");
       }
}