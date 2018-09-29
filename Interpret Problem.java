public int interpret(int value, String[] commands, int[] args) {
  int counter = 0;
  for(String command: commands)
    if(command.equals("+"))
      value += args[counter++];
    else if(command.equals("-"))
      value -= args[counter++];
    else if(command.equals("*"))
      value *= args[counter++];
    else
      return -1;

  return value;

}
