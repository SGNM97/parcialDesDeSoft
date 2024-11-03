package com.example.mutant;

public class MutantDetector {

    public boolean isMutant(String[] dna) {
        int n = dna.length;
        int count = 0;

        for (String row : dna) {
            count += countSequences(row);
        }

        for (int col = 0; col < n; col++) {
            StringBuilder column = new StringBuilder();
            for (String row : dna) {
                column.append(row.charAt(col));
            }
            count += countSequences(column.toString());
        }

        for (int i = 0; i < n; i++) {
            StringBuilder diagonal1 = new StringBuilder();
            StringBuilder diagonal2 = new StringBuilder();
            for (int j = 0; j < n - i; j++) {
                diagonal1.append(dna[j + i].charAt(j));
                diagonal2.append(dna[j].charAt(j + i));
            }
            count += countSequences(diagonal1.toString());
            count += countSequences(diagonal2.toString());
        }

        for (int i = 1; i < n; i++) {
            StringBuilder diagonal1 = new StringBuilder();
            StringBuilder diagonal2 = new StringBuilder();
            for (int j = 0; j < n - i; j++) {
                diagonal1.append(dna[j].charAt(j + i));
                diagonal2.append(dna[j + i].charAt(j));
            }
            count += countSequences(diagonal1.toString());
            count += countSequences(diagonal2.toString());
        }

        return count > 1;
    }

    private int countSequences(String sequence) {
        int count = 0;
        for (int i = 0; i < sequence.length() - 3; i++) {
            if (sequence.charAt(i) == sequence.charAt(i + 1) &&
                    sequence.charAt(i) == sequence.charAt(i + 2) &&
                    sequence.charAt(i) == sequence.charAt(i + 3)) {
                count++;
            }
        }
        return count;
    }
}