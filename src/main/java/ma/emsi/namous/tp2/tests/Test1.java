package ma.emsi.namous.tp2.tests;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test1 {
    public static void main(String[] args) {
        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        //String question = "Quel est le plus grand océan de la Terre?";
        //String question = "Quelle heure est-il?";
        String question1 = "Bonjour, je m'appelle Aymane Namous.";
        String reponse1 = model.chat(question1);

        System.out.println("Question 1: " + question1);
        System.out.println("Reponse 1: " + reponse1);

        String question2 = "Comment je m'appelle ?";
        String reponse2 = model.chat(question2);

        System.out.println("Question 2: " + question2);
        System.out.println("Reponse 2: " + reponse2);

        //String reponse = model.chat(question);

        //System.out.println("Question: " + question);
        //System.out.println("Réponse: " + reponse);

    }
}
