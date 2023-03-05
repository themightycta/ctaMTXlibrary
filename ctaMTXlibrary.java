package org.deer21.mtxlibraryupdated;

import java.io.BufferedReader;

import java.io.BufferedWriter;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

public class ctaMTX {

    private int numRows;

    private int numCols;

    private int numNonZero;

    private List<Integer> rowIndices;

    private List<Integer> colIndices;

    private List<Double> values;

    public ctaMTX() {

        this.rowIndices = new ArrayList<Integer>();

        this.colIndices = new ArrayList<Integer>();

        this.values = new ArrayList<Double>();

    }

    public void read(String filename) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filename));

        String line = br.readLine();

        String[] parts = line.split(" ");

        this.numRows = Integer.parseInt(parts[0]);

        this.numCols = Integer.parseInt(parts[1]);

        this.numNonZero = Integer.parseInt(parts[2]);

        while ((line = br.readLine()) != null) {

            parts = line.split(" ");

            this.rowIndices.add(Integer.parseInt(parts[0]));

            this.colIndices.add(Integer.parseInt(parts[1]));

            this.values.add(Double.parseDouble(parts[2]));

        }

        br.close();

    }

    public void write(String filename) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        bw.write(this.numRows + " " + this.numCols + " " + this.numNonZero + "\n");

        for (int i = 0; i < this.numNonZero; i++) {

            bw.write(this.rowIndices.get(i) + " " + this.colIndices.get(i) + " " + this.values.get(i) + "\n");

        }

        bw.close();

    }

    public int getNumRows() {

        return this.numRows;

    }

    public int getNumCols() {

        return this.numCols;

    }

    public int getNumNonZero() {

        return this.numNonZero;

    }

    public List<Integer> getRowIndices() {

        return this.rowIndices;

    }

    public List<Integer> getColIndices() {

        return this.colIndices;

    }

    public List<Double> getValues() {

        return this.values;

    }

}

