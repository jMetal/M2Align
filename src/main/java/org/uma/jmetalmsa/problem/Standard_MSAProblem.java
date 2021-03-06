package org.uma.jmetalmsa.problem;

import org.uma.jmetal.util.JMetalException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.uma.jmetalmsa.score.Score;

public class Standard_MSAProblem extends MSAProblem {

  /**
   * Constructor
   */
  public Standard_MSAProblem(String msaProblemFileName, String dataBaseDirectory, String preComputedFiles, List<Score> scoreList)
          throws IOException, CompoundNotFoundException {
    super(scoreList);

    setName(msaProblemFileName);

    String[] preComputedFilesList = preComputedFiles.split("-");
    
    if(preComputedFilesList.length<2){
         throw new JMetalException("Wrong number of Pre-computed Alignments, Minimum 2 files are required") ;
    }
    
    List<String> dataFiles = new ArrayList<>();
     
    for(String preComputedFile: preComputedFilesList){
        dataFiles.add(dataBaseDirectory + preComputedFile);
    }

    listOfSequenceNames = readSeqNameFromAlignment(msaProblemFileName);

    originalSequences = readDataFromFastaFile(msaProblemFileName);
    
    setNumberOfVariables(originalSequences.size());
    setNumberOfConstraints(0);
    
    listOfPrecomputedStringAlignments = readPreComputedAlignments(dataFiles);
    
  }

}
