package ma.emsi.namous.tp2.tests;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import java.util.Map;

public class Test3Traducteur {
    public static void main(String[] args) {
        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        PromptTemplate temp1 = PromptTemplate.from(
                "Traduis le texte suivant en anglais: {{it}}"
        );
        Prompt req1 = temp1.apply(
                "Il fait noir ici, il faut allumer la lumière"
        );
        String rep1 = model.chat(req1.text());
        System.out.println("Réponse: " + rep1);

        PromptTemplate temp2 = PromptTemplate.from(
                "Traduis le texte suivant en {{langue}}: {{texte}}"
        );
        Prompt req2 = temp2.apply(Map.of("langue", "chinois",
                "texte", "J'aimerai bien visiter la Chine")
        );
        String rep2 = model.chat(req2.text());
        System.out.println("Réponse: " + rep2);

    }
}
