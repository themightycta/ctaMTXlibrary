package org.deer21.mtxlibraryupdated;

import java.io.*;

public class ctaMTX {
	
    private int numRows;
    private int numCols;
    private int numValues;
    private int[] rowIndices;
    private int[] colIndices;
    private double[] values;

    public void readFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header information
            String[] header = br.readLine().split("\\s+");
            numRows = Integer.parseInt(header[0]);
            numCols = Integer.parseInt(header[1]);
            numValues = Integer.parseInt(header[2]);

            // Allocate arrays for data
            rowIndices = new int[numValues];
            colIndices = new int[numValues];
            values = new double[numValues];

            // Read data
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                rowIndices[i] = Integer.parseInt(parts[0]) - 1;
                colIndices[i] = Integer.parseInt(parts[1]) - 1;
                values[i] = Double.parseDouble(parts[2]);
                i++;
            }
        }
    }

    public void writeToFile(String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write header information
            bw.write(numRows + " " + numCols + " " + numValues + "\n");

            // Write data
            for (int i = 0; i < numValues; i++) {
                bw.write((rowIndices[i] + 1) + " " + (colIndices[i] + 1) + " " + values[i] + "\n");
            }
        }
    }

    // Method to retrieve a specific element from the matrix
    public double getElement(int row, int col) {
        for (int i = 0; i < numValues; i++) {
            if (rowIndices[i] == row && colIndices[i] == col) {
                return values[i];
            }
        }
        return 0.0; // if element is not found
    }

    // Method to set a specific element in the matrix
    public void setElement(int row, int col, double value) {
        for (int i = 0; i < numValues; i++) {
            if (rowIndices[i] == row && colIndices[i] == col) {
                values[i] = value;
                return;
            }
        }
        // if element is not found, add it to the matrix
        rowIndices[numValues] = row;
        colIndices[numValues] = col;
        values[numValues] = value;
        numValues++;
    }

    // Method to get the number of non-zero elements in a specific row or column
    public int getNumNonZeroElementsInRow(int row) {
        int count = 0;
        for (int i = 0; i < numValues; i++) {
            if (rowIndices[i] == row) {
                count++;
            }
        }
        return count;
    }

    public int getNumNonZeroElementsInColumn(int col) {
        int count = 0;
        for (int i = 0; i < numValues; i++) {
            if (colIndices[i] == col) {
                count++;
            }
        }
        return count;
    }
}
