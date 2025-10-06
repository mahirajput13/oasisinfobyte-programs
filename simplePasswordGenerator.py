import random
import string

def generate_password(length, use_letters=True, use_digits=True, use_symbols=True):
    characters = ""
    if use_letters:
        characters += string.ascii_letters
    if use_digits:
        characters += string.digits
    if use_symbols:
        characters += string.punctuation

    if not characters:
        raise ValueError("⚠️ You must choose at least one character set!")

    return "".join(random.choice(characters) for _ in range(length))

def main():
    print("=== Random Password Generator ===")
    
    try:
        length = int(input("Enter password length: "))
        if length <= 0:
            print("⚠️ Password length must be positive.")
            return

        use_letters = input("Include letters? (y/n): ").lower() == 'y'
        use_digits = input("Include digits? (y/n): ").lower() == 'y'
        use_symbols = input("Include symbols? (y/n): ").lower() == 'y'

        password = generate_password(length, use_letters, use_digits, use_symbols)
        print(f"\nGenerated Password: {password}")

    except ValueError:
        print("⚠️ Invalid input! Please enter numbers only.")

if __name__ == "__main__":
    main()
