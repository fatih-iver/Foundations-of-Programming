def interpret(value, commands, args):
  counter = 0
  for command in commands:

    if command == "+":
      value += args[counter]
    elif command == "-":
      value -= args[counter]
    elif command == "*":
      value *= args[counter]
    else:
      return -1

    counter += 1

  return value
