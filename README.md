# ctaMTXlibrary
A Java library for reading and writing Mediocre's MTX files.
# INSTALLATION
git clone https://github.com/themightycta/ctaMTXlibrary/
# USAGE
import org.deer21.mtxlibraryupdated.ctaMTX;
7#EXAMPLE CODE
import org.deer21.mtxlibraryupdated.ctaMTX;

import java.io.IOException;

public class Example {

    public static void main(String[] args) {

        String filename = "example.mtx";

        

        // create an instance of the ctaMTX class

        ctaMTX mtx = new ctaMTX();

        

        // read the .mtx file into the instance

        try {

            mtx.read(filename);

        } catch (IOException e) {

            e.printStackTrace();

        }

        

        // access the data in the instance

        int numRows = mtx.getNumRows();

        int numCols = mtx.getNumCols();

        int numNonZero = mtx.getNumNonZero();

        List<Integer> rowIndices = mtx.getRowIndices();

        List<Integer> colIndices = mtx.getColIndices();

        List<Double> values = mtx.getValues();

        

        // manipulate the data as needed...

        

        // write the data back to the .mtx file

        try {

            mtx.write(filename);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}


