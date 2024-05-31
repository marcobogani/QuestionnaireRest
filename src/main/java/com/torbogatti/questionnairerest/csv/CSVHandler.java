package com.torbogatti.questionnairerest.csv;

import com.torbogatti.questionnairerest.model.Answer;
import com.torbogatti.questionnairerest.model.Submission;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CSVHandler {
    private static final String CSV_FILE_PATH = "output.csv";

    public static void appendSubmissionToCsv(Submission submission) throws IOException {
        File file = new File(CSV_FILE_PATH);
        boolean fileExist = file.exists();

        FileWriter csvWriter = new FileWriter(CSV_FILE_PATH, true);

        List<Answer> answers = Arrays.asList(submission.getAnswers());
        answers.sort(Comparator.comparingInt(Answer::getQuestionId));
        if (!fileExist) {

            csvWriter.append("uuid,tax_id,").append(answers.stream().map(x -> "q" + x.getQuestionId()).collect(Collectors.joining(","))).append(",is_risk\n");
            System.out.println("File created: " + file.getAbsolutePath());
        }

        csvWriter.append(submission.getUuid().toString()).append(",").append(submission.getTaxId()).append(",");

        String answersStr = answers.stream().map(Answer::getText).collect(Collectors.joining(","));
        csvWriter.append(answersStr).append(",");

        csvWriter.append(String.valueOf(submission.isRisk()));

        csvWriter.append("\n");
        csvWriter.close();
        System.out.println("Record appended in: " + file.getAbsolutePath());
    }

    public static List<Submission> getSubmissionsByRisk(Boolean isRisk) throws IOException {
        List<Submission> submissions = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String row;
            // Skip the header
            csvReader.readLine();

            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");

                String uuid = data[0];
                String taxId = data[1];

                Answer[] answers = new Answer[5];
                for (int i = 0; i < 5; i++) {
                    answers[i] = new Answer(i + 1, data[i + 2]);
                }

                boolean recordIsRisk = Boolean.parseBoolean(data[7]);

                if (isRisk == null || recordIsRisk == isRisk) {
                    submissions.add(new Submission(UUID.fromString(uuid), taxId, answers, recordIsRisk));
                }
            }
        }

        return submissions;
    }
}
