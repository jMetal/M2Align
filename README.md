# jMetalMSA: Multiple Sequence Alignment with Multi-Objective Metaheuristics
jMetalMSA is a software project aimed at solving multiple sequence alignment (MSA) problems by using multi-objective metaheuristics. It is based on the jMetal multi-objective framework, which is extended with an encoding for representing MSA solutions. 

Currently it contains an implementation of the NSGA-II algorithm configured with a single-point crossover and shift closed gaps mutation operators, and three objectives to optimize: STRIKE, percentage of alignment columns and percentage of non gaps. These settings corresponds to the [MOSAStrE algorithm](http://bioinformatics.oxfordjournals.org/content/early/2013/06/21/bioinformatics.btt360.abstract). 

## Summary of features
jMetalMSA containts the following features:
* The algorithm can run in parallel in multi-core systems
* The included dataset is BAlibase
* more features ....

## Requirements
To use jMetalMSA the following software packages are required:
* [Java SE Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?ssSourceSiteId=otnes)
* [Apache Maven](https://maven.apache.org/)
* [Git](https://git-scm.com/)

## Downloading and compiling
To download jMetalMSA just clone the Git repository hosted in GitHub:
```
git clone https://github.com/jMetal/jMetalMSA.git
```
Once cloned, you can compile the software and generate a jar file with the following command:
```
mvn package
```
This sentence will generate a directory called `target` which will contain a file called `jMetalMSA-1.0-SNAPSHOT-jar-with-dependencies.jar`

## Runing MOSAStrE
To execute the algorithm to solve a problem in Balibase, just run this command:
````
java -cp target/jMetalMSA-1.0-SNAPSHOT-jar-with-dependencies.jar org.uma.jmetalmsa.runner.MOSAStrERunner balibaseProblemName dataDirectory NumberOfEvaluations PopulationSize NumberOfCores
```

The output of the program are two files:
* `VAR.tsv`: contains the Pareto front approximation. For each solution, this file contains a line with the values of the three objectives.
* `FUN.tsv`: contains the Pareto set approximation. Each solution is represented in FASTA format.
