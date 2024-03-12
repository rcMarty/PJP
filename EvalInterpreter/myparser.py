import sys


def tokenize(input_string):
    tokens = []
    current_number = ""
    for char in input_string:
        if char.isdigit():
            current_number += char
        else:
            if current_number:
                tokens.append(current_number)
                current_number = ""
            if char in ["+", "-", "*", "/", "(", ")"]:
                tokens.append(char)
    if current_number:
        tokens.append(current_number)
    print(tokens)
    return tokens


def parse(tokens):
    def parse_expression(index):
        left, index = parse_term(index)
        while index < len(tokens) and tokens[index] in ["+", "-"]:
            operator = tokens[index]
            right, index = parse_term(index + 1)
            left = (operator, left, right)
        return left, index

    def parse_term(index):
        left, index = parse_factor(index)
        while index < len(tokens) and tokens[index] in ["*", "/"]:
            operator = tokens[index]
            right, index = parse_factor(index + 1)
            left = (operator, left, right)
        return left, index

    def parse_factor(index):
        token = tokens[index]
        if token.isdigit():
            return int(token), index + 1
        elif token == "(":
            expression, index = parse_expression(index + 1)
            assert tokens[index] == ")"
            return expression, index + 1

    expression, index = parse_expression(0)
    assert index == len(tokens)
    return expression


def evaluate(expression):
    if isinstance(expression, int):
        return expression
    operator, left, right = expression
    left_value = evaluate(left)
    right_value = evaluate(right)
    if operator == "+":
        return left_value + right_value
    elif operator == "-":
        return left_value - right_value
    elif operator == "*":
        return left_value * right_value
    elif operator == "/":
        return left_value / right_value


def calculate(input_string):
    tokens = tokenize(input_string)
    expression = parse(tokens)
    return evaluate(expression)


print("TESTS")
print(calculate("2 + 3 * 4"))
print(calculate("2 * (3 + 4)"))
print(calculate("2 * (3 + 4) / 2"))
print(calculate("2 * (3 + 4) / 2 - 1"))
print(calculate("2 * (3 + 4) / (2 - 1)"))
print(calculate("2 * (3 + 4) / (2 - 1) + 5"))
print(calculate("2 * (3 + 4) / (2 - 1) + 5 - 2"))

print("ARGS")

print(calculate(sys.argv[1]))
