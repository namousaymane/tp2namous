package ma.emsi.namous.tp2.tests;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test2Couts {
    public static void main(String[] args) {
        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        String question = "Quel est le plus grand océan de la Terre?";

        ChatResponse response = model.chat(UserMessage.from(question));
        System.out.println("Réponse: " + response.aiMessage().text());

        int totalToken = response.tokenUsage().totalTokenCount();
        int inputToken = response.tokenUsage().inputTokenCount();
        int outputToken = response.tokenUsage().outputTokenCount();

        double inputPrice = 0.30;
        double outputPrice = 2.50;

        double cout = (inputToken * inputPrice + outputToken * outputPrice) / 1000000;
        long nbr = (long) Math.ceil(1.0 / cout); //j'arrondi au nbr supérieur

        System.out.println("Total Token: " + totalToken);
        System.out.println("Token en entrée: " + inputToken);
        System.out.println("Token en sortie: " + outputToken);
        System.out.println("Cout: " + cout);
        System.out.println("Nombre de requetes pour 1 dollar: " + nbr);
    }
}
