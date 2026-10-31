package ma.emsi.namous.tp2.tests;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.bgesmallenv15.BgeSmallEnV15EmbeddingModel;
import dev.langchain4j.store.embedding.CosineSimilarity;
import dev.langchain4j.model.google.genai.GoogleGenAiEmbeddingModel;

import java.time.Duration;

public class Test4Embeddings {

    public static void main(String[] args) {

        //EmbeddingModel model = new BgeSmallEnV15EmbeddingModel();

        EmbeddingModel model = GoogleGenAiEmbeddingModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-embedding-001")
                .taskType(GoogleGenAiEmbeddingModel.TaskTypeEnum.SEMANTIC_SIMILARITY)
                .timeout(Duration.ofSeconds(1))
                .build();

        String phrase1 = "Le chat est en train de manger";
        String phrase2 = "Un animal est en train de manger";
        Embedding embedding1 = model.embed(phrase1).content();
        Embedding embedding2 = model.embed(phrase2).content();
        double similarite = CosineSimilarity.between(embedding1, embedding2);
        System.out.println("Similarité 1: " + similarite);

        phrase1 = "J'ai trop chaud";
        phrase2 = "J'ai trop froid";
        embedding1 = model.embed(phrase1).content();
        embedding2 = model.embed(phrase2).content();
        similarite = CosineSimilarity.between(embedding1, embedding2);
        System.out.println("Similarité 2: " + similarite);

        phrase1 = "Casablanca est la plus grande ville du Maroc";
        phrase2 = "L'Homme retournera sur la lune avant 2030";
        embedding1 = model.embed(phrase1).content();
        embedding2 = model.embed(phrase2).content();
        similarite = CosineSimilarity.between(embedding1, embedding2);
        System.out.println("Similarité 3: " + similarite);

        phrase1 = "La capitale du Maroc est Rabat";
        phrase2 = "La capitale administration marocaine est Rabat";
        embedding1 = model.embed(phrase1).content();
        embedding2 = model.embed(phrase2).content();
        similarite = CosineSimilarity.between(embedding1, embedding2);
        System.out.println("Similarité 4: " + similarite);

        phrase1 = "Cette voiture est très rapide";
        phrase2 = "Ce camion se déplace lentement";
        embedding1 = model.embed(phrase1).content();
        embedding2 = model.embed(phrase2).content();
        similarite = CosineSimilarity.between(embedding1, embedding2);
        System.out.println("Similarité 5: " + similarite);

        phrase1 = "Les étudiants préparent leur examen";
        phrase2 = "Les étudiants révisent pour une évaluation";
        embedding1 = model.embed(phrase1).content();
        embedding2 = model.embed(phrase2).content();
        similarite = CosineSimilarity.between(embedding1, embedding2);
        System.out.println("Similarité 6: " + similarite);

    }
}