import speech_recognition as sr
import pyttsx3
import datetime
import wikipedia
import pywhatkit

# Initialize engine
engine = pyttsx3.init()

def speak(text):
    engine.say(text)
    engine.runAndWait()

def take_command():
    listener = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        listener.adjust_for_ambient_noise(source)  
        audio = listener.listen(source)
    try:
        command = listener.recognize_google(audio)
        command = command.lower()
        print(f"User said: {command}")
    except sr.UnknownValueError:
        command = ""
    return command

def run_assistant():
    command = take_command()

    if "hello" in command:
        speak("Hello! How can I help you today?")
    
    elif "time" in command:
        current_time = datetime.datetime.now().strftime("%I:%M %p")
        speak(f"The time is {current_time}")
    
    elif "date" in command:
        today = datetime.date.today().strftime("%B %d, %Y")
        speak(f"Today's date is {today}")
    
    elif "play" in command:
        song = command.replace("play", "")
        speak(f"Playing {song} on YouTube")
        pywhatkit.playonyt(song)
    
    elif "who is" in command:
        person = command.replace("who is", "")
        info = wikipedia.summary(person, sentences=2)
        speak(info)
    
    elif "search" in command:
        query = command.replace("search", "")
        speak(f"Searching for {query}")
        pywhatkit.search(query)
    
    elif command == "":
        speak("Sorry, I didn’t catch that. Please say it again.")
    
    else:
        speak("I’m not sure how to respond to that yet.")

# Run the assistant
while True:
    run_assistant()
